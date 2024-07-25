package sebnae.predictivemaintence.configuration;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import sebnae.predictivemaintence.exceptions.NoSensorException;
import sebnae.predictivemaintence.model.Sensor;
import sebnae.predictivemaintence.model.Sensors.DOFSensor;
import sebnae.predictivemaintence.model.Sensors.IMUSensor;
import sebnae.predictivemaintence.model.Sensors.SensorFactory;
import sebnae.predictivemaintence.model.Sensors.TemperatureSensor;

import java.io.IOException;
import java.time.ZonedDateTime;

@Component
public class SensorsDeserializer extends JsonDeserializer<Sensor> {
    private final SensorFactory sensorFactory;

    SensorsDeserializer() {
        this.sensorFactory = new SensorFactory();
    }

    @Override
    public Sensor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String typeSensor = node.get("typeSensor").asText();
        String timestamp = node.get("timestamp").asText();
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(timestamp);
        Sensor sensor = null;
        try {
            sensor = sensorFactory.createSensor(typeSensor);
        } catch (NoSensorException e) {
            throw new RuntimeException(e);
        }

        if (sensor == null) {
            throw new RuntimeException("Sensor not found");
        }

        if (sensor instanceof IMUSensor imuSensor){
            imuSensor.setTypeSensor(node.get("typeSensor").asText());
            imuSensor.setWx(node.get("wx").asDouble());
            imuSensor.setWy(node.get("wy").asDouble());
            imuSensor.setWz(node.get("wz").asDouble());
            imuSensor.setTimestamp(zonedDateTime);
            return imuSensor;
        } else if (sensor instanceof TemperatureSensor temperatureSensor) {
            temperatureSensor.setTypeSensor(node.get("typeSensor").asText());
            temperatureSensor.setGrade(node.get("grades").asDouble());
            temperatureSensor.setTimestamp(zonedDateTime);
            return temperatureSensor;
        } else if (sensor instanceof DOFSensor dofSensor) {
            dofSensor.setTypeSensor(node.get("typeSensor").asText());
            dofSensor.setGyroX(node.get("gyroX").asDouble());
            dofSensor.setGyroY(node.get("gyroY").asDouble());
            dofSensor.setGyroZ(node.get("gyroZ").asDouble());
            dofSensor.setMagX(node.get("magX").asDouble());
            dofSensor.setMagY(node.get("magY").asDouble());
            dofSensor.setMagZ(node.get("magZ").asDouble());
            dofSensor.setTimestamp(zonedDateTime);
            return dofSensor;
        } else {
            throw new RuntimeException("Sensor not found");
        }
    }
}
