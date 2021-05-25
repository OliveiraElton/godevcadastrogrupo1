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
	 * Cria colaborador.
	 * 
	 * Metodo responsavel por criar um registro de um novo colaborador no banco de dados. Recebe um 
	 *  objeto da {@link Colaborador} que sera criada. 
	 * 
	 * @param colaborador {@link Colaborador}
	 * @return 
	 */
	@RequestMapping(value = "/colaboradorSimplificado", method = RequestMethod.POST)
	public @ResponseBody Colaborador criarColadorador(@RequestBody Colaborador colaborador) {
		return daoColaborador.create(colaborador);
	}

	/**
	 * Exclui Colaborador.
	 * 
	 * Metodo responsavel por excluir um colaborador do banco de dados. Recebe como
	 * parametro um {@link Integer id}.
	 * @param id
	 * @return
	 */
	@RequestMapping (value = "colaborador/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletarColaborador (@PathVariable ("id") Integer id) {
		Colaborador colaborador = daoColaborador.readById(id);
		return daoColaborador.delete(colaborador);
	}
	
	/**
	 * Altera Colaborador
	 * 
	 * Metodo responsavel por alterar um colaborador do banco de dados. Recebendo como
	 * parametro um objeto {@link Colaborador}.
	 * 
	 * @param colaborador
	 * @return
	 */
	@RequestMapping(value = "/colaborador", method = RequestMethod.PUT)
	public @ResponseBody Colaborador atualizarColaborador (@RequestBody Colaborador colaborador) {
		return daoColaborador.update(colaborador);
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
