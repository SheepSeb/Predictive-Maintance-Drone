package sebnae.predictivemaintence.model.Sensors;

import sebnae.predictivemaintence.model.Sensor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TemperatureSensor extends Sensor {
    private double grade;

    public TemperatureSensor() {
        super();
    }

    public TemperatureSensor(String sensorType, ZonedDateTime timestamp) {
        super(sensorType, timestamp);
    }

    public TemperatureSensor(String sensorType, ZonedDateTime timestamp, double grade) {
        super(sensorType, timestamp);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
