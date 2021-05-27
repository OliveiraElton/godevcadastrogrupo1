package modelDAO;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContaDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

public class ContaDAOTest {
	
	static Session session = BDConexao.getSessao();
	static ContaDAO dao = ContaDAO.getInstance(session);
	
	@BeforeClass
	public static void limparTabela() {
		dao.deletarTodos();
		
	}
	
	@Test
	public void testConsultarPorId() {
		Conta conta = new Conta("Viacredi", "932", "125687", "7");
		dao.cadastrar(conta);
		Integer id = conta.getId();
		assertEquals(conta, dao.consultarPorId(id));
	}

	@Test
	public void testConsultarTodos() {
		Conta conta = new Conta("Caixa", "932", "55661", "13");
		Integer valorAntes = dao.consultarTodos().size();
		dao.cadastrar(conta);
		assertEquals(valorAntes + 1, dao.consultarTodos().size());
	}

	@Test
	public void testCadastrar() {
		Conta conta = new Conta("Banco do Brasil", "4125", "3366914", "3");
		int quantidade = dao.consultarTodos().size();
		dao.cadastrar(conta);
		assertEquals(quantidade + 1, dao.consultarTodos().size());
	}

	@Test
	public void testDeletar() {
		Conta conta = new Conta("15623", null, null, null);
		dao.cadastrar(conta);
		Integer valorAntes = dao.consultarTodos().size();
		dao.deletar(conta);
		assertEquals(valorAntes -1, dao.consultarTodos().size());
	}

	@Test
	public void testUpdate() {
		Conta conta = new Conta("Santander", "2222", "987635", "96");
		dao.cadastrar(conta);
		conta.setAgencia("9852");
		assertEquals("9852", dao.atualizar(conta).getAgencia());
	}
	
}
