package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;

/*
 * Classe de envio de dados do objeto para outros módulos.
 * 
 * Classe DTO que recebe atributos de objeto para interacao com outros módulos.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 */
public class ContatosDTO {

	
	private String telefonePrincipal;
	private String telefoneSecundario;
	private String email;
	private String telefoneFamiliar;
	
		public ContatosDTO(Contatos contatos) {
			this.telefonePrincipal = contatos.getTelefonePrincipal();
			this.telefoneSecundario = contatos.getTelefoneSecundario();
			this.email = contatos.getEmail();
			this.telefoneFamiliar = contatos.getTelefoneFamiliar();
		}
		
	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}
	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefoneFamiliar() {
		return telefoneFamiliar;
	}
}
