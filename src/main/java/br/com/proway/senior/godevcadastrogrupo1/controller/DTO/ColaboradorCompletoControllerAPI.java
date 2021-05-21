package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorCompletoDTO;

/**
 * Classe ColaboradorCompletoControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via API Rest.
 * Implementa os métodos de visualização do {@link ColaboradorCompletoController} e atriutos
 * do model {@link ColaboradorCompletoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class ColaboradorCompletoControllerAPI {
	
	static ColaboradorController controllerOriginal = new ColaboradorController();

	/**
	 * Buscar colaborador por Id.
	 * 
	 * Método busca as informações cadastradas do colaborador, conforme idColaborador
	 * informado. Retorna um objeto ColaboradorCompletoDTO que será visualizado pelo 
	 * cliente da API.
	 * 
	 * @param idColaborador identificação do colaborador que será retornado.
	 * @return ColaboradorCompletoDTO objeto com as informações do banco.
	 */
	public ColaboradorCompletoDTO buscarColaboradorPorId(Integer idColaborador) {
		ColaboradorCompletoDTO colaboradorDTO = new ColaboradorCompletoDTO(controllerOriginal.buscarColaboradorPorId(idColaborador));
		return colaboradorDTO;
	}

	/**
	 * Buscar todos os colaboradores.
	 * 
	 * Método busca as informações de todos os colaboradores cadastrados no banco de
	 * dados. Retorna uma lista de todos os registros de colaboradores.
	 * 
	 * @return listaColaboradorDTO lista de registros localizados.
	 */
	public static List<ColaboradorCompletoDTO> buscarTodosColaboradores() {
		List<ColaboradorCompletoDTO> listaColaboradorDTO = new ArrayList<ColaboradorCompletoDTO>();
		List<Colaborador> listaImprime = controllerOriginal.buscarTodosColaboradores();
		for (Colaborador colaborador : listaImprime) {
			listaColaboradorDTO.add(new ColaboradorCompletoDTO(colaborador));
		}
		return listaColaboradorDTO;
	}

	/**
	 * Busca colaborador por nome.
	 * 
	 * Método busca os colaboradores no banco de dados através dos seus respectivos
	 * nomes, é possível passar um parâmetro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeColaborador.
	 * 
	 * @param nomeColaborador nome dos registros que estão sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */
	public static List<ColaboradorCompletoDTO> buscarColaboradorPorNome(String nomeColaborador) {
		List<ColaboradorCompletoDTO> listaColaboradorDTO = new ArrayList<ColaboradorCompletoDTO>();
		for (Colaborador colaborador : controllerOriginal.buscarColaboradorPorNome(nomeColaborador)) {
			listaColaboradorDTO.add(new ColaboradorCompletoDTO(colaborador));
		}
		return listaColaboradorDTO;
	}

}
