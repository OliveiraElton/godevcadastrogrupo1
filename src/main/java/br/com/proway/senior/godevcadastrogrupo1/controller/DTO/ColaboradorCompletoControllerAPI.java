package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * Classe ColaboradorCompletoControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via 
 * API Rest. Implementa os metodos de interacao com o banco do
 * {@link ColaboradorCompletoController} e atributos do model
 * {@link ColaboradorCompletoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 * @author Gabriel Simon <b>gabriel.simon@senior.com.br</b>
 */

@RestController
public class ColaboradorCompletoControllerAPI {

	static Session session = BDConexao.getSessao();
	static ColaboradorDAO colaboradorDao = ColaboradorDAO.getInstance(session);

	/**
	 * Buscar colaborador por Id.
	 * 
	 * Metodo busca as informacoes cadastradas do colaborador, conforme
	 * idColaborador informado. Retorna um objeto ColaboradorCompletoDTO que sera
	 * visualizado pelo cliente da API.
	 * 
	 * @param idColaborador identificacao do colaborador que sera retornado.
	 * @return ColaboradorCompletoDTO objeto com as informacoes do banco.
	 */

	@RequestMapping(value = "/colaboradorcompleto/{id}", method = RequestMethod.GET)
	public @ResponseBody ColaboradorCompletoDTO buscarColaboradorPorId(@PathVariable("id") Integer idColaborador) {
		ColaboradorCompletoDTO colaboradorDTO = new ColaboradorCompletoDTO(colaboradorDao.buscarPorId(Colaborador.class, idColaborador));
		return colaboradorDTO;
	}

	/**
	 * Cadastrar Colaborador.
	 * 
	 * Recebe os dados necessarios para criar um colaborador. Depois chama o
	 * DAO e salva no banco de dados.
	 * 
	 * @param colaborador Objeto do registro que sera criado.
	 * @return Retorna o colaborador criado no banco.
	 */
	@RequestMapping(value = "/colaboradorcompleto", method = RequestMethod.POST)
	public @ResponseBody Colaborador cadastrarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorDao.cadastrar(colaborador);
	}

	/**
	 * Atualiza Colaborador.
	 * 
	 * Cria um novo Colaborador que vai sobrepor as informacoes do antigo registro
	 * do Colaborador pelo parametro passado.
	 * 
	 * @param colaborador Objeto com dados atualizados.
	 * @return Retorna o colaborador atualizado.
	 */
	@RequestMapping(value = "/colaboradorcompleto", method = RequestMethod.PUT)
	public @ResponseBody Colaborador atualizarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorDao.atualizar(colaborador);
	}

	/**
	 * Deleta um Colaborador.
	 * 
	 * Realiza a exclusao de um {@link Colaborador} conforme ID passado no parametro.
	 * 
	 * @param id Identificacao do colaborador que sera excluido.
	 * @return Vai retornar verdadeiro se for deletado e false caso contrario.
	 */
	@RequestMapping(value = "/colaboradorcompleto/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletarColaborador(@PathVariable("id") Integer id) {
		Colaborador colaborador = colaboradorDao.buscarPorId(Colaborador.class, id);
		return colaboradorDao.deletar(colaborador);
	}

	/**
	 * Buscar todos os colaboradores.
	 * 
	 * Metodo busca as informacoes de todos os colaboradores cadastrados no banco de
	 * dados. Retorna uma lista de todos os registros de colaboradores.
	 * 
	 * @return listaColaboradorDTO lista de registros localizados.
	 */

	@RequestMapping(value = "/colaboradorcompleto", method = RequestMethod.GET)
	public static @ResponseBody List<ColaboradorCompletoDTO> buscarTodosColaboradores() {
		List<ColaboradorCompletoDTO> listaColaboradorDTO = new ArrayList<ColaboradorCompletoDTO>();
		List<Colaborador> listaImprime = colaboradorDao.buscarTodos(Colaborador.class);
		for (Colaborador colaborador : listaImprime) {
			listaColaboradorDTO.add(new ColaboradorCompletoDTO(colaborador));
		}
		return listaColaboradorDTO;
	}

	/**
	 * Busca colaborador por nome.
	 * 
	 * Metodo busca os colaboradores no banco de dados atraves dos seus respectivos
	 * nomes, eh possivel passar um parametro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeColaborador.
	 * 
	 * @param nomeColaborador nome dos registros que estao sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */

	@RequestMapping(value = "/colaboradorcompleto/nome/{nome}", method = RequestMethod.GET)
	public static @ResponseBody List<ColaboradorCompletoDTO> buscarColaboradorPorNome(
			@PathVariable("nome") String nome) {
		List<ColaboradorCompletoDTO> listaColaboradorDTO = new ArrayList<ColaboradorCompletoDTO>();
		for (Colaborador colaborador : colaboradorDao.buscarPorNome(Colaborador.class, nome)) {
			listaColaboradorDTO.add(new ColaboradorCompletoDTO(colaborador));
		}
		return listaColaboradorDTO;
	}

}
