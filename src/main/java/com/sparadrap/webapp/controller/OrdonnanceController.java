package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.Achat;
import com.sparadrap.webapp.model.Compose;
import com.sparadrap.webapp.model.Panier;
import com.sparadrap.webapp.repository.AchatRepository;
import com.sparadrap.webapp.repository.ComposeRepository;
import com.sparadrap.webapp.repository.PanierRepository;
import com.sparadrap.webapp.service.AchatService;
import com.sparadrap.webapp.service.ComposeService;
import com.sparadrap.webapp.service.PanierService;
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

	@Autowired
	private ComposeService composeService;

	@Autowired
	private ComposeRepository composeRepo;

	@Autowired
	private AchatService achatService;

	@Autowired
	private AchatRepository achatRepo;

	@Autowired
	private PanierService panierService;

	@Autowired
	private PanierRepository panierRepo;

	@GetMapping("/signupOrdonnance")
    public String showSignUpForm(Ordonnance ordonnance) {
        return "form-new/formNewOrdonnance";
    }
	
	    @PostMapping("/addOrdonnance")
	    public String addOrdonnance(Ordonnance ordonnance, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewOrdonnance";
	        }
	        
	        ordonnanceService.saveOrdonnance(ordonnance);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listOrdonnance")
	    public String showOrdonnanceList(Model model) {
	    	Iterable<Ordonnance> listOrdonnance = ordonnanceService.getOrdonnance();
	        model.addAttribute("listOrdonnance", listOrdonnance);

			Iterable<Compose> listCompose = composeService.getCompose();
			model.addAttribute("listCompose", listCompose);

			Iterable<Achat> listAchat = achatService.getAchat();
			model.addAttribute("listAchat",listAchat);

			Iterable<Panier> listPanier = panierService.getPanier();
			model.addAttribute("listPanier", listPanier);

	        return "list/listOrdonnance";
	    }
	    
	    @GetMapping("/editOrdonnance/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Ordonnance ordonnance = ordonnanceService.getOrdonnance(id);
	        
	        model.addAttribute("ordonnance", ordonnance);
	        return "form-update/formUpdateOrdonnance";
	    }
	    
	    @PostMapping("/updateOrdonnance/{id}")
	    public String updateOrdonnance(@PathVariable("id") long id, Ordonnance ordonnance, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	ordonnance.setOrd_ID(id);
	            return "form-update/formUpdateOrdonnance";
	        }
	            
	        repo.save(ordonnance);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteOrdonnance/{id}")
	    public String deleteOrdonnance(@PathVariable("id") long id, Model model) {
	        ordonnanceService.deleteOrdonnance(id);
	        return "redirect:/home";
	    }

}