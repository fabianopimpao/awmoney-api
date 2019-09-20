package me.pimpao.awmoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import me.pimpao.awmoneyapi.model.Pessoa;
import me.pimpao.awmoneyapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Pessoa pessoa, Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");		
		return pessoaRepository.save(pessoaSalva);
	}
}
