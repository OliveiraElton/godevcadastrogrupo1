package br.com.proway.senior.godevcadastrogrupo1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;

/**
 * Classe Dependente.
 * 
 * Esta classe instancia a classe {@link Pessoa} para o cadastro de Dependente.
 * Deve ser instancianda usando DependenteBuilder. Um dependente sempre sera
 * atrelado a um {@link Colaborador}.
 *
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, Thiago
 *         Luiz Barbieri e Vitor Nathan Goncalves.
 * 
 * @author Bruno Marques <brunoliveira.marques@gmail.com
 * @author Daniella Lira <dev.danilira@gmail.com>
 * @author David Hildebrnadt <davihildebran@gmail.com>
 * @author David Willian <dwillian676@gmail.com>
 * @author Elton Frncisco de Oliveira <eltonf.oliveira22@gmail.com>
 */

@Entity
public class Dependente extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private TiposDependentes tipoDependente;
	private Boolean optanteIR;

	public Dependente() {
		super();
	}

	/**
	 * Construtor padrao da classe.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param cpf
	 * @param idDependente
	 * @param idColaborador
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public Dependente(String nome, String sobrenome, LocalDate dataDeNascimento, String nacionalidade, Boolean pcd,
			String genero, IdentidadeGenero identidadeGenero, String cpf, TiposDependentes tipoDependente,
			Boolean optanteIR) {
		super(nome, sobrenome, dataDeNascimento, nacionalidade, pcd, genero, identidadeGenero, cpf);
		this.setTipoDependente(tipoDependente);
		this.setOptanteIR(optanteIR);
	}

	public TiposDependentes getTipoDependente() {
		return tipoDependente;
	}

	public void setTipoDependente(TiposDependentes tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public Boolean isOptanteIR() {
		return optanteIR;
	}

	public void setOptanteIR(Boolean optanteIR) {
		this.optanteIR = optanteIR;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}