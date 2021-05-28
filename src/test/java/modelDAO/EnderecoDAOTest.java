package modelDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

public class EnderecoDAOTest {

	Session session = BDConexao.getSessao();
	EnderecoDAO dao = EnderecoDAO.getInstance(session);


	@Test
	public void testReadById() {
		Endereco endereco = new Endereco("Rua joao pessoa", 985, "lado esquerdo da rua", "8965123", 
				"Centro", "Brasil", "Blumenau", "SC");
		dao.cadastrar(endereco);
		assertEquals(endereco, dao.buscarPorId(Endereco.class, endereco.getId()));
	}

	@Test
	public void testGetAll() {
		Endereco endereco = new Endereco("Rua xv de Novembro", 1234, "", "8977445", "Centro", "Brasil", "Blumenau",
				"SC");
		Endereco endereco2 = new Endereco("Rua 7 de Setembro", 45, "", "8974335", "Centro", "Brasil", "Blumenau", "SC");
		Integer valorAntes = dao.buscarTodos(Endereco.class).size();
		dao.cadastrar(endereco);
		dao.cadastrar(endereco2);
		assertEquals(valorAntes + 2, dao.buscarTodos(Endereco.class).size());

	}


	@Test
	public void testCreate() throws Exception{
		Endereco endereco = new Endereco(); 
		endereco.setComplemento("Perto do posto de saude");
		endereco.setLogradouro("Rua 7");
		endereco.setNumero(2);
		endereco.setCep("8765512");
		endereco.setBairro("Itoupava Norte");
		endereco.setPais("Brasil");
		endereco.setCidade("Blumenau");
		endereco.setUf("SC");
		dao.cadastrar(endereco);
		
		assertEquals("Perto do posto de saude", endereco.getComplemento());
		assertEquals("Rua 7", endereco.getLogradouro());
		assertEquals(Integer.valueOf(2), endereco.getNumero());
		assertEquals("8765512", endereco.getCep());
		assertEquals("Itoupava Norte", endereco.getBairro());
		assertEquals("Brasil", endereco.getPais());
		assertEquals("Blumenau", endereco.getCidade());
		assertEquals("SC", endereco.getUf());

	}
	
	@Test
	public void testDelete() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.cadastrar(endereco);
		
		Integer valorAntes = dao.buscarTodos(Endereco.class).size();
		
		dao.deletar(endereco);
		assertEquals(valorAntes - 1, dao.buscarTodos(Endereco.class).size());
	}

	@Test
	public void testDeleteAll() {
		EnderecoDAO dao = EnderecoDAO.getInstance(session);
		dao.deletarTodos("endereco");
		assertFalse(dao.buscarTodos(Endereco.class).size() > 0);
	}
	
	@Before
	public void limparTabelas() {
		dao.deletarTodos("endereco");
	}
	
}
