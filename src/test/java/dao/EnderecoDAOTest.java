package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import model.Endereco;
import persistence.DBConnection;

public class EnderecoDAOTest {

	Session session = DBConnection.getSession();
	EnderecoDAO dao = EnderecoDAO.getInstance(session);

	@Before
	public void limparEndereco() {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.createSQLQuery("DELETE FROM Endereco;").executeUpdate();
		session.getTransaction().commit();
	}

	@Test
	public void testReadById() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.create(endereco);
		Integer id = endereco.getId();
		assertEquals(endereco, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		Endereco endereco2 = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.create(endereco);
		dao.create(endereco2);
		assertEquals(2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		assertEquals(endereco, dao.create(endereco));
	}

	@Test
	public void testDelete() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.create(endereco);

		dao.delete(endereco);
		assertEquals(0, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.create(endereco);
		endereco.setLogradouro("Av. Brasil");
		assertEquals("Av. Brasil", dao.update(endereco).getLogradouro());

	}
}
