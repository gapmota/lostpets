package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PETS_PERDIDO")
public class PetPerdido {

	@Id
	@GeneratedValue	
	@Column(name="ID_ANIMAL") private int idAnimal;
	
	@Column(name="ID_USUARIO") private int idUsuario;
	@Column(name="ID_DONO_PET_PERDIDO") private int idDonoPetPerdido;
	@Column(name="NOME_ANIMAL") private String nomeAnimal;
	@Column(name="DATA_PERDIDO") private Date dataPerdido;
	@Column(name="ATIVO") private char ativo;
	@Column(name="DESCRICAO") private String descricao;
	@Column(name="TIPO_ANIMAL") private String tipoAnimal;
	@Column(name="PATH_IMG")private String pathImg;
	@Column(name="CEP")private String Cep;
	@Column(name="LATITUDE") private String latitude;
	@Column(name="LONGITUDE") private String longitude;
	@Column(name="ADD_DATA") private Date addData;
	
	
	
}
