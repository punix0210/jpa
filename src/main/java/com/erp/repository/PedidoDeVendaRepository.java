package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.model.PedidoDeVenda;
import com.erp.repository.custom.PedidoDeVendaRepositoryCustom;

@Repository
public interface PedidoDeVendaRepository extends JpaRepository<PedidoDeVenda, String>, PedidoDeVendaRepositoryCustom {

}
