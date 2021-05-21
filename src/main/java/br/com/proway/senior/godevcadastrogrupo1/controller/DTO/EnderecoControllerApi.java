package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EnderecoDTO;

/**
 * Classe controller Api que busca enderecos para mandar na view.
 * 
 * Classe com metodos que busca no banco de dados, transforma em objeto DTO
 * e manda para a view de acordo com os criterios de busca passados no parametro.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
 * 
 */
public class EnderecoControllerApi{

	/**
	 * Metodo que busca endereco atraves do colaborador.
	 * 
	 * Metodo que recebe colaborador como parametro, busca o endereco no banco
	 * pelo seu id e retorna objeto transformado em DTO para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
	 * @param {@link Colaborador}
	 * @return {@link EnderecoDTO}
	 */
	public static EnderecoDTO buscarEnderecoDoColaborador(Colaborador colaborador){
		return new EnderecoDTO(ColaboradorController.buscarColaboradorPorId(colaborador.getId()));
	}

	/**
	 * Metodo que busca endereco atraves do colaborador.
	 * 
	 * Metodo que recebe id como parametro, busca o endereco no banco e 
	 * retorna objeto transformado em DTO para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
	 * @param {@link Integer}
	 * @return {@link EnderecoDTO}
	 */
	public static EnderecoDTO buscarEnderecoPorId(Integer id) {
		return new EnderecoDTO(EnderecoController.buscarEnderecoPorId(id));
	}
	
	/**
	 * Metodo que busca enderecos.
	 * 
	 * Metodo que busca enderecos no banco e retorna objetos transformados
	 * em DTO para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
	 * @return {@link EnderecoDTO}
	 */
	public static List<EnderecoDTO> buscarTodosEnderecos() {
		List<EnderecoDTO> listaEnderecoDTO = new ArrayList<EnderecoDTO>();
		for(Endereco endereco :  EnderecoController.listarTodosEnderecos()) {
			listaEnderecoDTO.add(new EnderecoDTO(endereco));
		}
		return listaEnderecoDTO;
	}

}

