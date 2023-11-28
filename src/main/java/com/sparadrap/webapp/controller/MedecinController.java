package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Medecin;
import com.sparadrap.webapp.repository.MedecinRepository;
import com.sparadrap.webapp.service.MedecinService;

import lombok.Data;

@Data
@Controller
public class MedecinController {
	
	@Autowired
	private MedecinService medecinService;
	
	@Autowired
	private MedecinRepository repo;
	    
	@GetMapping("/signupMedecin")
    public String showSignUpForm(Medecin medecin) {
        return "formNewMedecin";
    }
	
	    @PostMapping("/addMedecin")
	    public String addMedecin(Medecin medecin, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewMedecin";
	        }
	        
	        medecinService.saveMedecin(medecin);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/listMedecin")
	    public String showMedecinList(Model model) {
	    	Iterable<Medecin> listMedecin = medecinService.getMedecin();
	        model.addAttribute("listMedecin", listMedecin);
	        
	        return "listMedecin";
	    }
	    
	    @GetMapping("/editMedecin/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Medecin medecin = medecinService.getMedecin(id);
	        
	        model.addAttribute("medecin", medecin);
	        return "formUpdateMedecin";
	    }
	    
	    @PostMapping("/updateMedecin/{id}")
	    public String updateMedecin(@PathVariable("id") long id, Medecin medecin, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	medecin.setMed_ID(id);
	            return "formUpdateMedecin";
	        }
	            
	        repo.save(medecin);
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteMedecin/{id}")
	    public String deleteMedecin(@PathVariable("id") long id, Model model) {
	        medecinService.deleteMedecin(id);
	        return "redirect:/";
	    }

}