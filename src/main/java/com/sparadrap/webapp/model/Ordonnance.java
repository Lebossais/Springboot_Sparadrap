package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ordonnance {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Ord_ID;
	
	private String Ord_Num;
	
	private String Ord_Date;
	
	private Medecin Medecin;
	
	private Specialiste Specialiste;
	
	private Client Client;


}
