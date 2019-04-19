package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="petperdido")
public class PetPerdido {

	private int idAnimal;
	private int idUsuario;
	private int idDonoPetPerdido;
	private String nomeAnimal;
	private Date dataperdido;
	private char ativo;
	private String descricao;
	private String tipoAnimal;
	private String pathImg;
	private String Cep;
	private String latitude;
	private String longitude;
	private Date AddData;
	
	
	
}
