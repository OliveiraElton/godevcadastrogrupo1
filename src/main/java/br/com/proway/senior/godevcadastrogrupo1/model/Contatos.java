package br.com.proway.senior.godevcadastrogrupo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDocumentos;

/**
 * Armazena os contatos necess�rios de um colaborador, empresa ou prestador de
 * servi�o.
 * 
 * Deve ser instanciado utilizando o ContatosBuilder. 
 * 
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, Thiago Luiz Barbieri e Vitor Nathan Gon�alves.
 *
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 */

@Entity
public class Contatos{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String telefonePrincipal;
	private String telefoneSecundario;
	private String email;
	private String telefoneFamiliar;
	
	public Contatos() {
		
	}
	/**
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * @throws Exception 
	 */
	public Contatos(String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar) throws Exception {
		this.setTelefonePrincipal(telefonePrincipal);
		this.setTelefoneSecundario(telefoneSecundario);
		this.setEmail(email);
		this.setTelefoneFamiliar(telefoneFamiliar);
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) throws Exception {
			ValidacaoDocumentos.validarTamanhoTelefone(telefonePrincipal);
			this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) throws Exception{
			if(ValidacaoDocumentos.validarTamanhoTelefone(telefonePrincipal)) {
				this.telefoneSecundario = telefoneSecundario;
			}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if(ValidacaoDocumentos.validarEmail(email)) {
			this.email = email;
		}
	}

	public String getTelefoneFamiliar() {
		return telefoneFamiliar;
	}

	public void setTelefoneFamiliar(String telefoneFamiliar) throws Exception {
		if(ValidacaoDocumentos.validarTamanhoTelefone(telefoneFamiliar)) {
			this.telefoneFamiliar = telefoneFamiliar;
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
