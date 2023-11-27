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
public class Ordonnance {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Ord_ID;
	
	private String Ord_Num;
	
	private String Ord_Date;
	
	@ManyToOne
	@JoinColumn(name="Med_ID")
	private Medecin Medecin;
	
	@ManyToOne
	@JoinColumn(name="Spe_ID")
	private Specialiste Specialiste;
	
	@ManyToOne
	@JoinColumn(name="Cli_ID")
	private Client Client;

}
