package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Empresa;
import model.PrestadorServico;
import persistence.DBConnection;

public class PrestadorServicoDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	Session session = DBConnection.getSession();
	PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);

	@Before
	public void limparPrestadorServico() {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.createSQLQuery("DELETE FROM PrestadorServico;").executeUpdate();
		session.getTransaction().commit();
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
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "12345678", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		dao.delete(prestadorServico);
		assertEquals(0, dao.getAll().size());
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
