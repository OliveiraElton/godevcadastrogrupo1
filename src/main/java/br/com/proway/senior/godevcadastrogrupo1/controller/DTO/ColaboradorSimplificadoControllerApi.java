package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorSimplificadoDTO;

public class ColaboradorSimplificadoControllerApi {

	/**
	 * Retorna um registro de {@link ColaboradorSimplificadoDTO} atraves do id
	 * repassado no parametro.
	 * 
	 * @param id
	 * @return
	 */
	public ColaboradorSimplificadoDTO buscarColaboradorPorId(int id) {
		Colaborador colaborador = ColaboradorController.buscarColaboradorPorId(id);
		ColaboradorSimplificadoDTO colaboradorDto = new ColaboradorSimplificadoDTO(colaborador);
		return colaboradorDto;
	}

	/**
	 * Retorna uma Lista de todos os {@link ColaboradorSimplificadoDTO}.
	 * 
	 * @return
	 */
	public List<ColaboradorSimplificadoDTO> buscarTodos() {
		List<ColaboradorSimplificadoDTO> listaColaboradorDto = new ArrayList<ColaboradorSimplificadoDTO>();
		List<Colaborador> listaColaborador = ColaboradorController.buscarTodosColaboradores();

		for (Colaborador colaborador : listaColaborador) {
			listaColaboradorDto.add(new ColaboradorSimplificadoDTO(colaborador));
		}
		return listaColaboradorDto;
	}

	/**
	 * Retorna uma Lista de todos {@link ColaboradorSimplificadoDTO} onde o nome
	 * seja igual ao repassado por parametro.
	 * 
	 * @param nome
	 * @return
	 */
	public List<ColaboradorSimplificadoDTO> buscarColaboradorPorNome(String nome) {
		List<Colaborador> listaColaborador = ColaboradorController.buscarColaboradorPorNome(nome);
		List<ColaboradorSimplificadoDTO> listaColaboradorDto = new ArrayList<ColaboradorSimplificadoDTO>();
		for (Colaborador colaborador : listaColaborador) {
			listaColaboradorDto.add(new ColaboradorSimplificadoDTO(colaborador));
		}
		return listaColaboradorDto;
	}
}
