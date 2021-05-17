package controller;

import java.time.LocalDate;

import org.hibernate.Session;

import dao.ContaDAO;
import dao.ContatosDAO;
import dao.DependenteDAO;
import dao.EnderecoDAO;
import dao.ExameMedicoDAO;
import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMDadosPessoais.TiposDependentes;
import enums.EMOutros.TiposExames;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Dependente;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

public class ColaboradorBuilder implements Builder {

	Session session = DBConnection.getSession();
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

	public void setEndereco(String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf) {
		this.endereco = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);
		EnderecoDAO.getInstance(session).create(this.endereco);
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

	public void setConta(String nomeBanco, String agencia, String numeroConta, String digitoVerificador) {
		this.conta = new Conta(nomeBanco, agencia, numeroConta, digitoVerificador);
		ContaDAO.getInstance(session).create(this.conta);
	}

	public void setContatos(String telefonePrincipal, String telefoneSecundario, String email,
			String telefoneFamiliar) {
		this.contatos = new Contatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		ContatosDAO.getInstance(session).create(this.contatos);
	}

	public void setExameMedico(TiposExames tipoExame, LocalDate dataExame, boolean apto) {
		this.exameMedico = new ExameMedico(tipoExame, dataExame, apto);
		ExameMedicoDAO.getInstance(session).create(exameMedico);
	}

	public void setDependente(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			Endereco endereco, String cpf, String rg, TiposDependentes tipoDependente, boolean optanteIR) {
		this.dependente = new Dependente(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade,
				pcd, genero, identidadeGenero, endereco, cpf, rg, tipoDependente, optanteIR);
		DependenteDAO.getInstance(session).create(this.dependente);
	}

	public Colaborador build() {
		return new Colaborador(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, endereco, cpf, rg, contatos, idCargo, nit, optanteVT, optanteVAVR, dataAdmissao,
				optanteDependente, registro_alistamento, email_corporativo, titulo_eleitor, conta, exameMedico,
				dependente);
	}

}