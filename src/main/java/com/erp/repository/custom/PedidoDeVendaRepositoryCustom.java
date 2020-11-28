package com.erp.repository.custom;

import java.util.List;

import com.erp.model.PedidoDeVenda;
import com.erp.model.filter.PedidoDeVendaFilter;

public interface PedidoDeVendaRepositoryCustom {

	public List<PedidoDeVenda> findAllNotDeletedDataTable();
	
	public PedidoDeVenda findByIdPedido(String id);
	
	public List<PedidoDeVenda> search(PedidoDeVendaFilter filter);
}
