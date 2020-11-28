package com.erp.service.regras;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVendaItem;

@Service
@Qualifier("iss")
public class CalcularIssService implements CalculoImpostos {

	@Override
	public double calcular(PedidoDeVendaItem item, String uf) {
		return item.getProduto().getStServico() == "S" ? item.getVlItem() * 0.04 : 0;

	}

}
