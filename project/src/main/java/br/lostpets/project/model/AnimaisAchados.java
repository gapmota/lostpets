package br.lostpets.project.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ANIMAIS_ACHADOS")
public class AnimaisAchados {

	public AnimaisAchados() {}
	
	public AnimaisAchados(Usuario usuarioAchou, PetPerdido petPerdido, Date dataEncontrado, int pontos,
			String latitude, String longitude) {
		super();
		this.usuarioAchou = usuarioAchou;
		this.petPerdido = petPerdido;
		this.dataEncontrado = dataEncontrado;
		this.pontos = pontos;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = "A";
		
	}
	

	@Override
	public String toString() {
		return "AnimaisAchados [id=" + id + ", usuarioAchou=" + usuarioAchou + ", petPerdido=" + petPerdido
				+ ", dataEncontrado=" + dataEncontrado + ", pontos=" + pontos + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", status=" + status + ", addData=" + addData + "]";
	}
	
	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name="ID") private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USUARIO_ACHOU")
	private Usuario usuarioAchou;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PET_PERDIDO")
	private PetPerdido petPerdido;
	
	@Column(name="DATA_ENCONTRADO")	private Date dataEncontrado;
	@Column(name="PONTOS") private int pontos;
	@Column(name="LATITUDE") private String latitude;
	@Column(name="LONGIUDE") private String longitude;
	@Column(name="STATUS") private String status;
	@Column(name="ADD_DATA") private Date addData;
	
	
	public Usuario getUsuarioAchou() {
		return usuarioAchou;
	}
	public void setUsuarioAchou(Usuario usuarioAchou) {
		this.usuarioAchou = usuarioAchou;
	}
	public PetPerdido getPetPerdido() {
		return petPerdido;
	}
	public void setPetPerdido(PetPerdido petPerdido) {
		this.petPerdido = petPerdido;
	}
	public Date getDataEncontrado() {
		return dataEncontrado;
	}
	public void setDataEncontrado(Date dataEncontrado) {
		this.dataEncontrado = dataEncontrado;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAddData() {
		return addData;
	}
	public void setAddData(Date addData) {
		this.addData = addData;
	}
	public int getId() {
		return id;
	}
	
	
	
}
