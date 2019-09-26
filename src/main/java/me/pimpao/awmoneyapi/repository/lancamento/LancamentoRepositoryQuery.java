package me.pimpao.awmoneyapi.repository.lancamento;

import java.util.List;

import me.pimpao.awmoneyapi.model.Lancamento;
import me.pimpao.awmoneyapi.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {
	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
}
