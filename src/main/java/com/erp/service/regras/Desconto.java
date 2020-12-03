package com.erp.service.regras;

import com.erp.model.PedidoDeVendaItem;

public interface Desconto {

	public double calcular(PedidoDeVendaItem item);
}
