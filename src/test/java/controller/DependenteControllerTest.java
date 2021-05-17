package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import dao.ColaboradorDAO;
import dao.ColaboradorDAOTest;
import dao.DependenteDAO;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Dependente;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

public class DependenteControllerTest {
	
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Session session = DBConnection.getSession();
	static DependenteDAO dao = DependenteDAO.getInstance(session);
	static ColaboradorDAO daoColab = ColaboradorDAO.getInstance(session);
	
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
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		int quantidadeAnterior = dao.getAll().size();
		session.clear();
		DependenteController.deleteDependente(dependente);
		assertEquals(quantidadeAnterior - 1, dao.getAll().size());
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

	@Test
	public void testBuscarDependentePorIdColaborador() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		Conta conta = new Conta(null, null, null, null);
		String email = "teste@gmail.com";
		Contatos contatos = new Contatos(null, null, email, null);
		ExameMedico exameMedico = new ExameMedico(null, LocalDate.now(), true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", null, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		daoColab.create(colaborador);
		dao.create(dependente);
		Integer idColaborador = colaborador.getId();
		assertEquals(1, DependenteController.buscarDependentePorIdColaborador(idColaborador).size());
		
	}

}
