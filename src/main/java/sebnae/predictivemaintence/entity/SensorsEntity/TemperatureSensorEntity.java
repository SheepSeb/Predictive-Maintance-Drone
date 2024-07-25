package sebnae.predictivemaintence.entity.SensorsEntity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import sebnae.predictivemaintence.entity.SensorEntity;
@Entity
@DiscriminatorValue("Temperature")
public class TemperatureSensorEntity extends SensorEntity {
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
