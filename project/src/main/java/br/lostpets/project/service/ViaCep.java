package br.lostpets.project.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.lostpets.project.model.Endereco;

public class ViaCep {

	private Client client;
 	private WebTarget webTarget;
 	private final static String URL = "http://viacep.com.br/ws/";
 	private final static String FIMURL = "/json/";

 	public ViaCep() {
 		this.client = ClientBuilder.newClient(); 
 	}
 	
 	public Endereco buscarCep(String cep){
 		this.webTarget = this.client.target(URL+cep+FIMURL).path(""); 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8"); 
		Response response = invocationBuilder.get();
		return response.readEntity(Endereco.class); 
	} 
 	
 	
	
}
