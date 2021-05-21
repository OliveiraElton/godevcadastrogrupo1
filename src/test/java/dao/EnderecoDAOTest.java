package dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class EnderecoDAOTest {

	Session session = DBConnection.getSession();
	EnderecoDAO dao = EnderecoDAO.getInstance(session);

	@Test
	public void testReadById() {
		Endereco endereco = new Endereco("Rua joao pessoa", 985, "", "8965123", "Centro", "Brasil", "Blumenau", "SC");
		dao.create(endereco);
		Integer id = endereco.getId();
		assertEquals(endereco, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Endereco endereco = new Endereco("Rua xv de Novembro", 1234, "", "8977445", "Centro", "Brasil", "Blumenau", "SC");
		Endereco endereco2 = new Endereco("Rua 7 de Setembro", 45, "", "8974335", "Centro", "Brasil", "Blumenau", "SC");
		Integer valorAntes = dao.getAll().size();
		dao.create(endereco);
		dao.create(endereco2);
		assertEquals(valorAntes + 2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		Endereco endereco = new Endereco("Rua 2 de Setembro", 2, "", "8765512", "Itoupava Norte", "Brasil", "Blumenau", "SC");
		dao.create(endereco);
		assertEquals("Itoupava Norte", endereco.getBairro());
	}

	@Test
	public void testDelete() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.create(endereco);
		Integer valorAntes = dao.getAll().size();
		dao.delete(endereco);
		assertEquals(valorAntes -1, dao.getAll().size());
	}


}
