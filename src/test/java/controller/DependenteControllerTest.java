package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import dao.DependenteDAO;
import model.Dependente;
import model.Endereco;
import persistence.DBConnection;

public class DependenteControllerTest {
	
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Session session = DBConnection.getSession();
	static DependenteDAO dao = DependenteDAO.getInstance(session);
	
	@Test
	public void testCriarDependente() {
		Dependente d = DependenteController.criarDependente("Joãozinho", "moro", 
				"Jenifer", data, "Venezuelano",
				"del rio", true, "Masculino", null, "", "25415365", null, true,
				"João@gmail.com", null, null, 
				null, null, "54868452", null, null,
				null, null, "4521546583", "48524869754",
				"João@gmail.com", "5412457845");
		assertNotNull(d);
		assertEquals(d, dao.readById(d.getId()));
	}

	@Test
	public void testDeleteDependente() {
		int quantidadeAnterior = dao.getAll().size();
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		assertEquals(true, dao.delete(dependente));
		assertEquals(quantidadeAnterior, dao.getAll().size());
		// TODO ARRUMAR DELETE DEPENDENTE
	}
	

	@Test
	public void testAtualizarDependente() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		Integer id = dependente.getId();
		session.clear();
		DependenteController.atualizarDependente(id, "Jorge", "Fonseca", "Jenifer",
				data, "Brazil", "brasil", true, "masculino",
				null, "09619039610", null, null,
				true, "jorge@", null, endereco);
		List<Dependente> dependentes = dao.getAll();
		assertEquals("Jorge", dependentes.get(dependentes.size() -1).getNome());
		
	}

	@Test
	public void testBuscarDependentePorId() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		assertEquals(dependente, DependenteController.buscarDependentePorId(dependente.getId()));
	}

	@Ignore
	public void testBuscarDependentePorIdColaborador() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		// TODO Implementar teste buscar lista de dependentes do colaborador
	}

}
