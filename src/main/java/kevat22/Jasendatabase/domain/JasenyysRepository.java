package kevat22.Jasendatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JasenyysRepository extends CrudRepository<Jasenyys, Long> {
	List<Jasenyys> findByName(String name);

}
