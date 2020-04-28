package br.com.qintess.agencia.dto;

import lombok.Data;

@Data
public class CarroDTO {
	
	private int id;
	
	private String marca;
	
	private String modelo;
	
	private int ano;
	
	private String cor;
	
	private double valor;

}
