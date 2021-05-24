package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ContatosDAOTest {

	Session session = DBConnection.getSession();
	ContatosDAO dao = ContatosDAO.getInstance(session);
	
	@Test
	public void testBReadById() {
		Contatos contato = new Contatos("3522-2215","98484962","amaral@gmail.com","9999-1111");
		dao.create(contato);
		Integer id = contato.getId();
		assertEquals(contato, dao.readById(id));
		
	}

	@Test
	public void testCGetAll() {
		Contatos contato = new Contatos("3522-2215","9848-4962","joao@gmail.com","9999-1111");
		Contatos contato2 = new Contatos("3533-9999","1234-5678","amanda@gmail.com","1111-9999");
		Contatos contato3 = new Contatos("3533-9999","1234-5678","pedro@gmail.com","1111-9999");
		
		Integer valorAntes = dao.getAll().size();
		dao.create(contato);
		dao.create(contato2);
		dao.create(contato3);
		assertEquals(valorAntes + 3, dao.getAll().size());
	}
	
	@Test
	public void testDGetByEmail() {
		Contatos contato = new Contatos("3365-9856","98654-3246","lucas@gmail.com","98855-1456");
		dao.create(contato);
		
		List buscados = dao.buscarPorEmail("lucas@gmail.com");
		
		assertEquals(1, buscados.size());
	}
	
	@Test
	public void testEDeleteAll() {
		dao.deleteAll();
		assertFalse(dao.getAll().size() > 0);
	}

}
