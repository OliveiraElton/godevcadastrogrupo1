package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.godevcadastrogrupo1.model.Pessoa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;


/**
 * * 
* Classe para interacao via Controller API, tem referencia com {@link Pessoa},
* {@link PrestadorServicoSimplificadoDTO} e {@link PrestadorServico}.
* Disponibiliza todas as informacoes na API.
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
* @author Lucas Walim <lucas.walim@senior.com.br>
 *
 */
@CrossOrigin
@RestController
public class PrestadorServicoCompletoControllerAPI {
	
	static Session session = BDConexao.getSessao();
	PrestadorServicoDAO daoPrestadorServicos = PrestadorServicoDAO.getInstance(session);
	
	/**
	 * Cadastrar {@link PrestadorServico}
	 * 
	 * Metodo cria um registro de novo prestador de servicos no banco de dados.
	 * Recebe um objeto de {@link PrestadorServico} a ser criado.
	 * 
	 * @param prestador
	 * @return o objeto do registro criado no banco dedados.
	 */
	@RequestMapping(value = "/prestadorservico", method = RequestMethod.POST)
	public @ResponseBody PrestadorServico cadastrarPrestador(@RequestBody PrestadorServico prestador) {
		return daoPrestadorServicos.cadastrar(prestador);
	}
	
	/**
	 * Atualizar {@link PrestadorServico}.
	 * 
	 * Metodo atualiza o prestador de servicos no banco de dados, recebe o
	 * objeto alterado que sera atualizado com as informacoes.
	 * 
	 * @param prestador {@link PrestadorServico}
	 * @return prestador {@link PrestadorServico} atualizado
	 */
	@RequestMapping (value = "/prestadorservico", method = RequestMethod.PUT)
	public @ResponseBody PrestadorServico atualizarPrestador(@RequestBody PrestadorServico prestador) {
		return daoPrestadorServicos.atualizar(prestador);
	}
	
	/**
	 * Deletar {@link PrestadorServico}.
	 * 
	 * Metodo exclui um registro de prestador de servicos do banco de dados,
	 * conforme id informado.
	 * 
	 * @param id Identificacao do prestador de servico a ser excluido
	 * @return boolean
	 */
	@RequestMapping(value = "/prestadorservico/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletarPrestador(@PathVariable("id") Integer id) {
		PrestadorServico prestadorServico = daoPrestadorServicos.buscarPorId(PrestadorServico.class, id);
		return daoPrestadorServicos.deletar(prestadorServico);
	}
	
	/**
	 * Buscar prestador de servicos por Id.
	 * 
	 * Metodo busca as informacoes cadastradas de prestador de servicos, conforme 
	 * IdPrestadorServicos informado. Retorna um objeto PrestadorServicosDTO que sera
	 * visualizado pelo cliente da API.
	 * 
	 * @param id identificacao do prestador procurado.
	 * @return {@link PrestadorServicoCompletoDTO}
	 */
	@RequestMapping(value = "/prestadorservico/{id}", method = RequestMethod.GET)
	public @ResponseBody PrestadorServicoCompletoDTO buscarPrestadorServicoPorId(@PathVariable("id") Integer id) {
	PrestadorServicoCompletoDTO prestadorCompletoDTO = new PrestadorServicoCompletoDTO(daoPrestadorServicos.buscarPorId(PrestadorServico.class, id));
		return prestadorCompletoDTO;
	}
	
	/**
	 * Buscar todos os {@link PrestadorServicoCompletoDTO}.
	 * 
	 * Metodo busca as informacoes de todos os prestadores de servicos cadastrados no banco de
	 * dados. Retorna uma lista de todos os registros de prestadores de servicos.
	 * 
	 * @return listaPrestadorCompletoDTO lista de registros localizados.
	 */
	@RequestMapping(value = "/prestadorservico", method = RequestMethod.GET)
	public @ResponseBody List<PrestadorServicoCompletoDTO> buscarTodosPrestadoresServico() {
		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = new ArrayList<PrestadorServicoCompletoDTO>();
		for(PrestadorServico prestador : daoPrestadorServicos.buscarTodos(PrestadorServico.class)) {
			listaPrestadorCompletoDTO.add(new PrestadorServicoCompletoDTO(prestador));
		}
		return listaPrestadorCompletoDTO;
	}
	
	/**
	 * Busca prestador de servicos por nome.
	 * 
	 * Metodo busca os prestadores de servico no banco de dados atraves dos seus respectivos
	 * nomes, eh possivel passar um parametro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nome.
	 * 
	 * @param nome String
	 * @return ArrayList {@link PrestadorServico} lista de registros localizados.
	 */
	@RequestMapping(value = "/prestadorservico/nome/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<PrestadorServicoCompletoDTO> buscarPrestadorServicoPorNome(@PathVariable("nome") String nome){
		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = new ArrayList<PrestadorServicoCompletoDTO>();
		for(PrestadorServico prestador : daoPrestadorServicos.buscarPorNome(PrestadorServico.class, nome)) {
			listaPrestadorCompletoDTO.add(new PrestadorServicoCompletoDTO(prestador));
		}
		return listaPrestadorCompletoDTO;
	}

}
