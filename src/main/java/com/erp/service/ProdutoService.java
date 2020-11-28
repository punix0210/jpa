package com.erp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.erp.model.Produto;
import com.erp.model.dto.ProdutoDto;
import com.erp.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository repository;

	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	public ProdutoDto findByIdProduto(String id){
		return this.repository.findByIdProduto(id).convertDTO();
	}
	
	public List<ProdutoDto> findAll(){
		List<Produto> produtos = this.repository.findAllByStAtivo();
		
		return produtos.stream().map(item -> item.convertDTO()).collect(Collectors.toList());
	}

}
