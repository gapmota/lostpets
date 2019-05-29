package br.lostpets.findpet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DONO_PET_PERDIDO")
public class DonoPetPerdido {

	@Id
	@GeneratedValue
	@Column(name="ID") private int id;
	
	@Column(name="NOME") private String nome;
	@Column(name="TELEFONE_FIXO") private String telefoneFixo;
	@Column(name="TELEFONE_CELULAR") private String telefoneCelular;
	@Column(name="EMAIL") private String email;
	@Column(name="ADD_DATA") private Date addData;
	
	
}
