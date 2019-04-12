package br.lostpets.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_files")
public class UserFiles implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4272706566053817496L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="FILE_NAME")
	private String fileName;
	@Column(name="MOD_FILE_NAME")
	private String modifieldFileName;
	@Column(name="FILE_EXTENSION")
	private String fileExtension;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Usuario user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getModifieldFileName() {
		return modifieldFileName;
	}
	public void setModifieldFileName(String modifieldFileName) {
		this.modifieldFileName = modifieldFileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
}
