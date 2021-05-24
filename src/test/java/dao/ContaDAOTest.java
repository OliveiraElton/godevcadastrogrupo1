package dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContaDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class ContaDAOTest {
	
	static Session session = DBConnection.getSession();
	static ContaDAO dao = ContaDAO.getInstance(session);
	
	@BeforeClass
	public static void limparTabela() {
		dao.deleteAll();
		
	}
	
	@Test
	public void testReadById() {
		Conta conta = new Conta("Viacredi", "932", "125687", "7");
		dao.create(conta);
		Integer id = conta.getId();
		assertEquals(conta, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Conta conta = new Conta("Caixa", "932", "55661", "13");
		Integer valorAntes = dao.getAll().size();
		dao.create(conta);
		assertEquals(valorAntes + 1, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		Conta conta = new Conta("Banco do Brasil", "4125", "3366914", "3");
		int quantidade = dao.getAll().size();
		dao.create(conta);
		assertEquals(quantidade + 1, dao.getAll().size());
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
		Conta conta = new Conta("Santander", "2222", "987635", "96");
		dao.create(conta);
		conta.setAgencia("9852");
		assertEquals("9852", dao.update(conta).getAgencia());
	}
	
}
