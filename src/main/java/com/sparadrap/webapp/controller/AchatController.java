package com.sparadrap.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sparadrap.webapp.model.Achat;
import com.sparadrap.webapp.repository.AchatRepository;
import com.sparadrap.webapp.service.AchatService;

import lombok.Data;

@Data
@Controller
public class AchatController {
	
	@Autowired
	private AchatService achatService;
	
	@Autowired
	private AchatRepository repo;
	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}

	@GetMapping("/signupAchat")
    public String showSignUpForm(Achat achat) {
        return "formNewAchat";
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
