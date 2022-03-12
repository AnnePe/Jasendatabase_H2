package kevat22.Jasendatabase.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface YhdistysRepository extends CrudRepository<Yhdistys, Long> {
	List<Yhdistys> findByName(String name);
}
