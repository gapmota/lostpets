package br.lostpets.project.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

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
		
		Endereco endereco = response.readEntity(Endereco.class);
		
		return this.getLatitudeLongitude(endereco);
	} 
 	
 	private Endereco getLatitudeLongitude(Endereco endereco) {
 		String URL = "https://geocoder.api.here.com/6.2/geocode.json?searchtext="+(endereco.getLogradouro().replaceAll(" ", "%20")+"%20"+endereco.getBairro().replaceAll(" ", "%20")+"%20Brazil").toUpperCase()
 				+ "&app_id=YxULymX19IjsS2pE7KGo"
 				+ "&app_code=6isWeBIxu4YmK1hfYF6s1w"
 				+ "&gen=9";
 		
 		this.webTarget = this.client.target(URL).path(""); 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8"); 
		Response response = invocationBuilder.get();
	
		JSONObject data = new JSONObject(response.readEntity(String.class));
		JSONObject displayPosition = data.getJSONObject("Response").getJSONArray("View").getJSONObject(0).getJSONArray("Result").getJSONObject(0).getJSONObject("Location").getJSONObject("DisplayPosition");
		
		endereco.setLatitude(displayPosition.getDouble("Latitude"));
		endereco.setLongitude(displayPosition.getDouble("Longitude"));
		
		return endereco;
 	}
 	
}
