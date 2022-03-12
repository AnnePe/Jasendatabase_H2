package kevat22.Jasendatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TapahtumaRepository extends CrudRepository <Tapahtuma,Long>{
	List<Tapahtuma> findByName(String name);

}
