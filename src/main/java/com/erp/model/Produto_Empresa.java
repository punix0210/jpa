package com.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.erp.model.dto.Produto_EmpresaDto;

@Entity
@Table(name = "Produto_Empresa", schema = "dbo")
public class Produto_Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Produto_EmpresaPK id;

	@Column(name = "DsLocalizacao")
	private String dsLocalizacao;

	@Column(name = "QtCritica")
	private Double qtCritica;

	@Column(name = "QtMinima")
	private Double qtMinima;

	@Column(name = "QtMaxima")
	private Double qtMaxima;

	@Column(name = "AlLucro")
	private Double alLucro;

	@Column(name = "DtUltimaAtualizacao")
	private Date dtUltimaAtualizacao;

	@Column(name = "StComercializacao")
	private String stComercializacao;

	@Column(name = "StAtivoCompra")
	private String stAtivoCompra;

	@Column(name = "StAtivoVenda")
	private String stAtivoVenda;

	@MapsId("CdEmpresa")
	@ManyToOne
	@JoinColumn(name = "CdEmpresa", referencedColumnName = "CdEmpresa")
	private EmpresaERP empresa;

	public Produto_Empresa(Produto_EmpresaPK id, String dsLocalizacao, Double qtCritica, Double qtMinima,
			Double qtMaxima, Double alLucro, Date dtUltimaAtualizacao, String stComercializacao, String stAtivoCompra,
			String stAtivoVenda, EmpresaERP empresa) {
		super();
		this.id = id;
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

	public Produto_Empresa() {
		super();
	}
	
	public Produto_EmpresaDto convertDTO() {
		
		return new Produto_EmpresaDto(
				this.id.getIdProduto()  ,
				this.dsLocalizacao  ,
				this.qtCritica  ,
				this.qtMinima  ,
				this.qtMaxima  ,
				this.alLucro  ,
				this.dtUltimaAtualizacao == null ? null : this.dtUltimaAtualizacao.toString()  ,
				this.stComercializacao  ,
				this.stAtivoCompra  ,
				this.stAtivoVenda  ,
				this.empresa.convertDTO() 				
				);
	}

	public Produto_EmpresaPK getId() {
		return id;
	}

	public void setId(Produto_EmpresaPK id) {
		this.id = id;
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

	public Date getDtUltimaAtualizacao() {
		return dtUltimaAtualizacao;
	}

	public void setDtUltimaAtualizacao(Date dtUltimaAtualizacao) {
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

	public EmpresaERP getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaERP empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto_Empresa other = (Produto_Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
