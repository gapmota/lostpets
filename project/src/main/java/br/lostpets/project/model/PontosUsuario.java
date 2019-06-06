package br.lostpets.project.model;

public class PontosUsuario {
	
	private int idUsuario;
	private int pontos;
	private String nomeUsuario;
	private int quantidadePetsAchados;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public int getQuantidadePetsAchados() {
		return quantidadePetsAchados;
	}
	
	public void setQuantidadePetsAchados(int quantidadePetsAchados) {
		this.quantidadePetsAchados = quantidadePetsAchados;
	}
	
	public PontosUsuario(int idUsuario, int pontos, String nomeUsuario, int quantidadePetsAchados) {
		super();
		this.idUsuario = idUsuario;
		this.pontos = pontos;
		this.nomeUsuario = nomeUsuario;
		this.quantidadePetsAchados = quantidadePetsAchados;
	}

	@Override
	public String toString() {
		return "PontosUsuario [idUsuario=" + idUsuario + ", pontos=" + pontos + ", nomeUsuario=" + nomeUsuario
				+ ", quantidadePetsAchados=" + quantidadePetsAchados + "]";
	}
}
