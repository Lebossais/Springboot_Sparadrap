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
public class Medicament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Medi_ID;
	
	private String Medi_Nom;
	
	private int Medi_Prix;


	private String Medi_Date_Mise_Service;
	
	@ManyToOne
	@JoinColumn(name="Cat_ID")
	private Categorie Categorie;
	
}
