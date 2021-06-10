package modelDAO;

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
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
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

	static Session session = BDConexao.getSessao();
	static EmpresaDAO dao = EmpresaDAO.getInstance(session);
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	//	dao.deletarTodos("empresa");
		
	}

	@Test
	public void testBBuscarPorID() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "05.975.585/0001-89", endereco, contatos);
		
		Empresa empresaCriada = dao.cadastrar(empresa);
		Empresa empresaRetornada = dao.buscarPorId(Empresa.class, empresaCriada.getId());
		assertEquals(empresaCriada.getNome(), empresaRetornada.getNome());
		assertEquals(empresaCriada.getEndereco(), empresaRetornada.getEndereco());
		assertEquals(empresaCriada.getContato(), empresaRetornada.getContato());
		
	}

	@Test
	public void testFBuscarTodasEmpresas() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Integer valorAntes = dao.buscarTodos(Empresa.class).size();
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "05.975.585/0001-89", endereco, contatos);
		Empresa empresa2 = new Empresa("Senior", LocalDate.of(2021, 04, 15), "05.975.585/0001-89", endereco, contatos);
		
		Empresa empresaCriada1 = dao.cadastrar(empresa);
		System.out.println(empresaCriada1.getId());
		
		Empresa empresaCriada2 = dao.cadastrar(empresa2);
		assertEquals(valorAntes + 2, dao.buscarTodos(Empresa.class).size());

	}

	@Test
	public void testACadastrarEmpresa() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("4799944899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", endereco, contatos);
		Empresa empresaCriada = dao.cadastrar(empresa);
		assertEquals("Senior", empresaCriada.getNome());
	}

	@Test
	public void testEDeletarEmpresa() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "05.975.585/0001-89", endereco, contatos);
		
		dao.cadastrar(empresa);
		dao.deletar(empresa);
		assertNull(dao.buscarPorId(Empresa.class, empresa.getId()));
	}

	@Test
	public void testCAtualizarEmpresa() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "80.680.093/0001-81", endereco, contatos);
		
		dao.cadastrar(empresa);
		empresa.setNomeEmpresa("Senior 2");
		assertEquals("Senior 2", dao.atualizar(empresa).getNome());
	}

	@Test
	public void testGDeletarTodasEmpresas() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa empresa = new Empresa("Senior", LocalDate.of(2021, 04, 15), "05.975.585/0001-89", endereco, contatos);
		dao.cadastrar(empresa);
		dao.deletarTodos("empresa");
		assertTrue(dao.buscarTodos(Empresa.class).isEmpty());
	}
	
	@Test
	public void testDBuscarEmpresaPorNome() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Proway", LocalDate.of(2021, 04, 15), "80.680.093/0001-81", endereco, contatos);
		dao.cadastrar(empresa);
		
		ArrayList<Empresa> listaRetorno = (ArrayList<Empresa>) dao.buscarPorNome(Empresa.class, "Pro");
		System.out.println(listaRetorno.get(0).getNome());
		assertTrue(listaRetorno.size() == 1);		
	}
	
	@Test(expected = Exception.class)
	public void testEmpresaComCnpjInvalido() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		
		Empresa empresa = new Empresa("Proway", LocalDate.of(2021, 04, 15), "05.975.585/0001-90", endereco, contatos);
		dao.cadastrar(empresa);
	}
	
	@Test
	public void testConstrutor() {
		EmpresaDAO empresaDao = EmpresaDAO.getInstance(session);
		assertNotNull(empresaDao);
	}
}
