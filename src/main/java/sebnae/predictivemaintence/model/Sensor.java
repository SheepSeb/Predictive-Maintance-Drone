package sebnae.predictivemaintence.model;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public abstract class Sensor {
    private String typeSensor;
    private ZonedDateTime timestamp;

    public Sensor() {
    }

    public Sensor(String typeSensor, ZonedDateTime timestamp) {
        this.typeSensor = typeSensor;
        this.timestamp = timestamp;
    }

    public String getTypeSensor() {
        return typeSensor;
    }

    public void setTypeSensor(String typeSensor) {
        this.typeSensor = typeSensor;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
