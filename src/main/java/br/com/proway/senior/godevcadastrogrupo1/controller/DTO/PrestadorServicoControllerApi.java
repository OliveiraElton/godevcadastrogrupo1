package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;

/**
 * Classe Controller Api para interação de dados com view (usuario).
 * 
 * Metodos de busca no banco de dados de acordo com parametros para filtragem,
 * depois de buscar, transforma em objeto DTO para jogar na view.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 *
 */
public class PrestadorServicoControllerApi {
	
	/**
	 * Busca Prestador de servico.
	 * 
	 * Busca o Prestador de Servico cujo id é igual ao passado como parâmetro,
	 * transforma em objeto DTO e manda para view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @param id
	 * @return PrestadorServicoDTO
	 */
	public PrestadorServicoDTO buscarPrestadorServicoPorId(Integer id) {
		PrestadorServicoDTO prestadorDTO = new PrestadorServicoDTO(
				PrestadorServicoController.buscarPrestadorServicoPorId(id));
		return prestadorDTO;
	}

	/**
	 * Busca todos os Prestadores de servico.
	 * 
	 * Busca todos os prestadores de serviço cadastrados no banco de dados,
	 * transforma em objetos DTO e manda para a view como lista.
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b> 
	 * @return
	 */
	public static List<PrestadorServicoDTO> buscarTodosPrestadorServico() {
		List<PrestadorServicoDTO> listaPrestadorDTO = new ArrayList<PrestadorServicoDTO>();
		for (PrestadorServico prestador : PrestadorServicoController.buscarTodosPrestadorServico()) {
			listaPrestadorDTO.add(new PrestadorServicoDTO(prestador));
		}
		return listaPrestadorDTO;
	}
	/**
	 * Busca todos os prestadores de serviço pelo nome.
	 * 
	 * Busca todos os prestadores de serviço cadastrados no banco de dados, 
	 * transforma em objetos DTO e manda para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @param String nome
	 * @return List<nome>
	 */
	public static List<PrestadorServicoDTO> buscarPrestadorServicoPorNome(String nome) {
		List<PrestadorServicoDTO> listaPrestadorDTO = new ArrayList<PrestadorServicoDTO>();
		for (PrestadorServico prestador : PrestadorServicoController.buscarPrestadorServicoPorNome(nome)) {
			listaPrestadorDTO.add(new PrestadorServicoDTO(prestador));
		}
		return listaPrestadorDTO;
	}

}
