package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Entreprise;
import com.sparadrap.webapp.repository.EntrepriseRepository;
import com.sparadrap.webapp.service.EntrepriseService;

import lombok.Data;

@Data
@Controller
public class EntrepriseController {
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@Autowired
	private EntrepriseRepository repo;
	    
	@GetMapping("/signupEntreprise")
    public String showSignUpForm(Entreprise entreprise) {
        return "formNewEntreprise";
    }
	
	    @PostMapping("/addEntreprise")
	    public String addEntreprise(Entreprise entreprise, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewEntreprise";
	        }
	        
	        entrepriseService.saveEntreprise(entreprise);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listEntreprise")
	    public String showEntrepriseList(Model model) {
	    	Iterable<Entreprise> listEntreprise = entrepriseService.getEntreprise();
	        model.addAttribute("listEntreprise", listEntreprise);
	        
	        return "listEntreprise";
	    }
	    
	    @GetMapping("/editEntreprise/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Entreprise entreprise = entrepriseService.getEntreprise(id);
	        
	        model.addAttribute("entreprise", entreprise);
	        return "formUpdateEntreprise";
	    }
	    
	    @PostMapping("/updateEntreprise/{id}")
	    public String updateEntreprise(@PathVariable("id") long id, Entreprise entreprise, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	entreprise.setEnt_ID(id);
	            return "formUpdateEntreprise";
	        }
	            
	        repo.save(entreprise);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteEntreprise/{id}")
	    public String deleteEntreprise(@PathVariable("id") long id, Model model) {
	        entrepriseService.deleteEntreprise(id);
	        return "redirect:/home";
	    }

}