package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Client;
import com.sparadrap.webapp.repository.ClientRepository;
import com.sparadrap.webapp.service.ClientService;

import lombok.Data;

@Data
@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository repo;
	    
	@GetMapping("/signupClient")
    public String showSignUpForm(Client client) {
        return "formNewClient";
    }
	
	    @PostMapping("/addClient")
	    public String addClient(Client client, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "form-new/formNewClient";
	        }
	        
	        clientService.saveClient(client);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/listClient")
	    public String showClientList(Model model) {
	    	Iterable<Client> listClient = clientService.getClient();
	        model.addAttribute("listClient", listClient);
	        
	        return "list/listClient";
	    }
	    
	    @GetMapping("/editClient/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Client client = clientService.getClient(id);
	        
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
	        return "redirect:/";
	    }
	        
	    @GetMapping("/deleteClient/{id}")
	    public String deleteClient(@PathVariable("id") long id, Model model) {
	        clientService.deleteClient(id);
	        return "redirect:/";
	    }

}