package br.lostpets.project.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ServiceGeral {
	
	private Date dataHoraAtual = new Date();
	private String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	private String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	
	
	public String getDateHour() {
		return data + " " + hora;
	}
	
	public String getDate() {
		return data;
	}
	
	public String getHour() {
		return hora;
	}
	
	
	
}
