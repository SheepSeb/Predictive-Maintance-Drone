package sebnae.predictivemaintence.entity.SensorsEntity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import sebnae.predictivemaintence.entity.SensorEntity;

@Entity
@DiscriminatorValue("IMU")
public class IMUSensorEntity extends SensorEntity {
    private double Wx;
    private double Wy;
    private double Wz;

    public double getWx() {
        return Wx;
    }

    public void setWx(double wx) {
        Wx = wx;
    }

    public double getWy() {
        return Wy;
    }

    public void setWy(double wy) {
        Wy = wy;
    }

    public double getWz() {
        return Wz;
    }

    public void setWz(double wz) {
        Wz = wz;
    }
}
