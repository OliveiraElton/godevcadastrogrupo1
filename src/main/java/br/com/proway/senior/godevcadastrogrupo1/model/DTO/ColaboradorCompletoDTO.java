package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

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
	private ExameMedico exameMedico;
	private Dependente dependente;
	
	
	
	
	
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
	public ExameMedico getExameMedico() {
		return exameMedico;
	}
	public Dependente getDependente() {
		return dependente;
	}
	
	
	
}
