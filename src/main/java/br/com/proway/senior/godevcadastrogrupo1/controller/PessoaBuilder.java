package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.Pessoa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

public class PessoaBuilder implements Builder {

	Session session = DBConnection.getSession();
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private Boolean pcd = false;
	private String genero;
	private IdentidadeGenero identidadeGenero;
	private Endereco endereco = null;
	private String cpf;
	private String rg;
	private Integer idCargo = null;
	private Integer nit = null;
	private Boolean optanteVT = null;
	private Boolean optanteVAVR = null;
	private LocalDate dataAdmissao = null;
	private Boolean optanteDependente = null;
	private String registro_alistamento = null;
	private String email_corporativo = null;
	private String titulo_eleitor = null;
	private Conta conta = null;
	private Contatos contatos = null;
	private ExameMedico exameMedico = null;
	private Dependente dependente = null;
	private TiposDependentes tipoDependente = null;
	private Boolean optanteIR = null;
	private LocalDate dataInicioContrato = null;
	private Integer idSetor = null;

	public void setTipoDependente(TiposDependentes tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public void setOptanteIR(Boolean optanteIR) {
		this.optanteIR = optanteIR;
	}

	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	private Empresa empresa;

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

	public void setOptanteVT(Boolean optanteVT) {
		this.optanteVT = optanteVT;
	}

	public void setOptanteVAVR(Boolean optanteVAVR) {
		this.optanteVAVR = optanteVAVR;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public void setOptanteDependente(Boolean optanteDependente) {
		this.optanteDependente = optanteDependente;
	}

	public void setRegistro_alistamento(String registro_alistamento) {
		this.registro_alistamento = registro_alistamento;
	}

	public void setEmail_corporativo(String email_corporativo) {
		this.email_corporativo = email_corporativo;
	}

	public void setIdSetor(Integer setor) {
		this.idSetor = setor;
	}

	public void setTitulo_eleitor(String titulo_eleitor) {
		this.titulo_eleitor = titulo_eleitor;
	}

	public void setConta(String nomeBanco, String agencia, String numeroConta, String digitoVerificador) {
		this.conta = new Conta(nomeBanco, agencia, numeroConta, digitoVerificador);
		ContaDAO.getInstance(session).create(this.conta);
	}

	public void setContatos(String telefonePrincipal, String telefoneSecundario, String email,

			String telefoneFamiliar) throws Exception {
			this.contatos = new Contatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		
		ContatosDAO.getInstance(session).create(this.contatos);
	}

	public void setExameMedico(TiposExames tipoExame, LocalDate dataExame, Boolean apto) {
		this.exameMedico = new ExameMedico(tipoExame, dataExame, apto);
		ExameMedicoDAO.getInstance(session).create(exameMedico);
	}

	public void setDependente(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, Boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg, TiposDependentes tipoDependente, Boolean optanteIR) {
		this.dependente = new Dependente(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade,
				pcd, genero, identidadeGenero, endereco, cpf, rg, tipoDependente, optanteIR);
		DependenteDAO.getInstance(session).create(this.dependente);
	}

	public Pessoa build() {
		if (tipoDependente != null) {
			return new Dependente(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
					identidadeGenero, endereco, cpf, rg, tipoDependente, optanteIR);
		} else if (empresa != null) {
			return new PrestadorServico(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd,
					genero, identidadeGenero, endereco, cpf, rg, contatos, dataInicioContrato, empresa, idSetor);
		} else {
			return new Colaborador(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd,
					genero, identidadeGenero, endereco, cpf, rg, contatos, idCargo, nit, optanteVT, optanteVAVR,
					dataAdmissao, optanteDependente, registro_alistamento, email_corporativo, titulo_eleitor, conta,
					exameMedico, dependente);
		}
	}

}