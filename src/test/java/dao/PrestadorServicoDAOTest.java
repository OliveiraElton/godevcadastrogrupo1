package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class PrestadorServicoDAOTest {

	static Session session;
	static PrestadorServicoDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		session = DBConnection.getSession();
		dao = PrestadorServicoDAO.getInstance(session);
	}
	@Before
	public void limparTabela() throws Exception{
		dao.limparTabela();
	}

	@Test
	public void testReadById() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		Integer id = prestadorServico.getId();
		assertEquals(prestadorServico, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		PrestadorServico prestadorServico2 = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);

		dao.create(prestadorServico);
		dao.create(prestadorServico2);
		assertEquals(2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		assertEquals(prestadorServico, dao.create(prestadorServico));
	}

	@Test
	public void testDelete() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "testDelete", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		Integer valorAntes = dao.getAll().size();
		dao.delete(prestadorServico);
		assertEquals(valorAntes -1, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "testUpdate", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		prestadorServico.setNome("Senior 2");
		assertEquals("Senior 2", dao.update(prestadorServico).getNome());
		dao.limparTabela();

	}
}
