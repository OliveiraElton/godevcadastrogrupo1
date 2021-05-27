package controllerDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.controller.DTO.ContatosControllerAPI;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ContatosDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * Classe ContatosControllerApiTest.
 * 
 * Testa os métodos da classe {@link ContatosControllerAPI}.
 * 
 * @author Elton F Oliveira <b>elton.oliveira@senior.com.br</b>
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatosControllerApiTest {

	static Session session = BDConexao.getSessao();
	static ContatosControllerAPI contatosControllerApi;
	ContatosDAO daoContatos = ContatosDAO.getInstance(session);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ContatosDAO.getInstance(BDConexao.getSessao()).deletarTodos("contatos");
		contatosControllerApi = new ContatosControllerAPI();
	}
	
	@Before
	public void limparTabela() {
		ContatosDAO.getInstance(BDConexao.getSessao()).deletarTodos("contatos");
	}
	
	@Test
	public void testCriarContatos() throws Exception {
		Contatos contato = new Contatos("47988361245", "47988663322", "elton@gmail.com", "47332544579");
		ContatosDAO.getInstance(BDConexao.getSessao()).cadastrar(contato);
		assertNotNull(contato);
	}
	
	@Test
	public void testAtualizarContatos() throws Exception {
		Contatos contato = new Contatos("47988361245", "47988663322", "elton@gmail.com", "47332544579");
		ContatosDAO.getInstance(BDConexao.getSessao()).cadastrar(contato);
		contato.setEmail("joao@gmail.com");
		assertEquals("joao@gmail.com", daoContatos.atualizar(contato).getEmail());
	}
	
	@Test
	public void testDeletarContatos() throws Exception {
		Contatos contato = new Contatos("47988361245", "47988663322", "elton@gmail.com", "47332544579");
		ContatosDAO.getInstance(BDConexao.getSessao()).deletar(contato);
		Integer id = contato.getId();
		assertNull(daoContatos.consultarPorId(Contatos.class, id));
	}

	@Test
	public void testABuscarContatosPorId() throws Exception {
		Contatos contato = new Contatos("47988361245", "47988663322", "elton@gmail.com", "47332544579");
		ContatosDAO.getInstance(BDConexao.getSessao()).cadastrar(contato);

		ContatosDTO contatosDTO = contatosControllerApi.buscarContatosPorId(contato.getId());
		assertEquals("elton@gmail.com", contatosDTO.getEmail());
	}

	@Test
	public void testCBuscarTodosContatos() throws Exception {
		Contatos contato = new Contatos("47988361245", "47988663322", "junior@gmail.com", "3336548940");
		ContatosDAO.getInstance(BDConexao.getSessao()).cadastrar(contato);
		Contatos contato2 = new Contatos("4789641230", "479885566441", "amanda@gmail.com", "4734567850");
		ContatosDAO.getInstance(BDConexao.getSessao()).cadastrar(contato2);
		List<ContatosDTO> listaContatosDTO = contatosControllerApi.buscarTodosContatos();
		assertEquals(2 , listaContatosDTO.size());
	}

	@Test
	public void testBBuscarContatosPorEmail() throws Exception {
		Contatos contato = new Contatos("4788556644", "4789654120", "ricardinho@gmail.com", "47336515945");
		ContatosDAO.getInstance(BDConexao.getSessao()).cadastrar(contato);

		List<ContatosDTO> listaContatosDTO = contatosControllerApi
				.buscarContatosPorEmail("ricardinho@gmail.com");
		assertEquals(1, listaContatosDTO.size());
	}
}
