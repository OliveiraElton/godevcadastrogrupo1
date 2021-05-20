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
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public void setPcd(Boolean pcd) {
		this.pcd = pcd;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setIdentidadeGenero(IdentidadeGenero identidadeGenero) {
		this.identidadeGenero = identidadeGenero;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setTipoDependente(TiposDependentes tipoDependente) {
		this.tipoDependente = tipoDependente;
	}
	public void setOptanteIR(Boolean optanteIR) {
		this.optanteIR = optanteIR;
	}
	
}
