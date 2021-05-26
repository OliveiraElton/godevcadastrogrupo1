package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe PrestadorServicoCompletoControllerApiTest. Testa o m�todos de busca.
 * 
 * @author Elton Oliveira
 *
 */
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class PrestadorServicoCompletoControllerApiTest {

	static Session session = DBConnection.getSession();
	static PrestadorServico prestador = new PrestadorServico();
	PrestadorServicoController controller = new PrestadorServicoController();
	static Empresa empresa;
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	static PrestadorServicoCompletoControllerApi prestadorApi;
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PrestadorServicoDAO.getInstance(DBConnection.getSession()).deleteAll();
		prestadorApi = new PrestadorServicoCompletoControllerApi();
		empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", null, null);
		daoEmpresa.create(empresa);
	}

	@Before
	public void limparBanco() {
		dao.deleteAll();
	}

	@Test
	public void testBuscarAPrestadorServicoPorId() throws Exception {
		PrestadorServicoController.criarPrestadorServico("Carlos", "Da Silva", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510, "Pr�dio", "89032640",
				"Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServicoController.criarPrestadorServico("Beatriz", "Fulana", "bia", LocalDate.now(), "Brasil",
				"S�o Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510, "Pr�dio", "89032640",
				"Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		PrestadorServicoCompletoDTO prestadorCompletoDTO = prestadorApi
				.buscarPrestadorServicoCompletoPorId(prestadorApi.buscarTodosPrestadorServicoCompleto().get(0).getId());
		assertEquals("256.103.800-90", prestadorCompletoDTO.getCpf());

	}

	@Test
	public void testFBuscarTodosPrestadorServico() throws Exception {
		PrestadorServicoController.criarPrestadorServico("Jurandir", "Da Massa", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, "", IdentidadeGenero.CIS, "256.103.800-90", "", LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510, "Pr�dio", "89032640",
				"Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		PrestadorServicoController.criarPrestadorServico("Daniela", "Fulana", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, "", IdentidadeGenero.TRANS, "256.103.800-90", "", LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510, "Pr�dio", "89032640",
				"Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = prestadorApi.buscarTodosPrestadorServicoCompleto();
		assertEquals(2, listaPrestadorCompletoDTO.size());
	}

	@Test
	public void testBBuscarPrestadorServicoPorNome() throws Exception {
		PrestadorServicoController.criarPrestadorServico("Junior", "Da Massa", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1, "1543652548",
				"1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510, "Pr�dio", "89032640",
				"Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		PrestadorServicoController.criarPrestadorServico("Professor Ricardo", "Fulana", "Jhon", LocalDate.now(),
				"Brasil", "S�o Paulo", true, null, null, "256.103.800-90", null, LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua s�o Paulo", 510, "Pr�dio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = prestadorApi
				.buscarPrestadorServicoCompletoPorNome("Professor Ricardo");
		assertEquals(1, listaPrestadorCompletoDTO.size());
	}

	@Test
	public void testCCriarPrestador() throws Exception {
		int quantidade = prestadorApi.buscarTodosPrestadorServicoCompleto().size();

		Endereco endereco = new Endereco("Rua cinco", 45, "Casa", "89665522", "Centro", "Brasil", "Itajai", "SC");

		PrestadorServico prestador = new PrestadorServico("Jonas", "Silva", "John", LocalDate.now(), "Brasileiro",
				"Itajai", true, "Masculino", IdentidadeGenero.CIS, endereco, "09532665411", "96655221", null, null,
				empresa, null);

		prestadorApi.criarPrestador(prestador);

		assertEquals(quantidade + 1, prestadorApi.buscarTodosPrestadorServicoCompleto().size());
	}

	@Test
	public void testDUpdate() {
		Endereco endereco = new Endereco("Rua cinco", 45, "Casa", "89665522", "Centro", "Brasil", "Itajai", "SC");

		PrestadorServico prestador = new PrestadorServico("Jorge", "Pereira", "Jorge", LocalDate.now(), "Brasileiro",
				"Itajai", true, "Masculino", IdentidadeGenero.CIS, endereco, "09532665411", "96655221", null, null,
				empresa, null);
		
		prestadorApi.criarPrestador(prestador);
		session.clear();
		
		PrestadorServico prestadorBuscado = PrestadorServicoController.buscarPrestadorServicoPorId(prestador.getId());
		prestadorBuscado.setGenero("Feminino");
		prestadorBuscado.setIdentidadeGenero(IdentidadeGenero.TRANS);
		prestadorApi.atualizarPrestador(prestadorBuscado);
		
		assertNotEquals(prestador.getGenero(), prestadorBuscado.getGenero());
		assertNotEquals(prestador.getIdentidadeGenero(), prestadorBuscado.getIdentidadeGenero());
	}
	
	@Test
	public void testEDelete() throws Exception {
		session.clear();
	
		Contatos contato = new Contatos("4798632145", "4789653214", "teste@gmail.com", "4789632156");
		Endereco endereco = new Endereco("Rua cinco", 45, "Casa", "89665522", "Centro", "Brasil", "Itajai", "SC");

		PrestadorServico prestador = new PrestadorServico("Jorge", "Pereira", "Jorge", LocalDate.of(2000, 1, 5), "Brasileiro",
				"Itajai", true, "Masculino", IdentidadeGenero.CIS, endereco, "09532665411", "96655221", contato, LocalDate.now(),
				empresa, 8);
		
		PrestadorServico prest = prestadorApi.criarPrestador(prestador);
		int quantidade = prestadorApi.buscarTodosPrestadorServicoCompleto().size();
		prestadorApi.deletePrestador(prest.getId());
		
		assertEquals(quantidade - 1, prestadorApi.buscarTodosPrestadorServicoCompleto().size());
	}

}