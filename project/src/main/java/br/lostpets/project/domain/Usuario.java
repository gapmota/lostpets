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
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2568754922310268151L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private UUID id;
	@Column(name="IS_ONLINE")
	private boolean isOnline;
	@Column(name="NOME")
	private String nome;
	@Column(name="ENDERECO")
	private String endereco;
	@Column(name="TELEFONE")
	private String telefone;
	@Column(name="SENHA")
	private String senha;
	@Column(name="CEP")
	private String cep;
	@Column(name="LOGRADOURO")
	private String logradouro;
	@Column(name="BAIRRO")
	private String bairro;
	@Column(name="LOCALIDADE")
	private String localidade;
	@Column(name="UF")
	private String uf;
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
	public void setID(UUID iD) {
		id = iD;
	}
	public boolean isIS_ONLINE() {
		return isOnline;
	}
	public void setIS_ONLINE(boolean iS_ONLINE) {
		isOnline = iS_ONLINE;
	}
	public String getNOME() {
		return nome;
	}
	public void setNOME(String nOME) {
		nome = nOME;
	}
	public String getENDERECO() {
		return endereco;
	}
	public void setENDERECO(String eNDERECO) {
		endereco = eNDERECO;
	}
	public String getTELEFONE() {
		return telefone;
	}
	public void setTELEFONE(String tELEFONE) {
		telefone = tELEFONE;
	}
	public String getSENHA() {
		return senha;
	}
	public void setSENHA(String sENHA) {
		senha = sENHA;
	}
	public String getCEP() {
		return cep;
	}
	public void setCEP(String cEP) {
		cep = cEP;
	}
	public String getLOGRADOURO() {
		return logradouro;
	}
	public void setLOGRADOURO(String lOGRADOURO) {
		logradouro = lOGRADOURO;
	}
	public String getBAIRRO() {
		return bairro;
	}
	public void setBAIRRO(String bAIRRO) {
		bairro = bAIRRO;
	}
	public String getLOCALIDADE() {
		return localidade;
	}
	public void setLOCALIDADE(String lOCALIDADE) {
		localidade = lOCALIDADE;
	}
	public String getUF() {
		return uf;
	}
	public void setUF(String uF) {
		uf = uF;
	}
	public Date getDT_ADD_SYSTEM() {
		return dataAdicionado;
	}
	public void setDT_ADD_SYSTEM(Date dT_ADD_SYSTEM) {
		dataAdicionado = dT_ADD_SYSTEM;
	}
	public Date getDT_UPD_SYSTEM() {
		return dataAtualizado;
	}
	public void setDT_UPD_SYSTEM(Date dT_UPD_SYSTEM) {
		dataAtualizado = dT_UPD_SYSTEM;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public List<String> getRemoveImages() {
		return removeImages;
	}
	public void setRemoveImages(List<String> removeImages) {
		this.removeImages = removeImages;
	} 
	
	
	
	
}
