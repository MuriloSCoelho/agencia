package br.com.qintess.agencia.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@Column(nullable = false, name = "DATA")
	private LocalDate data;
		
	@Column(nullable = true, name = "TOTAL")
	private double total;
	
	@OneToMany
	private List<Carro> carro;
		
	public NotaFiscal() {
		
	}
	
	public void setTotal(double total) {
		if (getFuncionario().equals("Sim")) {
			this.total = getQtd() * ((Carro) carro).getValor()/ 1.25;
		}
		this.total = getQtd() * ((Carro) carro).getValor();
	}

}
