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
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo); 
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");		
		return pessoaRepository.save(pessoaSalva);
	}
	
	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}
	
	private Pessoa buscarPessoaPeloCodigo(Long codigo) {
		return pessoaRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
}
