package br.com.qintess.agencia.dto;

import java.util.List;

import br.com.qintess.agencia.models.Carro;
import br.com.qintess.agencia.models.NotaFiscal;
import lombok.Data;

@Data
public class NotaFiscalDTO {
	
	private int id;
	
	private String nome;
	
	private String cpf;
	
	private String funcionario;
	
	private int qtd;
	
	private double total;
	
	private List<Carro> carro;
	
	public NotaFiscal objeto() {
		return new NotaFiscal(id, nome, cpf, funcionario, qtd, total, carro);
	}

}
