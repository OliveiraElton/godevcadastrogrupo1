package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDocumentos;

/**
 * Classe que abstrai as informa��es de uma Empresa contratada. Esta Classe ser�
 * instanciada na Classe PrestadorServico, e instanciar� as classes Endereco e
 * Contato.
 * 
 * Deve ser instanciada utilizando o EmpresaBuilder.
 *
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, Thiago
 *         Luiz Barbieri e Vitor Nathan Gon�alves.
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private long empresaId;
	private String nomeEmpresa;
	private LocalDate dataInicioContrato;
	private String cnpj;

	@OneToOne
	private Endereco endereco;
	@OneToOne
	private Contatos contato;

	/**
	 * 
	 * @param nomeEmpresa
	 * @param dataInicioContrato
	 * @param cnpj
	 * @param endereco
	 * @param contato
	 */
	public Empresa(String nomeEmpresa, LocalDate dataInicioContrato, String cnpj, Endereco endereco, Contatos contato) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.dataInicioContrato = dataInicioContrato;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.contato = contato;
	}

	public Empresa() {
		super();
	}

	public long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(long empresaId) {
		this.empresaId = empresaId;
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

	public void setCnpj(String cnpj) {
		try {
			ValidacaoDocumentos.validarCNPJ(cnpj);
			this.cnpj = cnpj;
		} catch (Exception e) {
			e.getMessage();
		}

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
}
