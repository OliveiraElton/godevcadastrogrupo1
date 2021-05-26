package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.bind.v2.model.core.ID;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Classe ColaboradorCompletoControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via API Rest.
 * Implementa os m�todos de visualiza��o do
 * {@link ColaboradorCompletoController} e atriutos do model
 * {@link ColaboradorCompletoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class ColaboradorCompletoControllerAPI {

	static Session session = DBConnection.getSession();
	static ColaboradorController controllerOriginal = new ColaboradorController();
	static ColaboradorDAO colaboradorDao = ColaboradorDAO.getInstance(session);

	/**
	 * Buscar colaborador por Id.
	 * 
	 * M�todo busca as informa��es cadastradas do colaborador, conforme
	 * idColaborador informado. Retorna um objeto ColaboradorCompletoDTO que ser�
	 * visualizado pelo cliente da API.
	 * 
	 * @param idColaborador identifica��o do colaborador que ser� retornado.
	 * @return ColaboradorCompletoDTO objeto com as informa��es do banco.
	 */

	@RequestMapping(value = "/colaboradorCompleto/{id}", method = RequestMethod.GET)
	public @ResponseBody ColaboradorCompletoDTO buscarColaboradorPorId(@PathVariable("id") Integer idColaborador) {
		ColaboradorCompletoDTO colaboradorDTO = new ColaboradorCompletoDTO(
				controllerOriginal.buscarColaboradorPorId(idColaborador));
		return colaboradorDTO;
	}

	/**
	 * Criar Colaborador.
	 * 
	 * Vai receber os dados necessarios para criar um colaborador. Depois chama o dao e salva no banco de dados.
	 * 
	 * @param colaborador
	 * @return Retorna um colaborador 
	 */
	@RequestMapping(value = "/colaboradorCompleto", method = RequestMethod.POST)
	public @ResponseBody Colaborador criarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorDao.create(colaborador);
	}

	/**
	 * Atualiza Colaborador.
	 * 
	 * Cria um novo Colaborador que vai sobrepor as informacoes do antigo registro do Colaborador pelo parametro
	 * passado.
	 * 
	 * @param colaborador
	 * @return Vai retornar um colaborador novo.
	 */
	@RequestMapping(value = "/colaboradorCompleto", method = RequestMethod.PUT)
	public @ResponseBody Colaborador atualizarColaborador(Colaborador colaborador) {
		return colaboradorDao.update(colaborador);
	}

	/**
	 * * Excluir um Colaborador.
	 * 
	 * Vai excluir um {@link Colaborador} pelo {@link ID} passado no parametro.
	 * 
	 * @param id
	 * @return Vai retornar verdadeiro se for deletado e false caso contrario.
	 */
	@RequestMapping(value = "/colaboradorCompleto/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletarColaborador(@PathVariable("id") Integer id) {
		Colaborador colaborador = colaboradorDao.readById(id);
		return colaboradorDao.delete(colaborador);
	}

	/**
	 * Buscar todos os colaboradores.
	 * 
	 * M�todo busca as informa��es de todos os colaboradores cadastrados no banco de
	 * dados. Retorna uma lista de todos os registros de colaboradores.
	 * 
	 * @return listaColaboradorDTO lista de registros localizados.
	 */

	@RequestMapping(value = "/colaboradorCompleto", method = RequestMethod.GET)
	public static @ResponseBody List<ColaboradorCompletoDTO> buscarTodosColaboradores() {
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
	 * M�todo busca os colaboradores no banco de dados atrav�s dos seus respectivos
	 * nomes, � poss�vel passar um par�metro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeColaborador.
	 * 
	 * @param nomeColaborador nome dos registros que est�o sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */

	@RequestMapping(value = "/colaboradorCompleto/nome/{nomeColaborador}", method = RequestMethod.GET)
	public static @ResponseBody List<ColaboradorCompletoDTO> buscarColaboradorPorNome(
			@PathVariable("nomeColaborador") String nomeColaborador) {
		List<ColaboradorCompletoDTO> listaColaboradorDTO = new ArrayList<ColaboradorCompletoDTO>();
		for (Colaborador colaborador : controllerOriginal.buscarColaboradorPorNome(nomeColaborador)) {
			listaColaboradorDTO.add(new ColaboradorCompletoDTO(colaborador));
		}
		return listaColaboradorDTO;
	}

}
