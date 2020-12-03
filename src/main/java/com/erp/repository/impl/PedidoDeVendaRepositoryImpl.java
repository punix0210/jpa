package com.erp.repository.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.erp.exception.ResponseException;
import com.erp.model.PedidoDeVenda;
import com.erp.model.filter.PedidoDeVendaFilter;
import com.erp.repository.custom.PedidoDeVendaRepositoryCustom;
import com.erp.util.Utilitario;

public class PedidoDeVendaRepositoryImpl implements PedidoDeVendaRepositoryCustom {

	@Autowired
	EntityManager manager;

	@Override
	public List<PedidoDeVenda> findAllNotDeletedDataTable() {

//		EntityGraph<?> graph = this.manager.createEntityGraph("pedido-graph");

		List<PedidoDeVenda> rows = this.manager.createQuery(
				"From PedidoDeVenda p " + "join fetch p.empresa " + "join fetch p.setor " + "join fetch p.cliente "
						+ "join fetch p.usuario " + "Where p.stPedidoDeVenda not in (:stPedidoDeVenda) ",
				PedidoDeVenda.class).setParameter("stPedidoDeVenda", "C").getResultList();

		return rows;
	}

	public PedidoDeVenda findByIdPedido(String id) {

		EntityGraph<?> graph = this.manager.createEntityGraph("pedido-graph");

		Optional<PedidoDeVenda> row = this.manager
				.createQuery("From PedidoDeVenda p where p.idPedidoDeVenda = :id", PedidoDeVenda.class)
				.setHint("javax.persistence.loadgraph", graph).setParameter("id", id).getResultList().stream()
				.findFirst();

		if (!row.isPresent()) {
			throw new ResponseException("Pedido de venda não localizado");
		}

		return row.get();
	}

	@SuppressWarnings({"unchecked" })
	@Override
	public List<PedidoDeVenda> search(PedidoDeVendaFilter filter) {

		EntityGraph<?> graph = this.manager.createEntityGraph("pedido-graph");

		String sql = "select p from PedidoDeVenda p ";
		String condicao = "Where ";

		if (filter.getPedido() != null && !filter.getPedido().equals("")) {
			sql += condicao + " p.cdChamada like :cdChamada ";
			condicao = " and ";
		}

		if (filter.getCliente() != null && !filter.getCliente().equals("")) {
			sql += condicao + " p.cliente.nmPessoa like :cliente ";
			condicao = " and ";
		}

		if (filter.getDataInicio() != null && !filter.getDataInicio().equals("")) {
			sql += condicao + " p.dtEmissao >= :dtIni ";
			condicao = " and ";
		}

		if (filter.getDataFinal() != null && !filter.getDataFinal().equals("")) {
			sql += condicao + " p.dtEmissao <= :dtFim ";
			condicao = " and ";
		}

		Query query = this.manager.createQuery(sql, PedidoDeVenda.class)
				.setHint("javax.persistence.loadgraph", graph);

		if (filter.getPedido() != null && !filter.getPedido().equals("")) {
			query.setParameter("cdChamada","%"+filter.getPedido()+"%");
		}

		if (filter.getCliente() != null && !filter.getCliente().equals("")) {
			query.setParameter("cliente", "%"+filter.getCliente()+"%" );
		}

		if (filter.getDataInicio() != null && !filter.getDataInicio().equals("")) {
			try {
				query.setParameter("dtIni", Utilitario.convertToDate(filter.getDataInicio()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (filter.getDataFinal() != null && !filter.getDataFinal().equals("")) {
			try {
				query.setParameter("dtFim", Utilitario.convertToDate(filter.getDataInicio()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return (List<PedidoDeVenda>) query.getResultList();
	}

}
