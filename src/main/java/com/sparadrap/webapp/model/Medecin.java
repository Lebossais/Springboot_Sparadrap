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
public class Medecin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Med_ID;
	
	@ManyToOne
	@JoinColumn(name="Per_ID")
	public Personne Personne;
	
	private String Med_Aggrement;
}
