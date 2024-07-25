package sebnae.predictivemaintence.model;

import java.util.ArrayList;
import java.util.List;

public class Drone {
    private int droneId;
    private String droneName;
    private List<Motor> motors;
    private List<Sensor> sensors;

    public Drone() {
    }

    public Drone(int droneId, String droneName) {
        this.droneId = droneId;
        this.droneName = droneName;
        this.motors = new ArrayList<>();
        this.sensors = new ArrayList<>();
    }

    public Drone(int droneId, String droneName, List<Motor> motors, List<Sensor> sensors) {
        this.droneId = droneId;
        this.droneName = droneName;
        this.motors = motors;
        this.sensors = sensors;
    }

    public int getDroneId() {
        return droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    public String getDroneName() {
        return droneName;
    }

    public void setDroneName(String droneName) {
        this.droneName = droneName;
    }

    public List<Motor> getMotors() {
        return motors;
    }

    public void setMotors(List<Motor> motors) {
        this.motors = motors;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addMotor(Motor motor) {
        motors.add(motor);
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public void removeMotor(Motor motor) {
        motors.remove(motor);
    }

    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
    }

    public void printMotors() {
        for (Motor motor : motors) {
            System.out.println(motor.toString());
        }
    }

    public void printSensors() {
        for (Sensor sensor : sensors) {
            System.out.println(sensor.toString());
        }
    }
}
