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
 * Implementa os m�todos de visualiza��o do {@link EmpresaController} e atriutos
 * do model {@link EmpresaDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
@RestController
public class EmpresaControllerAPI {
	
	static Session session = DBConnection.getSession();
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	static EmpresaController controllerOriginal = new EmpresaController();

	@RequestMapping(value = "/empresa", method = RequestMethod.POST)
	public @ResponseBody Empresa criarEmpresa(@RequestBody Empresa empresa) {
		return daoEmpresa.create(empresa);
	}
	
	@RequestMapping(value = "/empresa/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteEmpresa(@PathVariable ("id") Integer id) {
		Empresa empresa = daoEmpresa.readById(id);
		return daoEmpresa.delete(empresa);
	}
	
	@RequestMapping(value = "/empresa/{id}", method = RequestMethod.PUT)
	public @ResponseBody Empresa atualizarEmpresa(@PathVariable ("id") Integer id, @RequestBody Empresa empresa) {
		empresa.setId(id);
		return daoEmpresa.update(empresa);
	}
	/**
	 * Buscar empresa por Id.
	 * 
	 * M�todo busca as informa��es cadastradas da empresa, conforme idEmpresa
	 * informado. Retorna um objeto EmpresaDTO que ser� visualizado pelo cliente da
	 * API.
	 * 
	 * @param idEmpresa identifica��o da empresa que ser� retornada.
	 * @return EmpresaDTO objeto com as informa��es do banco.
	 */
	@RequestMapping(value = "/empresa/{id}", method = RequestMethod.GET)
	public @ResponseBody EmpresaDTO buscarEmpresaPorId(@PathVariable ("id") Integer idEmpresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO(controllerOriginal.buscarEmpresaPorId(idEmpresa));
		return empresaDTO;
	}

	/**
	 * Buscar todas as empresas.
	 * 
	 * M�todo busca as informa��es de todas as empresas cadastradas no banco de
	 * dados. Retorna uma lista de todos os registros de empresas.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 */
	@RequestMapping(value = "/empresa", method = RequestMethod.GET)
	public @ResponseBody List<EmpresaDTO> buscarTodasEmpresas() {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<EmpresaDTO>();
		List<Empresa> listaImprime = controllerOriginal.buscarTodasEmpresas();
		for (Empresa empresa : listaImprime) {
			listaEmpresaDTO.add(new EmpresaDTO(empresa));
		}
		return listaEmpresaDTO;
	}

	/**
	 * Busca empresa por nome.
	 * 
	 * M�todo busca as empresas no banco de dados atrav�s dos seus respectivos
	 * nomes, � poss�vel passar um par�metro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeEmpresa.
	 * 
	 * @param nomeEmpresa nome dos registros que est�o sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */
	@RequestMapping(value = "/empresa/{nome}", method = RequestMethod.GET)
	public @ResponseBody List<EmpresaDTO> buscarEmpresaPorNome(@PathVariable ("nome") 
			String nome) {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<EmpresaDTO>();
		for (Empresa empresa : controllerOriginal.buscarEmpresaPorNome(nome)) {
			listaEmpresaDTO.add(new EmpresaDTO(empresa));
		}
		return listaEmpresaDTO;
	}

}
