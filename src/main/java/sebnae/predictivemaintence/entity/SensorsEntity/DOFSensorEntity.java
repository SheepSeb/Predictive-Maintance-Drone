package sebnae.predictivemaintence.entity.SensorsEntity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import sebnae.predictivemaintence.entity.SensorEntity;
@Entity
@DiscriminatorValue("DOF")
public class DOFSensorEntity extends SensorEntity {
    private double magX, magY, magZ;
    private double gyroX, gyroY, gyroZ;

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
