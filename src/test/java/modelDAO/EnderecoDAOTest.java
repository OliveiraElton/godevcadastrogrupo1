package modelDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

public class EnderecoDAOTest {

	Session session = BDConexao.getSessao();
	EnderecoDAO dao = EnderecoDAO.getInstance(session);
	ColaboradorDAO daoColaborador = ColaboradorDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Contatos contatos;
	static IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
	Conta conta = new Conta("Caixa", "105", "2569874", "15");
	static TiposExames em = EnumExamesMedicos.TiposExames.ADMISSIONAL;
	ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
	Endereco endereco = new Endereco("Rua XV de Novembro", 154, "Casa", "89065544", "Centro", "Brasil", "Blumenau",
			"SC");
	Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano", "Cidade del Leste",
			true, null, null, endereco, "09619039610", null, null, true);

	
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
		Endereco endereco = new Endereco("Rua 7 de Setembro", 45, "", "8974335", "Centro", "Brasil", "Blumenau", "SC");
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
	
	@Test
	public void testBuscarEnderecoPorIdColaborador() {
		Endereco endereco = new Endereco("Rua 7 de Setembro", 45, "", "8974335", "Centro", "Brasil", "Blumenau", "SC");
		
		Colaborador colaborador = new Colaborador("Carla", "Nunes", "Nada consta", data, "Americana", "Los Angeles",
				false, "Feminino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data,
				false, null, "maria.nunes@gmail.com", "554555", conta, exameMedico, dependente);
		
		Endereco enderecoCadastrado = dao.cadastrar(endereco);
		Endereco colaboradorCadastrado = dao.buscarPorId(Endereco.class, enderecoCadastrado.getId());
		assertEquals(enderecoCadastrado.getId(), colaboradorCadastrado.getId());
		assertNotNull(enderecoCadastrado);
		assertNotNull(colaboradorCadastrado);
		//assertNull(enderecoCadastrado);
	}
	
	@Before
	public void limparTabelas() {
		dao.deletarTodos("endereco");
	}
	
}
