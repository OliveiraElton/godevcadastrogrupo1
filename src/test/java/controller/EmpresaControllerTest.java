package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import dao.EmpresaDAO;
import model.Contatos;
import model.Empresa;
import persistence.DBConnection;

public class EmpresaControllerTest {

	static Session session = DBConnection.getSession();
	static EmpresaDAO dao = EmpresaDAO.getInstance(session);
	static Contatos contatos = new Contatos(null, null, null, null);
	static Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);

	@Test
	public void testCriarEmpresa() {
		Empresa ps = EmpresaController.criarEmpresa("Senior", LocalDate.now(), "12345678", null, null, null, null, null,
				null, null, null, null, null, null, null);
		session.clear();
		Empresa empresa = dao.readById(ps.getId());
		assertNotNull(empresa);
	}

	@Test
	public void testDeleteEmpresa() {
		Empresa empresa = EmpresaController.criarEmpresa("Senior", LocalDate.now(), "12345678", null, null, null, null,
				null, null, null, null, null, null, null, null);
		session.clear();
		dao.create(empresa);
		EmpresaController.deleteEmpresa(empresa);
		assertNull(dao.readById(empresa.getId()));
	}

	@Test
	public void testAtualizarEmpresa() {

		Empresa empresa = EmpresaController.criarEmpresa("Senior", LocalDate.now(), "12345678", null, null, null, null,
				null, null, null, null, null, null, null, null);
		dao.create(empresa);
		Integer id = empresa.getId();
		EmpresaController.atualizarEmpresa(id, "teste5", null, null, null, null);
		assertEquals("teste5", dao.readById(id).getNomeEmpresa());

	}

	@Test
	public void testBuscarEmpresaPorId() {
		Empresa empresa = EmpresaController.criarEmpresa("Senior", LocalDate.now(), "12345678", null, null, null, null,
				null, null, null, null, null, null, null, null);
		session.clear();
		dao.create(empresa);
		assertEquals(empresa, EmpresaController.buscarEmpresaPorId(empresa.getId()));
	}

	@Test
	public void testBuscarTodasEmpresas() {
		Empresa empresa = EmpresaController.criarEmpresa("Senior", LocalDate.now(), "12345678", null, null, null, null,
				null, null, null, null, null, null, null, null);
		session.clear();
		dao.create(empresa);
		List<Empresa> empresa2 = EmpresaController.buscarTodasEmpresas();
		assertEquals("Senior", empresa2.get(empresa2.size() - 1).getNomeEmpresa());
	}

}
