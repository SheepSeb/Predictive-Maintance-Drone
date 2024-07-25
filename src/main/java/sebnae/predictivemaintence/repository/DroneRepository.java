package sebnae.predictivemaintence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebnae.predictivemaintence.entity.DroneEntity;

@Repository
public interface DroneRepository  extends JpaRepository<DroneEntity, Long>{
}
