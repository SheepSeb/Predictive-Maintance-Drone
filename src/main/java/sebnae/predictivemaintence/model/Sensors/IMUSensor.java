package sebnae.predictivemaintence.model.Sensors;

import sebnae.predictivemaintence.model.Sensor;

import java.time.ZonedDateTime;

public class IMUSensor extends Sensor {
    private double Wx;
    private double Wy;
    private double Wz;

    public IMUSensor() {
        super();
    }

    public IMUSensor(String sensorType, ZonedDateTime timestamp) {
        super(sensorType, timestamp);
    }

    public IMUSensor(String sensorType, ZonedDateTime timestamp, double wx, double wy, double wz) {
        super(sensorType, timestamp);
        Wx = wx;
        Wy = wy;
        Wz = wz;
    }

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
