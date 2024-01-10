package com.sparadrap.webapp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Cli_ID;
	
	private Date Cli_Date_Naissance;
	
	private Integer Cli_Numero_Secu;
	
	@ManyToOne
	@JoinColumn(name="Mut_ID")
	private Mutuelle Mutuelle;
	
	@ManyToOne
	@JoinColumn(name="Med_ID")
	private Medecin Medecin;
	
	@ManyToOne
	@JoinColumn(name="Spe_ID")
	private Specialiste Specialiste;
	
	@ManyToOne
	@JoinColumn(name="Per_ID")
	public Personne Personne;
	
}
