package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Empresa;
import persistence.DBConnection;

public class EmpresaDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	Session session = DBConnection.getSession();
	EmpresaDAO dao = EmpresaDAO.getInstance(session);

	@Test
	public void testReadById() {
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
		dao.create(empresa);
		Integer id = empresa.getId();
		assertEquals(empresa, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		Integer valorAntes = dao.getAll().size();
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
		Empresa empresa2 = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
		dao.create(empresa);
		dao.create(empresa2);
		assertEquals(valorAntes + 2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
		assertEquals(empresa, dao.create(empresa));
	}

	@Test
	public void testDelete() {
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
		dao.create(empresa);
		dao.delete(empresa);
		assertNull(dao.readById(empresa.getId()));
	}

	@Test
	public void testUpdate() {
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);
		dao.create(empresa);
		empresa.setNomeEmpresa("Senior 2");
		assertEquals("Senior 2", dao.update(empresa).getNomeEmpresa());

	}
}
