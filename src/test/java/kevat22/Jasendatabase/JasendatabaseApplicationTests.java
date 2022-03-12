package kevat22.Jasendatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kevat22.Jasendatabase.web.JasenController;

@ExtendWith(SpringExtension.class) 
@SpringBootTest
class JasendatabaseApplicationTests {//SMOKE TESTING

	@Autowired
	private JasenController controller;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
