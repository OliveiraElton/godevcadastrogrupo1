package br.com.proway.senior.godevcadastrogrupo1.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.proway.senior.godevcadastrogrupo1.utilidades.ValidacaoDeDatas;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe PrestadorServico.
 * 
 * Classe que abstrai as informacoes do Prestador de Servico contratado.
 * Herda de {@link Pessoa} e instancia {@link Contatos}.
 * Deve ser instanciada utilizando o PrestadorServicoBuilder.
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

@Entity
public class PrestadorServico extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate dataInicioContrato;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Empresa empresa;
	private Integer idSetor;

	@OneToOne(cascade = CascadeType.ALL)
	private Contatos contatos;

	public PrestadorServico() {
		super();
	}

	/**
	 * Construtor padrao da classe.
	 * 
	 * @param id
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param cpf
	 * @param rg
	 * @param contatos
	 * @param dataInicioContrato
	 * @param empresa
	 * @param idSetor
	 */
	public PrestadorServico(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, Boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg, Contatos contatos, LocalDate dataInicioContrato, Empresa empresa,
			Integer idSetor) {
		super(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero, identidadeGenero,
				cpf, rg);
		this.dataInicioContrato = dataInicioContrato;
		this.empresa = empresa;
		this.idSetor = idSetor;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	/**
	 * Para cadastrar uma data de inicio eh necessario que a mesma seja 
	 * valida, este metodo chama a classe {@link ValidacaoDeDatas} e realiza 
	 * a verificacao.
	 * 
	 * @param dataInicioContrato Data que o prestador iniciara os servicos.
	 */
	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		try {
			ValidacaoDeDatas.validaDataInicioContrato(dataInicioContrato);
			this.dataInicioContrato = dataInicioContrato;
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Integer getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}

	public Contatos getContatos() {
		return contatos;
	}

	public void setContatos(Contatos contatos) {
		this.contatos = contatos;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}