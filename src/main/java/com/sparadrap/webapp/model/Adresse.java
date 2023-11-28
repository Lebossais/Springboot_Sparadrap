package com.sparadrap.webapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Adr_ID;
	
	private int Adr_Numero_Rue;
	
	private String Adr_Nom_Rue;
	
	private int Adr_Code_Postal;
	
	private String Adr_Ville;
	

}
