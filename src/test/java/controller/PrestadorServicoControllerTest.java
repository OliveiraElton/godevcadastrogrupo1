package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import dao.PrestadorServicoDAO;
import model.Contatos;
import model.Empresa;
import model.PrestadorServico;
import persistence.DBConnection;

public class PrestadorServicoControllerTest {

	static Session session = DBConnection.getSession();
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);
	static Contatos contatos = new Contatos(null, null, null, null);
	static Empresa empresa = new Empresa(null, null, null, null, contatos);
	static PrestadorServico prestadorServico = new PrestadorServico("Teste", null, null, null, null,
			null, false, null, null, null, null, null, 
			null, null, null, null);

	@Test
	public void testCriarPrestadorServico() {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("TestePrestador", null, null, null, null,
				null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null);
		PrestadorServico prestadorServico = dao.readById(ps.getId());
		assertNotNull(prestadorServico);
	}

	@Test
	public void testDeletePrestadorServico() {
		PrestadorServico prestadorServico = PrestadorServicoController.criarPrestadorServico("TestePrestador", null, null, null, null,
				null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		PrestadorServicoController.deletePrestadorServico(prestadorServico);
		assertNull(dao.readById(prestadorServico.getId()));
	}

	@Test
	public void testAtualizarPrestadorServico() {
		PrestadorServico prestadorServico = PrestadorServicoController.criarPrestadorServico("TestePrestador", null, null, null, null,
				null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		Integer id = prestadorServico.getId();
		PrestadorServico ps = PrestadorServicoController.atualizarPrestadorServico(id, "teste2", null, null, null, null,
				null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null);
		assertEquals("teste2", ps.getNome());
		
	}

	@Test
	public void testBuscarPrestadorServicoPorId() {
		PrestadorServico prestadorServico = PrestadorServicoController.criarPrestadorServico("TestePrestador", null, null, null, null,
				null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		assertEquals(prestadorServico , PrestadorServicoController.buscarPrestadorServicoPorId(prestadorServico.getId()));
	}

	@Test
	public void testBuscarTodosPrestadorServico() {
		PrestadorServico prestadorServico = PrestadorServicoController.criarPrestadorServico("servico", null, null, null, null,
				null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		List<PrestadorServico> prestadoresServico = PrestadorServicoController.buscarTodosPrestadorServico(); 
		assertEquals("servico", prestadoresServico.get(prestadoresServico.size() - 1).getNome());
	}

}