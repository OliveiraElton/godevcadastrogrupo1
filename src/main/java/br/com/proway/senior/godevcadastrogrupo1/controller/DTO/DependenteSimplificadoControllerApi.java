package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteSimplificadoDTO;

/**
 * Classe controller Api de Dependente Simplificado.
 * 
 * Metodos de buscar objetos do banco de dados por
 * diferentes tipos de parâmetro.
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 *
 */
public class DependenteSimplificadoControllerApi {

	/**
	 * Busca Dependente por id.
	 * 
	 * Busca o Dependente cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id Do dependente desejado.
	 * 
	 * @return Dependente ou null caso não encontrado.
	 */
	public static DependenteSimplificadoDTO buscarDependentePorId(Integer id) {
		return new DependenteSimplificadoDTO(DependenteController.buscarDependentePorId(id));
	}

	/**
	 * Busca Dependente por id do Colaborador.
	 * 
	 * Busca o Dependente relacionado ao Colaborador cujo id é igual ao passado como
	 * parâmetro.
	 * 
	 * @param id do Colaborador desejado.
	 * 
	 * @return Dependente ou null caso não encontrado.
	 */
	public static List<DependenteSimplificadoDTO> buscarDependentePorIdColaborador(Integer id) {
		List<DependenteSimplificadoDTO> listaDependentes = new ArrayList<DependenteSimplificadoDTO>();
		
		for(Dependente dependente : DependenteController.buscarDependentePorIdColaborador(id)) {
			listaDependentes.add(new DependenteSimplificadoDTO(dependente));
		}
		return listaDependentes;
	}
	
	/**
	 * Busca todos os dependentes.
	 * 
	 * Busca todos os dependentes do banco de dados.
	 * 
	 * @return List de {@link DependenteSimplificadoDTO}
	 */
	public static List<DependenteSimplificadoDTO> buscarTodosDependentes(){
		List<DependenteSimplificadoDTO> listaDependentes = new ArrayList<DependenteSimplificadoDTO>();
		for(Dependente dependente : DependenteController.buscarTodosDependentes()) {
			listaDependentes.add(new DependenteSimplificadoDTO(dependente));
		}
		
		return listaDependentes;
	}
}
