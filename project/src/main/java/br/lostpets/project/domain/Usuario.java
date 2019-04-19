package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	private int idPessoa;
	private String nome;
	private String telefoneFixo;
	private String telefoneCelular;
	private String email;
	private String senha;
	private String pathImg;
	private String Cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String latitude;
	private String longitude;
	private String addCadastro;
	private Date ultimoAcesso;
	
	//construtor temporario para funcionamento de acesso
	public Usuario(String email, String senha){
		this.email = email;
		this.senha = senha;
	}
	public Usuario() {}
	
	//get e set criado para funcionamento de acesso por repository SeguranAplicacao
	public String getEmail() {
		return this.email;
	}
	public String getSenha() {
		return this.senha;
	}
	
}
