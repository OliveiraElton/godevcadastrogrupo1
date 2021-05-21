package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;

public class ColaboradorSimplificadoControllerApi {

	/**
	 * Retorna um registro de {@link ColaboradorSimplificadoDTO} atraves do id repassado no parametro.
	 * @param id
	 * @return
	 */
	public ColaboradorSimplificadoDTO buscarColaboradorPorId(int id) {
		Colaborador colaborador = ColaboradorController.buscarColaboradorPorId(id);
		ColaboradorSimplificadoDTO colaboradorDto = new ColaboradorSimplificadoDTO(colaborador);
		return colaboradorDto;
	}

	public List<ColaboradorSimplificadoDTO> buscarTodos() {
		List<ColaboradorSimplificadoDTO> listaColaboradorDto = new ArrayList<ColaboradorSimplificadoDTO>();
		List<Colaborador> listaColaborador = ColaboradorController.buscarTodosColaborador();

		for (Colaborador colaborador : listaColaborador) {
			listaColaboradorDto.add(new ColaboradorSimplificadoDTO(colaborador));
		}
		return listaColaboradorDto;
	}
}
