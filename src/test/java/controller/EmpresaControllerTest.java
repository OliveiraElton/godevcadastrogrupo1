package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.controller.EmpresaController;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Classe EmpresaControllerTest.
 * 
 * Testa os m�todos da classe {@link EmpresaController}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 *
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class EmpresaControllerTest {

	static Session session = DBConnection.getSession();
	static EmpresaDAO dao = EmpresaDAO.getInstance(session);
	static Contatos contatos;
	static Endereco endereco = new Endereco("Rua Principal", 15, "Nada consta", "Centro", "89789456", "Brasil",
			"Blumenau", "SC");
	static Empresa empresa;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", null, null);
		contatos = new Contatos("47888999665", "47985556633", "empresa@gmail.com", "47987456321");
		dao.deleteAll();
		
	}
	
	@Test
	public void testACriarEmpresa() throws Exception {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Cooper", LocalDate.of(2019, 12, 31), "05.975.585/0001-89",
				"47988885566", "47888997852", "atendimento@cooper.com", "4788896655", "Rua XV", 78, "Proximo a",
				"89036789", "Escola Agricola", "Brasil", "Blumenau", "SC");
		
		assertEquals("Cooper", empresaCriada.getNomeEmpresa());
		assertEquals("05.975.585/0001-89", empresaCriada.getCnpj());
		assertEquals("Escola Agricola", empresaCriada.getEndereco().getBairro());
	}

	@Test
	public void testEDeleteEmpresa() throws Exception {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Viacred", LocalDate.of(218, 12, 31), "05.975.585/0001-89",
				"47988885566", "47888997852", "atendimento@cooper.com", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Centro", "Brasil", "Blumenau", "SC");
		
		EmpresaController.deleteEmpresa(empresaCriada);
		assertNull(EmpresaController.buscarEmpresaPorId(empresaCriada.getId()));
	}

	@Test
	public void testDAtualizarEmpresa() throws Exception {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Caixa", LocalDate.of(2021, 12, 31), "05.975.585/0001-89",
				"47988885566", "47888997852", "atendimento@caixa.com", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Escola Agr�cola", "Brasil", "Blumenau", "SC");
		
		Empresa empresaAlterada = EmpresaController.atualizarEmpresa(empresaCriada.getId(), "Caixa Econ�mica",
				LocalDate.of(2021, 11, 29), "05.975.585/0001-89", contatos, endereco);
		
		assertEquals(empresaCriada.getId(), empresaAlterada.getId());
		assertNotEquals("Caixa", empresaAlterada.getNomeEmpresa());
		assertEquals("Caixa Econ�mica", empresaAlterada.getNomeEmpresa());

	}

	@Test
	public void testBBuscarEmpresaPorId() throws Exception {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Selecionar", LocalDate.of(2019, 12, 31),
				"05.975.585/0001-89", "47988885566", "47888997852", "atendimento@selecionar.com", "4788896655", "Rua XV",
				78, "Pr�ximo �", "89036789", "Victor Konder", "Brasil", "Blumenau", "SC");
		
		Empresa empresaRetornada = EmpresaController.buscarEmpresaPorId(empresaCriada.getId());
		
		assertEquals(empresaCriada.getId(), empresaRetornada.getId());
		assertEquals(empresaCriada.getCnpj(), empresaRetornada.getCnpj());
		assertEquals(empresaCriada.getContato(), empresaRetornada.getContato());
		assertEquals(empresaCriada.getDataInicioContrato(), empresaRetornada.getDataInicioContrato());
		assertEquals(empresaCriada.getEndereco(), empresaRetornada.getEndereco());
		assertEquals(empresaCriada.getNomeEmpresa(), empresaRetornada.getNomeEmpresa());
	}

	@Test
	public void testFBuscarTodasEmpresas() throws Exception {
		Empresa empresaCriada1 = EmpresaController.criarEmpresa("Hering", LocalDate.of(2019, 12, 31), "05.975.585/0001-89",
				"47988885566", "47888997852", "atendimento@hering.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Bom Retiro", "Brasil", "Blumenau", "SC");
		
		Empresa empresaCriada2 = EmpresaController.criarEmpresa("Marisa", LocalDate.of(2018, 12, 31), "05.975.585/0001-89",
				"47988885566", "47888997852", "atendimento@marisa.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Bom Retiro", "Brasil", "Blumenau", "SC");
		
		List<Empresa> listaEmpresas = EmpresaController.buscarTodasEmpresas();
		
		assertEquals(7, listaEmpresas.size());
	}

	@Test
	public void testCBuscarEmpresaPorNome() throws Exception {
		EmpresaController.criarEmpresa("Magalu Rua XV", LocalDate.of(2019, 12, 31), "05.975.585/0001-89", "47988885566",
				"47888997852", "atendimento@magalu.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �", "89036789",
				"Bom Retiro", "Brasil", "Blumenau", "SC");
		
		EmpresaController.criarEmpresa("Magalu Centro", LocalDate.of(2018, 12, 31), "05.975.585/0001-89", "47988885566",
				"47888997852", "atendimento@magalu.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �", "89036789",
				"Bom Retiro", "Brasil", "Blumenau", "SC");
		
		List<Empresa> listaEmpresas = EmpresaController.buscarEmpresaPorNome("Magalu");
		assertEquals(2, listaEmpresas.size());
	}
	
	@Test
	public void testConstrutor() {
		EmpresaController controller = new EmpresaController();
		assertNotNull(controller);
	}
}
