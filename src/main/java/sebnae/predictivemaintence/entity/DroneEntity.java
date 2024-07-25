package sebnae.predictivemaintence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drones")
public class DroneEntity {
    @Id
    @Column(name = "drone_id")
    private int droneId;

    @Column(name = "drone_name")
    private String droneName;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL)
    private List<MotorEntity> motors;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL)
    private List<SensorEntity> sensors;

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

    public List<MotorEntity> getMotors() {
        return motors;
    }

    public void setMotors(List<MotorEntity> motors) {
        this.motors = motors;
    }

    public List<SensorEntity> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorEntity> sensors) {
        this.sensors = sensors;
    }
}
