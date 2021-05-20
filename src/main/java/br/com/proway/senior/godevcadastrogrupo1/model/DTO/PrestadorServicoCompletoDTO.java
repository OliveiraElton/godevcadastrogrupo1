package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
* Classe PrestadorServico.
* 
* Classe para interação via Controller API, tem referência com {@link Pessoa}.
* 
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
 */
public class PrestadorServicoCompletoDTO {
	
	private int id;
	private LocalDate dataInicioContrato;
	private Empresa empresa;
	private Integer idSetor;
	private Contatos contatos;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private Boolean pcd = false;
	private String genero;
	private IdentidadeGenero identidadeGenero;
	private Endereco endereco;
	private String cpf;
	private String rg;
	

	public PrestadorServicoCompletoDTO(PrestadorServico prestadorServico) {
		this.id = prestadorServico.getId();
		this.dataInicioContrato = prestadorServico.getDataInicioContrato();
		this.empresa = prestadorServico.getEmpresa();
		this.idSetor = prestadorServico.getIdSetor();
		this.contatos = prestadorServico.getContatos();
		this.nome = prestadorServico.getNome();
		this.sobrenome = prestadorServico.getSobrenome();
		this.nomeSocial = prestadorServico.getNomeSocial();
		this.dataDeNascimento = prestadorServico.getDataDeNascimento();
		this.nacionalidade = prestadorServico.getNacionalidade();
		this.naturalidade = prestadorServico.getNaturalidade();
		this.pcd = prestadorServico.isPcd();
		this.genero = prestadorServico.getGenero();
		this.identidadeGenero = prestadorServico.getIdentidadeGenero();
		this.endereco = prestadorServico.getEndereco();
		this.cpf = prestadorServico.getCpf();
		this.rg = prestadorServico.getRg();
	}


	public int getId() {
		return id;
	}


	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public Integer getIdSetor() {
		return idSetor;
	}


	public Contatos getContatos() {
		return contatos;
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


	public Endereco getEndereco() {
		return endereco;
	}


	public String getCpf() {
		return cpf;
	}


	public String getRg() {
		return rg;
	}
	
	
	
}
