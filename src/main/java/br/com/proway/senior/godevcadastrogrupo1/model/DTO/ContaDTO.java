package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import br.com.proway.senior.godevcadastrogrupo1.model.Conta;

/**
 * Classe ColaboradorSimplificadoDTO.
 * 
 * Classe para interacao via Controller API, referencia a {@link Conta}.
 * Oferece as informacoes completas de conta, vinculadas a um {@link Colaborador}.
 * 
 * @author Lucas Walim <b>lucas.walim@senior.com.br</b>
 */
public class ContaDTO {

	private int id;
	private String nomeBanco;
	private String agencia;
	private String numeroConta;
	private String digitoVerificador;

	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as informacoes
	 * de {@link Conta}.
	 * 
	 * @param Conta conta
	 */
	public ContaDTO(Conta conta) {
		this.id = conta.getId();
		this.nomeBanco = conta.getNomeBanco();
		this.agencia = conta.getAgencia();
		this.numeroConta = conta.getNumeroConta();
		this.digitoVerificador = conta.getDigitoVerificador();
	}

	public int getId() {
		return id;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

}