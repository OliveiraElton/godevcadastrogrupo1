package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class PrestadorServicoControllerTest {

	static Session session = DBConnection.getSession();
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Empresa empresa;
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	@BeforeClass
	public static void limparTabela() {
		dao.deleteAll();
		daoEmpresa.create(empresa);
	}

	@Test
	public void testACriarPrestadorServico() throws Exception {
		empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", null, null);
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServico prestadorServico = dao.readById(ps.getId());
		assertNotNull(prestadorServico);
	}

	@Test
	public void testEDeletePrestadorServico() throws Exception {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 4,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServicoController.deletePrestadorServico(ps);
		assertNull(dao.readById(ps.getId()));
	}

	@Test
	public void testDAtualizarPrestadorServico() throws Exception {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		Integer id = ps.getId();
		PrestadorServico novoPS = PrestadorServicoController.atualizarPrestadorServico(id, "Dani", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 2,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.update(novoPS);
		assertEquals("Dani", dao.readById(id).getNome());

	}

	@Test
	public void testBBuscarPrestadorServicoPorId() throws Exception {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		assertEquals(ps, PrestadorServicoController.buscarPrestadorServicoPorId(ps.getId()));
	}

	@Test
	public void testFBuscarTodosPrestadorServico() throws Exception {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		List<PrestadorServico> prestadoresServico = PrestadorServicoController.buscarTodosPrestadorServico();
		assertEquals("Beatriz", prestadoresServico.get(prestadoresServico.size() - 1).getNome());
	}

	@Test
	public void testCBuscarTodosPrestadorServicoPorNome() throws Exception {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Carina", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServico ps2 = PrestadorServicoController.criarPrestadorServico("Carina", "Fulana", "Jhon", data,
				"Brasil", "São Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		List<PrestadorServico> prestadoresServico = PrestadorServicoController.buscarPrestadorServicoPorNome("Vampeta");
		assertEquals(2, prestadoresServico.size());
	}

	@Before
	public void limpar() {
		dao.deleteAll();
	}
}
