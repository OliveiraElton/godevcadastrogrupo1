package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
/**
 * Classe EmpresaDAOTest.
 * 
 * Testa os métodos da classe {@link EmpresaDAO}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaDAOTest {

	Session session = DBConnection.getSession();
	EmpresaDAO dao = EmpresaDAO.getInstance(session);

	@Test
	public void testReadById() {
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
	public void testGetAll() {
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
	public void testCreate() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("4799944899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "00360305000104", endereco, contatos);
		Empresa empresaCriada = dao.create(empresa);
		assertEquals("Senior", empresaCriada.getNomeEmpresa());
	}

	@Test
	public void testDelete() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		dao.create(empresa);
		dao.delete(empresa);
		assertNull(dao.readById(empresa.getId()));
	}

	@Test
	public void testUpdate() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		dao.create(empresa);
		empresa.setNomeEmpresa("Senior 2");
		assertEquals("Senior 2", dao.update(empresa).getNomeEmpresa());
	}

	@Test
	public void testDeleteAll() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		dao.create(empresa);
		dao.deleteAll();
		assertTrue(dao.getAll().isEmpty());
	}
	
	@Test
	public void testBuscarPorNome() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Proway", LocalDate.of(2021, 04, 15), "00.360.305/0001-04", endereco, contatos);
		dao.create(empresa);
		ArrayList<Empresa> listaRetorno = (ArrayList<Empresa>) dao.buscarPorNome("Pro");
		System.out.println(listaRetorno.get(0).getNomeEmpresa());
		assertTrue(listaRetorno.size() == 1);		
	}

	@Before
	public void limparTabelas() {
		dao.deleteAll();
	}
}
