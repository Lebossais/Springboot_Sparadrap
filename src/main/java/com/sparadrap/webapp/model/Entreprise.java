package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Ent_ID;
	
    private String Ent_Raison_Sociale;
    
    private String Ent_Telephone;
    
    private String Ent_Email;
    
    private Adresse Adresse;

}
