package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;

public class ColaboradorSimplificadoDTO {

	private int id;
	private String nome;
	private String sobrenome;
	private Boolean pcd;
	private String cpf;
	private Integer idPostoDeTRabalho;
	private Integer nit;
	private Boolean optanteVT;
	private Boolean optanteVAVR;
	private LocalDate dataAdmissao;
	private Boolean optanteDependente;
	private String email_corporativo;
	private Conta conta;

	public ColaboradorSimplificadoDTO(Colaborador colaborador) {
		this.id = colaborador.getId();
		this.nome = colaborador.getNome();
		this.sobrenome = colaborador.getSobrenome();
		this.pcd = colaborador.isPcd();
		this.cpf = colaborador.getCpf();
		this.idPostoDeTRabalho = colaborador.getIdPostoDeTrabalho();
		this.nit = colaborador.getNit();
		this.optanteVT = colaborador.isOptanteVT();
		this.optanteVAVR = colaborador.isOptanteVAVR();
		this.dataAdmissao = colaborador.getDataAdmissao();
		this.optanteDependente = colaborador.isOptanteDependente();
		this.email_corporativo = colaborador.getEmail_corporativo();
		this.conta = colaborador.getConta();
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public Boolean getPcd() {
		return pcd;
	}

	public String getCpf() {
		return cpf;
	}

	public Integer getIdPostoDeTRabalho() {
		return idPostoDeTRabalho;
	}

	public Integer getNit() {
		return nit;
	}

	public Boolean getOptanteVT() {
		return optanteVT;
	}

	public Boolean getOptanteVAVR() {
		return optanteVAVR;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public Boolean getOptanteDependente() {
		return optanteDependente;
	}

	public String getEmail_corporativo() {
		return email_corporativo;
	}

	public Conta getConta() {
		return conta;
	}

}
