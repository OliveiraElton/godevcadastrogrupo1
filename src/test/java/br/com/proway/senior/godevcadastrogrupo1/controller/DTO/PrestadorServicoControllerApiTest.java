package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

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
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class PrestadorServicoControllerApiTest {
	
	static Session session = DBConnection.getSession();
	static PrestadorServico prestador = new PrestadorServico();
	PrestadorServicoController controller = new PrestadorServicoController();
	static Empresa empresa;
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);
	
	static PrestadorServicoSimplificadoControllerApi prestadorApi;
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PrestadorServicoDAO.getInstance(DBConnection.getSession()).deleteAll();
		empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", null, null);
		prestadorApi = new PrestadorServicoSimplificadoControllerApi();
		daoEmpresa.create(empresa);
	}
	
	@Before
	public void limparBanco() {
		dao.deleteAll();
	}

	@Test
	public void testBuscarPrestadorServicoPorId() throws Exception {

		PrestadorServicoController.criarPrestadorServico("Vampeta", "Da Massa", "Jhon",
				LocalDate.now(), "Brasil", "S�o Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510,
				"Pr�dio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		
		PrestadorServicoController.criarPrestadorServico("Vampeta", "Fulana", "Jhon",
				
				LocalDate.now(), "Brasil", "S�o Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510,
				"Pr�dio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		
		PrestadorServicoDTO prestadorDTO = prestadorApi.buscarPrestadorServicoPorId(prestadorApi.buscarTodosPrestadorServico().get(0).getId());
		assertEquals("256.103.800-90", prestadorDTO.getCpf());

	}

	@Test
	public void testBuscarTodosPrestadorServico() throws Exception {
		PrestadorServicoController.criarPrestadorServico("Vampeta", "Da Massa", "Jhon",
				LocalDate.now(), "Brasil", "S�o Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510,
				"Pr�dio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		
		PrestadorServicoController.criarPrestadorServico("Vampeta", "Fulana", "Jhon",
				LocalDate.now(), "Brasil", "S�o Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510,
				"Pr�dio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		
		List<PrestadorServicoDTO> listaPrestadorDTO = prestadorApi.buscarTodosPrestadorServico();
		assertEquals(2, listaPrestadorDTO.size());
	}
	
	@Test
	public void testBuscarPrestadorServicoPorNome() throws Exception {
    
		PrestadorServicoController.criarPrestadorServico("Vampeta", "Da Massa", "Jhon",
				LocalDate.now(), "Brasil", "S�o Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510,
				"Pr�dio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		
		PrestadorServicoController.criarPrestadorServico("Professor Ricardo", "Fulana", "Jhon",
				LocalDate.now(), "Brasil", "S�o Paulo", true, null,
				null, "256.103.800-90", null, 
				LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510,
				"Pr�dio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		
		List<PrestadorServicoDTO> listaPrestadorDTO = PrestadorServicoSimplificadoControllerApi.buscarPrestadorServicoPorNome("Professor Ricardo");
		assertEquals(1 ,listaPrestadorDTO.size());

	}

}