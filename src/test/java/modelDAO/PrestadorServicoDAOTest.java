package modelDAO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;

public class PrestadorServicoDAOTest {

	static Session session;
	static PrestadorServicoDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		session = BDConexao.getSessao();
		dao = PrestadorServicoDAO.getInstance(session);
	}
	
	@BeforeClass
	public static void limparTabela() {
		dao.deletarTodos("prestadorservico");
		
	}

	@Test
	public void testReadById() throws Exception {
		Endereco endereco = new Endereco("Rua xv de Novembro", 154, "Casa", "89065544", "Centro", "Brasil", "Blumenau",
				"SC");
		Contatos contatos = new Contatos("47988554466", "47325698740", "adriana@gmail.com", "4798756430");

		Empresa empresa = EmpresaDAO.getInstance(BDConexao.getSessao()).consultarPorId(Empresa.class, 1);

		PrestadorServico prestadorServico = new PrestadorServico("Adriana", "Pereira", "pereira",
				LocalDate.of(1978, 3, 21), "Brasileira", "Itajai", false, "Feminino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		dao.cadastrar(prestadorServico);
		Integer id = prestadorServico.getId();
		assertEquals(prestadorServico, dao.consultarPorId(PrestadorServico.class, id));
	}

	@Test
	public void testGetAll() throws Exception {
		Endereco endereco = new Endereco("Rua xv de Novembro", 154, "Casa", "89065544", "Centro", "Brasil", "Blumenau",
				"SC");
		Contatos contatos = new Contatos("47988554466", "4732569874", "adriana@gmail.com", "4798756430");

		Empresa empresa = EmpresaDAO.getInstance(BDConexao.getSessao()).consultarPorId(Empresa.class, 1);

		PrestadorServico prestadorServico = new PrestadorServico("Adriana", "Pereira", "pereira",
				LocalDate.of(1978, 3, 21), "Brasileira", "Itajai", false, "Feminino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		PrestadorServico prestadorServico2 = new PrestadorServico("Joao", "Pereira", "Joao", LocalDate.of(1985, 5, 2),
				"Brasileira", "Itajai", false, "Masculino", IdentidadeGenero.CIS, endereco, "13125566", "1231256",
				contatos, LocalDate.now(), empresa, 4);
		Integer valorAntes = dao.consultarTodos(PrestadorServico.class).size();

		dao.cadastrar(prestadorServico);
		dao.cadastrar(prestadorServico2);
		assertEquals(valorAntes + 2, dao.consultarTodos(PrestadorServico.class).size());
	}

	@Test
	public void testCreate() throws Exception {
		Endereco endereco = new Endereco("Rua Itra", 3, "Casa", "96634455", "Escola Agricola", "Brasil", "Blumenau",
				"SC");
		Contatos contatos = new Contatos("4788552145", "4733256984", "Ricardo@gmail.com", "4798531150");

		Empresa empresa = EmpresaDAO.getInstance(BDConexao.getSessao()).consultarPorId(Empresa.class, 11);

		PrestadorServico prestadorServico = new PrestadorServico("Ricardo", "Junior", "juninho",
				LocalDate.of(1972, 4, 12), "Brasileiro", "Blumenau", false, "Masculino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		dao.cadastrar(prestadorServico);

		assertEquals("Ricardo", dao.consultarPorId(PrestadorServico.class, prestadorServico.getId()).getNome());

	}

	@Test
	public void testDelete() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "testDelete", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.cadastrar(prestadorServico);
		Integer valorAntes = dao.consultarTodos(PrestadorServico.class).size();
		dao.deletar(prestadorServico);
		assertEquals(valorAntes - 1, dao.consultarTodos(PrestadorServico.class).size());
	}

	@Test
	public void testUpdate() throws Exception {
		Contatos contatos = new Contatos("4788552145", "4733256984", "Ricardo@gmail.com", "4798531150");

		Empresa empresa = EmpresaDAO.getInstance(BDConexao.getSessao()).consultarPorId(Empresa.class, 11);
		Endereco endereco = new Endereco("Rua Casarao", 33, "Casa", "8975665", "Escola Agricola", "Brasil", "Blumenau",
				"SC");
		PrestadorServico prestadorServico = new PrestadorServico("Ricardo", "Junior", "juninho",
				LocalDate.of(1972, 4, 12), "Brasileiro", "Blumenau", false, "Masculino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		dao.cadastrar(prestadorServico);
		prestadorServico.setNome("Amarildo");
		prestadorServico.setCpf("85636478911");
		prestadorServico.setSobrenome("Gomes");
		prestadorServico.setNomeSocial("rildo");
		assertEquals("Amarildo", dao.atualizar(prestadorServico).getNome());
	}
}
