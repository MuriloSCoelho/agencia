package br.com.qintess.agencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100, name = "MARCA")
	private String marca;
	
	@Column(nullable = false, length = 100, name = "MODELO")
	private String modelo;
	
	@Column(nullable = false, length = 100, name = "ANO")
	private int ano;
	
	@Column(nullable = false, length = 100, name = "COR")
	private String cor;
	
	@Column(nullable = false, length = 100, name = "VALOR")
	private double valor;
	
	@ManyToOne
	@JoinColumn(name = "NotaFiscal", referencedColumnName = "id")
	private NotaFiscal nf;
	
	public Carro() {
		
	}

	public void setValor(double valor) {
		if (getMarca().equals("GM")) {
			this.valor = 1.25 * valor;
		} else {		
		this.valor = valor;
		}
	}
	
	
}
