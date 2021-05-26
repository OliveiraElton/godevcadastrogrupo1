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

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * * 
* Classe para intera��o via Controller API, tem refer�ncia com {@link Colaborador}.
* Disponibiliza todas as informa��es na API.
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
 *
 */
@RestController
public class DependenteCompletoControllerApi {
	
	static Session session = DBConnection.getSession();
	static DependenteDAO dependenteDao = DependenteDAO.getInstance(session);
	
	/**
	 * Criar Dependente.
	 * 
	 * Recebe os dados do dependente separados, cria todos os dados e chama os DAO
	 * necessários para a criação do dependente, por fim chama o DAO do dependente
	 * para salvar no banco.
	 * 
	 * @param Dependente dependente
	 * 
	 * @return Retorna o Dependente caso tenha sido cadastrado ou null caso contrário
	 */
	@RequestMapping(value = "/dependente", method = RequestMethod.POST)
	public @ResponseBody Dependente criarDependente(@RequestBody Dependente dependente) {
		return dependenteDao.create(dependente);
	}
	
	/**
	 * Deleta Dependente.
	 * 
	 * Deleta o Dependente passado como parâmetro.
	 * 
	 * @param dependente DEpendente a ser deletado
	 * 
	 * @return true caso seja deletado ou false caso contrário
	 */
	@RequestMapping(value = "/dependente/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteDependente(@PathVariable ("id") Integer id) {
		Dependente dependente = dependenteDao.readById(id);
		return dependenteDao.delete(dependente);
	}
	/**
	 * Atualizar Dependente.
	 * 
	 * Cria um novo dependente com os dados recebidos e os altera no dependente
	 * passado como parâmetro chamando o DAO do dependente.
	 * 
	 * @param Dependente dependente
	 * @return Objeto dependente caso seja atualizado ou false caso contrário.
	 */
	@RequestMapping(value = "/dependente", method = RequestMethod.PUT)
	public @ResponseBody Dependente atualizarDependente(@RequestBody Dependente dependente) {
		
		return dependenteDao.update(dependente);
	}
	
	/**
	 * Busca Dependente por id.
	 * 
	 * Busca o Dependente cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id Do dependente desejado.
	 * 
	 * @return Dependente ou null caso não encontrado.
	 */
	@RequestMapping(value = "/dependente/{id}", method = RequestMethod.GET)
	public @ResponseBody DependenteCompletoDTO buscarDependentePorId(@PathVariable ("id") Integer id) {
		DependenteCompletoDTO DependenteCompletoDTO = new DependenteCompletoDTO(dependenteDao.readById(id));
		return DependenteCompletoDTO;
	}
	
	/**
	 * Busca todos os dependentes do banco de dados.
	 * 
	 * @return List de {@link Dependente}
	 */
	@RequestMapping(value = "/dependente", method = RequestMethod.GET)
	public @ResponseBody List<DependenteCompletoDTO> buscarTodosDependenteCompleto() {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteCompletoDTO>();
		for(Dependente dependente : dependenteDao.getAll()) {
			listaDependenteCompletoDTO.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}
	
	/**
	 * Buscar todos os dependentes por nome.
	 * 
	 * Buscar todos os dependentes no banco de dados que tem nome igual ao
	 * passado como parametro.
	 * @param nome
	 * @return
	 */
	@RequestMapping(value = "/dependente/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<DependenteCompletoDTO> buscarDependenteCompletoPorNome(@PathVariable ("nome") String nome) {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteCompletoDTO>();
		for(Dependente dependente : dependenteDao.buscarPorNome(nome)) {
			listaDependenteCompletoDTO.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}
}
