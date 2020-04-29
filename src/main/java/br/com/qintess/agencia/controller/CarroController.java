package br.com.qintess.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.agencia.dto.CarroDTO;
import br.com.qintess.agencia.models.Carro;
import br.com.qintess.agencia.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroService carroService;
	
	@GetMapping
	public ResponseEntity buscaTodos() {
		List<Carro> lista = carroService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> buscaPorId(@PathVariable("id") int id) {
		Carro carro = carroService.buscaPorId(id);
		
		if (carro != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*
	 * @GetMapping("/{marca}") public ResponseEntity<Carro>
	 * buscaPorMarca(@RequestBody String marca) { Carro carro =
	 * carroService.buscaPorMarca(marca);
	 * 
	 * if (carro != null) { return new ResponseEntity<>(HttpStatus.OK); } return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 */	 		
	@PostMapping
	public ResponseEntity<Carro> salvaCarro(@RequestBody CarroDTO carroDTO) {
		carroService.salva(carroDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Carro> deletaCarro(@PathVariable("id") int id) {
		Carro carro = carroService.deleta(id);
		return new ResponseEntity<>(carro, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carro> atualizaCarro(@RequestBody CarroDTO carroDTO, @PathVariable("id") int id) {
		Carro carro = carroService.atualiza(carroDTO, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
