package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import model.Conta;
import model.Endereco;
import persistence.DBConnection;

public class ContaDAOTest {
	
	Session session = DBConnection.getSession();
	ContaDAO dao = ContaDAO.getInstance(session);


	@Test
	public void testReadById() {
		Conta conta = new Conta("989896565", "9", "0456", null);
		dao.create(conta);
		Integer id = conta.getId();
		assertEquals(conta, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Conta conta = new Conta("698955", "9", "0456", null);
		Integer valorAntes = dao.getAll().size();
		dao.create(conta);
		assertEquals(valorAntes + 1, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		Conta conta = new Conta("Brasil", "0155", "05633558", "7");
		assertEquals(conta, dao.create(conta));
	}

	@Test
	public void testDelete() {
		Conta conta = new Conta("15623", null, null, null);
		dao.create(conta);
		Integer valorAntes = dao.getAll().size();
		dao.delete(conta);
		assertEquals(valorAntes -1, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		Conta conta = new Conta("15623", "B13", null, null);
		dao.create(conta);
		conta.setAgencia("B11");
		assertEquals("B11", dao.update(conta).getAgencia());
	}

}
