package dao;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class ContatosDAOTest {

	Session session = DBConnection.getSession();
	ContatosDAO dao = ContatosDAO.getInstance(session);
	
//	@Before
//	public void limparContatos() {
//		if (!session.getTransaction().isActive())
//			session.beginTransaction();
//		session.createSQLQuery("DELETE FROM Contatos;").executeUpdate();
//		session.getTransaction().commit();
//	}

	
	@Test
	public void testReadById() {
		Contatos contato = new Contatos("3522-2215","98484962","pessoa@maravilhosa.com","9999-1111");
		dao.create(contato);
		Integer id = contato.getId();
		assertEquals(contato, dao.readById(id));
		
	}

	@Test
	public void testGetAll() {
		Contatos contato = new Contatos("3522-2215","9848-4962","pessoa@maravilhosa.com","9999-1111");
		Contatos contato2 = new Contatos("3533-9999","1234-5678","pessoa@idonea.com","1111-9999");
		Contatos contato3 = new Contatos("3533-9999","1234-5678","pessoa@impar.com","1111-9999");
		Integer valorAntes = dao.getAll().size();
		dao.create(contato);
		dao.create(contato2);
		dao.create(contato3);
		assertEquals(valorAntes + 3, dao.getAll().size());

	}

}
