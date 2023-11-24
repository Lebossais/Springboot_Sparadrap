package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Cli_ID;
	
	private String Cli_Date_Naissance;
	
	private String Cli_Numero_Secu;
	
	private Mutuelle Mutuelle;
	
	private Medecin Medecin_Traitant;
	
	private Specialiste Specialiste;
	
	public Personne Personne;

}
