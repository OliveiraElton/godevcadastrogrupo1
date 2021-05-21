package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

public class EnderecoDTO {
	

	/**
	 * @param idColaborador
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 */
	

	private Integer idColaborador;
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
	public EnderecoDTO(Endereco endereco) {
		super();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cep = endereco.getCep();
		this.bairro = endereco.getBairro();
		this.pais = endereco.getPais();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf();
	}

	public Integer getId() {
		return idColaborador;
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