package com.erp.service.regras;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVendaItem;

@Service("descontoIcms")
@Qualifier("descontoIcms")
public class DescontoIcms implements Desconto {

	@Override
	public double calcular(PedidoDeVendaItem item) {
		return 0.20;
	}

}
