package com.sparadrap.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="Achat_ID")
	private Long achatid;

	private Date Achat_Date;

	@ManyToOne
	@JoinColumn(name="Cli_ID")
	private Client	Client;

	@ManyToOne
	@JoinColumn(name="Ord_ID")
	private Ordonnance Ordonnance;
	
}