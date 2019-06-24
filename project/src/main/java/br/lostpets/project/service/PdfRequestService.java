package br.lostpets.project.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import br.lostpets.project.model.Endereco;
import br.lostpets.project.model.InfoPet;
import br.lostpets.project.model.PetPerdido;

@Service
public class PdfRequestService {
	
	private static final String URL_REQUEST = "http://localhost:8081/exportpdf";
	//private static final String URL_REQUEST = "http://pdflostpets.azurewebsites.net/exportpdf";
	
	private Client client;
 	private WebTarget webTarget;

 	public PdfRequestService() {
 		this.client = ClientBuilder.newClient(); 
 	}
 	
 	
 	public String downloadPdf(PetPerdido pet) {
 		InfoPet petRequest = new InfoPet(pet);
 		
 		this.webTarget = this.client.target(URL_REQUEST).path(""); 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8"); 
		Response response = invocationBuilder.post(Entity.entity(petRequest, "application/json;charset=UTF-8"));
		
		return response.readEntity(String.class);
		
 	}
	
}
