package br.com.proway.senior.godevcadastrogrupo1.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDocumentos;

/**
 * Classe que abstrai as informacoess de uma Empresa contratada. Esta Classe
 * sera instanciada na Classe PrestadorServico, e instanciara as classes
 * Endereco e Contato.
 * 
 * Deve ser instanciada utilizando o EmpresaBuilder.
 *
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, Thiago
 *         Luiz Barbieri e Vitor Nathan Goncalves.
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com>
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 *
 */
@Entity
public class Empresa {

	private @Id @GeneratedValue int id;

	private String nomeEmpresa;
	private LocalDate dataInicioContrato;
	private String cnpj;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.ALL)
	private Contatos contato;

	/**
	 * Construtor padr�o da classe.
	 * 
	 * @param nomeEmpresa
	 * @param dataInicioContrato
	 * @param cnpj
	 * @param endereco
	 * @param contato
	 * @throws Exception 
	 */
	public Empresa(String nomeEmpresa, LocalDate dataInicioContrato, String cnpj, Endereco endereco, Contatos contato) throws Exception {
		this.setNomeEmpresa(nomeEmpresa);
		this.setDataInicioContrato(dataInicioContrato);
		this.setCnpj(cnpj);
		this.setEndereco(endereco);
		this.setContato(contato);
	}

	public Empresa() {
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	public void setDataInicioContrato(LocalDate dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}

	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Metodo setCNPJ.
	 * 
	 * Metodo realiza a verificacao se o CNPJ eh valido,
	 * caso seja, retorna o valor do mesmo, caso contrario, 
	 * lanca a Exception para ajuste da informacao.
	 * 
	 * @param String cnpj CNPJ que sera validado.
	 * @throws Exception caso o CNPJ nao seja valido.
	 */
	public void setCnpj(String cnpj) throws Exception {
		if (!ValidacaoDocumentos.validarCNPJ(cnpj)) {
			throw (new Exception("Por favor, insira um CNPJ v�lido."));
		}
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contatos getContato() {
		return contato;
	}

	public void setContato(Contatos contato) {
		this.contato = contato;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;

	}
}
