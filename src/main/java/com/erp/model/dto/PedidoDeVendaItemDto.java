package com.erp.model.dto;

public class PedidoDeVendaItemDto {

	private String idPedidoDeVendaItem;
	private String idPedidoDeVenda;
	private ProdutoDto produto;
	private String dsComplementoItem;
	private Double qtPedida;
	private Double qtAtendida;
	private Double vlItem;
	private Double vlUnitario;
	private Double vlAcrescimoItem;
	private Double vlDescontoItem;
	private String stPedidoDeVendaItem;
	private String dtEntrega;
	private String tpDescontoItem;
	private String tpOrigemProduto;
	private String tpEntrega;
	private SetorDto setorEntrada;
	private SetorDto setorSaida;
	private String idCfop;
	private Double vlIcms;
	private Double vlISS;

	public PedidoDeVendaItemDto(String idPedidoDeVendaItem, String idPedidoDeVenda, ProdutoDto produto,
			String dsComplementoItem, Double qtPedida, Double qtAtendida, Double vlItem, Double vlUnitario,
			Double vlAcrescimoItem, Double vlDescontoItem, String stPedidoDeVendaItem, String dtEntrega,
			String tpDescontoItem, String tpOrigemProduto, String tpEntrega, SetorDto setorEntrada, SetorDto setorSaida,
			String idCfop, Double vlIcms, Double vlISS) {
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
		this.idCfop = idCfop;
		this.vlIcms = vlIcms;
		this.vlISS = vlISS;
	}

	public PedidoDeVendaItemDto() {
		super();
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

	public ProdutoDto getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDto produto) {
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

	public String getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(String dtEntrega) {
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

	public SetorDto getSetorEntrada() {
		return setorEntrada;
	}

	public void setSetorEntrada(SetorDto setorEntrada) {
		this.setorEntrada = setorEntrada;
	}

	public SetorDto getSetorSaida() {
		return setorSaida;
	}

	public void setSetorSaida(SetorDto setorSaida) {
		this.setorSaida = setorSaida;
	}

	public String getIdCfop() {
		return idCfop;
	}

	public void setIdCfop(String idCfop) {
		this.idCfop = idCfop;
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
		PedidoDeVendaItemDto other = (PedidoDeVendaItemDto) obj;
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
