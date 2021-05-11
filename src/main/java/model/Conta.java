package model;

public class Conta {

	private String nomeBanco;
	private String agencia;
	private String numeroConta;
	private String digitoVerificador;
	
	/**
	 * @param nomeBanco
	 * @param agencia
	 * @param numeroConta
	 * @param digitoVerificador
	 */
	public Conta(String nomeBanco, String agencia, String numeroConta, String digitoVerificador) {
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.digitoVerificador = digitoVerificador;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	
}
