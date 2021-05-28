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

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * * 
* Classe para interacao via Controller API, tem referencia com 
* {@link Colaborador}. Disponibiliza todas as informacoes na API.
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
* @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 *
 */
@RestController
public class DependenteCompletoControllerAPI {
	
	static Session session = BDConexao.getSessao();
	static DependenteDAO dependenteDao = DependenteDAO.getInstance(session);
	
	/**
	 * Cadastrar Dependente.
	 * 
	 * Recebe os dados do dependente separados, cria todos os dados e chama os DAO
	 * necessários para a criacao do dependente, por fim chama o DAO do dependente
	 * para salvar no banco.
	 * 
	 * @param Dependente dependente
	 * 
	 * @return Retorna o Dependente caso tenha sido cadastrado ou null caso contrário
	 */
	@RequestMapping(value = "/dependente", method = RequestMethod.POST)
	public @ResponseBody Dependente cadastrarDependente(@RequestBody Dependente dependente) {
		return dependenteDao.cadastrar(dependente);
	}
	
	/**
	 * Deleta Dependente.
	 * 
	 * Deleta o Dependente passado como parametro.
	 * 
	 * @param id dependente a ser deletado
	 * 
	 * @return true caso seja deletado ou false caso contrario
	 */
	@RequestMapping(value = "/dependente/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletarDependente(@PathVariable ("id") Integer id) {
		Dependente dependente = dependenteDao.buscarPorId(Dependente.class, id);
		return dependenteDao.deletar(dependente);
	}
	
	/**
	 * Atualizar Dependente.
	 * 
	 * Cria um novo dependente com os dados recebidos e os altera no dependente
	 * passado como parametro chamando o DAO do dependente.
	 * 
	 * @param Dependente dependente
	 * @return Objeto dependente caso seja atualizado ou false caso contrario.
	 */
	@RequestMapping(value = "/dependente", method = RequestMethod.PUT)
	public @ResponseBody Dependente atualizarDependente(@RequestBody Dependente dependente) {
		
		return dependenteDao.atualizar(dependente);
	}
	
	/**
	 * Busca Dependente por id.
	 * 
	 * Busca o Dependente cujo id eh igual ao passado como parametro.
	 * 
	 * @param id Do dependente desejado.
	 * 
	 * @return Dependente ou null caso nao encontrado.
	 */
	@RequestMapping(value = "/dependente/{id}", method = RequestMethod.GET)
	public @ResponseBody DependenteCompletoDTO buscarDependentePorId(@PathVariable ("id") Integer id) {
		DependenteCompletoDTO DependenteCompletoDTO = new DependenteCompletoDTO(dependenteDao.buscarPorId(Dependente.class, id));
		return DependenteCompletoDTO;
	}
	/**
	 * Busca Dependente por id do Colaborador.
	 * 
	 * Busca o Dependente relacionado ao Colaborador cujo id eh igual ao passado como
	 * parametro.
	 * 
	 * @param id do Colaborador desejado.
	 * 
	 * @return Dependente ou null caso nao encontrado.
	 */
	@RequestMapping(value = "/dependente/colab/{id}", method = RequestMethod.GET)
	public @ResponseBody List<DependenteCompletoDTO> buscarDependentePorIdColaborador(@PathVariable ("id") Integer id) {
		List<DependenteCompletoDTO> listaDependentes = new ArrayList<DependenteCompletoDTO>();
		
		for(Dependente dependente : dependenteDao.buscarDependentesPorIdColaborador(id)) {
			listaDependentes.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependentes;
	}
	
	/**
	 * Busca todos os dependentes do banco de dados.
	 * 
	 * @return listaDependenteCompletoDTO Lista de {@link DependenteDTO}
	 */
	@RequestMapping(value = "/dependente", method = RequestMethod.GET)
	public @ResponseBody List<DependenteCompletoDTO> buscarTodosDependentes() {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteCompletoDTO>();
		for(Dependente dependente : dependenteDao.buscarTodos(Dependente.class)) {
			listaDependenteCompletoDTO.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}
	
	/**
	 * Buscar todos os dependentes por nome.
	 * 
	 * Buscar todos os dependentes no banco de dados que tem nome igual ao
	 * passado como parametro.
	 * 
	 * @param nome do registro procurado.
	 * @return listaDependenteCompletoDTO
	 */
	@RequestMapping(value = "/dependente/nome/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<DependenteCompletoDTO> buscarDependentePorNome(@PathVariable ("nome") String nome) {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteCompletoDTO>();
		for(Dependente dependente : dependenteDao.buscarPorNome(Dependente.class, nome)) {
			listaDependenteCompletoDTO.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}
}
