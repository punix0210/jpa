package com.erp.service.regras;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVendaItem;

@Service("descontoIss")
@Qualifier("descontoIss")
public class DescontoIss implements Desconto{

	@Override
	public double calcular(PedidoDeVendaItem item) {
		return item.getProduto().getStServico() == "S" ? 0.30 : 1.20 ;
	}

}
