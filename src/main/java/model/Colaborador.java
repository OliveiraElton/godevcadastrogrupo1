package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import enums.EMDadosPessoais.IdentidadeGenero;

@Entity
public class Colaborador extends Pessoa {

	/**
	 * Classe Colaborador.
	 * 
	 * A classe Colaborador instancia as classes Pessoa, Documentos, Enderecos,
	 * Contatos e ExameMedico para concluir o cadastro do colaborador.
	 * 
	 * Deve ser instanciado utilizando o ColaboradorBuilder.
	 * 
	 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, Thiago
	 *         Luiz Barbieri e Vitor Nathan Gon�alves.
	 * 
	 * @author Bruna <sh4323202@gmail.com>
	 * @author Enzo <enzomm.bodyandmind@gmail.com>
	 * @author Sabrina <sabrinaschmidt335@gmail.com>
	 * @author Vanderlei <vanderleik@yahoo.com.br>
	 * @author Vitor <vitornathang@gmail.com>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Integer idCargo;
	private Integer nit;
	private boolean optanteVT;
	private boolean optanteVAVR;
	private LocalDate dataAdmissao;
	private boolean optanteDependente;
	private String registro_alistamento;
	private String email_corporativo;
	private String titulo_eleitor;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Conta conta;
	@OneToOne(cascade = CascadeType.ALL)
	private Contatos contatos;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ExameMedico> exameMedico = new ArrayList<ExameMedico>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Dependente> dependente = new ArrayList<Dependente>();

	public Colaborador() {
		super();
	}
	
	/**
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param endereco
	 * @param cpf
	 * @param rg
	 * @param contatos
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param conta
	 * @param exameMedico
	 */
	public Colaborador(String nome, String sobrenome, String nomeSocial, 
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade,
			boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			Endereco endereco, String cpf, String rg, Contatos contatos, 
			Integer idCargo, Integer nit, boolean optanteVT, boolean optanteVAVR,
			LocalDate dataAdmissao, boolean optanteDependente, String registro_alistamento, 
			String email_corporativo, String titulo_eleitor, Conta conta, 
			ExameMedico exameMedico, Dependente dependente) {
		super(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, 
				naturalidade, pcd, genero, identidadeGenero, endereco, cpf, rg);
		this.idCargo = idCargo;
		this.nit = nit;
		this.optanteVT = optanteVT;
		this.optanteVAVR = optanteVAVR;
		this.dataAdmissao = dataAdmissao;
		this.optanteDependente = optanteDependente;
		this.registro_alistamento = registro_alistamento;
		this.email_corporativo = email_corporativo;
		this.titulo_eleitor = titulo_eleitor;
		this.conta = conta;
		this.contatos = contatos;
		this.addExameMedico(exameMedico);
		this.addDependente(dependente);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public Integer getNit() {
		return nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public boolean isOptanteVT() {
		return optanteVT;
	}

	public void setOptanteVT(boolean optanteVT) {
		this.optanteVT = optanteVT;
	}

	public boolean isOptanteVAVR() {
		return optanteVAVR;
	}

	public void setOptanteVAVR(boolean optanteVAVR) {
		this.optanteVAVR = optanteVAVR;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public boolean isOptanteDependente() {
		return optanteDependente;
	}

	public void setOptanteDependente(boolean optanteDependente) {
		this.optanteDependente = optanteDependente;
	}

	public String getRegistro_alistamento() {
		return registro_alistamento;
	}

	public void setRegistro_alistamento(String registro_alistamento) {
		this.registro_alistamento = registro_alistamento;
	}

	public String getEmail_corporativo() {
		return email_corporativo;
	}

	public void setEmail_corporativo(String email_corporativo) {
		this.email_corporativo = email_corporativo;
	}

	public String getTitulo_eleitor() {
		return titulo_eleitor;
	}

	public void setTitulo_eleitor(String titulo_eleitor) {
		this.titulo_eleitor = titulo_eleitor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Contatos getContatos() {
		return contatos;
	}

	public void setContatos(Contatos contatos) {
		this.contatos = contatos;
	}

	public List<ExameMedico> getExameMedico() {
		return exameMedico;
	}

	public void addExameMedico(ExameMedico exameMedico) {
		this.exameMedico.add(exameMedico);
	}

	public List<Dependente> getDependente() {
		return dependente;
	}

	public void addDependente(Dependente dependente) {
		this.dependente.add(dependente);
	}

}
