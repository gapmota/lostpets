package br.lostpets.project.service;

import org.junit.Test;

public class ViaCepTest {

	private ViaCep viaCep = new ViaCep();
	
	@Test
	public void viaCep() {
		System.out.println(viaCep.getLatitudeLongitude("08411-570"));
	}
	
}

