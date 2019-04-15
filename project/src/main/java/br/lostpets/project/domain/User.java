package br.lostpets.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="usuario")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2568754922310268151L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private UUID id;
	@Column(name="NOME")
	private String nome;
	@Column(name="EMAIL")
	private String email;
	@Column(name="SENHA")
	private String senha;
	@Column(name="TELEFONE")
	private String telefone;
	@Column(name="CIDADE")
	private String cidade;
	@Column(name="BAIRRO")
	private String bairro;
	@Column(name="LOGRADOURO")
	private String logradouro;
	@Column(name="NUM_CASA")
	private String numCasa;
	@Column(name="DT_ADD_SYSTEM")
	private Date dataAdicionado;
	@Column(name="DT_UPD_SYSTEM")
	private Date dataAtualizado;
	
	@Transient
	private List<MultipartFile> files = new ArrayList<MultipartFile>();
	@Transient
	private List<String> removeImages = new ArrayList<String>();
	public UUID getID() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}
	public Date getDataAdicionado() {
		return dataAdicionado;
	}
	public void setDataAdicionado(Date dataAdicionado) {
		this.dataAdicionado = dataAdicionado;
	}
	public Date getDataAtualizado() {
		return dataAtualizado;
	}
	public void setDataAtualizado(Date dataAtualizado) {
		this.dataAtualizado = dataAtualizado;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	 
		
	
}
