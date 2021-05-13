package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import model.Dependente;
import model.Endereco;
import persistence.DBConnection;

public class DependenteDAOTest {

	Session session = DBConnection.getSession();
	DependenteDAO dao = DependenteDAO.getInstance(session);

	@Before
	public void limparDependente() {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.createSQLQuery("DELETE FROM Dependente;").executeUpdate();
		session.getTransaction().commit();
	}

	@Test
	public void testReadById() {
		Dependente dependente = new Dependente("Joãozinho", null, null, null, null, null, false, null, null, null, null, null, null, null, null, false);
		dao.create(dependente);
		Integer id = dependente.getId();
		assertEquals(dependente, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Dependente dependente = new Dependente ("Joãozinho", null, null, null, null, null, false, null, null, null, null, null, null, null, null, false);
		Dependente dependente2 = new Dependente("Mariazinha", null, null, null, null, null, false, null, null, null, null, null, null, null, null, false);
		dao.create(dependente);
		dao.create(dependente2);
		assertEquals(2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		Dependente dependente = new Dependente("Joãozinho", null, null, null, null, null, false, null, null, null, null, null, null, null, null, false);
		assertEquals(dependente, dao.create(dependente));
	}

	@Test
	public void testDelete() {
		Dependente dependente = new Dependente("Joãozinho", null, null, null, null, null, false, null, null, null, null, null, null, null, null, false);
		dao.create(dependente);

		dao.delete(dependente);
		assertEquals(0, dao.getAll().size());
	}
	
	@Test
	public void testUpdate() {
		Dependente dependente = new Dependente("Joãozinho", null, null, null, null, null, false, null, null, null, null, null, null, null, null, false);
		dao.create(dependente);
		dependente.setRg("012345678");
		assertEquals("012345678", dao.update(dependente).getRg());

	}
}
