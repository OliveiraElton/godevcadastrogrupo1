package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

public class PrestadorServicoDAOTest {

	static Session session;
	static PrestadorServicoDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		session = DBConnection.getSession();
		dao = PrestadorServicoDAO.getInstance(session);
	}
	@Before
	public void limparTabela() throws Exception{
		dao.limparTabela();
	}

	@Test
	public void testReadById() {
		Endereco endereco = new Endereco("Rua xv de Novembro", 154, "Casa", "89065544", "Centro", "Brasil", "Blumenau",
				"SC");
		Contatos contatos = new Contatos("47988554466", "4732569874", "adriana@gmail.com", "479875643");

		Empresa empresa = EmpresaDAO.getInstance(DBConnection.getSession()).readById(1);

		PrestadorServico prestadorServico = new PrestadorServico("Adriana", "Pereira", "pereira",
				LocalDate.of(1978, 3, 21), "Brasileira", "Itajai", false, "Feminino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		dao.create(prestadorServico);
		Integer id = prestadorServico.getId();
		assertEquals(prestadorServico, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Endereco endereco = new Endereco("Rua xv de Novembro", 154, "Casa", "89065544", "Centro", "Brasil", "Blumenau",
				"SC");
		Contatos contatos = new Contatos("47988554466", "4732569874", "adriana@gmail.com", "479875643");

		Empresa empresa = EmpresaDAO.getInstance(DBConnection.getSession()).readById(1);

		PrestadorServico prestadorServico = new PrestadorServico("Adriana", "Pereira", "pereira",
				LocalDate.of(1978, 3, 21), "Brasileira", "Itajai", false, "Feminino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		PrestadorServico prestadorServico2 = new PrestadorServico("Joao", "Pereira", "Joao", LocalDate.of(1985, 5, 2),
				"Brasileira", "Itajai", false, "Masculino", IdentidadeGenero.CIS, endereco, "13125566", "1231256",
				contatos, LocalDate.now(), empresa, 4);
		Integer valorAntes = dao.getAll().size();

		dao.create(prestadorServico);
		dao.create(prestadorServico2);
		assertEquals(valorAntes + 2, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		Endereco endereco = new Endereco("Rua Itra", 3, "Casa", "96634455", "Escola Agricola", "Brasil", "Blumenau",
				"SC");
		Contatos contatos = new Contatos("4788552145", "4733256984", "Ricardo@gmail.com", "479853115");

		Empresa empresa = EmpresaDAO.getInstance(DBConnection.getSession()).readById(11);

		PrestadorServico prestadorServico = new PrestadorServico("Ricardo", "Junior", "juninho",
				LocalDate.of(1972, 4, 12), "Brasileiro", "Blumenau", false, "Masculino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		dao.create(prestadorServico);

		assertEquals("Ricardo", dao.readById(prestadorServico.getId()).getNome());

	}

	@Test
	public void testDelete() {
		PrestadorServico prestadorServico = new PrestadorServico(null, null, null, LocalDate.now(), "testDelete", null,
				false, null, null, null, null, null, null, null, null, null);
		dao.create(prestadorServico);
		Integer valorAntes = dao.getAll().size();
		dao.delete(prestadorServico);
		assertEquals(valorAntes - 1, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		Contatos contatos = new Contatos("4788552145", "4733256984", "Ricardo@gmail.com", "479853115");

		Empresa empresa = EmpresaDAO.getInstance(DBConnection.getSession()).readById(11);
		Endereco endereco = new Endereco("Rua Casarao", 33, "Casa", "8975665", "Escola Agricola", "Brasil", "Blumenau",
				"SC");
		PrestadorServico prestadorServico = new PrestadorServico("Ricardo", "Junior", "juninho",
				LocalDate.of(1972, 4, 12), "Brasileiro", "Blumenau", false, "Masculino", IdentidadeGenero.CIS, endereco,
				"1234567891", "965412", contatos, LocalDate.now(), empresa, 8);

		dao.create(prestadorServico);
		prestadorServico.setNome("Amarildo");
		prestadorServico.setCpf("85636478911");
		prestadorServico.setSobrenome("Gomes");
		prestadorServico.setNomeSocial("rildo");
		assertEquals("Amarildo", dao.update(prestadorServico).getNome());
	}
}
