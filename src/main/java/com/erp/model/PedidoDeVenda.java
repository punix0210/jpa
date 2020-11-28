package com.erp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erp.model.dto.PedidoDeVendaDto;
import com.erp.model.dto.PedidoDeVendaItemDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NamedEntityGraph(name="pedido-graph",attributeNodes = {
		@NamedAttributeNode("cliente"),
		@NamedAttributeNode("transportador"),
		@NamedAttributeNode("empresa"),
		@NamedAttributeNode("setor"),		
		@NamedAttributeNode("operacao"),
		@NamedAttributeNode(value = "usuario"),
		@NamedAttributeNode(value = "items", subgraph = "items-graph")
},
subgraphs = {
		@NamedSubgraph(
				name = "items-graph", 
				attributeNodes = {
						@NamedAttributeNode(value = "produto", subgraph = "produto-graph"),
						@NamedAttributeNode("setorEntrada"),
						@NamedAttributeNode("setorSaida")
				   }
				),
		@NamedSubgraph(
				name = "produto-graph",
				attributeNodes = {
						@NamedAttributeNode("codigos"),
						@NamedAttributeNode("grupoProduto"),
						@NamedAttributeNode("familiaProduto"),
						@NamedAttributeNode("unidade"),	
						@NamedAttributeNode(value = "setores", subgraph = "setores-graph"),
						@NamedAttributeNode(value = "empresas", subgraph = "empresas-graph")
				}
				),
		@NamedSubgraph(name="setores-graph", attributeNodes = {
				@NamedAttributeNode("setor"),
		}),
		@NamedSubgraph(name="empresas-graph", attributeNodes = {
				@NamedAttributeNode("empresa"),
		})		
		}
)
@Entity
@Table(name = "PedidoDeVenda", schema = "dbo")
public class PedidoDeVenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdPedidoDeVenda")
	private String idPedidoDeVenda;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "CdContratoDeCompraCliente")
	private String cdContratoDeCompraCliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CdEmpresa", referencedColumnName = "CdEmpresa")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private EmpresaERP empresa;

	@Column(name = "CdEmpresaEstoque")
	private Integer cdEmpresaEstoque;

	@Column(name = "CdEmpresaFinanceiro")
	private Integer cdEmpresaFinanceiro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSetor", referencedColumnName = "IdSetor")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Setor setor;

	@Column(name = "DtEmissao")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtEmissao;

	@Column(name = "DtEntrada")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtEntrada;

	@Column(name = "DtEntrega")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtEntrega;

	@Column(name = "StPedidoDeVenda")
	private String stPedidoDeVenda;

	@ManyToOne
	@JoinColumn(name = "IdPessoaCliente", referencedColumnName = "IdPessoa")
	private Pessoa cliente;

	@Column(name = "CdEnderecoPrincipal")
	private String cdEnderecoPrincipal;

	@Column(name = "CdEnderecoCobranca")
	private String cdEnderecoCobranca;

	@Column(name = "CdEnderecoEntrega")
	private String cdEnderecoEntrega;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "IdOperacao", referencedColumnName = "IdOperacao")
	private Operacao operacao;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "IdPessoaTransportador", referencedColumnName = "IdPessoa")
	private Pessoa transportador;

	@Column(name = "TpFretePorConta")
	private String tpFretePorConta;

	@Column(name = "DsObservacaoPedido")
	private String dsObservacaoPedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
	private Usuario usuario;

	@Column(name = "DtReferenciaPagamento")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtReferenciaPagamento;

	@Column(name = "DtCancelamento")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtCancelamento;

	@Column(name = "TpPedidoDeVenda")
	private String tpPedidoDeVenda;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPedidoDeVenda", referencedColumnName = "IdPedidoDeVenda")
	private Set<PedidoDeVendaItem> items = new HashSet<PedidoDeVendaItem>();

	public PedidoDeVenda(String idPedidoDeVenda, String cdChamada, String cdContratoDeCompraCliente, EmpresaERP empresa,
			Integer cdEmpresaEstoque, Integer cdEmpresaFinanceiro, Setor setor, Date dtEmissao, Date dtEntrada,
			Date dtEntrega, String stPedidoDeVenda, Pessoa cliente, String cdEnderecoPrincipal,
			String cdEnderecoCobranca, String cdEnderecoEntrega, Operacao operacao, Pessoa transportador,
			String tpFretePorConta, String dsObservacaoPedido, Usuario usuario, Date dtReferenciaPagamento,
			Date dtCancelamento, String tpPedidoDeVenda) {
		super();
		this.idPedidoDeVenda = idPedidoDeVenda;
		this.cdChamada = cdChamada;
		this.cdContratoDeCompraCliente = cdContratoDeCompraCliente;
		this.empresa = empresa;
		this.cdEmpresaEstoque = cdEmpresaEstoque;
		this.cdEmpresaFinanceiro = cdEmpresaFinanceiro;
		this.setor = setor;
		this.dtEmissao = dtEmissao;
		this.dtEntrada = dtEntrada;
		this.dtEntrega = dtEntrega;
		this.stPedidoDeVenda = stPedidoDeVenda;
		this.cliente = cliente;
		this.cdEnderecoPrincipal = cdEnderecoPrincipal;
		this.cdEnderecoCobranca = cdEnderecoCobranca;
		this.cdEnderecoEntrega = cdEnderecoEntrega;
		this.operacao = operacao;
		this.transportador = transportador;
		this.tpFretePorConta = tpFretePorConta;
		this.dsObservacaoPedido = dsObservacaoPedido;
		this.usuario = usuario;
		this.dtReferenciaPagamento = dtReferenciaPagamento;
		this.dtCancelamento = dtCancelamento;
		this.tpPedidoDeVenda = tpPedidoDeVenda;
	}

	public PedidoDeVenda() {
		super();
	}
	
	public PedidoDeVendaDto convertTableDto() {
		return new PedidoDeVendaDto(
				this.getIdPedidoDeVenda(), 
				this.getCdChamada(), 
				this.getCdContratoDeCompraCliente(), 
				this.getEmpresa() == null ? null: this.getEmpresa().getCdEmpresa(), 
				this.getCdEmpresaEstoque(), 
				this.getCdEmpresaFinanceiro(), 
				this.getSetor() == null ? null: this.getSetor().convertToDto(), 
				this.getDtEmissao() == null ? null: this.getDtEmissao().toString(), 
				this.getDtEntrada() == null ? null:this.getDtEntrada().toString(), 
				this.getDtEntrega() == null ? null:this.getDtEntrega().toString(), 
				this.getStPedidoDeVenda(), 
				this.getCliente() == null ? null: this.getCliente().convertToDto(), 
				this.getCdEnderecoPrincipal(), 
				this.getCdEnderecoCobranca(), 
				this.getCdEnderecoEntrega(), 
				null, 
				null, 
				this.getTpFretePorConta(), 
				this.getDsObservacaoPedido(), 
				this.getUsuario() == null ? null: this.getUsuario().getIdUsuario(), 
				this.getDtReferenciaPagamento()== null ? null: this.getDtReferenciaPagamento().toString(), 
				this.getDtCancelamento()== null ? null: this.getDtCancelamento().toString(), 
				this.getTpPedidoDeVenda()
				);
	}
	
	public PedidoDeVendaDto convertDTO() {
		
		List<PedidoDeVendaItemDto> itemsDTO = this.getItems().stream().map(item -> item.convertDTO())
				.collect(Collectors.toList());
		
		PedidoDeVendaDto dto = new PedidoDeVendaDto(
				this.getIdPedidoDeVenda(), 
				this.getCdChamada(), 
				this.getCdContratoDeCompraCliente(), 
				this.getEmpresa() == null ? null: this.getEmpresa().getCdEmpresa(), 
				this.getCdEmpresaEstoque(), 
				this.getCdEmpresaFinanceiro(), 
				this.getSetor() == null ? null: this.getSetor().convertToDto(), 
				this.getDtEmissao() == null ? null: this.getDtEmissao().toString(), 
				this.getDtEntrada() == null ? null:this.getDtEntrada().toString(), 
				this.getDtEntrega() == null ? null:this.getDtEntrega().toString(), 
				this.getStPedidoDeVenda(), 
				this.getCliente() == null ? null: this.getCliente().convertToDto(), 
				this.getCdEnderecoPrincipal(), 
				this.getCdEnderecoCobranca(), 
				this.getCdEnderecoEntrega(), 
				this.getOperacao() == null ? null: this.getOperacao().convertToDto(), 
				this.getTransportador()== null ? null:this.getTransportador().convertToDto(), 
				this.getTpFretePorConta(), 
				this.getDsObservacaoPedido(), 
				this.getUsuario() == null ? null: this.getUsuario().getIdUsuario(), 
				this.getDtReferenciaPagamento()== null ? null: this.getDtReferenciaPagamento().toString(), 
				this.getDtCancelamento()== null ? null: this.getDtCancelamento().toString(), 
				this.getTpPedidoDeVenda()
				);
		
		dto.adicionarItems(itemsDTO);
		
		return dto;
	}	

	public Set<PedidoDeVendaItem> getItems() {
		return items;
	}

	public void setItems(Set<PedidoDeVendaItem> items) {
		this.items = items;
	}

	public String getIdPedidoDeVenda() {
		return idPedidoDeVenda;
	}

	public void setIdPedidoDeVenda(String idPedidoDeVenda) {
		this.idPedidoDeVenda = idPedidoDeVenda;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getCdContratoDeCompraCliente() {
		return cdContratoDeCompraCliente;
	}

	public void setCdContratoDeCompraCliente(String cdContratoDeCompraCliente) {
		this.cdContratoDeCompraCliente = cdContratoDeCompraCliente;
	}

	public EmpresaERP getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaERP empresa) {
		this.empresa = empresa;
	}

	public Integer getCdEmpresaEstoque() {
		return cdEmpresaEstoque;
	}

	public void setCdEmpresaEstoque(Integer cdEmpresaEstoque) {
		this.cdEmpresaEstoque = cdEmpresaEstoque;
	}

	public Integer getCdEmpresaFinanceiro() {
		return cdEmpresaFinanceiro;
	}

	public void setCdEmpresaFinanceiro(Integer cdEmpresaFinanceiro) {
		this.cdEmpresaFinanceiro = cdEmpresaFinanceiro;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public String getStPedidoDeVenda() {
		return stPedidoDeVenda;
	}

	public void setStPedidoDeVenda(String stPedidoDeVenda) {
		this.stPedidoDeVenda = stPedidoDeVenda;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public String getCdEnderecoPrincipal() {
		return cdEnderecoPrincipal;
	}

	public void setCdEnderecoPrincipal(String cdEnderecoPrincipal) {
		this.cdEnderecoPrincipal = cdEnderecoPrincipal;
	}

	public String getCdEnderecoCobranca() {
		return cdEnderecoCobranca;
	}

	public void setCdEnderecoCobranca(String cdEnderecoCobranca) {
		this.cdEnderecoCobranca = cdEnderecoCobranca;
	}

	public String getCdEnderecoEntrega() {
		return cdEnderecoEntrega;
	}

	public void setCdEnderecoEntrega(String cdEnderecoEntrega) {
		this.cdEnderecoEntrega = cdEnderecoEntrega;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Pessoa getTransportador() {
		return transportador;
	}

	public void setTransportador(Pessoa transportador) {
		this.transportador = transportador;
	}

	public String getTpFretePorConta() {
		return tpFretePorConta;
	}

	public void setTpFretePorConta(String tpFretePorConta) {
		this.tpFretePorConta = tpFretePorConta;
	}

	public String getDsObservacaoPedido() {
		return dsObservacaoPedido;
	}

	public void setDsObservacaoPedido(String dsObservacaoPedido) {
		this.dsObservacaoPedido = dsObservacaoPedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDtReferenciaPagamento() {
		return dtReferenciaPagamento;
	}

	public void setDtReferenciaPagamento(Date dtReferenciaPagamento) {
		this.dtReferenciaPagamento = dtReferenciaPagamento;
	}

	public Date getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public String getTpPedidoDeVenda() {
		return tpPedidoDeVenda;
	}

	public void setTpPedidoDeVenda(String tpPedidoDeVenda) {
		this.tpPedidoDeVenda = tpPedidoDeVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdChamada == null) ? 0 : cdChamada.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dtEmissao == null) ? 0 : dtEmissao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((idPedidoDeVenda == null) ? 0 : idPedidoDeVenda.hashCode());
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
		PedidoDeVenda other = (PedidoDeVenda) obj;
		if (cdChamada == null) {
			if (other.cdChamada != null)
				return false;
		} else if (!cdChamada.equals(other.cdChamada))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dtEmissao == null) {
			if (other.dtEmissao != null)
				return false;
		} else if (!dtEmissao.equals(other.dtEmissao))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (idPedidoDeVenda == null) {
			if (other.idPedidoDeVenda != null)
				return false;
		} else if (!idPedidoDeVenda.equals(other.idPedidoDeVenda))
			return false;
		return true;
	}

}
