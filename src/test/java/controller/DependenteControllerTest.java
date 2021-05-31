package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.Escolaridade;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.EstadoCivil;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

/**
 * Classe DependenteControllerTest
 * 
 * Testes dos metodos da classe {@link DependenteController}.
 * 
 * @author Sprint 5
 * @author Vitor Cesar Peres <b>vitor.peres@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class DependenteControllerTest {

	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Session session = BDConexao.getSessao();
	static DependenteDAO dao = DependenteDAO.getInstance(session);
	static ColaboradorDAO daoColab = ColaboradorDAO.getInstance(session);
	static DependenteController controller = new DependenteController();

	@Before
	public void limparTabela() {
		DependenteController.deletarTodosRegistros();
	}

	@Test
	public void testCriarDependente() {
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", data, "Brasileira", true,
				"Masculino", IdentidadeGenero.TRANS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.FILHO, true);
		assertNotNull(dependente);
		assertEquals(dependente, controller.buscarDependentePorId(dependente.getId()));
	}

	@Test
	public void testDeleteDependente() {
		Endereco endereco = new Endereco("Rua 1", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", false, "Masculino",
				IdentidadeGenero.TRANS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);

		dao.cadastrar(dependente);
		int quantidadeAnterior = controller.buscarTodosDependentes().size();
		session.clear();
		DependenteController.deletarDependente(dependente);
		assertEquals(quantidadeAnterior - 1, controller.buscarTodosDependentes().size());
	}

	@Test
	public void testAtualizarDependente() {
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", data, "Brasileiro", true,
				"Masculino", IdentidadeGenero.TRANS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.cadastrar(dependente);
		session.clear();
		DependenteController.atualizarDependente(dependente.getId(), "Bruno", "Souza", data, "Brasileira", true,
				"Masculino", IdentidadeGenero.CIS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.CONJUGE, true);
		List<Dependente> dependentes = controller.buscarTodosDependentes();
		assertEquals("Bruno", dependentes.get(dependentes.size() - 1).getNome());
	}

	@Test
	public void testBuscarDependentePorId() {
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", true, "Masculino",
				IdentidadeGenero.CIS, "09619039610", EnumDadosPessoais.TiposDependentes.CONJUGE, true);
		dao.cadastrar(dependente);
		assertEquals(dependente, DependenteController.buscarDependentePorId(dependente.getId()));
	}

	@Test
	public void testBuscarDependentePorIdColaborador() throws Exception {
		Endereco endereco = new Endereco("Rua 1", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Carla", "Fonseca", data, "Venezuelano", true, "Feminino",
				IdentidadeGenero.CIS, "09619039610", EnumDadosPessoais.TiposDependentes.CONJUGE, true);

		Conta conta = new Conta("Caixa", "0505", "0808080", "0");
		String email = "teste@gmail.com";

		Contatos contatos = new Contatos("47984556633", "4789568948", email, "4798989898");
		ExameMedico exameMedico = new ExameMedico(TiposExames.PERIODICO, LocalDate.now(), true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "Nada consta", data, "Brasileiro", "Blumenau",
				false, "Masculino", IdentidadeGenero.CIS, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL,
				"Carla Nunes", "Joao Nunes", endereco, "21164028324", "45124563", contatos, 54545, 454545454, false,
				false, data, false, "", "carla@empresa.com.br", "554555", conta, exameMedico, dependente);
		daoColab.cadastrar(colaborador);
		dao.cadastrar(dependente);
		Integer idColaborador = colaborador.getId();
		assertEquals(1, controller.buscarDependentePorIdColaborador(idColaborador).size());
	}

	@Test
	public void testBuscarTodosDependentes() {
		Dependente dependente = DependenteController.cadastrarDependente("Jessia", "Martins", data, "Brasileiro", true,
				"Feminino", IdentidadeGenero.CIS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.FILHO, true);
		assertEquals(1, DependenteController.buscarTodosDependentes().size());
	}

	@Test
	public void testBuscarTodosDependentesPorNome() {
		Dependente dependente1 = DependenteController.cadastrarDependente("Jorge", "Martins", data, "Brasileira", true,
				"Masculino", IdentidadeGenero.CIS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.FILHO, true);

		Dependente dependente2 = DependenteController.cadastrarDependente("Carlos", "Martins", data, "Brasileira", true,
				"Masculino", IdentidadeGenero.CIS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.FILHO, true);

		Dependente dependente3 = DependenteController.cadastrarDependente("Carlos", "Martins", data, "Brasileira", true,
				"Masculino", IdentidadeGenero.CIS, "256.103.800-90", EnumDadosPessoais.TiposDependentes.FILHO, true);

		assertEquals(2, DependenteController.buscarDependentePorNome(dependente2.getNome()).size());
	}

}
