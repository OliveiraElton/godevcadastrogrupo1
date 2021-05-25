package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;


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
	static DependenteCompletoControllerApi  dependenteApi;
	
	@Before
	public void limparTabela() {
		DependenteController.deleteAll();
	}
  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		data = LocalDate.of(2002, 01, 28);
		session = DBConnection.getSession();
		dao = DependenteDAO.getInstance(session);
		daoColab = ColaboradorDAO.getInstance(session);
		dependenteApi = new DependenteCompletoControllerApi();
	}

	@Test
	public void testCriarDependente() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		Dependente dependenteBanco = dependenteApi.criarDependente(dependente);
		assertEquals(dependenteBanco, dao.readById(dependenteBanco.getId()));
		
	}
	
	@Test
	public void testDeletaDependente() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		Integer idBanco = dao.create(dependente).getId();
		dependenteApi.deleteDependente(idBanco);
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
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarTodosDependenteCompleto();
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
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarDependenteCompletoPorNome("Carolina");
		assertEquals(2 ,listaDependenteCompletoDTO.size());
	}
}
