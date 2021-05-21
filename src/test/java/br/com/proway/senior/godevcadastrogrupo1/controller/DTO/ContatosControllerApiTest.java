package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ContatosDTO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatosControllerApiTest {

	static ContatosControllerApi contatosControllerApi;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ContatosDAO.getInstance(DBConnection.getSession()).deleteAll();
		contatosControllerApi = new ContatosControllerApi();
	}

	@Test
	public void testABuscarContatosPorId() {
		Contatos contato = new Contatos("47988361245", "47988663322", "elton@gmail.com", "332544579");
		ContatosDAO.getInstance(DBConnection.getSession()).create(contato);

		ContatosDTO contatosDTO = contatosControllerApi.buscarContatosPorId(contato.getId());
		assertEquals("elton@gmail.com", contatosDTO.getEmail());
	}

	@Test
	public void testCBuscarTodosContatos() {
		Contatos contato = new Contatos("47988361245", "47988663322", "junior@gmail.com", "333654894");
		ContatosDAO.getInstance(DBConnection.getSession()).create(contato);

		Contatos contato2 = new Contatos("478964123", "479885566441", "amanda@gmail.com", "123456785");
		ContatosDAO.getInstance(DBConnection.getSession()).create(contato2);

		List<ContatosDTO> listaContatosDTO = contatosControllerApi.buscarTodosContatos();
		;
		assertEquals(4, listaContatosDTO.size());
	}

	@Test
	public void testBBuscarContatosPorEmail() {
		Contatos contato = new Contatos("4788556644", "478965412", "ricardinho@gmail.com", "336515945");
		ContatosDAO.getInstance(DBConnection.getSession()).create(contato);

		List<ContatosDTO> listaContatosDTO = contatosControllerApi
				.buscarPrestadorServicoPorEmail("ricardinho@gmail.com");
		assertEquals(1, listaContatosDTO.size());
	}
}
