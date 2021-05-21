package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import br.com.proway.senior.godevcadastrogrupo1.controller.EmpresaController;
import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EmpresaDTO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;

/**
 * Classe EmpresaControllerAPI
 * 
 * Classe disponibilizada para consulta dos dados da empresa via API Rest.
 * Implementa os métodos de visualização do {@link EmpresaController} e 
 * atriutos do model {@link EmpresaDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class EmpresaControllerAPI {
	
	EmpresaController controllerOriginal = new EmpresaController();
	
	/**
	 * Buscar empresa por Id.
	 * 
	 * Método busca as informações cadastradas da empresa, conforme idEmpresa informado.
	 * Retorna um objeto EmpresaDTO que será visualizado pelo cliente da API.
	 * 
	 * @param idEmpresa identificação da empresa que será retornada.
	 * @return EmpresaDTO objeto com as informações do banco.
	 */
	public EmpresaDTO buscarEmpresaPorId(Integer idEmpresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO(controllerOriginal.buscarEmpresaPorId(idEmpresa));
			return empresaDTO;
		}
	

}
