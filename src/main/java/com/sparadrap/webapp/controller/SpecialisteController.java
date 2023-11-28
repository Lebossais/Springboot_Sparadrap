package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Specialiste;
import com.sparadrap.webapp.repository.SpecialisteRepository;
import com.sparadrap.webapp.service.SpecialisteService;

import lombok.Data;

@Data
@Controller
public class SpecialisteController {
	
	@Autowired
	private SpecialisteService specialisteService;
	
	@Autowired
	private SpecialisteRepository repo;
	    
	@GetMapping("/signupSpecialiste")
    public String showSignUpForm(Specialiste specialiste) {
        return "formNewSpecialiste";
    }
	
	    @PostMapping("/addSpecialiste")
	    public String addSpecialiste(Specialiste specialiste, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewSpecialiste";
	        }
	        
	        specialisteService.saveSpecialiste(specialiste);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/listSpecialiste")
	    public String showSpecialisteList(Model model) {
	    	Iterable<Specialiste> listSpecialiste = specialisteService.getSpecialiste();
	        model.addAttribute("listSpecialiste", listSpecialiste);
	        
	        return "listSpecialiste";
	    }
	    
	    @GetMapping("/editSpecialiste/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Specialiste specialiste = specialisteService.getSpecialiste(id);
	        
	        model.addAttribute("specialiste", specialiste);
	        return "formUpdateSpecialiste";
	    }
	    
	    @PostMapping("/updateSpecialiste/{id}")
	    public String updatePersonne(@PathVariable("id") long id, Specialiste specialiste, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	specialiste.setSpe_ID(id);
	            return "formUpdateSpecialiste";
	        }
	            
	        repo.save(specialiste);
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteSpecialiste/{id}")
	    public String deleteSpecialiste(@PathVariable("id") long id, Model model) {
	    	specialisteService.deleteSpecialiste(id);
	        return "redirect:/";
	    }

}