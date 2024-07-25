package sebnae.predictivemaintence.model.Sensors;

import org.springframework.stereotype.Component;
import sebnae.predictivemaintence.exceptions.NoSensorException;
import sebnae.predictivemaintence.model.Sensor;
@Component
public class SensorFactory {
    public Sensor createSensor(String typeSensor) throws NoSensorException {
        return switch (typeSensor) {
            case "IMU" -> new IMUSensor();
            case "Temperature" -> new TemperatureSensor();
            case "DOF" -> new DOFSensor();
            default -> throw new NoSensorException("No sensor found");
        };
    }
}
