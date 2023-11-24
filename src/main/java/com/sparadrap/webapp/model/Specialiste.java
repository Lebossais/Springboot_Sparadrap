package com.sparadrap.webapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Specialiste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Spe_ID;
	
	private Personne Personne;
	
	private String Spe_Specialite;

}
