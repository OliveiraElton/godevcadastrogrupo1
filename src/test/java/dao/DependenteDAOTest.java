package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe DependenteDAOTest
 * 
 * Testes dos métodos da classe {@link DependenteDAOT}.
 * 
 * @author Sprint 5
 * @author Vitor Cesar Peres <b>vitor.peres@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class DependenteDAOTest {

	Session session = DBConnection.getSession();
	DependenteDAO dao = DependenteDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);

	@Before
	public void limparTabela() {
		dao.deleteAll();
	}
	@Test
	public void testReadById() {
		Dependente dependente = DependenteController.criarDependente("Jessia", "Martins", "Jessica", data, "Brasileiro",
				"Camboriu", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.create(dependente);
		Integer id = dependente.getId();
		assertEquals(dependente, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		int tamanhoAnterior = dao.getAll().size();
		Dependente dependente = DependenteController.criarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		Dependente dependente2 = DependenteController.criarDependente("Jessia", "Martins", "Jessica", data, "Brasileiro",
				"Camboriu", true, "Feminino", IdentidadeGenero.CIS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.create(dependente);
		dao.create(dependente2);
		assertEquals(tamanhoAnterior + 2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		Dependente dependente = DependenteController.criarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		assertEquals(dependente, dao.create(dependente));
	}

	@Test
	public void testDelete() {
		Dependente dependente = DependenteController.criarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.create(dependente);
		assertEquals(true, dao.delete(dependente));
		assertNull(dao.readById(dependente.getId()));
	}
	
	@Test
	public void testUpdate() {
		Dependente dependente = DependenteController.criarDependente("Jorge", "Martins", "Jessica", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, "256.103.800-90", "mg14388606",
				EnumDadosPessoais.TiposDependentes.FILHO, true, "Rua das Oliveiras", 32, "casa", "89032640",
				"Passo Manso", "Brasil", "Blumenau", "SC");
		dao.create(dependente);
		dependente.setRg("012345678");
		assertEquals("012345678", dao.update(dependente).getRg());

	}

}
