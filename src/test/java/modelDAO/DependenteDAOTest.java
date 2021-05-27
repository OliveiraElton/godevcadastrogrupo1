package modelDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

/**
 * Classe DependenteDAOTest
 * 
 * Testes dos m�todos da classe {@link DependenteDAOT}.
 * 
 * @author Sprint 5
 * @author Vitor Cesar Peres <b>vitor.peres@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class DependenteDAOTest {

	Session session = BDConexao.getSessao();
	DependenteDAO dao = DependenteDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);

	@Before
	public void limparTabela() {
		dao.deletarTodos("dependente");
	}
	
	@Test
	public void testBuscarDependentePorId() {
		Dependente dependente = DependenteController.cadastrarDependente("Jessia", "Martins", "Jessica", data, "Brasileiro",
				"Camboriu", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.cadastrar(dependente);
		Integer id = dependente.getId();
		assertEquals(dependente, dao.consultarPorId(Dependente.class, id));
	}

	@Test
	public void testBuscarTodosDependentes() {
		int tamanhoAnterior = dao.consultarTodos(Dependente.class).size();
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		Dependente dependente2 = DependenteController.cadastrarDependente("Jessia", "Martins", "Jessica", data, "Brasileiro",
				"Camboriu", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.cadastrar(dependente);
		dao.cadastrar(dependente2);
		assertEquals(tamanhoAnterior + 2, dao.consultarTodos(Dependente.class).size());
	}

	@Test
	public void testCadastrarDependente() {
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		assertEquals(dependente, dao.cadastrar(dependente));
	}

	@Test
	public void testDeletarDependente() {
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.cadastrar(dependente);
		assertEquals(true, dao.deletar(dependente));
		assertNull(dao.consultarPorId(Dependente.class, dependente.getId()));
	}
	
	@Test
	public void testAtualizarDependente() {
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.cadastrar(dependente);
		dependente.setRg("012345678");
		assertEquals("012345678", dao.atualizar(dependente).getRg());

	}
	
	@Test
	public void testBuscarDependentePeloColab() throws Exception {
		Colaborador colaboradorCriado = ColaboradorController.cadastrarColaborador("Rodrigo", "Moraes", "Nada consta", data, "Brasileira", "Blumenau", true, 
				"Masculino", IdentidadeGenero.CIS, "09619039610", "mg14388606", 8, 8788881, false, false, data, false, "88080888708", "rodrigo@gmail.com", "04040505050", 
				"Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Florianopolis", "SC", "4521452015", "5421452103", "rodrigo@empresa.com.br", "1542413655", 
				TiposExames.ADMISSIONAL, LocalDate.of(2020, 10, 5), true, "Caixa", "055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", 
				true, "Feminino", IdentidadeGenero.CIS, "09619039610", "mg14388606", TiposDependentes.FILHO, true);
		Dependente dependente = DependenteController.cadastrarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606", EnumDadosPessoais.TiposDependentes.FILHO, true, 
				"Rua das Oliveiras", 32, "casa", "89032640", "Passo Manso", "Brasil", "Blumenau", "SC");
		dao.cadastrar(dependente);
		colaboradorCriado.addDependente(dependente);
		ArrayList<Dependente> listaDeps = (ArrayList<Dependente>) dao.buscarDependentesPorIdColaborador(colaboradorCriado.getId());
		assertEquals(1, listaDeps.size());

	}
}
