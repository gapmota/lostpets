package br.lostpets.findpet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.lostpets.findpet.service.ServiceGeral;

@Entity
@Table(name="PETS_PERDIDO")
public class PetPerdido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_ANIMAL") private int idAnimal;
	
	@ManyToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@Column(name="NOME_ANIMAL") private String nomeAnimal;
	@Column(name="DATA_PERDIDO") private String dataPerdido;
	@Column(name="ATIVO") private String status;
	@Column(name="DESCRICAO") private String descricao;
	@Column(name="TIPO_ANIMAL") private String tipoAnimal;
	@Column(name="PATH_IMG")private String pathImg;
	@Column(name="CEP")private String cep;
	@Column(name="LATITUDE") private String latitude;
	@Column(name="LONGITUDE") private String longitude;
	@Column(name="ADD_DATA") private String addData = dataHora();
	
	@OneToMany(mappedBy = "petPerdido")
	private List<AnimaisAchados> animaisAchados;
	
	private String dataHora() {
		return new ServiceGeral().getDateHour();
	}

	public PetPerdido() {}

	public PetPerdido(Usuario usuario, String nomeAnimal, String dataPerdido, String descricao,
			String tipoAnimal, String pathImg, String cep, String latitude, String longitude) {
		this.usuario = usuario;
		this.nomeAnimal = nomeAnimal;
		this.dataPerdido = dataPerdido;
		this.status = "P";
		this.descricao = descricao;
		this.tipoAnimal = tipoAnimal;
		this.pathImg = pathImg;
		this.cep = cep;
		this.latitude = latitude;
		this.longitude = longitude;
		this.addData = dataHora();
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getDataPerdido() {
		return dataPerdido;
	}

	public void setDataPerdido(String dataPerdido) {
		this.dataPerdido = dataPerdido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getAddData() {
		return addData;
	}

	public void setAddData(String addData) {
		this.addData = addData;
	}

	@Override
	public String toString() {
		return "PetPerdido [idAnimal=" + idAnimal + ", usuario=" + usuario + ", nomeAnimal=" + nomeAnimal
				+ ", dataPerdido=" + dataPerdido + ", status=" + status + ", descricao=" + descricao + ", tipoAnimal="
				+ tipoAnimal + ", pathImg=" + pathImg + ", cep=" + cep + ", latitude=" + latitude + ", longitude="
				+ longitude + ", addData=" + addData + "]";
	}
	

}
