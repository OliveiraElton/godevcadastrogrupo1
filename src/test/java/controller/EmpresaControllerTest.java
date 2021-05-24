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
	static Contatos contatos = new Contatos("478889996655", "47985556633", "empresa@gmail.com", "47987456321");
	static Endereco endereco = new Endereco("Rua Principal", 15, "Nada consta", "Centro", "89789456", "Brasil",
			"Blumenau", "SC");
	static Empresa empresa = new Empresa("Senior", LocalDate.now(), "12345678", null, null);

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.deleteAll();
		
	}
	
	@Test
	public void testACriarEmpresa() {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Cooper", LocalDate.of(2019, 12, 31), "78456963000115",
				"4798888556633", "47888997852", "atendimento@cooper.com", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Escola Agr�cola", "Brasil", "Blumenau", "SC");
		
		assertEquals("Cooper", empresaCriada.getNomeEmpresa());
		assertEquals("78456963000115", empresaCriada.getCnpj());
		assertEquals("Escola Agr�cola", empresaCriada.getEndereco().getBairro());
	}

	@Test
	public void testEDeleteEmpresa() {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Viacred", LocalDate.of(218, 12, 31), "78456963000115",
				"4798888556633", "47888997852", "atendimento@cooper.com", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Centro", "Brasil", "Blumenau", "SC");
		
		EmpresaController.deleteEmpresa(empresaCriada);
		assertNull(EmpresaController.buscarEmpresaPorId(empresaCriada.getId()));
	}

	@Test
	public void testDAtualizarEmpresa() {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Caixa", LocalDate.of(2019, 12, 31), "78456963000115",
				"4798888556633", "47888997852", "atendimento@caixa.com", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Escola Agr�cola", "Brasil", "Blumenau", "SC");
		
		session.clear();
		
		Empresa empresaAlterada = EmpresaController.atualizarEmpresa(empresaCriada.getId(), "Caixa Econ�mica",
				LocalDate.of(2021, 03, 31), "89456789000123", contatos, endereco);
		
		assertEquals(empresaCriada.getId(), empresaAlterada.getId());
		assertNotEquals("Caixa", empresaAlterada.getNomeEmpresa());
		assertEquals("Caixa Econ�mica", empresaAlterada.getNomeEmpresa());

	}

	@Test
	public void testBBuscarEmpresaPorId() {
		Empresa empresaCriada = EmpresaController.criarEmpresa("Selecionar", LocalDate.of(2019, 12, 31),
				"78456963000115", "4798888556633", "47888997852", "atendimento@selecionar.com", "4788896655", "Rua XV",
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
	public void testFBuscarTodasEmpresas() {
		Empresa empresaCriada1 = EmpresaController.criarEmpresa("Hering", LocalDate.of(2019, 12, 31), "45123987000123",
				"4798888556633", "47888997852", "atendimento@hering.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Bom Retiro", "Brasil", "Blumenau", "SC");
		
		Empresa empresaCriada2 = EmpresaController.criarEmpresa("Marisa", LocalDate.of(2018, 12, 31), "78963258000178",
				"4798888556633", "47888997852", "atendimento@marisa.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �",
				"89036789", "Bom Retiro", "Brasil", "Blumenau", "SC");
		
		List<Empresa> listaEmpresas = EmpresaController.buscarTodasEmpresas();
		
		assertEquals(7, listaEmpresas.size());
	}

	@Test
	public void testCBuscarEmpresaPorNome() {
		EmpresaController.criarEmpresa("Magalu Rua XV", LocalDate.of(2019, 12, 31), "45123987000123", "4798888556633",
				"47888997852", "atendimento@magalu.com.br", "4788896655", "Rua XV", 78, "Pr�ximo �", "89036789",
				"Bom Retiro", "Brasil", "Blumenau", "SC");
		
		EmpresaController.criarEmpresa("Magalu Centro", LocalDate.of(2018, 12, 31), "78963258000178", "4798888556633",
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
