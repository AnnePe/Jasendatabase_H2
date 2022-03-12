package kevat22.Jasendatabase.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kevat22.Jasendatabase.domain.Jasen;
import kevat22.Jasendatabase.domain.JasenRepository;
import kevat22.Jasendatabase.domain.JasenyysRepository;

import kevat22.Jasendatabase.domain.TapahtumaRepository;
import kevat22.Jasendatabase.domain.YhdistysRepository;


@Controller
public class JasenController {
	
	@Autowired
	private JasenRepository jrepository;
	
	@Autowired
	private YhdistysRepository yrepository;
	@Autowired
	private JasenyysRepository arepository;
	
	@Autowired
	private TapahtumaRepository trepository;
	
	@RequestMapping(value = "/login")
	public String login(){
		return "/login";
	}
	
	//näytä kaikki jäsenet , ilman endpointia file
	@RequestMapping(value = "/jasenlista")
	public String jasenList(Model model) {
		model.addAttribute("jasenet", jrepository.findAll());
		return("jasenlista");
	}
	  @PreAuthorize("hasAuthority('ADMIN')")//tarkastetaan oikeus   
	 @RequestMapping(value = "/add")
	    public String lisaaJasen(Model model){
		
	    	model.addAttribute("jasen", new Jasen());
	    	model.addAttribute("yhdistykset", yrepository.findAll());
	    	model.addAttribute("jasenyydet", arepository.findAll());
	    	model.addAttribute("tapahtumat", trepository.findAll());
	    	
	    	
	    	return "lisaajasen";
	    }
	 
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(@Valid Jasen jasen, BindingResult bindingResult, Model model ){
		if (bindingResult.hasErrors()) {
			System.out.println("virhe");
			model.addAttribute("yhdistykset", yrepository.findAll());//yhdistyslista pitää viedä modelissa uudelleen muuten tyhjentää kentän
			model.addAttribute("jasenyydet", arepository.findAll());
			model.addAttribute("tapahtumat", trepository.findAll());
			return ("/lisaajasen");
		}
	        jrepository.save(jasen);
	        return "redirect:/jasenlista";
	    } 
	 
	// Edit jäsen
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String editJasen(@PathVariable("id") Long jasenId, Model model) {
	    	model.addAttribute("jasen", jrepository.findById(jasenId));
	    	model.addAttribute("yhdistykset", yrepository.findAll());
	    	model.addAttribute("jasenyydet", arepository.findAll());
	    	model.addAttribute("tapahtumat", trepository.findAll());//test
	    	return "muokkaajasen";
	    }   
	    
	    //Tallennus kun jäsen editoidaan ja validointi 
	    @RequestMapping(value = "/saveE", method = RequestMethod.POST)
	    public String saveE(@Valid Jasen jasen, BindingResult bindingResult, Model model ){
		if (bindingResult.hasErrors()) {
			System.out.println("Erroria");
			model.addAttribute("yhdistykset", yrepository.findAll());
			model.addAttribute("jasenyydet", arepository.findAll());
			model.addAttribute("tapahtumat", trepository.findAll());//test
			return ("/muokkaajasen");
		}
	        jrepository.save(jasen);
	        return "redirect:/jasenlista";
	    } 
  @PreAuthorize("hasAuthority('ADMIN')")//tarkastetaan oikeus   
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	 public String deleteBook(@PathVariable("id") Long jasenId, Model model) {
    	jrepository.deleteById(jasenId);
        return "redirect:../jasenlista";
	 }   

}
