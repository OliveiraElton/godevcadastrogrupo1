package br.com.proway.senior.godevcadastrogrupo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.proway.senior.godevcadastrogrupo1.utilidades.ValidacaoDocumentos;

/**
 * Classe Endereco.
 * 
 * Classe que engloba e abstrai as informacoes de endereco de um
 * Colaborador/Empresa. Esta classe sera instanciada nas classes 
 * {@link Colaborador} e {@link Empresa}. Deve ser instanciada 
 * utilizando o EnderecoBuilder.
 * 
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, 
 * Thiago Luiz Barbieri e Vitor Nathan Gon�alves.
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 *
 */
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private Integer numero;
	private String pais;
	private String uf;
	
	public Endereco() {
		
	}
	
	/**
	 * Construtor padrao da classe.
	 * 
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 */
	public Endereco(String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf) {
		super();
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setCep(cep);
		this.setBairro(bairro);
		this.setPais(pais);
		this.setCidade(cidade);
		this.setUf(uf);
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	
	/**
	 * Para cadastrar um CEP, eh necessario que o mesmoa seja valido,
	 * este metodo realiza a verificacao.
	 * 
	 * @param cep CEP que sera cadastrado.
	 */
	public void setCep(String cep) {
		try{
			ValidacaoDocumentos.validarCEP(cep);
			this.cep = cep;
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

}
