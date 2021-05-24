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
	public void testBuscarDependentePorId() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		DependenteCompletoDTO dependenteCompletoDTO = new DependenteCompletoDTO(dependente);
		assertEquals(dependenteCompletoDTO.getId(), dependenteApi.buscarDependentePorId(dependenteCompletoDTO.getId()).getId());

	}
	
	@Test
	public void testBuscarTodosDependente() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		Dependente dependente2 = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente2);
		
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarTodosDependenteCompleto();
		assertEquals(2, listaDependenteCompletoDTO.size());
	}
	
	@Test
	public void testBuscarDependentePorNome() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Tutuzinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		Dependente dependente2 = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente2);
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarDependenteCompletoPorNome("Tutuzinho");
		assertEquals(1 ,listaDependenteCompletoDTO.size());
	}
}
