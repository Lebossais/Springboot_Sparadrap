package com.sparadrap.webapp.controller;

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
	        return "redirect:/";
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
	        
	        model.addAttribute("mutuelle", mutuelle);
	        return "formUpdateMutuelle";
	    }
	    
	    @PostMapping("/updateMutuelle/{id}")
	    public String updateMutuelle(@PathVariable("id") long id, Mutuelle mutuelle, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	mutuelle.setMut_ID(id);
	            return "formUpdateMutuelle";
	        }
	            
	        repo.save(mutuelle);
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteMutuelle/{id}")
	    public String deleteMutuelle(@PathVariable("id") long id, Model model) {
	        mutuelleService.deleteMutuelle(id);
	        return "redirect:/";
	    }

}