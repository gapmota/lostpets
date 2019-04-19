package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="donopetperdido")
public class DonoPetPerdido {

	private int id;
	private String nome;
	private String telefoneFixo;
	private String telefoneCelular;
	private String email;
	private Date addData;
	
	
}
