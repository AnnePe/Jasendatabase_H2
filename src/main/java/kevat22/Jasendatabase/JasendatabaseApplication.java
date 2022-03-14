package kevat22.Jasendatabase;



import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import kevat22.Jasendatabase.domain.Jasen;
import kevat22.Jasendatabase.domain.JasenRepository;
import kevat22.Jasendatabase.domain.Jasenyys;
import kevat22.Jasendatabase.domain.JasenyysRepository;
import kevat22.Jasendatabase.domain.Tapahtuma;
import kevat22.Jasendatabase.domain.TapahtumaRepository;
import kevat22.Jasendatabase.domain.User;
import kevat22.Jasendatabase.domain.UserRepository;
import kevat22.Jasendatabase.domain.Yhdistys;
import kevat22.Jasendatabase.domain.YhdistysRepository;


@SpringBootApplication
public class JasendatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(JasendatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JasendatabaseApplication.class, args);
	}
	@Bean	
	public CommandLineRunner jasendemo(JasenRepository jrepository, YhdistysRepository yrepository, JasenyysRepository arepository, UserRepository urepository, TapahtumaRepository trepository) {
	return (args) -> {
		
		log.info("save a couple of yhdistys");
		yrepository.save(new Yhdistys("Y"));
		yrepository.save(new Yhdistys("A"));
			
		arepository.save(new Jasenyys("J"));
		arepository.save(new Jasenyys("O"));
		
		trepository.save(new Tapahtuma("Kesä"));
		trepository.save(new Tapahtuma("Talvi"));
		trepository.save(new Tapahtuma("Syksy"));
		trepository.save(new Tapahtuma("Kevät"));
		
		
			
		jrepository.save( new Jasen("Jasen","Ykkönen", "os1","00520","09123456","jasen@ykkonen.fi",yrepository.findByName("Y").get(0),arepository.findByName("J").get(0)));
		jrepository.save( new Jasen("Jasen","Kakkonen", "os2","00500","094112233","jasen@kakkonen.fi",yrepository.findByName("A").get(0),arepository.findByName("O").get(0)));
		jrepository.save( new Jasen("Jasen","Kolmonen", "os3","00510","09223344","jasen@kolmonen.fi",yrepository.findByName("A").get(0),arepository.findByName("O").get(0)));
		
		
       		
		
		// Create users: admin/admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				User user3 = new User("anne", "$2a$10$2gZC/6ONPe2eV6EDAN1x5es7R9y57ToKZfTmzSV1Wi.r25imRNf5G", "ADMIN");
				User user4 = new User("vieras", "$2a$10$yYZ3YWUg0lcHCNfja4KmMeZffxgJrBmh9FjigCKw4otIBpydrloz2", "USER");
				urepository.save(user1);
				urepository.save(user2);
				urepository.save(user3);
				urepository.save(user4);
			log.info("fetch all books");
			for (Jasen jasen : jrepository.findAll()) {
				log.info(jasen.toString());
			}
			log.info("fetch all tapahtumat");
			for (Tapahtuma tapahtuma : trepository.findAll()) {
				log.info(tapahtuma.toString());
			}
		};
}
}
