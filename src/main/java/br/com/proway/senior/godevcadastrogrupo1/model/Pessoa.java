package br.com.proway.senior.godevcadastrogrupo1.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import br.com.proway.senior.godevcadastrogrupo1.utils.FormatacaoDocumentos;
import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDeDatas;
import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDocumentos;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe Pessoa.
 * 
 * Abstrai os atributos de uma pessoa. Servira de heranca para as classes
 * {@link Colaborador}, {@link PrestadorServico} e {@link Dependente}.
 * Deve ser instanciada utilizando o PessoaBuilder.
 * 
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger
 *         Brito, Thiago Luiz Barbieri e Vitor Nathan Goncalves.
 *         
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 */

@MappedSuperclass
public class Pessoa{

	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private Boolean pcd = false;
	private String genero;
	private IdentidadeGenero identidadeGenero;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	private String cpf;
	private String rg;
	
	public Pessoa() {
		
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
	 * @param endereco
	 * @param cpf
	 * @param rg
	 * @param contatos
	 */
	public Pessoa(String nome, String sobrenome, String nomeSocial, 
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade,
			Boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			Endereco endereco, String cpf, String rg) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setNomeSocial(nomeSocial);
		this.setDataDeNascimento(dataDeNascimento);;
		this.setNacionalidade(nacionalidade);
		this.setNaturalidade(naturalidade);
		this.setPcd(pcd);
		this.setGenero(genero);
		this.setIdentidadeGenero(identidadeGenero);
		this.setEndereco(endereco);
		this.setCpf(cpf);
		this.setRg(rg);
	}
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo remove os caracteres desnecessarios ao cadastrar
	 * um nome. Utiliza a classe {@link FormatacaoDocumentos}.
	 * 
	 * @param nome Nome que sera que sera atribuido a Pessoa.
	 */
	public void setNome(String nome) {
		try{
			FormatacaoDocumentos.removerCaracteres(nome);
			this.nome = nome;
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Metodo remove os caracteres desnecessarios ao cadastrar
	 * um sobremnome. Utiliza a classe {@link FormatacaoDocumentos}.
	 * 
	 * @param sobrenome Sobrenome que sera que sera atribuido a Pessoa.
	 */
	public void setSobrenome(String sobrenome) {
		try{
			FormatacaoDocumentos.removerCaracteres(sobrenome);
			this.sobrenome = sobrenome;
		}
		catch(Exception e){
			e.getMessage();
		}
	}
	
	public String getNomeSocial() {
		return nomeSocial;
	}
	
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	/**
	 * Para cadastrar uma data de nascimento eh necessario que a mesma seja 
	 * valida, este metodo chama a classe {@link ValidacaoDeDatas} e realiza 
	 * a verificacao.
	 * 
	 * @param dataDeNascimento Data de nascimento que sera atribuida a Pessoa.
	 */
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		try {
			if(ValidacaoDeDatas.validaDataDeNascimento(dataDeNascimento)) {
				this.dataDeNascimento = dataDeNascimento;
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public Boolean isPcd() {
		return pcd;
	}
	
	public void setPcd(Boolean pcd) {
		this.pcd = pcd;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public IdentidadeGenero getIdentidadeGenero() {
		return identidadeGenero;
	}
	
	public void setIdentidadeGenero(IdentidadeGenero identidadeGenero) {
		this.identidadeGenero = identidadeGenero;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Para cadastrar um CPF eh necessario que o mesmo seja valido,
	 * este metodo chama a classe {@link ValidacaoDocumentos}
	 * e realiza a verificacao.
	 * 
	 * @param cpf CPF que sera atribuido a Pessoa.
	 */
	public void setCpf(String cpf) {
		try{
			if(ValidacaoDocumentos.validarCPF(cpf)) {
				this.cpf = cpf;
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}

}