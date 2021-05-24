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
	public void testBReadById() throws Exception {
		Contatos contato = new Contatos("4735222215","4798484962","amaral@gmail.com","4799991111");
		dao.create(contato);
		
		Contatos contatoBuscado = dao.readById(contato.getId());
		
		assertEquals(contato.getEmail(), contatoBuscado.getEmail());
		assertEquals(contato.getTelefoneFamiliar(), contatoBuscado.getTelefoneFamiliar());
		assertEquals(contato.getTelefoneSecundario(), contatoBuscado.getTelefoneSecundario());
		assertEquals(contato.getTelefonePrincipal(), contatoBuscado.getTelefonePrincipal());
		
	}

	@Test
	public void testCGetAll() throws Exception {
		Contatos contato = new Contatos("4735222215","4798484962","joao@gmail.com","4799991111");
		Contatos contato2 = new Contatos("4735339999","4712345678","amanda@gmail.com","4711119999");
		Contatos contato3 = new Contatos("4735339999","4712345678","pedro@gmail.com","4711119999");
		
		Integer valorAntes = dao.getAll().size();
		dao.create(contato);
		dao.create(contato2);
		dao.create(contato3);
		assertEquals(valorAntes + 3, dao.getAll().size());
	}
	
	@Test
	public void testDGetByEmail() throws Exception {
		Contatos contato = new Contatos();
		contato.setEmail("lucas@gmail.com");
		contato.setTelefonePrincipal("47988657898");
		contato.setTelefoneFamiliar("4733277896");
		contato.setTelefoneSecundario("47988996633");
		dao.create(contato);
		
		List buscados = dao.buscarPorEmail("lucas@gmail.com");
		
		assertEquals(1, buscados.size());
	}
	
	@Test (expected = Exception.class)
	public void testEDadosIncorretos() throws Exception {
		Contatos contato = new Contatos();
		contato.setTelefonePrincipal("5504798845123"); // 13 numeros
		contato.setTelefoneSecundario("5504798632154789"); //16
		contato.setTelefoneFamiliar("55047332756598463");
		
	}
	
	@Test (expected = Exception.class)
	public void testFEmailIncorreto() throws Exception {
		Contatos contato = new Contatos("4735222215","4798484962","joao@gmailcom","4799991111");
	}
	
	@Test
	public void testFDeleteAll() {
		dao.deleteAll();
		assertFalse(dao.getAll().size() > 0);
	}

}
