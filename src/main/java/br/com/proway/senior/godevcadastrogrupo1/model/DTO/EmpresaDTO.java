package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

/**
 * Classe EmpresaDTO.
 * 
 * Classe para interacao via Controller API, referencia a {@link Empresa},
 * disponibilizando todos os dados do model original.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaDTO {

	private int id;
	private String nome;
	private LocalDate dataInicioContrato;
	private String cnpj;
	private Endereco endereco;
	private Contatos contato;
	
	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as informacoes
	 * de {@link Empresa}.
	 * 
	 * @param Empresa modelOriginal
	 */
	public EmpresaDTO (Empresa modelOrginal) {
		this.id = modelOrginal.getId();
		this.nome = modelOrginal.getNome();
		this.dataInicioContrato = modelOrginal.getDataInicioContrato();
		this.cnpj = modelOrginal.getCnpj();
		this.endereco = modelOrginal.getEndereco();
		this.contato = modelOrginal.getContato();
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}
	public String getCnpj() {
		return cnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public Contatos getContato() {
		return contato;
	}
}
