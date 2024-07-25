package sebnae.predictivemaintence.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "sensors")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_sensor", discriminatorType = DiscriminatorType.STRING)
public abstract class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    @ManyToOne
    @JoinColumn(name = "drone_id")
    private DroneEntity drone;

    private OffsetDateTime timestamp;

    @Column(name = "type_sensor", insertable = false, updatable = false)
    private String typeSensor;

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public DroneEntity getDrone() {
        return drone;
    }

    public void setDrone(DroneEntity drone) {
        this.drone = drone;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTypeSensor() {
        return typeSensor;
    }

    public void setTypeSensor(String typeSensor) {
        this.typeSensor = typeSensor;
    }
}
