package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="animaisachados")
public class AnimaisAchados {

	private int id;
	private int idUsuarioAchou;
	private int idPetPerdido;
	private Date dataEncontrado;
	private int Pontos;
	private Date addData;
	
}
