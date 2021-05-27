package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * Classe controller API de {@link DependenteSimplificadoDTO}.
 * 
 * Metodos de buscar objetos do banco de dados por
 * diferentes tipos de parametro.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 *
 */
@RestController
public class DependenteSimplificadoControllerAPI {

	static Session session = BDConexao.getSessao();
	static DependenteDAO dependenteDao = DependenteDAO.getInstance(session);
	
	/**
	 * Busca Dependente por id.
	 * 
	 * Busca o Dependente cujo id eh igual ao passado como parametro.
	 * 
	 * @param id Do dependente desejado.
	 * @return Dependente ou null caso nao encontrado.
	 */
	@RequestMapping(value = "/dependentesimplificado/{id}", method = RequestMethod.GET)
	public @ResponseBody DependenteSimplificadoDTO buscarDependentePorId(@PathVariable ("id") Integer id) {
		return new DependenteSimplificadoDTO(dependenteDao.readById(id));
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
	@RequestMapping(value = "/dependentesimplificado/colab/{id}", method = RequestMethod.GET)
	public @ResponseBody List<DependenteSimplificadoDTO> buscarDependentePorIdColaborador(@PathVariable ("id") Integer id) {
		List<DependenteSimplificadoDTO> listaDependentes = new ArrayList<DependenteSimplificadoDTO>();
		
		for(Dependente dependente : dependenteDao.readByIdColab(id)) {
			listaDependentes.add(new DependenteSimplificadoDTO(dependente));
		}
		return listaDependentes;
	}
	
	/**
	 * Busca todos os dependentes.
	 * 
	 * Busca todos os dependentes do banco de dados.
	 * 
	 * @return Lista de {@link DependenteSimplificadoDTO}
	 */
	@RequestMapping(value = "/dependentesimplificado", method = RequestMethod.GET)
	public @ResponseBody List<DependenteSimplificadoDTO> buscarTodosDependentes(){
		List<DependenteSimplificadoDTO> listaDependentes = new ArrayList<DependenteSimplificadoDTO>();
		for(Dependente dependente : dependenteDao.getAll()) {
			listaDependentes.add(new DependenteSimplificadoDTO(dependente));
		}
		return listaDependentes;
	}
	/**
	 * Buscar todos os dependentes por nome.
	 * 
	 * Buscar todos os dependentes no banco de dados que tem nome igual ao
	 * passado como parametro.
	 * 
	 * @param nome do dependente procurado.
	 * @return listaDependenteCompletoDTO
	 */
	@RequestMapping(value = "/dependentesimplificado/nome/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<DependenteSimplificadoDTO> buscarDependentePorNome(@PathVariable ("nome") String nome) {
		List<DependenteSimplificadoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteSimplificadoDTO>();
		for(Dependente dependente : dependenteDao.buscarPorNome(nome)) {
			listaDependenteCompletoDTO.add(new DependenteSimplificadoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}
}