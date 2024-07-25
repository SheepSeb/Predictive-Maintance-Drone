package sebnae.predictivemaintence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import sebnae.predictivemaintence.entity.DroneEntity;
import sebnae.predictivemaintence.entity.MotorEntity;
import sebnae.predictivemaintence.entity.SensorEntity;
import sebnae.predictivemaintence.entity.SensorsEntity.DOFSensorEntity;
import sebnae.predictivemaintence.entity.SensorsEntity.IMUSensorEntity;
import sebnae.predictivemaintence.entity.SensorsEntity.TemperatureSensorEntity;
import sebnae.predictivemaintence.exceptions.NoSensorException;
import sebnae.predictivemaintence.model.Drone;
import sebnae.predictivemaintence.model.Motor;
import sebnae.predictivemaintence.model.Sensor;
import sebnae.predictivemaintence.model.Sensors.DOFSensor;
import sebnae.predictivemaintence.model.Sensors.IMUSensor;
import sebnae.predictivemaintence.model.Sensors.TemperatureSensor;
import sebnae.predictivemaintence.repository.DroneRepository;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaDroneConsumerService {
    private final ObjectMapper objectMapper;
    private final DroneRepository droneRepository;

    public KafkaDroneConsumerService(ObjectMapper objectMapper, DroneRepository droneRepository){
        this.objectMapper = objectMapper;
        this.droneRepository = droneRepository;
    }

    @KafkaListener(topics = "drone-topic", groupId = "my-group")
    @Transactional
    public void consume(String message) throws JsonProcessingException {
        Drone drone = objectMapper.readValue(message, Drone.class);
        DroneEntity droneEntity = new DroneEntity();
        droneEntity.setDroneName(drone.getDroneName());
        droneEntity.setDroneId(drone.getDroneId());
        droneEntity.setMotors(drone.getMotors().stream().map(
                motor ->{
                    MotorEntity motorEntity = new MotorEntity();
                    motorEntity.setDrone(droneEntity);
                    motorEntity.setVoltage(motor.getVoltage());
                    motorEntity.setVoltageRef(motor.getVoltageRef());
                    motorEntity.setTimestamp(motor.getTimestamp().toOffsetDateTime());
                    return motorEntity;
                }
        ).toList());

        droneEntity.setSensors(drone.getSensors().stream().map(
                sensor -> {
                    SensorEntity sensorEntity;
                    if (sensor instanceof IMUSensor imuSensor){
                        IMUSensorEntity imuSensorEntity = new IMUSensorEntity();
                        imuSensorEntity.setWx(imuSensor.getWx());
                        imuSensorEntity.setWy(imuSensor.getWy());
                        imuSensorEntity.setWz(imuSensor.getWz());
                        sensorEntity = imuSensorEntity;
                    } else if (sensor instanceof TemperatureSensor temperatureSensor){
                        TemperatureSensorEntity tempEntity = new TemperatureSensorEntity();
                        tempEntity.setTemperature(temperatureSensor.getGrade());
                        sensorEntity = tempEntity;
                    } else if (sensor instanceof DOFSensor dofSensor){
                        DOFSensorEntity dofEntity = new DOFSensorEntity();
                        dofEntity.setMagX(dofSensor.getMagX());
                        dofEntity.setMagY(dofSensor.getMagY());
                        dofEntity.setMagZ(dofSensor.getMagZ());
                        dofEntity.setGyroX(dofSensor.getGyroX());
                        dofEntity.setGyroY(dofSensor.getGyroY());
                        dofEntity.setGyroZ(dofSensor.getGyroZ());
                        sensorEntity = dofEntity;
                    } else {
                        try {
                            throw new NoSensorException("Unknown sensor type");
                        } catch (NoSensorException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    sensorEntity.setTypeSensor(sensor.getTypeSensor());
                    sensorEntity.setDrone(droneEntity);
                    sensorEntity.setTimestamp(sensor.getTimestamp().toOffsetDateTime());
                    return sensorEntity;
                }
        ).toList());
        DroneEntity savedEntity = droneRepository.save(droneEntity);
        System.out.println("Saved entity: " + savedEntity.getDroneName());
        System.out.println("Saved entity: " + savedEntity.getDroneId());
    }
}
