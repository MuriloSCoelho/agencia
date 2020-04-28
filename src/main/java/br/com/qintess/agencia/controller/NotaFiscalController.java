package br.com.qintess.agencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qintess.agencia.dto.NotaFiscalDTO;
import br.com.qintess.agencia.models.NotaFiscal;
import br.com.qintess.agencia.service.NotaFiscalService;

@RestController
@RequestMapping("/nota")
public class NotaFiscalController {
	
	@Autowired
	NotaFiscalService nfService;

	@GetMapping
	public ResponseEntity buscaTodas() {
		List<NotaFiscal> lista = nfService.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<NotaFiscal> salva(@RequestBody NotaFiscalDTO nfDTO) {
		nfService.salva(nfDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
