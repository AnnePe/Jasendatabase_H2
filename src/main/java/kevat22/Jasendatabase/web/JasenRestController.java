package kevat22.Jasendatabase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import kevat22.Jasendatabase.domain.Jasen;
import kevat22.Jasendatabase.domain.JasenRepository;
import kevat22.Jasendatabase.domain.Jasenyys;
import kevat22.Jasendatabase.domain.JasenyysRepository;
import kevat22.Jasendatabase.domain.Yhdistys;
import kevat22.Jasendatabase.domain.YhdistysRepository;

@RestController
public class JasenRestController {
	@Autowired
	private JasenRepository jrepository;
	@Autowired
	private YhdistysRepository yrepository;
	@Autowired
	private JasenyysRepository arepository;
	
	// REST haetaan kaikki jäsenet, toimii
    @RequestMapping(value="/jasenet", method = RequestMethod.GET)
    public List<Jasen> JasenListRest() {	
        return (List<Jasen>) jrepository.findAll();
    }  
    
    //toimii, muista ettet vie id:tä postmanilla bodyssä
    
    @PostMapping("jasenet")
    Jasen addJasen(@RequestBody Jasen addJasen) {
    	return jrepository.save(addJasen);
       }
    
    //toimii,nyt pitää olla id mukana postman huomio
    @PutMapping("/jasenet/{id}")
    Jasen replaceJasen(@RequestBody Jasen replaceJasen,@PathVariable Long id) {
    	replaceJasen.setId(id);
    	return jrepository.save(replaceJasen);
    }
    
    //toimii
    @DeleteMapping("/jasenet/{id}")
    void deleteBook(@PathVariable Long id) {
    	jrepository.deleteById(id);
    	
    }
 // REST haetaan kaikki yhdistykset, toimii
    @RequestMapping(value="/yhdistykset", method = RequestMethod.GET)
    public List<Yhdistys> YhdistysListRest() {	
        return (List<Yhdistys>) yrepository.findAll();
    }
 // REST haetaan kaikki jäsenyydet, toimii
    @RequestMapping(value="/jasenyydet", method = RequestMethod.GET)
    public List<Jasenyys> JasenyysListRest() {	
        return (List<Jasenyys>) arepository.findAll();
    }
}
