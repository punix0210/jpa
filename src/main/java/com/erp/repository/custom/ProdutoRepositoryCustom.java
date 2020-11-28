package com.erp.repository.custom;

import java.util.List;

import com.erp.model.Produto;

public interface ProdutoRepositoryCustom {

	Produto findByIdProduto(String id);
	public List<Produto> findAllByStAtivo();
}
