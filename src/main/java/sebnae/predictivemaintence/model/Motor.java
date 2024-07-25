package sebnae.predictivemaintence.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Motor {
    private double voltage;
    private double voltageRef;
    private ZonedDateTime timestamp;
    private String typeSensor;


    public Motor() {
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getVoltageRef() {
        return voltageRef;
    }

    public void setVoltageRef(double voltageRef) {
        this.voltageRef = voltageRef;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTypeSensor() {
        return typeSensor;
    }

    public void setTypeSensor(String typeSensor) {
        this.typeSensor = typeSensor;
    }
}
