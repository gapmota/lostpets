package br.lostpets.project.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true, name = "ID_PESSOA")
	private UUID idPessoa;

	@Column(nullable = true, name = "NOME") private String nome;
	@Column(nullable = true, name = "TELEFONE_FIXO") private String telefoneFixo;
	@Column(nullable = true, name = "TELEFONE_CELULAR") private String telefoneCelular;
	@Column(nullable = true, name = "EMAIL") private String email;
	@Column(nullable = true, name = "SENHA") private String senha;
	@Column(nullable = true, name = "PATH_IMG") private String pathImg;
	@Column(nullable = true, name = "CEP") private String cep;
	@Column(nullable = true, name = "RUA") private String rua;
	@Column(nullable = true, name = "BAIRRO") private String bairro;
	@Column(nullable = true, name = "CIDADE") private String cidade;
	@Column(nullable = true, name = "UF") private String uf;
	@Column(nullable = true, name = "LATITUDE") private String latitude;
	@Column(nullable = true, name = "LONGITUDE") private String longitude;
	@Column(nullable = true, name = "ADD_CADASTRO") private String addCadastro;
	@Column(nullable = true, name = "ULTIMO_ACESSO") private String ultimoAcesso;

	public Usuario(String nome, String telefoneFixo, String telefoneCelular, String email, String senha, String pathImg, String cep,
			String rua, String bairro, String cidade, String uf, String latitude, String longitude, String addCadastro, String ultimoAcesso)
	{
		this.nome = nome;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
		this.senha = senha;
		this.pathImg = pathImg;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.latitude = latitude;
		this.longitude = longitude;
		this.addCadastro = addCadastro;
		this.ultimoAcesso = ultimoAcesso;
	}
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Usuario() {}
	
	public UUID getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(UUID idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

	public String getAddCadastro() {
		return addCadastro;
	}

	public void setAddCadastro(String addCadastro) {
		this.addCadastro = addCadastro;
	}

	public String getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(String ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	
}
