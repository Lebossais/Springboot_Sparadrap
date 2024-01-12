package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.Mutuelle;
import com.sparadrap.webapp.model.Specialiste;
import com.sparadrap.webapp.repository.MutuelleRepository;
import com.sparadrap.webapp.repository.PersonneRepository;
import com.sparadrap.webapp.repository.SpecialisteRepository;
import com.sparadrap.webapp.service.MutuelleService;
import com.sparadrap.webapp.service.PersonneService;
import com.sparadrap.webapp.service.SpecialisteService;
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
	private SpecialisteService specialisteService;

	@Autowired
	private MedecinService medecinService;
	
	@Autowired
	private MedecinRepository repo;

	@Autowired
	private PersonneRepository perRepo;

	@Autowired
	private PersonneService perService;

	@Autowired
	private SpecialisteRepository speRepo;

	@Autowired
	private MutuelleService mutuelleService;

	@Autowired
	private MutuelleRepository mutRepo;

	    
	@GetMapping("/signupMedecin")
    public String showSignUpForm(Medecin medecin, Model model) {
		model.addAttribute("listPersonne", perRepo.findAll());
        return "form-new/formNewMedecin";
    }
	
	    @PostMapping("/addMedecin")
	    public String addMedecin(Medecin medecin, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewMedecin";
	        }
	        
	        medecinService.saveMedecin(medecin);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listMedecin")
	    public String showMedecinList(Model model) {
			Iterable<Medecin> listMedecin = medecinService.getMedecin();
			model.addAttribute("listMedecin", listMedecin);

			Iterable<Specialiste> listSpecialiste = specialisteService.getSpecialiste();
			model.addAttribute("listSpecialiste", listSpecialiste);

			Iterable<Mutuelle> listMutuelle = mutuelleService.getMutuelle();
			model.addAttribute("listMutuelle", listMutuelle);
	        
	        return "list/listMedecin";
	    }
	    
	    @GetMapping("/editMedecin/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Medecin medecin = medecinService.getMedecin(id);
	        
	        model.addAttribute("medecin", medecin);
	        return "form-update/formUpdateMedecin";
	    }
	    
	    @PostMapping("/updateMedecin/{id}")
	    public String updateMedecin(@PathVariable("id") long id, Medecin medecin, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	medecin.setMed_ID(id);
	            return "form-update/formUpdateMedecin";
	        }
	            
	        repo.save(medecin);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteMedecin/{id}")
	    public String deleteMedecin(@PathVariable("id") long id, Model model) {
	        medecinService.deleteMedecin(id);
	        return "redirect:/home";
	    }

}