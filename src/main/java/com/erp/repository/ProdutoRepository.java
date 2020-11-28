package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.model.Produto;
import com.erp.repository.custom.ProdutoRepositoryCustom;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String>, ProdutoRepositoryCustom {

}
