package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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

	@Autowired
	private PersonneRepository perRepo;

	@GetMapping("/signupSpecialiste")
    public String showSignUpForm(Specialiste specialiste, Model model) {
		model.addAttribute("listPersonne", perRepo.findAll());
        return "form-new/formNewSpecialiste";
    }
	
	    @PostMapping("/addSpecialiste")
	    public String addSpecialiste(Specialiste specialiste, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewSpecialiste";
	        }
	        
	        specialisteService.saveSpecialiste(specialiste);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listSpecialiste")
	    public String showSpecialisteList(Model model) {
	    	Iterable<Specialiste> listSpecialiste = specialisteService.getSpecialiste();
	        model.addAttribute("listSpecialiste", listSpecialiste);
	        
	        return "list/listSpecialiste";
	    }
	    
	    @GetMapping("/editSpecialiste/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Specialiste specialiste = specialisteService.getSpecialiste(id);
	        
	        model.addAttribute("specialiste", specialiste);
	        return "form-update/formUpdateSpecialiste";
	    }
	    
	    @PostMapping("/updateSpecialiste/{id}")
	    public String updatePersonne(@PathVariable("id") long id, Specialiste specialiste, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	specialiste.setSpe_ID(id);
	            return "form-update/formUpdateSpecialiste";
	        }
	            
	        repo.save(specialiste);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteSpecialiste/{id}")
	    public String deleteSpecialiste(@PathVariable("id") long id, Model model) {
	    	specialisteService.deleteSpecialiste(id);
	        return "redirect:/home";
	    }

}