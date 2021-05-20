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
	
	
}
