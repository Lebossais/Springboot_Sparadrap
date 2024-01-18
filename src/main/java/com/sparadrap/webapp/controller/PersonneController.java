package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.repository.AdresseRepository;
import com.sparadrap.webapp.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Personne;
import com.sparadrap.webapp.repository.PersonneRepository;
import com.sparadrap.webapp.service.PersonneService;

import lombok.Data;

@Data
@Controller
public class PersonneController {
	
	@Autowired
	private PersonneService personneService;
	
	@Autowired
	private PersonneRepository repo;

	@Autowired
	private AdresseRepository adrRepo;

	@Autowired
	private AdresseService adresseService;
	    
	@GetMapping("/signupPersonne")
    public String showSignUpForm(Personne personne, Model model) {
		model.addAttribute("listAdresse", adrRepo.findAll());
        return "form-new/formNewPersonne";
    }
	
	    @PostMapping("/addPersonne")
	    public String addPersonne(Personne personne, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewPersonne";
	        }
	        
	        personneService.savePersonne(personne);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listPersonne")
	    public String showPersonneList(Model model) {
	    	Iterable<Personne> listPersonne = personneService.getPersonne();
	        model.addAttribute("listPersonne", listPersonne);
	        
	        return "list/listPersonne";
	    }
	    
	    @GetMapping("/editPersonne/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Personne personne = personneService.getPersonne(id);

			Iterable<Adresse> listAdresse = adresseService.getAdresse();
			model.addAttribute("listAdresse", listAdresse);

			model.addAttribute("personne", personne);
	        return "form-update/formUpdatePersonne";
	    }
	    
	    @PostMapping("/updatePersonne/{id}")
	    public String updatePersonne(@PathVariable("id") long id, Personne personne, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	personne.setPer_ID(id);
	            return "form-update/formUpdatePersonne";
	        }
	            
	        repo.save(personne);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deletePersonne/{id}")
	    public String deletePersonne(@PathVariable("id") long id, Model model) {
	    	personneService.deletePersonne(id);
	        return "redirect:/home";
	    }

}