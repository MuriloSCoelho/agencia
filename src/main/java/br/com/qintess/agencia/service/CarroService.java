package br.com.qintess.agencia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qintess.agencia.dto.CarroDTO;
import br.com.qintess.agencia.models.Carro;
import br.com.qintess.agencia.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository carroRepo;
	
	public List<Carro> buscarTodos() {
		List<Carro> carros = new ArrayList<Carro>();
		carroRepo.findAll().forEach(carro -> carros.add(carro));
		return carros;
	}
	
	public Carro buscaPorId(int id) {
		Optional<Carro> carro = carroRepo.findById(id);
		
		if (carro.isPresent()) {
			return carro.get();
		}
		return null;
	}
	
	/*
	 * public Carro buscaPorMarca(String marca) { Carro carro =
	 * carroRepo.buscaPorMarca(marca);
	 * 
	 * if (carro.getMarca().isEmpty()) { return null; } return carro;
	 * 
	 * }
	 */		 	
	public void salva(CarroDTO carroDTO) {
		ModelMapper modelMapper = new ModelMapper();
		
		Carro carro = modelMapper.map(carroDTO, Carro.class);
		
		carroRepo.save(carro);
		
	}
	
	public Carro deleta(int id) {
		carroRepo.deleteById(id);
		return null;
	}
	
	public Carro atualiza(CarroDTO carroDTO, int id) {
		
		ModelMapper modelMapper = new ModelMapper();
		Carro carro = modelMapper.map(carroDTO, Carro.class);
		
		if (carroRepo.findById(id) != null) {
			carroRepo.save(carro);
			return carro;
		} else {
			return carro;
		}		
	}

}
