package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.EmpresaController;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EmpresaDTO;

/**
 * Classe EmpresaControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via API Rest.
 * Implementa os métodos de visualização do {@link EmpresaController} e atriutos
 * do model {@link EmpresaDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class EmpresaControllerAPI {

	static EmpresaController controllerOriginal = new EmpresaController();

	/**
	 * Buscar empresa por Id.
	 * 
	 * Método busca as informações cadastradas da empresa, conforme idEmpresa
	 * informado. Retorna um objeto EmpresaDTO que será visualizado pelo cliente da
	 * API.
	 * 
	 * @param idEmpresa identificação da empresa que será retornada.
	 * @return EmpresaDTO objeto com as informações do banco.
	 */
	public EmpresaDTO buscarEmpresaPorId(Integer idEmpresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO(controllerOriginal.buscarEmpresaPorId(idEmpresa));
		return empresaDTO;
	}

	/**
	 * Buscar todas as empresas.
	 * 
	 * Método busca as informações de todas as empresas cadastradas no banco de dados.
	 * Retorna uma lista de todos os registros de empresas.
	 * 
	 * @return listaPrestadorDTO lista de registros localizados.
	 */
	public static List<EmpresaDTO> buscarTodasEmpresas() {
		List<EmpresaDTO> listaPrestadorDTO = new ArrayList<EmpresaDTO>();
		List<Empresa> listaImprime = controllerOriginal.buscarTodasEmpresas();
		for(Empresa empresa : controllerOriginal.buscarTodasEmpresas()) {
			listaPrestadorDTO.add(new EmpresaDTO(empresa));
		}
		return listaPrestadorDTO;
	}
	
}
