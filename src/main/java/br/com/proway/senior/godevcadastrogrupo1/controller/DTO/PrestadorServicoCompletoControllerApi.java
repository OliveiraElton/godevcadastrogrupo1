package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Pessoa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;


/**
 * * 
* Classe para interação via Controller API, tem referência com {@link Pessoa}.
* Disponibiliza todas as informações na API.
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
 *
 */
public class PrestadorServicoCompletoControllerApi {
	
	public PrestadorServicoCompletoDTO buscarPrestadorServicoCompletoPorId(Integer id) {
	PrestadorServicoCompletoDTO prestadorCompletoDTO = new PrestadorServicoCompletoDTO(PrestadorServicoController.buscarPrestadorServicoPorId(id));
		return prestadorCompletoDTO;
	}
	
	public static List<PrestadorServicoCompletoDTO> buscarTodosPrestadorServicoCompleto() {
		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = new ArrayList<PrestadorServicoCompletoDTO>();
		List<PrestadorServico> listaImprime = PrestadorServicoController.buscarTodosPrestadorServico();
		System.out.println(listaImprime.get(0).getNome());
		System.out.println(listaImprime.get(1).getNome());
		for(PrestadorServico prestador : PrestadorServicoController.buscarTodosPrestadorServico()) {
			listaPrestadorCompletoDTO.add(new PrestadorServicoCompletoDTO(prestador));
		}
		return listaPrestadorCompletoDTO;
	}
	public static List<PrestadorServicoCompletoDTO> buscarPrestadorServicoCompletoPorNome(String nome){
		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = new ArrayList<PrestadorServicoCompletoDTO>();
		for(PrestadorServico prestador : PrestadorServicoController.buscarPrestadorServicoPorNome(nome)) {
			listaPrestadorCompletoDTO.add(new PrestadorServicoCompletoDTO(prestador));
		}
		return listaPrestadorCompletoDTO;
	}

}
