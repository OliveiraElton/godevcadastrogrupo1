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

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ContatosDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * * Classe para intera��o via Controller API, tem refer�ncia com
 * {@link Colaborador} e {@link PrestadorServico}. Disponibiliza todas as
 * informa��es na API.
 * 
 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
 *
 */

@RestController
public class ContatosControllerApi {

	static Session session = DBConnection.getSession();
	ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	
	/**
	 * Método criar contato
	 * 
	 * Ao criar irá registrar as informações no banco de dados com os parametros informados.
	 * 
	 * Salva as informações no banco.
	 * 
	 * @param contatos
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@RequestMapping(value = "/contatos", method = RequestMethod.POST)
	public @ResponseBody Contatos criarContato(@RequestBody Contatos contatos) {
		return daoContatos.create(contatos);
	}
	
	/**
	 * Método deletar contato
	 * 
	 * Ao deletar irá remover as informações no banco de dados, com parametro id informado..
	 * 
	 * Deleta as informações no banco.
	 * 
	 * @param contatos
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteContatos(@PathVariable ("id") Integer id) {
		Contatos contatos = daoContatos.readById(id);
		return daoContatos.delete(contatos);
	}
	
	/**
	 * Método atualiza contato
	 * 
	 * Irá atualizar as informações no banco de dados com os parametros id informado.
	 * 
	 * Atualiza as informações no banco.
	 * 
	 * @param contatos
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.PUT)
	public @ResponseBody Contatos atualizarContatos(@PathVariable ("id")  Integer id, @RequestBody Contatos contatos) {
		contatos.setId(id);
		return daoContatos.update(contatos);
	}
	
	
	/**
	 * Buscar contatos por Id.
	 * 
	 * Método busca as informações dos contatos informando parametro id.
	 * 
	 * Retorna o conteudo informado no parametro id referente ao contato.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.GET)
	public @ResponseBody ContatosDTO buscarContatosPorId(@PathVariable ("id") Integer id) {
		ContatosDTO contatosDTO = new ContatosDTO(ContatosDAO.getInstance(session).readById(id));
		System.out.println(contatosDTO.getEmail());
		return contatosDTO;
	}

	/**
	 * Buscar todos os contatos.
	 * 
	 * Método busca as informações de todos os contatos cadastrados no banco de
	 * dados. Retorna uma lista de todos os registros do contatos.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@RequestMapping(value = "/contatos", method = RequestMethod.GET)
	public @ResponseBody List<ContatosDTO> buscarTodosContatos() {
		List<ContatosDTO> listaContatosDTO = new ArrayList<ContatosDTO>();
		List<Contatos> listaImprime = ContatosDAO.getInstance(session).getAll();
		System.out.println(listaImprime.get(0).getEmail());
		System.out.println(listaImprime.get(1).getEmail());
		for (Contatos contatos : ContatosDAO.getInstance(session).getAll()) {
			listaContatosDTO.add(new ContatosDTO(contatos));
		}
		return listaContatosDTO;
	}
	
	/**
	 * Buscar contatos por email.
	 * 
	 * Método busca as informações dos contatos informando parametro email.
	 * 
	 * Retorna o conteudo informado no parametro email referente ao contato.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@RequestMapping(value = "/empresa/{email}", method = RequestMethod.GET)
	public @ResponseBody List<ContatosDTO> buscarPrestadorServicoPorEmail(@PathVariable ("email") String email) {
		List<ContatosDTO> listaContatosDTO = new ArrayList<ContatosDTO>();
		for (Contatos contatos : ContatosDAO.getInstance(session).buscarPorEmail(email)) {
			listaContatosDTO.add(new ContatosDTO(contatos));
		}
		return listaContatosDTO;
	}
}
