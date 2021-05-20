package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe ColaboradorCompletoDTO.
 * 
 * Classe para interação via Controller API, referencia a {@link Colaborador}.
 * Oferece as informações completas do colaborador, podendo ser utilizada para 
 * relatórios. As informações simplificadas para os demais módulos do sistema,
 * estão disponíveis em {@link ColaboradorSimplificadoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class ColaboradorCompletoDTO {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private Boolean pcd; 
	private String genero; 
	private IdentidadeGenero identidadeGenero;
	private Endereco endereco; 
	private String cpf; 
	private String rg; 
	private Contatos contatos; 
	private Integer idPostoDeTrabalho;
	private Integer nit; 
	private Boolean optanteVT; 
	private Boolean optanteVAVR;
	private LocalDate dataAdmissao;
	private Boolean optanteDependente;
	private String registro_alistamento; 
	private String email_corporativo;
	private String titulo_eleitor;
	private Conta conta; 
	private List<ExameMedico> exameMedico;
	private List<Dependente> dependente;
	
	/**
	 * Construtor que irá interagir com o Controller da API, disponibilizando as informações
	 * de {@link Colaborador}.
	 * 
	 * @param Colaborador modelOriginal
	 */
	public ColaboradorCompletoDTO (Colaborador modelOriginal) {
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
		this.endereco = modelOriginal.getEndereco(); 
		this.cpf = modelOriginal.getCpf(); 
		this.rg = modelOriginal.getRg(); 
		this.contatos = modelOriginal.getContatos(); 
		this.idPostoDeTrabalho = modelOriginal.getIdPostoDeTrabalho();
		this.nit = modelOriginal.getNit(); 
		this.optanteVT = modelOriginal.isOptanteVT(); 
		this.optanteVAVR = modelOriginal.isOptanteVAVR();
		this.dataAdmissao = modelOriginal.getDataAdmissao();
		this.optanteDependente = modelOriginal.isOptanteDependente();
		this.registro_alistamento = modelOriginal.getRegistro_alistamento(); 
		this.email_corporativo = modelOriginal.getEmail_corporativo();
		this.titulo_eleitor = modelOriginal.getTitulo_eleitor();
		this.conta = modelOriginal.getConta(); 
		this.exameMedico = modelOriginal.getExameMedico();
		this.dependente = modelOriginal.getDependente();
	}
	
	
	public Integer getId() {
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
	public Boolean getPcd() {
		return pcd;
	}
	public String getGenero() {
		return genero;
	}
	public IdentidadeGenero getIdentidadeGenero() {
		return identidadeGenero;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public String getRg() {
		return rg;
	}
	public Contatos getContatos() {
		return contatos;
	}
	public Integer getIdPostoDeTrabalho() {
		return idPostoDeTrabalho;
	}
	public Integer getNit() {
		return nit;
	}
	public Boolean getOptanteVT() {
		return optanteVT;
	}
	public Boolean getOptanteVAVR() {
		return optanteVAVR;
	}
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public Boolean getOptanteDependente() {
		return optanteDependente;
	}
	public String getRegistro_alistamento() {
		return registro_alistamento;
	}
	public String getEmail_corporativo() {
		return email_corporativo;
	}
	public String getTitulo_eleitor() {
		return titulo_eleitor;
	}
	public Conta getConta() {
		return conta;
	}
	public List<ExameMedico> getExameMedico() {
		return exameMedico;
	}
	public List<Dependente> getDependente() {
		return dependente;
	}
	
}
