package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
/**
 * Classe EmpresaDAOTest.
 * 
 * Testa os métodos da classe {@link EmpresaDAO}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 * @author Lucas Walim da Silva	 <b>lucas.walim@senior.com.br</b>
 *
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class EmpresaDAOTest {

	static Session session = DBConnection.getSession();
	static EmpresaDAO dao = EmpresaDAO.getInstance(session);
	

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		dao.deleteAll();
//		
//	}

	@Test
	public void testBReadById() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00360305000104", endereco, contatos);
		
		Empresa empresaCriada = dao.create(empresa);
		Empresa empresaRetornada = dao.readById(empresaCriada.getId());
		assertEquals(empresaCriada.getNomeEmpresa(), empresaRetornada.getNomeEmpresa());
		assertEquals(empresaCriada.getEndereco(), empresaRetornada.getEndereco());
		assertEquals(empresaCriada.getContato(), empresaRetornada.getContato());
		
	}

	@Test
	public void testFGetAll() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Integer valorAntes = dao.getAll().size();
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		Empresa empresa2 = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		
		Empresa empresaCriada1 = dao.create(empresa);
		System.out.println(empresaCriada1.getId());
		
		Empresa empresaCriada2 = dao.create(empresa2);
		assertEquals(valorAntes + 2, dao.getAll().size());

	}

	@Test
	public void testACreate() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("4799944899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "00360305000104", endereco, contatos);
		Empresa empresaCriada = dao.create(empresa);
		assertEquals("Senior", empresaCriada.getNomeEmpresa());
	}

	@Test
	public void testEDelete() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		
		dao.create(empresa);
		dao.delete(empresa);
		assertNull(dao.readById(empresa.getId()));
	}

	@Test
	public void testCUpdate() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		
		dao.create(empresa);
		empresa.setNomeEmpresa("Senior 2");
		assertEquals("Senior 2", dao.update(empresa).getNomeEmpresa());
	}

	@Test
	public void testGDeleteAll() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		dao.create(empresa);
	//	dao.deleteAll();
		assertTrue(dao.getAll().isEmpty());
	}
	
	@Test
	public void testDBuscarPorNome() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Proway", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		dao.create(empresa);
		
		ArrayList<Empresa> listaRetorno = (ArrayList<Empresa>) dao.buscarPorNome("Pro");
		System.out.println(listaRetorno.get(0).getNomeEmpresa());
		assertTrue(listaRetorno.size() == 1);		
	}
	
	@Test
	public void testConstrutor() {
		EmpresaDAO empresaDao = EmpresaDAO.getInstance(session);
		assertNotNull(empresaDao);
	}
}
