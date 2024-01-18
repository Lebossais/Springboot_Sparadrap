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
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository repo;

	@Autowired
	private PersonneService personneService;

	@Autowired
	private PersonneRepository perRepo;

	@Autowired
	private AdresseService adresseService;

	@Autowired
	private AdresseRepository adrRepo;

	@Autowired
	private SpecialisteService specialisteService;

	@Autowired
	private SpecialisteRepository speRepo;

	@Autowired
	private MedecinService medecinService;

	@Autowired
	private MedecinRepository medecinRepo;

	@Autowired
	private MutuelleService mutuelleService;

	@Autowired
	private MutuelleRepository mutRepo;


	@GetMapping("/signupClient")
    public String showSignUpForm(Client client) {
        return "form-new/formNewClient";
    }
	
	    @PostMapping("/addClient")
	    public String addClient(Client client, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewClient";
	        }
	        
	        clientService.saveClient(client);
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/listClient")
	    public String showClientList(Model model) {
	    	Iterable<Client> listClient = clientService.getClient();
	        model.addAttribute("listClient", listClient);

			Iterable<Personne> listPersonne = personneService.getPersonne();
			model.addAttribute("listPersonne", listPersonne);

			Iterable<Adresse> listAdresse = adresseService.getAdresse();
			model.addAttribute("listAdresse", listAdresse);

			return "list/listClient";
	    }
	    
	    @GetMapping("/editClient/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Client client = clientService.getClient(id);

			Iterable<Personne> listPersonne = personneService.getPersonne();
			model.addAttribute("listPersonne", listPersonne);

			Iterable<Medecin> listMedecin = medecinService.getMedecin();
			model.addAttribute("listMedecin", listMedecin);

			Iterable<Specialiste> listSpecialiste = specialisteService.getSpecialiste();
			model.addAttribute("listSpecialiste", listSpecialiste);

			Iterable<Mutuelle> listMutuelle = mutuelleService.getMutuelle();
			model.addAttribute("listMutuelle", listMutuelle);

	        model.addAttribute("client", client);
	        return "form-update/formUpdateClient";
	    }
	    
	    @PostMapping("/updateClient/{id}")
	    public String updateClient(@PathVariable("id") long id, Client client, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            client.setCli_ID(id);
	            return "form-update/formUpdateClient";
	        }
	            
	        repo.save(client);
	        return "redirect:/home";
	    }
	        
	    @GetMapping("/deleteClient/{id}")
	    public String deleteClient(@PathVariable("id") long id, Model model) {
	        clientService.deleteClient(id);
	        return "redirect:/home";
	    }

}