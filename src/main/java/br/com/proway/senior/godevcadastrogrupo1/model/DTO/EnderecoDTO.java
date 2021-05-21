package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;

public class EnderecoDTO {
	
	private int idColaborador;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String pais;
	private String cidade;
	private String uf;
	
	public EnderecoDTO(Colaborador colaborador) {
		this.idColaborador = colaborador.getId();
		this.logradouro = colaborador.getEndereco().getLogradouro();
		this.numero = colaborador.getEndereco().getNumero();
		this.complemento = colaborador.getEndereco().getComplemento();
		this.cep = colaborador.getEndereco().getCep();
		this.bairro = colaborador.getEndereco().getBairro();
		this.pais = colaborador.getEndereco().getPais();
		this.cidade = colaborador.getEndereco().getCidade();
		this.uf = colaborador.getEndereco().getUf();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getPais() {
		return pais;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}
}