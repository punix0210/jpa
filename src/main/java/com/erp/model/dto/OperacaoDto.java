package com.erp.model.dto;

public class OperacaoDto {

	private String idOperacao;

	private String cdChamada;

	private String nmOperacao;

	private String tpOperacao;

	private String idCfopIntraUf;

	private String idCfopEntreUf;

	private String stAtivo;

	private String stAtualizaFinanceiro;

	public OperacaoDto(String idOperacao, String cdChamada, String nmOperacao, String tpOperacao, String idCfopIntraUf,
			String idCfopEntreUf, String stAtivo, String stAtualizaFinanceiro) {
		super();
		this.idOperacao = idOperacao;
		this.cdChamada = cdChamada;
		this.nmOperacao = nmOperacao;
		this.tpOperacao = tpOperacao;
		this.idCfopIntraUf = idCfopIntraUf;
		this.idCfopEntreUf = idCfopEntreUf;
		this.stAtivo = stAtivo;
		this.stAtualizaFinanceiro = stAtualizaFinanceiro;
	}

	public OperacaoDto() {
		super();
	}

	public String getIdOperacao() {
		return idOperacao;
	}

	public void setIdOperacao(String idOperacao) {
		this.idOperacao = idOperacao;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmOperacao() {
		return nmOperacao;
	}

	public void setNmOperacao(String nmOperacao) {
		this.nmOperacao = nmOperacao;
	}

	public String getTpOperacao() {
		return tpOperacao;
	}

	public void setTpOperacao(String tpOperacao) {
		this.tpOperacao = tpOperacao;
	}

	public String getIdCfopIntraUf() {
		return idCfopIntraUf;
	}

	public void setIdCfopIntraUf(String idCfopIntraUf) {
		this.idCfopIntraUf = idCfopIntraUf;
	}

	public String getIdCfopEntreUf() {
		return idCfopEntreUf;
	}

	public void setIdCfopEntreUf(String idCfopEntreUf) {
		this.idCfopEntreUf = idCfopEntreUf;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getStAtualizaFinanceiro() {
		return stAtualizaFinanceiro;
	}

	public void setStAtualizaFinanceiro(String stAtualizaFinanceiro) {
		this.stAtualizaFinanceiro = stAtualizaFinanceiro;
	}

}
