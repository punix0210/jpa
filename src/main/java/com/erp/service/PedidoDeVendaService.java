package com.erp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.erp.model.PedidoDeVenda;
import com.erp.model.dto.PedidoDeVendaDto;
import com.erp.model.filter.PedidoDeVendaFilter;
import com.erp.repository.PedidoDeVendaRepository;
import com.erp.service.regras.CalculoImpostos;

@Service
public class PedidoDeVendaService {

	private PedidoDeVendaRepository repository;

	@Autowired
	@Qualifier("icms")
	private CalculoImpostos icms;

	@Autowired
	@Qualifier("iss")
	private CalculoImpostos iss;

	public PedidoDeVendaService(PedidoDeVendaRepository repository) {
		this.repository = repository;
	}

	public List<PedidoDeVendaDto> findAll() {
		List<PedidoDeVenda> pedidos = this.repository.findAllNotDeletedDataTable();
		return pedidos.stream().map(p -> p.convertTableDto()).collect(Collectors.toList());
	}

	public PedidoDeVendaDto findByIdPedido(String id) {
		PedidoDeVenda p = this.repository.findByIdPedido(id);
		p.getItems().stream().forEach(item -> {
			item.setVlIcms(icms.calcular(item, p.getEmpresa().getCdUf()));
			item.setVlISS(iss.calcular(item, p.getEmpresa().getCdUf()));
		});
		return p.convertDTO();
	}
	
	public List<PedidoDeVendaDto> search(PedidoDeVendaFilter filter) {
		List<PedidoDeVenda> pedidos = this.repository.search(filter);
		return pedidos.stream().map(p -> p.convertTableDto()).collect(Collectors.toList());		
	}

}
