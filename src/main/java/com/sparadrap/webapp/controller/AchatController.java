package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.*;
import com.sparadrap.webapp.repository.*;
import com.sparadrap.webapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;

@Data
@Controller
public class AchatController {
	
	@Autowired
	private AchatService achatService;
	
	@Autowired
	private AchatRepository repo;

	@Autowired
	private SpecialisteService specialisteService;

	@Autowired
	private SpecialisteRepository speRepo;

	@Autowired
	private MedecinService medecinService;

	@Autowired
	private MedecinRepository medecinRepo;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private MedicamentService medicamentService;

	@Autowired
	private MedicamentRepository mediRepo;


	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}

	@GetMapping("/newAchat")
    public String showSignUpForm(Achat achat, Model model) {
		Iterable<Medecin> listMedecin = medecinService.getMedecin();
		model.addAttribute("listMedecin", listMedecin);

		Iterable<Specialiste> listSpecialiste = specialisteService.getSpecialiste();
		model.addAttribute("listSpecialiste", listSpecialiste);

		Iterable<Client> listClient = clientService.getClient();
		model.addAttribute("listClient", listClient);

		Iterable<Medicament> listMedicament = medicamentService.getMedicament();
		model.addAttribute("listMedicament", listMedicament);

		return "new-achat";
    }
	
	    @PostMapping("/addAchat")
	    public String addAchat(Achat achat, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "formNewAchat";
	        }
	        
	        achatService.saveAchat(achat);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/listAchat")
	    public String showAchatList(Model model) {
	    	Iterable<Achat> listAchat = achatService.getAchat();
	        model.addAttribute("listAchat", listAchat);
	        
	        return "listAchat";
	    }
	    
	    @GetMapping("/editAchat/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        Achat achat = achatService.getAchat(id);
	        
	        model.addAttribute("achat", achat);
	        return "formUpdateAchat";
	    }
	    
	    @PostMapping("/updateAchat/{id}")
	    public String updateAdresse(@PathVariable("id") long id, Achat achat, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            achat.setAchat_ID(id);
	            return "formUpdateAchat";
	        }
	            
	        repo.save(achat);
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteAchat/{id}")
	    public String deleteAchat(@PathVariable("id") long id, Model model) {
	        achatService.deleteAchat(id);
	        return "redirect:/";
	    }

}
