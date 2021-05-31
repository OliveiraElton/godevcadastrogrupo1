package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;

/**
 * Classe DependenteCompletoDTO.
 * 
 * Classe para interacao via Controller API, referencia a {@link Dependente}.
 * Oferece as informacoes completas do dependente, podendo ser utilizada para 
 * relatorios. As informacoes simplificadas para os demais modulos do sistema,
 * estao disponiveis em {@link DependenteSimplificadoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class DependenteCompletoDTO {

	private int id;
	private String nome;
	private String sobrenome;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private Boolean pcd;
	private String genero;
	private IdentidadeGenero identidadeGenero;
	private String cpf; 
	private TiposDependentes tipoDependente;
	private Boolean optanteIR;
	
	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as informacoes
	 * de {@link Dependente}.
	 * 
	 * @param Dependente modelOriginal
	 */
	public DependenteCompletoDTO (Dependente modelOriginal) {
		this.id = modelOriginal.getId();
		this.nome = modelOriginal.getNome();
		this.sobrenome = modelOriginal.getSobrenome();
		this.dataDeNascimento = modelOriginal.getDataDeNascimento();
		this.nacionalidade = modelOriginal.getNacionalidade();
		this.pcd = modelOriginal.isPcd();
		this.genero = modelOriginal.getGenero();
		this.identidadeGenero = modelOriginal.getIdentidadeGenero();
		this.cpf = modelOriginal.getCpf(); 
		this.tipoDependente = modelOriginal.getTipoDependente();
		this.optanteIR = modelOriginal.isOptanteIR();
	}

	public int getId() {
		return id;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public Boolean isPcd() {
		return pcd;
	}

	public String getGenero() {
		return genero;
	}

	public IdentidadeGenero getIdentidadeGenero() {
		return identidadeGenero;
	}

	public String getCpf() {
		return cpf;
	}

	public TiposDependentes getTipoDependente() {
		return tipoDependente;
	}

	public Boolean isOptanteIR() {
		return optanteIR;
	}
	
}
