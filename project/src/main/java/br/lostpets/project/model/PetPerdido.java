package br.lostpets.project.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PETS_PERDIDO")
public class PetPerdido {

	@Id
	@GeneratedValue
	@Column(name = "ID_ANIMAL")
	private int idAnimal;
	@Column(name = "ID_USUARIO")
	private int idUsuario;
	@Column(name = "ID_DONO_PET_PERDIDO")
	private int idDonoPetPerdido;
	@Column(name = "NOME_ANIMAL")
	private String nomeAnimal;
	@Column(name = "DATA_PERDIDO")
	private Date dataPerdido;
	@Column(name = "ATIVO")
	private char ativo;
	@Column(name = "DESCRICAO")
	private String descricao;
	@Column(name = "TIPO_ANIMAL")
	private String tipoAnimal;
	@Column(name = "PATH_IMG")
	private String pathImg;
	@Column(name = "CEP")
	private String Cep;
	@Column(name = "LATITUDE")
	private String latitude;
	@Column(name = "LONGITUDE")
	private String longitude;
	@Column(name = "ADD_DATA")
	private Date addData;

	public PetPerdido(String nomeAnimal, String descricao, String tipoAnimal, String Cep) {
		this.nomeAnimal = nomeAnimal;
		this.descricao = descricao;
		this.tipoAnimal = tipoAnimal;
		this.Cep = Cep;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDonoPetPerdido() {
		return idDonoPetPerdido;
	}

	public void setIdDonoPetPerdido(int idDonoPetPerdido) {
		this.idDonoPetPerdido = idDonoPetPerdido;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public Date getDataPerdido() {
		return dataPerdido;
	}

	public void setDataPerdido(Date dataPerdido) {
		this.dataPerdido = dataPerdido;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
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
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
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

	public Date getAddData() {
		return addData;
	}

	public void setAddData(Date addData) {
		this.addData = addData;
	}

}
