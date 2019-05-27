package br.lostpets.project.components;

import br.lostpets.project.model.PetPerdido;
import br.lostpets.project.model.Usuario;

public class PessoaAnimalComponent {

	private PetPerdido petPerdido;
	private Usuario usuario;

	// Usuario
	private String nomeUsuario;
	private String email;
	private String celular;
	private String telefone;

	// Animal
	private String tipoAnimal;
	private String nomeAnimal;
	private String data;
	private String imgId;
	private String bairro;
	private String cep;
	private String rua;
	private String cidade;

	public PessoaAnimalComponent() {
	}

	public PessoaAnimalComponent(String nomeUsuario, String email, String celular, String telefone, String tipoAnimal,
			String nomeAnimal, String data, String cep, String bairro, String rua, String cidade) {
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.celular = celular;
		this.telefone = telefone;
		this.tipoAnimal = tipoAnimal;
		this.nomeAnimal = nomeAnimal;
		this.data = data;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.cidade = cidade;
	}
	
	//getters
	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public String getData() {
		return data;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getCelular() {
		return celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getImgId() {
		return imgId;
	}
	
	//setters
	public void setTelefone() {
		usuario.setTelefoneFixo(getTelefone());
	}

	public void setNomeUsuario() {
		usuario.setNome(getNomeUsuario());
	}

	public void setCelular() {
		usuario.setTelefoneCelular(getCelular());
	}

	public void setEmail() {
		usuario.setEmail(getEmail());
	}
	
	public void setNomeAnimal() {
		petPerdido.setNomeAnimal(getNomeAnimal());
	}

	public void setTipoAnimal() {
		petPerdido.setTipoAnimal(getTipoAnimal());
	}
	
	public void setCep() {
		petPerdido.setCep(getCep());
	}
	
	public void setDataPerdido() {
		petPerdido.setDataPerdido(getData());
	}
	
	public void setImgId() {
		petPerdido.setPathImg(getImgId());
	}
}
