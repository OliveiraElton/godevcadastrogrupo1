package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Classe ColaboradorSimplificadoControllerApi
 * 
 * Classe usada para consulta dos dados do colaborador pela API Rest.
 * 
 * @author Gabriel Simon <gabrielsimon775@gmail.com>
 *
 */
@RestController
public class ColaboradorSimplificadoControllerApi {

	static Session session = DBConnection.getSession();
	ColaboradorDAO daoColaborador = ColaboradorDAO.getInstance(session);
	static ColaboradorController controllerOriginal = new ColaboradorController();
	
	/**
	 * Retorna um registro de {@link ColaboradorSimplificadoDTO} atraves do id
	 * repassado no parametro.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/colaboradorSimplificado/{id}", method = RequestMethod.GET)
	public @ResponseBody ColaboradorSimplificadoDTO buscarColaboradorPorId(@PathVariable Integer id) {
		Colaborador colaborador = ColaboradorController.buscarColaboradorPorId(id);
		ColaboradorSimplificadoDTO colaboradorDto = new ColaboradorSimplificadoDTO(colaborador);
		return colaboradorDto;
	}

	/**
	 * Retorna uma Lista de todos os {@link ColaboradorSimplificadoDTO}.
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "/colaboradorSimplificado", method = RequestMethod.GET)
	public @ResponseBody List<ColaboradorSimplificadoDTO> buscarTodos() {
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
	
	@RequestMapping(value = "/colaboradorSimplificado/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<ColaboradorSimplificadoDTO> buscarColaboradorPorNome(@PathVariable ("nome") String nome) {
		List<Colaborador> listaColaborador = ColaboradorController.buscarColaboradorPorNome(nome);
		List<ColaboradorSimplificadoDTO> listaColaboradorDto = new ArrayList<ColaboradorSimplificadoDTO>();
		for (Colaborador colaborador : listaColaborador) {
			listaColaboradorDto.add(new ColaboradorSimplificadoDTO(colaborador));
		}
		return listaColaboradorDto;
	}
}
