package me.pimpao.awmoneyapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.pimpao.awmoneyapi.model.Lancamento;
import me.pimpao.awmoneyapi.model.Pessoa;
import me.pimpao.awmoneyapi.repository.LancamentoRepository;
import me.pimpao.awmoneyapi.repository.PessoaRepository;
import me.pimpao.awmoneyapi.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		if (!pessoaOptional.isPresent() || !pessoaOptional.get().isAtivo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		return lancamentoRepository.save(lancamento);
	}
	
}
