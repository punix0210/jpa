package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.model.dto.OperacaoDto;

@Entity
@Table(name = "Operacao", schema = "dbo")
public class Operacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdOperacao")
	private String idOperacao;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "NmOperacao")
	private String nmOperacao;

	@Column(name = "TpOperacao")
	private String tpOperacao;

	@Column(name = "IdCFOPIntraUF")
	private String idCfopIntraUf;

	@Column(name = "IdCFOPEntreUF")
	private String idCfopEntreUf;

	@Column(name = "StAtivo")
	private String stAtivo;

	@Column(name = "StAtualizaFinanceiro")
	private String stAtualizaFinanceiro;

	public Operacao(String idOperacao, String cdChamada, String nmOperacao, String tpOperacao, String idCfopIntraUf,
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

	public Operacao() {
		super();
	}

	public OperacaoDto convertToDto() {
		return new OperacaoDto(this.getIdOperacao(), this.getCdChamada(), this.getNmOperacao(), this.getTpOperacao(),
				this.getIdCfopIntraUf(), this.getIdCfopEntreUf(), this.getStAtivo(), this.getStAtualizaFinanceiro());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOperacao == null) ? 0 : idOperacao.hashCode());
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
		Operacao other = (Operacao) obj;
		if (idOperacao == null) {
			if (other.idOperacao != null)
				return false;
		} else if (!idOperacao.equals(other.idOperacao))
			return false;
		return true;
	}

}
