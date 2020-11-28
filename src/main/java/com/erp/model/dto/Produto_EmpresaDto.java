package com.erp.model.dto;

public class Produto_EmpresaDto {

	private String idProduto;

	private String dsLocalizacao;

	private Double qtCritica;

	private Double qtMinima;

	private Double qtMaxima;

	private Double alLucro;

	private String dtUltimaAtualizacao;

	private String stComercializacao;

	private String stAtivoCompra;

	private String stAtivoVenda;

	private EmpresaDto empresa;

	public Produto_EmpresaDto(String idProduto, String dsLocalizacao, Double qtCritica, Double qtMinima,
			Double qtMaxima, Double alLucro, String dtUltimaAtualizacao, String stComercializacao, String stAtivoCompra,
			String stAtivoVenda, EmpresaDto empresa) {
		super();
		this.idProduto = idProduto;
		this.dsLocalizacao = dsLocalizacao;
		this.qtCritica = qtCritica;
		this.qtMinima = qtMinima;
		this.qtMaxima = qtMaxima;
		this.alLucro = alLucro;
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
		this.stComercializacao = stComercializacao;
		this.stAtivoCompra = stAtivoCompra;
		this.stAtivoVenda = stAtivoVenda;
		this.empresa = empresa;
	}

	public Produto_EmpresaDto() {
		super();
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getDsLocalizacao() {
		return dsLocalizacao;
	}

	public void setDsLocalizacao(String dsLocalizacao) {
		this.dsLocalizacao = dsLocalizacao;
	}

	public Double getQtCritica() {
		return qtCritica;
	}

	public void setQtCritica(Double qtCritica) {
		this.qtCritica = qtCritica;
	}

	public Double getQtMinima() {
		return qtMinima;
	}

	public void setQtMinima(Double qtMinima) {
		this.qtMinima = qtMinima;
	}

	public Double getQtMaxima() {
		return qtMaxima;
	}

	public void setQtMaxima(Double qtMaxima) {
		this.qtMaxima = qtMaxima;
	}

	public Double getAlLucro() {
		return alLucro;
	}

	public void setAlLucro(Double alLucro) {
		this.alLucro = alLucro;
	}

	public String getDtUltimaAtualizacao() {
		return dtUltimaAtualizacao;
	}

	public void setDtUltimaAtualizacao(String dtUltimaAtualizacao) {
		this.dtUltimaAtualizacao = dtUltimaAtualizacao;
	}

	public String getStComercializacao() {
		return stComercializacao;
	}

	public void setStComercializacao(String stComercializacao) {
		this.stComercializacao = stComercializacao;
	}

	public String getStAtivoCompra() {
		return stAtivoCompra;
	}

	public void setStAtivoCompra(String stAtivoCompra) {
		this.stAtivoCompra = stAtivoCompra;
	}

	public String getStAtivoVenda() {
		return stAtivoVenda;
	}

	public void setStAtivoVenda(String stAtivoVenda) {
		this.stAtivoVenda = stAtivoVenda;
	}

	public EmpresaDto getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDto empresa) {
		this.empresa = empresa;
	}

}
