package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe DependenteDTO.
 * 
 * Classe para interação via API, referencia a {@link Dependente}. 
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 *
 */
public class DependenteDTO {

	private int id;
	private TiposDependentes tipoDependente;
	private Boolean optanteIR;
	private String nome;
	private String sobrenome;
	private LocalDate dataDeNascimento;
	private Boolean pcd;
	private String cpf;
	
	/**
	 * Construtor que irá interagir com o Controller da API, disponibilizando as informações
	 * de {@link Dependente}.
	 * 
	 * @param Dependente modelOriginal
	 */
	public DependenteDTO (Dependente modelOriginal) {
		this.id = modelOriginal.getId();
		this.tipoDependente = modelOriginal.getTipoDependente();
		this.optanteIR = modelOriginal.isOptanteIR();
		this.nome = modelOriginal.getNome();
		this.sobrenome = modelOriginal.getSobrenome();
		this.dataDeNascimento = modelOriginal.getDataDeNascimento();
		this.pcd = modelOriginal.isPcd();
		this.cpf = modelOriginal.getCpf();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TiposDependentes getTipoDependente() {
		return tipoDependente;
	}
	public void setTipoDependente(TiposDependentes tipoDependente) {
		this.tipoDependente = tipoDependente;
	}
	public Boolean getOptanteIR() {
		return optanteIR;
	}
	public void setOptanteIR(Boolean optanteIR) {
		this.optanteIR = optanteIR;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Boolean getPcd() {
		return pcd;
	}
	public void setPcd(Boolean pcd) {
		this.pcd = pcd;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
}
