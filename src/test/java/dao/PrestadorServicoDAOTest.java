package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class PrestadorServicoDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	Session session = DBConnection.getSession();
	PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);
	protected static PrestadorServicoDAO instance;

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
		Integer valorAntes = dao.getAll().size();
		dao.create(prestadorServico);
		dao.create(prestadorServico2);
		assertEquals(valorAntes +2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		assertEquals(prestadorServico, dao.create(prestadorServico));
	}

	@Test
	public void testDelete() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		Integer valorAntes = dao.getAll().size();
		dao.delete(prestadorServico);
		assertEquals(valorAntes -1, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		prestadorServico.setNome("Senior 2");
		assertEquals("Senior 2", dao.update(prestadorServico).getNome());

	}
}
