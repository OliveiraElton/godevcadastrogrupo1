package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

/**
 * Classe EmpresaDTO.
 * 
 * Classe para interação via Controller API, referencia a {@link Empresa}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaDTO {

	private int id;
	private String nomeEmpresa;
	private LocalDate dataInicioContrato;
	private String cnpj;
	private Endereco endereco;
	private Contatos contato;
	
	
}
