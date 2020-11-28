package com.erp.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDeVendaDto {

	private String idPedidoDeVenda;
	private String cdChamada;
	private String cdContratoDeCompraCliente;
	private Integer cdEmpresa;
	private Integer cdEmpresaEstoque;
	private Integer cdEmpresaFinanceiro;
	private SetorDto setor;
	private String dtEmissao;
	private String dtEntrada;
	private String dtEntrega;
	private String stPedidoDeVenda;
	private PessoaDto cliente;
	private String cdEnderecoPrincipal;
	private String cdEnderecoCobranca;
	private String cdEnderecoEntrega;
	private OperacaoDto operacao;
	private PessoaDto transportador;
	private String tpFretePorConta;
	private String dsObservacaoPedido;
	private String idUsuario;
	private String dtReferenciaPagamento;
	private String dtCancelamento;
	private String tpPedidoDeVenda;
	private List<PedidoDeVendaItemDto> items = new ArrayList<PedidoDeVendaItemDto>();

	public PedidoDeVendaDto(String idPedidoDeVenda, String cdChamada, String cdContratoDeCompraCliente,
			Integer cdEmpresa, Integer cdEmpresaEstoque, Integer cdEmpresaFinanceiro, SetorDto setor, String dtEmissao,
			String dtEntrada, String dtEntrega, String stPedidoDeVenda, PessoaDto cliente, String cdEnderecoPrincipal,
			String cdEnderecoCobranca, String cdEnderecoEntrega, OperacaoDto operacao, PessoaDto transportador,
			String tpFretePorConta, String dsObservacaoPedido, String idUsuario, String dtReferenciaPagamento,
			String dtCancelamento, String tpPedidoDeVenda) {
		super();
		this.idPedidoDeVenda = idPedidoDeVenda;
		this.cdChamada = cdChamada;
		this.cdContratoDeCompraCliente = cdContratoDeCompraCliente;
		this.cdEmpresa = cdEmpresa;
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
		this.idUsuario = idUsuario;
		this.dtReferenciaPagamento = dtReferenciaPagamento;
		this.dtCancelamento = dtCancelamento;
		this.tpPedidoDeVenda = tpPedidoDeVenda;
	}

	public PedidoDeVendaDto() {
		super();
	}

	public List<PedidoDeVendaItemDto> getItems() {
		return items;
	}

	public void adicionarItems(List<PedidoDeVendaItemDto> items) {
		this.items = items;
	}

	public void adicionarItem(PedidoDeVendaItemDto e) {
		this.items.add(e);
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

	public Integer getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Integer cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
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

	public SetorDto getSetor() {
		return setor;
	}

	public void setSetor(SetorDto setor) {
		this.setor = setor;
	}

	public String getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public String getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public String getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(String dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public String getStPedidoDeVenda() {
		return stPedidoDeVenda;
	}

	public void setStPedidoDeVenda(String stPedidoDeVenda) {
		this.stPedidoDeVenda = stPedidoDeVenda;
	}

	public PessoaDto getCliente() {
		return cliente;
	}

	public void setCliente(PessoaDto cliente) {
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

	public OperacaoDto getOperacao() {
		return operacao;
	}

	public void setOperacao(OperacaoDto operacao) {
		this.operacao = operacao;
	}

	public PessoaDto getTransportador() {
		return transportador;
	}

	public void setTransportador(PessoaDto transportador) {
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

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDtReferenciaPagamento() {
		return dtReferenciaPagamento;
	}

	public void setDtReferenciaPagamento(String dtReferenciaPagamento) {
		this.dtReferenciaPagamento = dtReferenciaPagamento;
	}

	public String getDtCancelamento() {
		return dtCancelamento;
	}

	public void setDtCancelamento(String dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	public String getTpPedidoDeVenda() {
		return tpPedidoDeVenda;
	}

	public void setTpPedidoDeVenda(String tpPedidoDeVenda) {
		this.tpPedidoDeVenda = tpPedidoDeVenda;
	}

}
