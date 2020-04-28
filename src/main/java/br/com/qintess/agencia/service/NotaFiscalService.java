package br.com.qintess.agencia.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qintess.agencia.dto.NotaFiscalDTO;
import br.com.qintess.agencia.models.NotaFiscal;
import br.com.qintess.agencia.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {
	
	@Autowired
	NotaFiscalRepository nfRepo;
	
	public List<NotaFiscal> buscarTodos() {
		List<NotaFiscal> nfs = new ArrayList<NotaFiscal>();
		nfRepo.findAll().forEach(nf -> nfs.add(nf));
		return nfs;
	}
	
	public void salva(NotaFiscalDTO nfDTO) {
		ModelMapper modelMapper = new ModelMapper();
		NotaFiscal nf = modelMapper.map(nfDTO, NotaFiscal.class);
		nfRepo.save(nf);
	}

}
