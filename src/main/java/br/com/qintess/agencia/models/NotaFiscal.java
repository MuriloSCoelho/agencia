package br.com.qintess.agencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class NotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100, name = "NOME")
	private String nome;
	
	@Column(nullable = false, length = 14, name = "CPF")
	private String cpf;
	
	@Column(nullable = false, length = 14, name = "FUNCIONARIO")
	private String funcionario;
	
	@Column(nullable = false, name = "QTD")
	private int qtd;
	
	@Column(nullable = false, name = "PRECO")
	private double preco;
	@Column(nullable = true, name = "TOTAL")
	private double total;
		
	public NotaFiscal() {
		
	}
	
	public void setTotal(double total) {
		if (getFuncionario().equals("Sim")) {
			this.total = getQtd() * getPreco() / 1.25;
		}
		this.total = getQtd() * getPreco();
	}

}
