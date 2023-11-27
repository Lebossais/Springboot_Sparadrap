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
public class Mutuelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Mut_ID;
	
	@ManyToOne
	@JoinColumn(name="Ent_ID")
	private Entreprise  Entreprise ;
	
	private int Mut_Departement;
	
	private int Mut_Prise_En_Charge;

}
