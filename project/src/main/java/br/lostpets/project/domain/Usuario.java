package br.lostpets.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name="ID_PESSOA") private int idPessoa;
	
	@Column(name="NOME") private String nome;
	@Column(name="TELEFONE_FIXO") private String telefoneFixo;
	@Column(name="TELEFONE_CELULAR") private String telefoneCelular;
	@Column(name="EMAIL") private String email;
	@Column(name="SENHA") private String senha;
	@Column(name="PATH_IMG") private String pathImg;
	@Column(name="CEP") private String cep;
	@Column(name="RUA") private String rua;
	@Column(name="BAIRRO") private String bairro;
	@Column(name="CIDADE") private String cidade;
	@Column(name="UF") private String uf;
	@Column(name="LATITUDE") private String latitude;
	@Column(name="LONGITUDE") private String longitude;
	@Column(name="ADD_CADASTRO") private String addCadastro;
	@Column(name="ULTIMO_ACESSO") private Date ultimoAcesso;

	public Usuario(String nome, String telefoneFixo, String telefoneCelular, String email, String senha, String pathImg,
			String cep, String rua, String bairro, String cidade, String uf, String latitude, String longitude,
			String addCadastro, Date ultimoAcesso) {
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
	//construtor funcionamento de acesso
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
