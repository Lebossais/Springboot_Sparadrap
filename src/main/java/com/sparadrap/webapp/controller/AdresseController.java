package com.sparadrap.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	
}
