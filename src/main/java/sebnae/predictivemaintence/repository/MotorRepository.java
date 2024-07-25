package sebnae.predictivemaintence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebnae.predictivemaintence.entity.MotorEntity;

@Repository
public interface MotorRepository extends JpaRepository<MotorEntity, Long>{
}
