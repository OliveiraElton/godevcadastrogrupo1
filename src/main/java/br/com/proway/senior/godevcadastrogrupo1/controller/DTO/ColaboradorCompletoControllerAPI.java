package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.EmpresaController;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EmpresaDTO;

/**
 * Classe ColaboradorCompletoControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via API Rest.
 * Implementa os métodos de visualização do {@link ColaboradorCompletoController} e atriutos
 * do model {@link ColaboradorCompletoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class ColaboradorCompletoControllerAPI {
	
	static ColaboradorController controllerOriginal = new ColaboradorController();

	/**
	 * Buscar colaborador por Id.
	 * 
	 * Método busca as informações cadastradas do colaborador, conforme idColaborador
	 * informado. Retorna um objeto ColaboradorCompletoDTO que será visualizado pelo 
	 * cliente da API.
	 * 
	 * @param idColaborador identificação do colaborador que será retornado.
	 * @return ColaboradorCompletoDTO objeto com as informações do banco.
	 */
	public ColaboradorCompletoDTO buscarEmpresaPorId(Integer idColaborador) {
		ColaboradorCompletoDTO colaboradorDTO = new ColaboradorCompletoDTO(controllerOriginal.buscarColaboradorPorId(idColaborador));
		return colaboradorDTO;
	}

	/**
	 * Buscar todas as empresas.
	 * 
	 * Método busca as informações de todas as empresas cadastradas no banco de
	 * dados. Retorna uma lista de todos os registros de empresas.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 */
	public static List<EmpresaDTO> buscarTodasEmpresas() {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<EmpresaDTO>();
		List<Empresa> listaImprime = controllerOriginal.buscarTodasEmpresas();
		for (Empresa empresa : controllerOriginal.buscarTodasEmpresas()) {
			listaEmpresaDTO.add(new EmpresaDTO(empresa));
		}
		return listaEmpresaDTO;
	}

	/**
	 * Busca empresa por nome.
	 * 
	 * Método busca as empresas no banco de dados através dos seus respectivos
	 * nomes, é possível passar um parâmetro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeEmpresa.
	 * 
	 * @param nomeEmpresa nome dos registros que estão sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */
	public static List<EmpresaDTO> buscarEmpresaPorNome(String nomeEmpresa) {
		List<EmpresaDTO> listaEmpresaDTO = new ArrayList<EmpresaDTO>();
		for (Empresa empresa : controllerOriginal.buscarEmpresaPorNome(nomeEmpresa)) {
			listaEmpresaDTO.add(new EmpresaDTO(empresa));
		}
		return listaEmpresaDTO;
	}

}
