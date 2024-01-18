package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Categorie;
import com.sparadrap.webapp.repository.CategorieRepository;
import com.sparadrap.webapp.service.CategorieService;

import lombok.Data;

@Data
@Controller
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private CategorieRepository repo;
	    
	@GetMapping("/signupCategorie")
    public String showSignUpForm(Categorie categorie) {
        return "form-new/formNewCategorie";
    }
	
	    @PostMapping("/addCategorie")
	    public String addCategorie(Categorie categorie, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewCategorie";
	        }
	        
	        categorieService.saveCategorie(categorie);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listCategorie")
	    public String showCategorieList(Model model) {
	    	Iterable<Categorie> listCategorie = categorieService.getCategorie();
	        model.addAttribute("listCategorie", listCategorie);
	        
	        return "listCategorie";
	    }
	    
	    @GetMapping("/editCategorie/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Categorie categorie = categorieService.getCategorie(id);
	        
	        model.addAttribute("categorie", categorie);
	        return "formUpdateCategorie";
	    }
	    
	    @PostMapping("/updateCategorie/{id}")
	    public String updateCategorie(@PathVariable("id") long id, Categorie categorie, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            categorie.setCat_ID(id);
	            return "formUpdateCategorie";
	        }
	            
	        repo.save(categorie);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteCategorie/{id}")
	    public String deleteCategorie(@PathVariable("id") long id, Model model) {
	        categorieService.deleteCategorie(id);
	        return "redirect:/home";
	    }

}