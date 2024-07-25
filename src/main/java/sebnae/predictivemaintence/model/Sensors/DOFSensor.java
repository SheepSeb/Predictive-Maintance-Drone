package sebnae.predictivemaintence.model.Sensors;

import sebnae.predictivemaintence.model.Sensor;

import java.time.ZonedDateTime;

public class DOFSensor extends Sensor {
    private double magX, magY, magZ;
    private double gyroX, gyroY, gyroZ;

    public DOFSensor() {
        super();
    }

    public DOFSensor(String sensorType, ZonedDateTime timestamp) {
        super(sensorType, timestamp);
    }

    public DOFSensor(String sensorType, ZonedDateTime timestamp, double magX, double magY, double magZ, double gyroX, double gyroY, double gyroZ) {
        super(sensorType, timestamp);
        this.magX = magX;
        this.magY = magY;
        this.magZ = magZ;
        this.gyroX = gyroX;
        this.gyroY = gyroY;
        this.gyroZ = gyroZ;
    }

    public double getMagX() {
        return magX;
    }

    public void setMagX(double magX) {
        this.magX = magX;
    }

    public double getMagY() {
        return magY;
    }

    public void setMagY(double magY) {
        this.magY = magY;
    }

    public double getMagZ() {
        return magZ;
    }

    public void setMagZ(double magZ) {
        this.magZ = magZ;
    }

    public double getGyroX() {
        return gyroX;
    }

    public void setGyroX(double gyroX) {
        this.gyroX = gyroX;
    }

    public double getGyroY() {
        return gyroY;
    }

    public void setGyroY(double gyroY) {
        this.gyroY = gyroY;
    }

    public double getGyroZ() {
        return gyroZ;
    }

    public void setGyroZ(double gyroZ) {
        this.gyroZ = gyroZ;
    }
}
