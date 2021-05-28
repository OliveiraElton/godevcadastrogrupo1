package modelDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class ContatosDAOTest {

	Session session = BDConexao.getSessao();
	ContatosDAO dao = ContatosDAO.getInstance(session);
	
	@Test
	public void testBConsultarPorId() throws Exception {
		Contatos contato = new Contatos("4735222215","4798484962","amaral@gmail.com","4799991111");
		dao.cadastrar(contato);
		
		Integer id = contato.getId();
		Contatos contatoBuscado = dao.buscarPorId(Contatos.class, id);
		
		assertEquals(contato.getEmail(), contatoBuscado.getEmail());
		assertEquals(contato.getTelefoneFamiliar(), contatoBuscado.getTelefoneFamiliar());
		assertEquals(contato.getTelefoneSecundario(), contatoBuscado.getTelefoneSecundario());
		assertEquals(contato.getTelefonePrincipal(), contatoBuscado.getTelefonePrincipal());
		
	}

	@Test
	public void testCConsultarTodos() throws Exception {
		Contatos contato = new Contatos("4735222215","4798484962","joao@gmail.com","4799991111");
		Contatos contato2 = new Contatos("4735339999","4712345678","amanda@gmail.com","4711119999");
		Contatos contato3 = new Contatos("4735339999","4712345678","pedro@gmail.com","4711119999");
		
		Integer valorAntes = dao.buscarTodos(Contatos.class).size();
		dao.cadastrar(contato);
		dao.cadastrar(contato2);
		dao.cadastrar(contato3);
		assertEquals(valorAntes + 3, dao.buscarTodos(Contatos.class).size());
	}
	
	@Test
	public void testDConsultarPorEmail() throws Exception {
		Contatos contato = new Contatos();
		contato.setEmail("lucas@gmail.com");
		contato.setTelefonePrincipal("47988657898");
		contato.setTelefoneFamiliar("4733277896");
		contato.setTelefoneSecundario("47988996633");
		dao.cadastrar(contato);
		
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
	public void testFDeletarTodos() {
		dao.deletarTodos("contatos");
		assertFalse(dao.buscarTodos(Contatos.class).size() > 0);
	}

}
