package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadoresServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;

public class PrestadorServicoControllerTest {

	static Session session = BDConexao.getSessao();
	static PrestadorServicoDAO dao = PrestadorServicoDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Empresa empresa;
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	@BeforeClass
	public static void limparTabela() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89010-911", "Centro", "Brasil",
				"Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		empresa = new Empresa("Senior", LocalDate.now(), "05.975.585/0001-89", endereco, contatos);
		dao.deletarTodos("prestadorservico");
		daoEmpresa.cadastrar(empresa);
	}

	@Test
	public void testACriarPrestadorServico() throws Exception {
		
		PrestadorServico ps = PrestadoresServicoController.cadastrarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "4545454", LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServico prestadorServico = dao.consultarPorId(PrestadorServico.class, ps.getId());
		assertNotNull(prestadorServico);
	}

	@Test
	public void testEDeletePrestadorServico() throws Exception {
		PrestadorServico ps = PrestadoresServicoController.cadastrarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "454454", LocalDate.of(2020, 01, 28), 4,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadoresServicoController.deletarPrestadorServico(ps);
		assertNull(dao.consultarPorId(PrestadorServico.class, ps.getId()));
	}

	@Test
	public void testDAtualizarPrestadorServico() throws Exception {
		PrestadorServico ps = PrestadoresServicoController.cadastrarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "454545", LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		Integer id = ps.getId();
		PrestadorServico novoPS = PrestadoresServicoController.atualizarPrestadorServico(id, "Dani", "Massa", "Jhon",
				data, "Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.TRANS, "256.103.800-90", "45454", LocalDate.of(2020, 01, 28), 2,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		dao.atualizar(novoPS);
		assertEquals("Dani", dao.consultarPorId(PrestadorServico.class, id).getNome());

	}

	@Test
	public void testBBuscarPrestadorServicoPorId() throws Exception {
		PrestadorServico ps = PrestadoresServicoController.cadastrarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "45545", LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServico prestadorRetornado = PrestadoresServicoController.buscarPrestadorServicoPorId(ps.getId());
		assertEquals(ps.getCpf(), prestadorRetornado.getCpf());
	}

	@Test
	public void testFBuscarTodosPrestadorServico() throws Exception {
		PrestadorServico ps = PrestadoresServicoController.cadastrarPrestadorServico("Beatriz", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "65454", LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		List<PrestadorServico> prestadoresServico = PrestadoresServicoController.buscarTodosPrestadoresServico();
		assertEquals("Beatriz", prestadoresServico.get(prestadoresServico.size() - 1).getNome());
	}

	@Test
	public void testCBuscarTodosPrestadorServicoPorNome() throws Exception {
		PrestadorServico ps = PrestadoresServicoController.cadastrarPrestadorServico("Carina", "Massa", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "565455", LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);
		PrestadorServico ps2 = PrestadoresServicoController.cadastrarPrestadorServico("Carina", "Fulana", "Jhon", data,
				"Brasil", "São Paulo", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "124545", LocalDate.of(2020, 01, 28), 1,
				"1543652548", "1543652548", "batriz@gmail.com", "1543652548", "Rua são Paulo", 510, "Prédio",
				"89032640", "Agua Verde", "Brasil", "Blumenau", "SP", empresa);

		List<PrestadorServico> prestadoresServico = PrestadoresServicoController.buscarPrestadorServicoPorNome("Carina");
		assertEquals(2, prestadoresServico.size());
	}

	@Before
	public void limpar() {
		dao.deletarTodos("prestadorservico");
	}
}
