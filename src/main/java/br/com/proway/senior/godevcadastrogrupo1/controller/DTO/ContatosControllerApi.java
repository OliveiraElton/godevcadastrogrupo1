package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ContatosDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * * Classe para interação via Controller API, tem referência com
 * {@link Colaborador} e {@link PrestadorServico}. Disponibiliza todas as
 * informações na API.
 * 
 * @author Elton Oliveira <elton.oliveira@senior.com.br>
 *
 */
public class ContatosControllerApi {

	static Session session = DBConnection.getSession();
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);

	public ContatosDTO buscarContatosPorId(Integer id) {
		ContatosDTO contatosDTO = new ContatosDTO(ContatosDAO.getInstance(session).readById(id));
		System.out.println(contatosDTO.getEmail());
		return contatosDTO;
	}

	public static List<ContatosDTO> buscarTodosContatos() {
		List<ContatosDTO> listaContatosDTO = new ArrayList<ContatosDTO>();
		List<Contatos> listaImprime = ContatosDAO.getInstance(session).getAll();
		System.out.println(listaImprime.get(0).getEmail());
		System.out.println(listaImprime.get(1).getEmail());
		for (Contatos contatos : ContatosDAO.getInstance(session).getAll()) {
			listaContatosDTO.add(new ContatosDTO(contatos));
		}
		return listaContatosDTO;
	}

	public static List<ContatosDTO> buscarPrestadorServicoPorEmail(String email) {
		List<ContatosDTO> listaContatosDTO = new ArrayList<ContatosDTO>();
		for (Contatos contatos : ContatosDAO.getInstance(session).buscarPorEmail(email)) {
			listaContatosDTO.add(new ContatosDTO(contatos));
		}
		return listaContatosDTO;
	}
}
