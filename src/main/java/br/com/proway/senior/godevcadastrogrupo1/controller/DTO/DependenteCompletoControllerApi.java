package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Pessoa;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * * 
* Classe para interação via Controller API, tem referência com {@link Colaborador}.
* Disponibiliza todas as informações na API.
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
 *
 */
public class DependenteCompletoControllerApi {
	
	static Session session = DBConnection.getSession();
	static DependenteDAO daoContatos = DependenteDAO.getInstance(session);
	
	public DependenteCompletoDTO buscarDependentePorId(Integer id) {
		DependenteCompletoDTO DependenteCompletoDTO = new DependenteCompletoDTO(DependenteController.buscarDependentePorId(id));
		return DependenteCompletoDTO;
	}

	public List<DependenteCompletoDTO> buscarTodosDependenteCompleto() {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteCompletoDTO>();
		List<Dependente> listaImprime = DependenteController.buscarTodosDependente();
		System.out.println(listaImprime.get(0).getNome());
		System.out.println(listaImprime.get(1).getNome());
		for(Dependente dependente : DependenteController.buscarTodosDependente()) {
			listaDependenteCompletoDTO.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}

	public List<DependenteCompletoDTO> buscarDependenteCompletoPorNome(String nome) {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = new ArrayList<DependenteCompletoDTO>();
		for(Dependente dependente : DependenteController.buscarDependentePorNome(nome)) {
			listaDependenteCompletoDTO.add(new DependenteCompletoDTO(dependente));
		}
		return listaDependenteCompletoDTO;
	}
}
