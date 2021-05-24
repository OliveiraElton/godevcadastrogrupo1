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
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

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
	static Session session = DBConnection.getSession();
	static DependenteDAO dao = DependenteDAO.getInstance(session);
	static ColaboradorDAO daoColab = ColaboradorDAO.getInstance(session);

	@Before
	public void limparTabela() {
		DependenteController.deleteAll();
	}

	@Test
	public void testCriarDependente() {
		Dependente dependente = DependenteController.criarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		assertNotNull(dependente);
		assertEquals(dependente, dao.readById(dependente.getId()));
	}

	@Test
	public void testDeleteDependente() {
		Endereco endereco = new Endereco("Rua 1", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano", "Cidade del Leste",
				false, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610", "",
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		int quantidadeAnterior = dao.getAll().size();
		session.clear();
		DependenteController.deleteDependente(dependente);
		assertEquals(quantidadeAnterior - 1, dao.getAll().size());
	}

	@Test
	public void testAtualizarDependente() {
		Dependente dependente = DependenteController.criarDependente("Jorge", "Martins", "Jessica", data, "Brasileiro",
				"Cascavel", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.create(dependente);
		session.clear();
		DependenteController.atualizarDependente(dependente.getId(), "Bruno", "Souza", "Nada consta", data, "Brasileira",
				"Brusque", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.CONJUGE, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		List<Dependente> dependentes = dao.getAll();
		assertEquals("Bruno", dependentes.get(dependentes.size() - 1).getNome());
	}

	@Test
	public void testBuscarDependentePorId() {
		Endereco endereco = new Endereco("Rua 1", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Nada consta", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.CIS, endereco, "09619039610", "480808408",
				EnumDadosPessoais.TiposDependentes.CONJUGE, true);
		dao.create(dependente);
		assertEquals(dependente, DependenteController.buscarDependentePorId(dependente.getId()));
	}

	@Test
	public void testBuscarDependentePorIdColaborador() throws Exception {
		Endereco endereco = new Endereco("Rua 1", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Carla", "Fonseca", "Carla", data, "Venezuelano", "Cidade del Leste",
				true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610", "480808408",
				EnumDadosPessoais.TiposDependentes.CONJUGE, true);
		Conta conta = new Conta("Caixa", "0505", "0808080", "0");
		String email = "teste@gmail.com";
		Contatos contatos = new Contatos("47984556633", "4789568948", email, "4798989898");
		ExameMedico exameMedico = new ExameMedico(TiposExames.PERIODICO, LocalDate.now(), true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "Nada consta", data, "Brasileiro", "Blumenau",
				false, "Masculino", null, endereco, "21164028324", "45124563", contatos, 54545, 454545454, false, false,
				data, false, "", "carla@empresa.com.br", "554555", conta, exameMedico, dependente);
		daoColab.create(colaborador);
		dao.create(dependente);
		Integer idColaborador = colaborador.getId();
		assertEquals(1, DependenteController.buscarDependentePorIdColaborador(idColaborador).size());
	}

	@Test
	public void testBuscarTodosDependentes() {
		Dependente dependente = DependenteController.criarDependente("Jessia", "Martins", "Jessica", data, "Brasileiro",
				"Camboriu", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		assertEquals(1, DependenteController.buscarTodosDependentes().size());
	}

	@Test
	public void testBuscarTodosDependentesPorNome() {
		Dependente dependente1 = DependenteController.criarDependente("Jorge", "Martins", "Nada consta", data, "Brasileira",
				"Camboriu", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		Dependente dependente2 = DependenteController.criarDependente("Carlos", "Martins", "Nada consta", data, "Brasileira",
				"Camboriu", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		Dependente dependente3 = DependenteController.criarDependente("Carlos", "Martins", "Nada consta", data, "Brasileira",
				"Camboriu", true, "Masculino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		assertEquals(2, DependenteController.buscarDependentePorNome(dependente2.getNome()).size());
	}

}
