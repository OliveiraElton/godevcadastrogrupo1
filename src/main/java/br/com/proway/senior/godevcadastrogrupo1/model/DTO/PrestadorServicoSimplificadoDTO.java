package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;

/**
 * Classe PrestadorServicoSimplificadoDTO.
 * 
 * Classe para interacao via Controller API, referencia a
 * {@link PrestadorServico}. Os dados sao simplificados, proporcionando somente
 * as informacoes necessarias para os demais modulos do sistema. Dados completos
 * disponiveis em {@link PrestadorServicoCompletoDTO}.
 * 
 * @author Vitor Cesar Peres <b>vitor.peres@senior.com.br</b>
 *
 */
public class PrestadorServicoSimplificadoDTO {

	private int id;
	private LocalDate dataInicioContrato;
	private Empresa empresa;
	private int idSetor;
	private Contatos contatos;
	private String nome;
	private String sobrenome;
	private String cpf;

	/**
	 * Construtor que ira interagir com o Controller da API, disponibilizando as
	 * informacoes de {@link PrestadorServico}.
	 * 
	 * @param PrestadorServico prestadorServico
	 */
	public PrestadorServicoSimplificadoDTO(PrestadorServico prestador) {
		this.id = prestador.getId();
		this.dataInicioContrato = prestador.getDataInicioContrato();
		this.empresa = prestador.getEmpresa();
		this.idSetor = prestador.getIdSetor();
		this.contatos = prestador.getContatos();
		this.nome = prestador.getNome();
		this.sobrenome = prestador.getSobrenome();
		this.cpf = prestador.getCpf();
	}

	public int getId() {
		return id;
	}

	public LocalDate getDataInicioContrato() {
		return dataInicioContrato;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public int getIdSetor() {
		return idSetor;
	}

	public Contatos getContatos() {
		return contatos;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

}
