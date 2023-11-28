package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Ordonnance;
import com.sparadrap.webapp.repository.OrdonnanceRepository;
import com.sparadrap.webapp.service.OrdonnanceService;

import lombok.Data;

@Data
@Controller
public class OrdonnanceController {
	
	@Autowired
	private OrdonnanceService ordonnanceService;
	
	@Autowired
	private OrdonnanceRepository repo;
	    
	@GetMapping("/signupOrdonnance")
    public String showSignUpForm(Ordonnance ordonnance) {
        return "formNewOrdonnance";
    }
	
	    @PostMapping("/addOrdonnance")
	    public String addOrdonnance(Ordonnance ordonnance, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewOrdonnance";
	        }
	        
	        ordonnanceService.saveOrdonnance(ordonnance);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/listOrdonnance")
	    public String showOrdonnanceList(Model model) {
	    	Iterable<Ordonnance> listOrdonnance = ordonnanceService.getOrdonnance();
	        model.addAttribute("listOrdonnance", listOrdonnance);
	        
	        return "listOrdonnance";
	    }
	    
	    @GetMapping("/editOrdonnance/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Ordonnance ordonnance = ordonnanceService.getOrdonnance(id);
	        
	        model.addAttribute("ordonnance", ordonnance);
	        return "formUpdateOrdonnance";
	    }
	    
	    @PostMapping("/updateOrdonnance/{id}")
	    public String updateOrdonnance(@PathVariable("id") long id, Ordonnance ordonnance, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	ordonnance.setOrd_ID(id);
	            return "formUpdateOrdonnance";
	        }
	            
	        repo.save(ordonnance);
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteOrdonnance/{id}")
	    public String deleteOrdonnance(@PathVariable("id") long id, Model model) {
	        ordonnanceService.deleteOrdonnance(id);
	        return "redirect:/";
	    }

}