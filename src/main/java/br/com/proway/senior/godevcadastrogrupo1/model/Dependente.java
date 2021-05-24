package br.com.proway.senior.godevcadastrogrupo1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe Dependente Esta classe instancia a classe Pessoa para o cadastro de
 * Dependente. Deve ser instancianda usando DependenteBuilder.
 * 
 *
 * @author Bruno Marques <brunoliveira.marques@gmail.com
 * @author Daniella Lira <dev.danilira@gmail.com>
 * @author David Hildebrnadt <davihildebran@gmail.com>
 * @author David Willian <dwillian676@gmail.com>
 * @author Elton Frncisco de Oliveira <eltonf.oliveira22@gmail.com>
 */

@Entity
public class Dependente extends Pessoa  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private TiposDependentes tipoDependente;
	private Boolean optanteIR;
	
	public Dependente() {
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
	 * @param idDependente
	 * @param idColaborador
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public Dependente(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, Boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			Endereco endereco, String cpf, String rg, TiposDependentes tipoDependente, Boolean optanteIR) {
		super(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero, identidadeGenero,
				endereco, cpf, rg);
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