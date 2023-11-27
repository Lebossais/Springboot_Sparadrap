package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.service.AdresseService;

import lombok.Data;

@Data
@Controller
public class AdresseController {
	
	@Autowired
	private AdresseService adresseService;
	
	@GetMapping("/")
	public String home(Model model) {
	    Iterable<Adresse> listAdresse = adresseService.getAdresse();
	    model.addAttribute("listAdresse", listAdresse);
	    
	    return "home";
	}
	
	@GetMapping("/createAdresse")
	public String createAdresse(Model model) {
		Adresse adr = new Adresse();
		model.addAttribute("adresse", adr);
		return "formNewAdresse";
	}

	@GetMapping("/updateAdresse/{id}")
	public String updateAdresse(@PathVariable("id")final int id, Model model) {
		Adresse adr = adresseService.getAdresse(id);
		model.addAttribute("Adresse", adr);
		return "formUpdateAdresse";
	}
	
	@GetMapping("/deleteAdresse/{id}")
	public ModelAndView deleteAdresse(@PathVariable("id") final Long id) {
		adresseService.deleteAdresse(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveAdresse")
	public ModelAndView saveEmployee(@ModelAttribute Adresse adresse) {
		if(adresse.getAdr_ID() != null) {
			
			Adresse current = adresseService.getAdresse(adresse.getAdr_ID());
		}
		adresseService.saveAdresse(adresse);
		return new ModelAndView("redirect:/");	
	}
	
}
