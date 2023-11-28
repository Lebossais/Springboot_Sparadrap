package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.service.AdresseService;

import lombok.Data;

@Data
@Controller
public class AdresseController {
	
	@Autowired
	private AdresseService adresseService;
	    
	@GetMapping("/signupAdresse")
    public String showSignUpForm(Adresse adresse) {
        return "formNewAdresse";
    }
	
	    @PostMapping("/addAdresse")
	    public String addAdresse(Adresse adresse, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewAdresse";
	        }
	        
	        adresseService.saveAdresse(adresse);
	        return "redirect:/index";
	    }
	    
	    @GetMapping("/")
	    public String showAdresseList(Model model) {
	    	Iterable<Adresse> listAdresse = adresseService.getAdresse();
	        model.addAttribute("listAdresse", listAdresse);
	        
	        return "home";
	    }
	    
	    @GetMapping("/editAdresse/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Adresse adresse = adresseService.getAdresse(id);
	        
	        model.addAttribute("adresse", adresse);
	        return "formUpdateAdresse";
	    }
	    
	    @PostMapping("/updateAdresse/{id}")
	    public String updateAdresse(@PathVariable("id") long id, Adresse adresse, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            adresse.setAdr_ID(id);
	            return "formUpdateAdresse";
	        }
	            
	        adresseService.saveAdresse(adresse);
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteAdresse/{id}")
	    public String deleteAdresse(@PathVariable("id") long id, Model model) {
	        adresseService.deleteAdresse(id);
	        return "redirect:/";
	    }

}
