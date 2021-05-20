package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;

public class PrestadorServicoControllerApi {
	
	public PrestadorServicoDTO buscarPrestadorServicoPorId(Integer id) {
	
	PrestadorServicoDTO prestadorDTO = new PrestadorServicoDTO(PrestadorServicoController.buscarPrestadorServicoPorId(id));
		return prestadorDTO;
	}
	
	public static List<PrestadorServicoDTO> buscarTodosPrestadorServico() {
		List<PrestadorServicoDTO> listaPrestadorDTO = new ArrayList<PrestadorServicoDTO>();
		List<PrestadorServico> listaImprime = PrestadorServicoController.buscarTodosPrestadorServico();
		System.out.println(listaImprime.get(0).getNome());
		for(PrestadorServico prestador : PrestadorServicoController.buscarTodosPrestadorServico()) {
			listaPrestadorDTO.add(new PrestadorServicoDTO(prestador));
		}
		return listaPrestadorDTO;
	}
	public static List<PrestadorServicoDTO> buscarPrestadorServicoPorNome(String nome){
		List<PrestadorServicoDTO> listaPrestadorDTO = new ArrayList<PrestadorServicoDTO>();
		for(PrestadorServico prestador : PrestadorServicoController.buscarPrestadorServicoPorNome(nome)) {
			listaPrestadorDTO.add(new PrestadorServicoDTO(prestador));
		}
		return listaPrestadorDTO;
	}

}

