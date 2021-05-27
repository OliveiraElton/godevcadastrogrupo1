package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe DependenteSimplificadoDTO.
 * 
 * Classe para interacao via Controller API, referencia a {@link Dependente}. 
 * Os dados sao simplicados, proporcionando somente as informacoes necessarias
 * para os demais modulos do sistema.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 *
 */
public class DependenteSimplificadoDTO {

	private int id;
	private TiposDependentes tipoDependente;
	private Boolean optanteIR;
	private String nome;
	private String sobrenome;
	private LocalDate dataDeNascimento;
	private Boolean pcd;
	private String cpf;
	
	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as informacoes
	 * de {@link Dependente}.
	 * 
	 * @param Dependente modelOriginal
	 */
	public DependenteSimplificadoDTO (Dependente modelOriginal) {
		this.id = modelOriginal.getId();
		this.tipoDependente = modelOriginal.getTipoDependente();
		this.optanteIR = modelOriginal.isOptanteIR();
		this.nome = modelOriginal.getNome();
		this.sobrenome = modelOriginal.getSobrenome();
		this.dataDeNascimento = modelOriginal.getDataDeNascimento();
		this.pcd = modelOriginal.isPcd();
		this.cpf = modelOriginal.getCpf();
	}
	
	public int getId() {
		return id;
	}

	public TiposDependentes getTipoDependente() {
		return tipoDependente;
	}

	public Boolean isOptanteIR() {
		return optanteIR;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public Boolean isPcd() {
		return pcd;
	}

	public String getCpf() {
		return cpf;
	}

}
