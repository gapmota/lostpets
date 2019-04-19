package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tipoanimal")
public class TipoAnimal {

	private int id;
	private String tipoAnimal;
	private Date addData;
	
}
