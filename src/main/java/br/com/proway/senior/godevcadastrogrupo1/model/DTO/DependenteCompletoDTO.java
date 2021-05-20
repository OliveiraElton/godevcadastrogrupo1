package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe EmpresaDTO.
 * 
 * Classe para interação via Controller API, referencia a {@link Empresa}.
 * Oferece as informações completas do dependente, podendo ser utilizada para 
 * relatórios. As informações simplificadas para os demais módulos do sistema,
 * estão disponíveis em {@link DependenteSimplificadoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class DependenteCompletoDTO {

	private int id;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private Boolean pcd;
	private String genero;
	private IdentidadeGenero identidadeGenero;
	private String cpf; 
	private String rg;
	private TiposDependentes tipoDependente;
	private Boolean optanteIR;
	
	/**
	 * Construtor que irá interagir com o Controller da API, disponibilizando as informações
	 * de {@link Dependente}.
	 * 
	 * @param Dependente modelOriginal
	 */
	public DependenteCompletoDTO (Dependente modelOriginal) {
		this.id = modelOriginal.getId();
		this.nome = modelOriginal.getNome();
		this.sobrenome = modelOriginal.getSobrenome();
		this.nomeSocial = modelOriginal.getNomeSocial();
		this.dataDeNascimento = modelOriginal.getDataDeNascimento();
		this.nacionalidade = modelOriginal.getNacionalidade();
		this.naturalidade = modelOriginal.getNaturalidade();
		this.pcd = modelOriginal.isPcd();
		this.genero = modelOriginal.getGenero();
		this.identidadeGenero = modelOriginal.getIdentidadeGenero();
		this.cpf = modelOriginal.getCpf(); 
		this.rg = modelOriginal.getRg();
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

	public String getNomeSocial() {
		return nomeSocial;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
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

	public String getRg() {
		return rg;
	}

	public TiposDependentes getTipoDependente() {
		return tipoDependente;
	}

	public Boolean isOptanteIR() {
		return optanteIR;
	}
	
}
