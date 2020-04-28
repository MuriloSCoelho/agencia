package br.com.qintess.agencia.dto;

import lombok.Data;

@Data
public class NotaFiscalDTO {
	
	private int id;
	
	private String nome;
	
	private String cpf;
	
	private int qtd;
	
	private double preco;
	
	private double total;

}
