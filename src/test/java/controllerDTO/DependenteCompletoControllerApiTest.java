package controllerDTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.controller.DTO.DependenteCompletoControllerAPI;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

/**
 * Classe DependenteDAOTest
 * 
 * Testes dos metodos da classe {@link DependenteDAOT}.
 *
 * @author Elton Oliveira
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class DependenteCompletoControllerApiTest {

	static LocalDate data;
	static Session session;
	static DependenteDAO dao;
	static ColaboradorDAO daoColab;
	static DependenteCompletoControllerAPI dependenteApi;

	@Before
	public void limparTabela() {
		DependenteController.deletarTodosRegistros();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		data = LocalDate.of(2002, 01, 28);
		session = BDConexao.getSessao();
		dao = DependenteDAO.getInstance(session);
		daoColab = ColaboradorDAO.getInstance(session);
		dependenteApi = new DependenteCompletoControllerAPI();
	}

	@Test
	public void testCriarDependente() {
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", true, "Masculino",
				IdentidadeGenero.TRANS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		Dependente dependenteBanco = dependenteApi.cadastrarDependente(dependente);
		assertEquals(dependenteBanco, dao.buscarPorId(Dependente.class, dependenteBanco.getId()));

	}

	@Test
	public void testDeletaDependente() {
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", true, "Masculino",
				IdentidadeGenero.TRANS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		Integer idBanco = dao.cadastrar(dependente).getId();
		dependenteApi.deletarDependente(idBanco);
		assertEquals(0, dao.buscarTodos(Dependente.class).size());
	}

	@Test
	public void testAtualizaDependente() {
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", true, "Masculino",
				IdentidadeGenero.TRANS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		Dependente dependenteNovo = dao.cadastrar(dependente);
		dependenteNovo.setNome("Nome alterado");
		dependenteApi.atualizarDependente(dependenteNovo);
		assertEquals("Nome alterado", dao.buscarPorId(Dependente.class, dependenteNovo.getId()).getNome());
	}

	@Test
	public void testBuscarDependentePorId() {
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", true, "Masculino",
				IdentidadeGenero.TRANS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.cadastrar(dependente);
		DependenteCompletoDTO dependenteCompletoDTO = new DependenteCompletoDTO(dependente);
		assertEquals(dependenteCompletoDTO.getId(),
				dependenteApi.buscarDependentePorId(dependenteCompletoDTO.getId()).getId());
	}

	@Test
	public void testBuscarTodosDependente() {
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano", true, "Feminino",
				IdentidadeGenero.CIS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.cadastrar(dependente);
		Dependente dependente2 = new Dependente("Marta", "Fonseca", data, "Venezuelano", true, "Feminino",
				IdentidadeGenero.CIS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.cadastrar(dependente2);
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarTodosDependentes();
		assertEquals(2, listaDependenteCompletoDTO.size());
	}

	@Test
	public void testBuscarDependentePorNome() {
		Dependente dependente = new Dependente("Carolina", "Fonseca", data, "Venezuelano", true, "Feminino",
				IdentidadeGenero.CIS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.cadastrar(dependente);
		Dependente dependente2 = new Dependente("Carolina", "Fonseca", data, "Venezuelano", true, "Feminino",
				IdentidadeGenero.CIS, "09619039610", EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.cadastrar(dependente2);
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarDependentePorNome("Carolina");
		assertEquals(2, listaDependenteCompletoDTO.size());
	}

	@Test
	public void testBuscarDependentePorIdColaborador() throws Exception {

		IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
		LocalDate data = LocalDate.of(2002, 01, 28);
		TiposExames te = EnumExamesMedicos.TiposExames.ADMISSIONAL;
		TiposDependentes td = EnumDadosPessoais.TiposDependentes.CONJUGE;
		Colaborador colaborador1 = ColaboradorController.cadastrarColaborador("Joana", "Marla", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false,
				false, data, false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547",
				"Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos", data,
				"Venezuelano", true, "Feminino", ig, "09619039610", td, true);

		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi
				.buscarDependentePorIdColaborador(colaborador1.getId());
		assertEquals("Feminino", listaDependenteCompletoDTO.get(0).getGenero());
	}
}
