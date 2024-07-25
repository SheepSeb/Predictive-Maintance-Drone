package sebnae.predictivemaintence.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;

@Entity
@Table(name = "motors")
public class MotorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int motorId;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private DroneEntity drone;

    private double voltage;
    private double voltageRef;
    private OffsetDateTime timestamp;

    public int getMotorId() {
        return motorId;
    }

    public void setMotorId(int motorId) {
        this.motorId = motorId;
    }

    public DroneEntity getDrone() {
        return drone;
    }

    public void setDrone(DroneEntity drone) {
        this.drone = drone;
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

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
