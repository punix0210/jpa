package com.erp.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.erp.exception.ResponseException;
import com.erp.model.Produto;
import com.erp.repository.custom.ProdutoRepositoryCustom;

public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {

	@Autowired
	EntityManager manager;

	@Override
	public Produto findByIdProduto(String id) {
		
		EntityGraph<?> graph = this.manager.createEntityGraph("produto-graph");
		
		Optional<Produto> produto = (Optional<Produto>) this.manager.createQuery(
				"From Produto p Where p.idProduto = :id ",
				Produto.class)
				.setHint("javax.persistence.loadgraph", graph)
				.setParameter("id", id)
				.getResultList().stream().findFirst();

		if (!produto.isPresent()) {
			throw new ResponseException("Produto não localizado!");
		}

		return produto.get();
	}

	public List<Produto> findAllByStAtivo() {

		EntityGraph<?> graph = this.manager.createEntityGraph("produto-graph");
		
		List<Produto> rows = this.manager.createQuery("From Produto p " 
				+ "Where p.stAtivo = :ativo", Produto.class).setParameter("ativo", "S")
				.setHint("javax.persistence.loadgraph",graph)
				.setMaxResults(20)
				.getResultList();		

		return rows;

	}

}
