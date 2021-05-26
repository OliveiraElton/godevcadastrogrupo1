package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe PrestadorServicoControllerApiTest.
 * 
 * Testa os metodos da classe {@link PrestadorServicoControllerApi}.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class PrestadorServicoSimplificadoControllerApiTest {

	static Session session = DBConnection.getSession();
	static PrestadorServico prestador = new PrestadorServico();
	PrestadorServicoController controller = new PrestadorServicoController();
	static Empresa empresa;
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);
	static Endereco endereco;
	static Contatos contatos;
	static PrestadorServicoSimplificadoControllerApi prestadorApi;
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		endereco = new Endereco("Rua 10", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		contatos = new Contatos("47985415263", "47987526341", "joaopires@gmail.com", "47985632144");
		PrestadorServicoDAO.getInstance(DBConnection.getSession()).deleteAll();
		empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", endereco, contatos);
		prestadorApi = new PrestadorServicoSimplificadoControllerApi();
		daoEmpresa.create(empresa);
	}

	@Before
	public void limparBanco() {
		dao.deleteAll();
	}

	@Test
	public void testBuscarPrestadorServicoPorId() throws Exception {
		Endereco endereco2 = new Endereco("Rua 15", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47985236587", "47987526341", "joaopires@gmail.com", "47985632144");
		Empresa empresa2 = new Empresa("Proway", LocalDate.now(), "05.975.585/0001-89", endereco2, contatos2);
		PrestadorServicoController.criarPrestadorServico("Joao", "Massa", "Jhon", LocalDate.now(), "Brasil",
				"Sao Paulo", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "84454",
				LocalDate.of(2020, 01, 28), 1, "1543652548", "1543652548", "beatriz@gmail.com", "1543652548",
				"Rua Sao Paulo", 510, "Predio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		PrestadorServicoController.criarPrestadorServico("Joao", "Fulana", "Jhon",

				LocalDate.now(), "Brasil", "Sao Paulo", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90",
				"879898", LocalDate.of(2020, 01, 28), 1, "1543652548", "1543652548", "batriz@gmail.com", "1543652548",
				"Rua Sao Paulo", 510, "Predio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa2);

		PrestadorServicoDTO prestadorDTO = prestadorApi
				.buscarPrestadorServicoPorId(prestadorApi.buscarTodosPrestadorServico().get(0).getId());
		assertEquals("256.103.800-90", prestadorDTO.getCpf());

	}

	@Test
	public void testBuscarTodosPrestadorServico() throws Exception {
		Endereco endereco2 = new Endereco("Rua 15", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47985236587", "47987526341", "joaopires@gmail.com", "47985632144");
		Empresa empresa2 = new Empresa("Proway", LocalDate.now(), "05.975.585/0001-89", endereco2, contatos2);
		PrestadorServicoController.criarPrestadorServico("Joao", "Massa", "Jhon", LocalDate.now(), "Brasil",
				"Sao Paulo", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "547878",
				LocalDate.of(2020, 01, 28), 1, "1543652548", "1543652548", "batriz@gmail.com", "1543652548",
				"Rua Sao Paulo", 510, "Predio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		PrestadorServicoController.criarPrestadorServico("Joao", "Fulana", "Jhon", LocalDate.now(), "Brasil",
				"Sao Paulo", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "78744",
				LocalDate.of(2020, 01, 28), 1, "1543652548", "1543652548", "batriz@gmail.com", "1543652548",
				"Rua s�o Paulo", 510, "Predio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa2);

		List<PrestadorServicoDTO> listaPrestadorDTO = prestadorApi.buscarTodosPrestadorServico();
		assertEquals(2, listaPrestadorDTO.size());
	}

	@Test
	public void testBuscarPrestadorServicoPorNome() throws Exception {
		Endereco endereco2 = new Endereco("Rua 15", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47985236587", "47987526341", "joaopires@gmail.com", "47985632144");
		Empresa empresa2 = new Empresa("Proway", LocalDate.now(), "05.975.585/0001-89", endereco2, contatos2);
		PrestadorServicoController.criarPrestadorServico("Joao", "Massa", "Jhon", LocalDate.now(), "Brasil",
				"Sao Paulo", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "45544",
				LocalDate.of(2020, 01, 28), 1, "1543652548", "1543652548", "batriz@gmail.com", "1543652548",
				"Rua Sao Paulo", 510, "Predio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		PrestadorServicoController.criarPrestadorServico("Joao", "Souza", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "4445454",
				LocalDate.of(2020, 01, 28), 1, "1543652548", "1543652548", "batriz@gmail.com", "1543652548",
				"Rua s�o Paulo", 510, "Predio", "89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa2);

		List<PrestadorServicoDTO> listaPrestadorDTO = prestadorApi.buscarPrestadorServicoPorNome("Joao");
		assertEquals(2, listaPrestadorDTO.size());

	}

	@Test
	public void testCriarPrestador() throws Exception {
		Endereco endereco1 = new Endereco("Rua 15", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos1 = new Contatos("47985236587", "47987526341", "joaopires@gmail.com", "47985632144");
		PrestadorServico prestador = new PrestadorServico("Joao", "Pires", "Jhon", LocalDate.now(), "Brasil",
				"Sao Paulo", true, "Masculino", IdentidadeGenero.CIS, endereco1, "256.103.800-90", "1543652548",
				contatos1, LocalDate.of(2020, 01, 28), empresa, 12);
		PrestadorServico prestadorRetornado = prestadorApi.cadastrarPrestadorServico(prestador);
		assertEquals(prestador.getContatos(), prestadorRetornado.getDataDeNascimento());
		assertEquals(prestador.getSobrenome(), prestadorRetornado.getSobrenome());
		assertEquals(prestador.getIdentidadeGenero(), prestadorRetornado.getIdentidadeGenero());
	}

	@Test
	public void testDeletarPrestador() throws Exception {
		Endereco endereco2 = new Endereco("Rua 10", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47985415263", "47987526341", "joaopires@gmail.com", "47985632144");
		Empresa empresa2 = new Empresa("Proway", LocalDate.now(), "05.975.585/0001-89", endereco2, contatos2);
		PrestadorServico prestador = new PrestadorServico("Joao", "Pires", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, "Masculino", IdentidadeGenero.CIS, endereco2, "256.103.800-90", "1543652548",
				contatos2, LocalDate.of(2020, 01, 28), empresa2, 12);
		PrestadorServico prestadorRetornado = prestadorApi.cadastrarPrestadorServico(prestador);
		prestadorApi.deletePrestadorServico(prestadorRetornado.getId());
		assertTrue(prestadorApi.buscarTodosPrestadorServico().isEmpty());
	}

	@Test
	public void testAtualizarPrestador() throws Exception {
		Endereco endereco2 = new Endereco("Rua 10", 10, "", "89123582", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47985415263", "47987526341", "joaopires@gmail.com", "47985632144");
		PrestadorServico prestador = new PrestadorServico("Joao", "Pires", "Jhon", LocalDate.now(), "Brasil",
				"S�o Paulo", true, "Masculino", IdentidadeGenero.CIS, endereco2, "256.103.800-90", "1543652548",
				contatos2, LocalDate.of(2020, 01, 28), empresa, 12);
		PrestadorServico prestadorRetornado = prestadorApi.cadastrarPrestadorServico(prestador);
		prestadorRetornado.setNome("Carlos");
		prestadorRetornado.setGenero("Feminino");
		prestadorRetornado.setRg("878787");
		prestadorApi.atualizarPrestadorServico(prestadorRetornado);
		assertEquals("Carlos", prestadorRetornado.getNome());
		assertEquals("Feminino", prestadorRetornado.getGenero());
		assertEquals("878787", prestadorRetornado.getRg());
	}

}