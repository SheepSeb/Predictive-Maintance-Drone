package sebnae.predictivemaintence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebnae.predictivemaintence.entity.SensorEntity;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long>{
}
