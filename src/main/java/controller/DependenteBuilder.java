package controller;

import java.time.LocalDate;

import enums.EMDadosPessoais.IdentidadeGenero;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Dependente;
import model.Endereco;
import model.ExameMedico;

public class DependenteBuilder {

	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private boolean pcd = false;
	private String genero;
	private IdentidadeGenero identidadeGenero;
	private Endereco endereco = null;
	private String cpf;
	private String rg;
	private Integer idCargo;
	private Integer nit;
	private boolean optanteVT;
	private boolean optanteVAVR;
	private LocalDate dataAdmissao;
	private boolean optanteDependente;
	private String registro_alistamento;
	private String email_corporativo;
	private String titulo_eleitor;
	private Conta conta = null;
	private Contatos contatos = null;
	private ExameMedico exameMedico = null;
	private Dependente dependente = null;

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

	public void setPcd(boolean pcd) {
		this.pcd = pcd;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setIdentidadeGenero(IdentidadeGenero identidadeGenero) {
		this.identidadeGenero = identidadeGenero;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public void setOptanteVT(boolean optanteVT) {
		this.optanteVT = optanteVT;
	}

	public void setOptanteVAVR(boolean optanteVAVR) {
		this.optanteVAVR = optanteVAVR;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public void setOptanteDependente(boolean optanteDependente) {
		this.optanteDependente = optanteDependente;
	}

	public void setRegistro_alistamento(String registro_alistamento) {
		this.registro_alistamento = registro_alistamento;
	}

	public void setEmail_corporativo(String email_corporativo) {
		this.email_corporativo = email_corporativo;
	}

	public void setTitulo_eleitor(String titulo_eleitor) {
		this.titulo_eleitor = titulo_eleitor;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setContatos(Contatos contatos) {
		this.contatos = contatos;
	}

	public void setExameMedico(ExameMedico exameMedico) {
		this.exameMedico = exameMedico;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public Colaborador build() {
		return new Colaborador(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, endereco, cpf, rg, contatos, idCargo, nit, optanteVT, optanteVAVR, dataAdmissao,
				optanteDependente, registro_alistamento, email_corporativo, titulo_eleitor, conta, exameMedico,
				dependente);
	}
}
