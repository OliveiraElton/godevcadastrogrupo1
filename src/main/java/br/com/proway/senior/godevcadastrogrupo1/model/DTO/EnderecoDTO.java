package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

/**
 * Classe EnderecoDTO.
 * 
 * Classe para interacao via Controller API, referencia a {@link Endereco},
 * disponibilizando todos os dados do model original.
 * 
 * @author Gabriel Simon <b>gabriel.simon@senior.com.br</b> 
 *
 */
public class EnderecoDTO {
	
	private Integer id;
	private Integer idColaborador;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String pais;
	private String cidade;
	private String uf;
	
	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as informacoes
	 * de {@link Endereco} atraves do cadastro de um {@link Colaborador}.
	 * 
	 * @param Colaborador colaborador
	 */
	public EnderecoDTO(Colaborador colaborador) {
		this.id = colaborador.getEndereco().getId();
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
	
	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as informacoes
	 * de {@link Endereco}.
	 * 
	 * @param Endereco endereco
	 */
	public EnderecoDTO(Endereco endereco) {
		super();
		this.id = endereco.getId();
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
		return id;
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