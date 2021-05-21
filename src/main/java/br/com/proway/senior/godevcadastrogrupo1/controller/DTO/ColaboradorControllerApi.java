package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorDTO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;

public class ColaboradorControllerApi {

	/**
	 * Retorna um registro de {@link ColaboradorDTO} atraves do id repassado no parametro.
	 * @param id
	 * @return
	 */
	public ColaboradorDTO buscarColaboradorPorId(int id) {
		Colaborador colaborador = ColaboradorController.buscarColaboradorPorId(id);
		ColaboradorDTO colaboradorDto = new ColaboradorDTO(colaborador);
		return colaboradorDto;
	}

	public List<ColaboradorDTO> buscarTodos() {
		List<ColaboradorDTO> listaColaboradorDto = new ArrayList<ColaboradorDTO>();
		List<Colaborador> listaColaborador = ColaboradorController.buscarTodosColaborador();

		for (Colaborador colaborador : listaColaborador) {
			listaColaboradorDto.add(new ColaboradorDTO(colaborador));
		}
		return listaColaboradorDto;
	}
}
