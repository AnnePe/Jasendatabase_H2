package kevat22.Jasendatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import kevat22.Jasendatabase.domain.Jasen;
import kevat22.Jasendatabase.domain.JasenRepository;




@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JasenRepositoryTest {
	@Autowired
	private JasenRepository repository;
	
	@Test
	public void findBySukunimiShouldReturnEtunimi() {//toimii
		List<Jasen> jasenet = repository.findBySukunimi("Pelin");
		//assertThat(books).hasSize(1);
		assertThat(jasenet.get(0).getEtunimi()).isEqualTo("Anne");
		}
	@Test
	public void findSukunimiShouldReturnSize() {//toimii, etsii montako tällä sukunimellä on 2
		List<Jasen> jasenet = repository.findBySukunimi("Melin");
		assertThat(jasenet).hasSize(2);
		
		}
	@Test
	public void findPonoShouldReturnSize() {//toimii, etsii montako tällä postinumerolla on 3
		List<Jasen> jasenet = repository.findByPostinumero("00590");
		assertThat(jasenet).hasSize(3);
		
		}
	
	
}
