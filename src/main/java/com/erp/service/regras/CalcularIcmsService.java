package com.erp.service.regras;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVendaItem;

@Service("icms")
@Qualifier("icms")
public class CalcularIcmsService implements CalculoImpostos {

//	@Qualifier("descontoIcms")
	private final Desconto descontoIcms;

	public CalcularIcmsService(Desconto descontoIcms) {
		this.descontoIcms = descontoIcms;
	}

	@Override
	public double calcular(PedidoDeVendaItem item, String uf) {
		Double valor = (Double) item.getVlItem() * 0.133;

		if (valor <= 0) {
			return valor;
		}

		return valor - this.descontoIcms.calcular(item);
	}

}
