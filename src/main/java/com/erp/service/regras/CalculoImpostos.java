package com.erp.service.regras;

import com.erp.model.PedidoDeVendaItem;

public interface CalculoImpostos {

	public double calcular(PedidoDeVendaItem item, String uf);

}
