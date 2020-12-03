package com.erp.service.regras;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVendaItem;

@Service("iss")
@Qualifier("iss")
public class CalcularIssService implements CalculoImpostos {

//	@Qualifier("descontoIss")
	private final Desconto descontoIss;

	public CalcularIssService(Desconto descontoIss) {
		this.descontoIss = descontoIss;
	}

	@Override
	public double calcular(PedidoDeVendaItem item, String uf) {
		double valor = item.getProduto().getStServico() == "S" ? item.getVlItem() * 0.04 : 0;

//		if (valor <= 0) {
//			return valor;
//		}

		return valor - this.descontoIss.calcular(item);
	}

}
