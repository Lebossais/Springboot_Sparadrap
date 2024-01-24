package com.sparadrap.webapp.controller;

import com.sparadrap.webapp.model.Achat;
import com.sparadrap.webapp.model.Adresse;
import com.sparadrap.webapp.model.Medicament;
import com.sparadrap.webapp.model.Panier;
import com.sparadrap.webapp.repository.AchatRepository;
import com.sparadrap.webapp.repository.MedicamentRepository;
import com.sparadrap.webapp.repository.PanierRepository;
import com.sparadrap.webapp.service.AchatService;
import com.sparadrap.webapp.service.PanierService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Data
@Controller
public class PanierController {

    @Autowired
    PanierService panierService;

    @Autowired
    PanierRepository repo;

    @Autowired
    AchatService achatService;

    @Autowired
    AchatRepository achatRepository;

    @Autowired
    MedicamentRepository medicamentRepository;

    @GetMapping("/signupPanier")
    public String showSignUpForm(Panier panier, Model model) {
        Iterable<Achat> listAchat = achatService.getAchat();
        model.addAttribute("listAchat", listAchat);

        Achat achat = achatRepository.findTopByOrderByAchatidDesc();
        model.addAttribute("achatid", achat);

        Optional<Medicament> medicament=medicamentRepository.findById(panier.getMedicament().getMedi_ID());
        medicament.ifPresent(panier::setMedicament);
        return "form-new/formNewAchat";
    }

    @PostMapping("/addPanier")
    public String addPanier(Panier panier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form-new/formNewAchat";
        }

        panierService.savePanier(panier);
        return "redirect:/home";
    }

}
