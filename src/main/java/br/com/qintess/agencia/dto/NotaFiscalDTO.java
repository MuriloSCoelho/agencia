package br.com.qintess.agencia.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private double total;
	
	private List<Carro> carro;
	
	public NotaFiscal objeto() {
		return new NotaFiscal(id, nome, cpf, funcionario, qtd, data, total, carro);
	}

}
