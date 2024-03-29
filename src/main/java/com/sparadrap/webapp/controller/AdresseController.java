package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.repository.AdresseRepository;
import com.sparadrap.webapp.service.AdresseService;

import lombok.Data;

@Data
@Controller
public class AdresseController {
	
	@Autowired
	private AdresseService adresseService;
	
	@Autowired
	private AdresseRepository repo;
	    
	@GetMapping("/signupAdresse")
    public String showSignUpForm(Adresse adresse) {
        return "form-new/formNewAdresse";
    }
	
	    @PostMapping("/addAdresse")
	    public String addAdresse(Adresse adresse, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewAdresse";
	        }
	        
	        adresseService.saveAdresse(adresse);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listAdresse")
	    public String showAdresseList(Model model) {
	    	Iterable<Adresse> listAdresse = adresseService.getAdresse();
	        model.addAttribute("listAdresse", listAdresse);
	        
	        return "list/listAdresse";
	    }
	    
	    @GetMapping("/editAdresse/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Adresse adresse = adresseService.getAdresse(id);
	        
	        model.addAttribute("adresse", adresse);
	        return "form-update/formUpdateAdresse";
	    }
	    
	    @PostMapping("/updateAdresse/{id}")
	    public String updateAdresse(@PathVariable("id") long id, Adresse adresse, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            adresse.setAdr_ID(id);
	            return "form-update/formUpdateAdresse";
	        }
	            
	        repo.save(adresse);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteAdresse/{id}")
	    public String deleteAdresse(@PathVariable("id") long id, Model model) {
	        adresseService.deleteAdresse(id);
	        return "redirect:/home";
	    }

}
