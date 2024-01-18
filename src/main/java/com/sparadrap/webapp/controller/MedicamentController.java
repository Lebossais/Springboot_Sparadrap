package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.Categorie;
import com.sparadrap.webapp.repository.CategorieRepository;
import com.sparadrap.webapp.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Medicament;
import com.sparadrap.webapp.repository.MedicamentRepository;
import com.sparadrap.webapp.service.MedicamentService;

import lombok.Data;

@Data
@Controller
public class MedicamentController {
	
	@Autowired
	private MedicamentService medicamentService;
	
	@Autowired
	private MedicamentRepository repo;

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private CategorieRepository catRepo;
	    
	@GetMapping("/signupMedicament")
    public String showSignUpForm(Medicament medicament) {
        return "form-new/formNewMedicament";
    }
	
	    @PostMapping("/addMedicament")
	    public String addMedicament(Medicament medicament, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewMedicament";
	        }
	        
	        medicamentService.saveMedicament(medicament);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listMedicament")
	    public String showMedicamentList(Model model) {
	    	Iterable<Medicament> listMedicament = medicamentService.getMedicament();
	        model.addAttribute("listMedicament", listMedicament);

			Iterable<Categorie> listCategorie = categorieService.getCategorie();
			model.addAttribute("listCategorie", listCategorie);

			return "list/listMedicament";
	    }
	    
	    @GetMapping("/editMedicament/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Medicament medicament = medicamentService.getMedicament(id);
	        
			model.addAttribute("medicament", medicament);

			Iterable<Medicament> listMedicament = medicamentService.getMedicament();
			model.addAttribute("listMedicament", listMedicament);


			Iterable<Categorie> listCategorie = categorieService.getCategorie();
			model.addAttribute("listCategorie", listCategorie);

			return "form-update/formUpdateMedicament";
	    }
	    
	    @PostMapping("/updateMedicament/{id}")
	    public String updateMedicament(@PathVariable("id") long id, Medicament medicament, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	medicament.setMedi_ID(id);
	            return "form-update/formUpdateMedicament";
	        }
	            
	        repo.save(medicament);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteMedicament/{id}")
	    public String deleteMedicament(@PathVariable("id") long id, Model model) {
	        medicamentService.deleteMedicament(id);
	        return "redirect:/home";
	    }

}