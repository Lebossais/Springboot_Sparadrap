package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Personne {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Per_ID;
	
    private String Per_Prenom ;
     
    private String Per_Nom ;
    
    @ManyToOne
	@JoinColumn(name="Adr_ID")
    private Adresse Adresse;
     
    private String Per_Telephone;
     
    private String Per_Email;
    
}
