package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ContatosDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * Classe para interacao via Controller API, tem referencia com
 * {@link Colaborador}. Disponibiliza todas as informacoes na API.
 * 
 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
 */

@CrossOrigin
@RestController
public class ContatosControllerAPI {

	static Session session = BDConexao.getSessao();
	ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	
	/**
	 * Metodo cadastrar contato.
	 * 
	 * Ao criar ire registrar as informacoes no banco de dados com os parametros informados.
	 * 
	 * Salva as informacoes no banco.
	 * 
	 * @param contatos que sera cadastrado.
	 * @param o objeto cadastrado de fato, com a respectiva ID.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@CrossOrigin
	@RequestMapping(value = "/contatos", method = RequestMethod.POST)
	public @ResponseBody Contatos cadastrarContatos(@RequestBody Contatos contatos) {
		return daoContatos.cadastrar(contatos);
	}
	
	/**
	 * Metodo deletar contato.
	 * 
	 * Ao deletar ira remover as informacoes no banco de dados, com parametro id informado..
	 * 
	 * Deleta as informacoes no banco.
	 * 
	 * @param id Identificacao do contato que sera deletado.
	 * @return boolean
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@CrossOrigin
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletarContatos(@PathVariable ("id") Integer id) {
		Contatos contatos = daoContatos.buscarPorId(Contatos.class, id);
		return daoContatos.deletar(contatos);
	}
	
	/**
	 * Metodo atualiza contato
	 * 
	 * Ira atualizar as informacoes no banco de dados com os parametros id informado.
	 * 
	 * Atualiza as informacoes no banco.
	 * 
	 * @param contatos objeto com os dados atualizados.
	 * @return objeto do banco de dados com os dados atualizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@CrossOrigin
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.PUT)
	public @ResponseBody Contatos atualizarContatos(@PathVariable ("id")  Integer id, @RequestBody Contatos contatos) {
		contatos.setId(id);
		return daoContatos.atualizar(contatos);
	}
	
	
	/**
	 * Buscar contatos por Id.
	 * 
	 * Metodo busca as informacoes dos contatos informando parametro id.
	 * 
	 * Retorna o conteudo informado no parametro id referente ao contato.
	 * 
	 * @param id Identificacao do contato
	 * @return listaEmpresaDTO lista de registros localizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@CrossOrigin
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.GET)
	public @ResponseBody ContatosDTO buscarContatosPorId(@PathVariable ("id") Integer id) {
		ContatosDTO contatosDTO = new ContatosDTO(ContatosDAO.getInstance(session).buscarPorId(Contatos.class, id));
		System.out.println(contatosDTO.getEmail());
		return contatosDTO;
	}

	/**
	 * Buscar todos os contatos.
	 * 
	 * Metodo busca as informacoes de todos os contatos cadastrados no banco de
	 * dados. Retorna uma lista de todos os registros do contatos.
	 * 
	 * @return listaEmpresaDTO lista de registros localizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@CrossOrigin
	@RequestMapping(value = "/contatos", method = RequestMethod.GET)
	public @ResponseBody List<ContatosDTO> buscarTodosContatos() {
		List<ContatosDTO> listaContatosDTO = new ArrayList<ContatosDTO>();
		List<Contatos> listaImprime = ContatosDAO.getInstance(session).buscarTodos(Contatos.class);
		System.out.println(listaImprime.get(0).getEmail());
		System.out.println(listaImprime.get(1).getEmail());
		for (Contatos contatos : ContatosDAO.getInstance(session).buscarTodos(Contatos.class)) {
			listaContatosDTO.add(new ContatosDTO(contatos));
		}
		return listaContatosDTO;
	}
	
	/**
	 * Buscar contatos por email.
	 * 
	 * Metodo busca as informacoes dos contatos informando parametro email.
	 * 
	 * Retorna o conteudo informado no parametro email referente ao contato.
	 * 
	 * @param String email informacao a ser procurado no banco.
	 * @return listaEmpresaDTO lista de registros localizados.
	 * @author Elton Oliveira <b>elton.oliveira@senior.com.br</b>
	 */
	@CrossOrigin
	@RequestMapping(value = "/contatos/{email}", method = RequestMethod.GET)
	public @ResponseBody List<ContatosDTO> buscarContatosPorEmail(@PathVariable ("email") String email) {
		List<ContatosDTO> listaContatosDTO = new ArrayList<ContatosDTO>();
		for (Contatos contatos : ContatosDAO.getInstance(session).buscarPorEmail(email)) {
			listaContatosDTO.add(new ContatosDTO(contatos));
		}
		return listaContatosDTO;
	}
}
