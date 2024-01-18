package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.Entreprise;
import com.sparadrap.webapp.repository.EntrepriseRepository;
import com.sparadrap.webapp.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Mutuelle;
import com.sparadrap.webapp.repository.MutuelleRepository;
import com.sparadrap.webapp.service.MutuelleService;

import lombok.Data;

@Data
@Controller
public class MutuelleController {
	
	@Autowired
	private MutuelleService mutuelleService;
	
	@Autowired
	private MutuelleRepository repo;

	@Autowired
	private EntrepriseService entrepriseService;

	@Autowired
	private EntrepriseRepository mutRepo;
	    
	@GetMapping("/signupMutuelle")
    public String showSignUpForm(Mutuelle mutuelle) {
        return "formNewMutuelle";
    }
	
	    @PostMapping("/addMutuelle")
	    public String addMutuelle(Mutuelle mutuelle, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewMutuelle";
	        }
	        
	        mutuelleService.saveMutuelle(mutuelle);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listMutuelle")
	    public String showMutuelleList(Model model) {
	    	Iterable<Mutuelle> listMutuelle = mutuelleService.getMutuelle();
	        model.addAttribute("listMutuelle", listMutuelle);
	        
	        return "listMutuelle";
	    }
	    
	    @GetMapping("/editMutuelle/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Mutuelle mutuelle = mutuelleService.getMutuelle(id);

			Iterable<Entreprise> listEntreprise = entrepriseService.getEntreprise();
			model.addAttribute("listEntreprise", listEntreprise);

			model.addAttribute("mutuelle", mutuelle);
	        return "form-update/formUpdateMutuelle";
	    }
	    
	    @PostMapping("/updateMutuelle/{id}")
	    public String updateMutuelle(@PathVariable("id") long id, Mutuelle mutuelle, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	mutuelle.setMut_ID(id);
	            return "form-update/formUpdateMutuelle";
	        }
	            
	        repo.save(mutuelle);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteMutuelle/{id}")
	    public String deleteMutuelle(@PathVariable("id") long id, Model model) {
	        mutuelleService.deleteMutuelle(id);
	        return "redirect:/home";
	    }

}