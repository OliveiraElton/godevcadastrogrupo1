package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.EmpresaDAO;
import dao.PrestadorServicoDAO;
import model.Empresa;
import model.PrestadorServico;
import persistence.DBConnection;

public class PrestadorServicoControllerTest {

	static Session session = DBConnection.getSession();
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);
	
	@BeforeClass
	public static void criarEmpresa() {
		daoEmpresa.create(empresa);
	}
	
	@Test
	public void testCriarPrestadorServico() {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), null, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510,
				"Prédio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.create(ps);
		PrestadorServico prestadorServico = dao.readById(ps.getId());
		assertNotNull(prestadorServico);
	}

	@Test
	public void testDeletePrestadorServico() {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), null, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510,
				"Prédio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.create(ps);
		PrestadorServicoController.deletePrestadorServico(ps);
		assertNull(dao.readById(ps.getId()));
	}

	@Test
	public void testAtualizarPrestadorServico() {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), null, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510,
				"Prédio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.create(ps);
		Integer id = ps.getId();
		PrestadorServico novoPS = PrestadorServicoController.atualizarPrestadorServico(id, "Dani", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null,
				null, "256.103.800-90", null, 
				null, null, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510,
				"Prédio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.update(novoPS);
		assertEquals("Dani", dao.readById(id).getNome());

	}

	@Test
	public void testBuscarPrestadorServicoPorId() {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), null, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510,
				"Prédio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.create(ps);
		assertEquals(ps,
				PrestadorServicoController.buscarPrestadorServicoPorId(ps.getId()));
	}

	@Test
	public void testBuscarTodosPrestadorServico() {
		PrestadorServico ps = PrestadorServicoController.criarPrestadorServico("Beatriz", "Da Massa", "Jhon",
				data, "Brasil", "São Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), null, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510,
				"Prédio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.create(ps);
		List<PrestadorServico> prestadoresServico = PrestadorServicoController.buscarTodosPrestadorServico(); 
		assertEquals("Beatriz", prestadoresServico.get(prestadoresServico.size() - 1).getNome());
	}

}
