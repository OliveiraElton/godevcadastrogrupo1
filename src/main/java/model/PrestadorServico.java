package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import enums.EMDadosPessoais.IdentidadeGenero;

/**
 * Classe que abstrai as informa��es do prestador de servi�o contratado.
 * 
 * Possui inst�ncia de Pessoa e Contatos.
 * 
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDate dataInicioContrato;
	
	@OneToOne
	private Empresa empresa;
	private Integer idSetor;
	
	@OneToOne
	private Contatos contatos;
	
	/**
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
	 * @param endereco
	 * @param cpf
	 * @param rg
	 * @param contatos
	 * @param dataInicioContrato
	 * @param empresa
	 * @param idSetor
	 * @param contatos2
	 */
	public PrestadorServico(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			Endereco endereco, String cpf, String rg, Contatos contatos, LocalDate dataInicioContrato, Empresa empresa,
			Integer idSetor) {
		super(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, endereco, cpf, rg);
		this.dataInicioContrato = dataInicioContrato;
		this.empresa = empresa;
		this.idSetor = idSetor;
	}
	
	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}
	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
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
	
}
