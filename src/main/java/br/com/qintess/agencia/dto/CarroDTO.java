package br.com.qintess.agencia.dto;

import br.com.qintess.agencia.models.Carro;
import br.com.qintess.agencia.models.NotaFiscal;
import lombok.Data;

@Data
public class CarroDTO {
	
	private int id;
	
	private String marca;
	
	private String modelo;
	
	private int ano;
	
	private String cor;
	
	private double valor;
	
	private NotaFiscal nf;
	
	public Carro objeto() {
		return new Carro(id, marca, modelo, ano, cor, valor, nf);
	}

}
