package kevat22.Jasendatabase.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface JasenRepository extends CrudRepository<Jasen, Long>{

	List<Jasen> findBySukunimi(String sukunimi);
	List<Jasen> findByPostinumero(String postinumero);
	Optional<Jasen> findById(int id);
	
	
}
