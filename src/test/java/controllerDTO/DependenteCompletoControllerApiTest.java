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
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;


/**
 * Classe DependenteDAOTest
 * 
 * Testes dos m�todos da classe {@link DependenteDAOT}.
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
	static DependenteCompletoControllerAPI  dependenteApi;
	
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
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		Dependente dependenteBanco = dependenteApi.cadastrarDependente(dependente);
		assertEquals(dependenteBanco, dao.readById(dependenteBanco.getId()));
		
	}
	
	@Test
	public void testDeletaDependente() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		Integer idBanco = dao.create(dependente).getId();
		dependenteApi.deletarDependente(idBanco);
		assertEquals(0, dao.getAll().size());
	}
	
	@Test
	public void testAtualizaDependente() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		Dependente dependenteNovo = dao.create(dependente);
		dependenteNovo.setNome("Nome alterado");
		dependenteApi.atualizarDependente(dependenteNovo);
		assertEquals("Nome alterado", dao.readById(dependenteNovo.getId()).getNome());
	}
	
	@Test
	public void testBuscarDependentePorId() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		DependenteCompletoDTO dependenteCompletoDTO = new DependenteCompletoDTO(dependente);
		assertEquals(dependenteCompletoDTO.getId(), dependenteApi.buscarDependentePorId(dependenteCompletoDTO.getId()).getId());
	}
	
	@Test
	public void testBuscarTodosDependente() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610", "123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		Endereco endereco2 = new Endereco("Rua 15", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente2 = new Dependente("Marta", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", IdentidadeGenero.CIS, endereco2, "09619039610", "123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente2);
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarTodosDependentes();
		assertEquals(2, listaDependenteCompletoDTO.size());
	}
	
	@Test
	public void testBuscarDependentePorNome() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Carolina", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610", "123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		Dependente dependente2 = new Dependente("Carolina", "Fonseca", "Nada consta", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610", "123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente2);
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarDependentePorNome("Carolina");
		assertEquals(2 ,listaDependenteCompletoDTO.size());
	}
	@Test
	public void testBuscarDependentePorIdColaborador() throws Exception {
		
		IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
		LocalDate data = LocalDate.of(2002, 01, 28);
		TiposExames te = EnumExamesMedicos.TiposExames.ADMISSIONAL;
		TiposDependentes td = EnumDadosPessoais.TiposDependentes.CONJUGE;
		Colaborador colaborador1 = ColaboradorController.cadastrarColaborador("Joana", "Marla", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00",
				"055", "438614625", "154", "joãozinho", "Santos", "Erika", data, "Venezuelano", "Blumenauense", true,
				"Feminino", ig, "09619039610", "mg14388606", td, true);
	
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarDependentePorIdColaborador(colaborador1.getId());
		assertEquals("Feminino" ,listaDependenteCompletoDTO.get(0).getGenero());
	}
}
