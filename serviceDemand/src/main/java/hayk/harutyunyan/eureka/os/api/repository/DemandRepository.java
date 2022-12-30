package hayk.harutyunyan.eureka.os.api.repository;

import hayk.harutyunyan.eureka.os.api.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand,Integer> {
}
