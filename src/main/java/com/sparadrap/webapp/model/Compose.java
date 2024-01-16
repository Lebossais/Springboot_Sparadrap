package com.sparadrap.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Compose {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Comp_ID;

	@ManyToOne
	@JoinColumn(name="Ord_ID")
	private Ordonnance Ordonnance;

	@ManyToOne
	@JoinColumn(name="Medi_ID")
	private Medicament Medicament;

	private int Compose_Qte;

}
