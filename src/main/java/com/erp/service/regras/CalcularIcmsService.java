package com.erp.service.regras;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVendaItem;

@Service
@Qualifier("icms")
public class CalcularIcmsService implements CalculoImpostos {

	@Override
	public double calcular(PedidoDeVendaItem item, String uf) {		
		return (Double) item.getVlItem() * 0.133;
	}

	
	
}
