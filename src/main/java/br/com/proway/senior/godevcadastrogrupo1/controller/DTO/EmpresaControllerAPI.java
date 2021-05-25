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

import br.com.proway.senior.godevcadastrogrupo1.controller.EmpresaController;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EmpresaDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Classe EmpresaControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via API Rest.
 * Implementa os metodos do {@link EmpresaController} e atributos
 * dos models {@link EmpresaDTO} e {@link Empresa}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
@RestController
public class EmpresaControllerAPI {
	
	static Session session = DBConnection.getSession();
	EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	/**
	 * Criar empresa.
	 * 
	 * Metodo cria um registro de nova empresa no banco de dados. Recebe um objeto
	 * da {@link Empresa} que sera criada.
	 * 
	 * @param empresa {@link Empresa}
	 * @return
	 */
	@RequestMapping(value = "/empresa", method = RequestMethod.POST)
	public @ResponseBody Empresa criarEmpresa(@RequestBody Empresa empresa) {
		return daoEmpresa.create(empresa);
	}
	
	/**
	 * Deletar empresa.
	 * 
	 * Metodo exclui um registro de empresa do banco de dados, conforme id informada.
	 * 
	 * @param id identificacao da empresa que sera excluida.
	 * @return boolean
	 */
	@RequestMapping(value = "/empresa/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteEmpresa(@PathVariable ("id") Integer id) {
		Empresa empresa = daoEmpresa.readById(id);
		return daoEmpresa.delete(empresa);
	}
	
	/**
	 * Atualizar empresa.
	 * 
	 * Metodo atualiza a empresa no banco de dados, recebe o objeto da empresa que sera alterada e um
	 * objeto empresa com as informacoes atualizadas, inclusive id referenciada. 
	 * 
	 * @param empresa objeto {@link Empresa}.
	 * @return objeto {@link Empresa} atualizado.
	 */
	@RequestMapping(value = "/empresa", method = RequestMethod.PUT)
	public @ResponseBody Empresa atualizarEmpresa(@RequestBody Empresa empresa) {
		return daoEmpresa.update(empresa);
	}
	
	/**
	 * Buscar empresa por Id.
	 * 
	 * Metodo busca as informacoes cadastradas da empresa, conforme idEmpresa
	 * informado. Retorna um objeto EmpresaDTO que sera visualizado pelo cliente da
	 * API.
	 * 
	 * @param idEmpresa identificacao da empresa que sera retornada.
	 * @return EmpresaDTO objeto com as informacoes do banco.
	 */
	@RequestMapping(value = "/empresa/{id}", method = RequestMethod.GET)
	public @ResponseBody EmpresaDTO buscarEmpresaPorId(@PathVariable ("id") Integer idEmpresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO(daoEmpresa.readById(idEmpresa));
		return empresaDTO;
	}

	/**
	 * Buscar todas as empresas.
	 * 
	 * Metodo busca as informacoes de todas as empresas cadastradas no banco de
	 * dados. Retorna uma lista de todos os registros de empresas.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 */
	@RequestMapping(value = "/empresa", method = RequestMethod.GET)
	public @ResponseBody List<EmpresaDTO> buscarTodasEmpresas() {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<EmpresaDTO>();
		List<Empresa> listaImprime = daoEmpresa.getAll();
		for (Empresa empresa : listaImprime) {
			listaEmpresaDTO.add(new EmpresaDTO(empresa));
		}
		return listaEmpresaDTO;
	}

	/**
	 * Busca empresa por nome.
	 * 
	 * Metodo busca as empresas no banco de dados atraves dos seus respectivos
	 * nomes, eh possivel passar um parametro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeEmpresa.
	 * 
	 * @param nomeEmpresa nome dos registros que estao sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */
	@RequestMapping(value = "/empresa/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<EmpresaDTO> buscarEmpresaPorNome(@PathVariable ("nome") 
			String nome) {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<EmpresaDTO>();
		for (Empresa empresa : daoEmpresa.buscarPorNome(nome)) {
			listaEmpresaDTO.add(new EmpresaDTO(empresa));
		}
		return listaEmpresaDTO;
	}

}
