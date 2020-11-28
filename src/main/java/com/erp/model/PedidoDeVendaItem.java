package com.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedAttributeNode;
//import javax.persistence.NamedEntityGraph;
//import javax.persistence.NamedSubgraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erp.model.dto.PedidoDeVendaItemDto;

@Entity
@Table(name = "PedidoDeVendaItem", schema = "dbo")
//@NamedEntityGraph(name = "items-graph", attributeNodes = {
//		@NamedAttributeNode(value = "produto", subgraph = "produto-graph"),
//		@NamedAttributeNode("setorEntrada"),
//		@NamedAttributeNode("setorSaida")
//}
//,
//subgraphs = {
//		@NamedSubgraph(
//				name = "produto-graph",
//				attributeNodes = {
//						@NamedAttributeNode("codigos"),
//						@NamedAttributeNode("grupoProduto"),
//						@NamedAttributeNode("familiaProduto"),
//						@NamedAttributeNode("unidade")}
//				)
//		}
//
//)
public class PedidoDeVendaItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdPedidoDeVendaItem")
	private String idPedidoDeVendaItem;

	@Column(name = "IdPedidoDeVenda")
	private String idPedidoDeVenda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
	private Produto produto;

	@Column(name = "DsComplementoItem")
	private String dsComplementoItem;

	@Column(name = "QtPedida")
	private Double qtPedida;

	@Column(name = "QtAtendida")
	private Double qtAtendida;

	@Column(name = "VlItem")
	private Double vlItem;

	@Column(name = "VlUnitario")
	private Double vlUnitario;

	@Column(name = "VlAcrescimoItem")
	private Double vlAcrescimoItem;

	@Column(name = "VlDescontoItem")
	private Double vlDescontoItem;

	@Column(name = "StPedidoDeVendaItem")
	private String stPedidoDeVendaItem;

	@Column(name = "DtEntrega")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtEntrega;

	@Column(name = "TpDescontoItem")
	private String tpDescontoItem;

	@Column(name = "TpOrigemProduto")
	private String tpOrigemProduto;

	@Column(name = "TpEntrega")
	private String tpEntrega;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSetorEntradaTransEmp")
	private Setor setorEntrada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSetorSaida")
	private Setor setorSaida;

	@Column(name = "IdCFOP")
	private String idCFOP;

	@Column(name = "VlICMS")
	private Double vlIcms;

	@Column(name = "VlISS")
	private Double vlISS;

	public PedidoDeVendaItem(String idPedidoDeVendaItem, String idPedidoDeVenda, Produto produto,
			String dsComplementoItem, Double qtPedida, Double qtAtendida, Double vlItem, Double vlUnitario,
			Double vlAcrescimoItem, Double vlDescontoItem, String stPedidoDeVendaItem, Date dtEntrega,
			String tpDescontoItem, String tpOrigemProduto, String tpEntrega, Setor setorEntrada, Setor setorSaida,
			String idCFOP, Double vlIcms, Double vlISS) {
		super();
		this.idPedidoDeVendaItem = idPedidoDeVendaItem;
		this.idPedidoDeVenda = idPedidoDeVenda;
		this.produto = produto;
		this.dsComplementoItem = dsComplementoItem;
		this.qtPedida = qtPedida;
		this.qtAtendida = qtAtendida;
		this.vlItem = vlItem;
		this.vlUnitario = vlUnitario;
		this.vlAcrescimoItem = vlAcrescimoItem;
		this.vlDescontoItem = vlDescontoItem;
		this.stPedidoDeVendaItem = stPedidoDeVendaItem;
		this.dtEntrega = dtEntrega;
		this.tpDescontoItem = tpDescontoItem;
		this.tpOrigemProduto = tpOrigemProduto;
		this.tpEntrega = tpEntrega;
		this.setorEntrada = setorEntrada;
		this.setorSaida = setorSaida;
		this.idCFOP = idCFOP;
		this.vlIcms = vlIcms;
		this.vlISS = vlISS;
	}

	public PedidoDeVendaItem() {
		super();
	}

	public PedidoDeVendaItemDto convertDTO() {

		return new PedidoDeVendaItemDto(this.getIdPedidoDeVendaItem(), this.getIdPedidoDeVenda(),
				this.getProduto().convertDTO(), this.getDsComplementoItem(), this.getQtPedida(), this.getQtAtendida(),
				this.getVlItem(), this.getVlUnitario(), this.getVlAcrescimoItem(), this.getVlDescontoItem(),
				this.getStPedidoDeVendaItem(), this.getDtEntrega() == null ? null : this.getDtEntrega().toString(),
				this.getTpDescontoItem(), this.getTpOrigemProduto(), this.getTpEntrega(),
				this.getSetorEntrada() == null ? null : this.getSetorEntrada().convertToDto(),
				this.getSetorSaida() == null ? null : this.getSetorSaida().convertToDto(), this.getIdCFOP(),
				this.getVlIcms(), this.getVlISS());
	}

	public Double getVlISS() {
		return vlISS;
	}

	public void setVlISS(Double vlISS) {
		this.vlISS = vlISS;
	}

	public Double getVlIcms() {
		return vlIcms;
	}

	public void setVlIcms(Double vlIcms) {
		this.vlIcms = vlIcms;
	}

	public String getIdPedidoDeVendaItem() {
		return idPedidoDeVendaItem;
	}

	public void setIdPedidoDeVendaItem(String idPedidoDeVendaItem) {
		this.idPedidoDeVendaItem = idPedidoDeVendaItem;
	}

	public String getIdPedidoDeVenda() {
		return idPedidoDeVenda;
	}

	public void setIdPedidoDeVenda(String idPedidoDeVenda) {
		this.idPedidoDeVenda = idPedidoDeVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getDsComplementoItem() {
		return dsComplementoItem;
	}

	public void setDsComplementoItem(String dsComplementoItem) {
		this.dsComplementoItem = dsComplementoItem;
	}

	public Double getQtPedida() {
		return qtPedida;
	}

	public void setQtPedida(Double qtPedida) {
		this.qtPedida = qtPedida;
	}

	public Double getQtAtendida() {
		return qtAtendida;
	}

	public void setQtAtendida(Double qtAtendida) {
		this.qtAtendida = qtAtendida;
	}

	public Double getVlItem() {
		return vlItem;
	}

	public void setVlItem(Double vlItem) {
		this.vlItem = vlItem;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Double getVlAcrescimoItem() {
		return vlAcrescimoItem;
	}

	public void setVlAcrescimoItem(Double vlAcrescimoItem) {
		this.vlAcrescimoItem = vlAcrescimoItem;
	}

	public Double getVlDescontoItem() {
		return vlDescontoItem;
	}

	public void setVlDescontoItem(Double vlDescontoItem) {
		this.vlDescontoItem = vlDescontoItem;
	}

	public String getStPedidoDeVendaItem() {
		return stPedidoDeVendaItem;
	}

	public void setStPedidoDeVendaItem(String stPedidoDeVendaItem) {
		this.stPedidoDeVendaItem = stPedidoDeVendaItem;
	}

	public Date getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public String getTpDescontoItem() {
		return tpDescontoItem;
	}

	public void setTpDescontoItem(String tpDescontoItem) {
		this.tpDescontoItem = tpDescontoItem;
	}

	public String getTpOrigemProduto() {
		return tpOrigemProduto;
	}

	public void setTpOrigemProduto(String tpOrigemProduto) {
		this.tpOrigemProduto = tpOrigemProduto;
	}

	public String getTpEntrega() {
		return tpEntrega;
	}

	public void setTpEntrega(String tpEntrega) {
		this.tpEntrega = tpEntrega;
	}

	public Setor getSetorEntrada() {
		return setorEntrada;
	}

	public void setSetorEntrada(Setor setorEntrada) {
		this.setorEntrada = setorEntrada;
	}

	public Setor getSetorSaida() {
		return setorSaida;
	}

	public void setSetorSaida(Setor setorSaida) {
		this.setorSaida = setorSaida;
	}

	public String getIdCFOP() {
		return idCFOP;
	}

	public void setIdCFOP(String idCFOP) {
		this.idCFOP = idCFOP;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedidoDeVenda == null) ? 0 : idPedidoDeVenda.hashCode());
		result = prime * result + ((idPedidoDeVendaItem == null) ? 0 : idPedidoDeVendaItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDeVendaItem other = (PedidoDeVendaItem) obj;
		if (idPedidoDeVenda == null) {
			if (other.idPedidoDeVenda != null)
				return false;
		} else if (!idPedidoDeVenda.equals(other.idPedidoDeVenda))
			return false;
		if (idPedidoDeVendaItem == null) {
			if (other.idPedidoDeVendaItem != null)
				return false;
		} else if (!idPedidoDeVendaItem.equals(other.idPedidoDeVendaItem))
			return false;
		return true;
	}

}
