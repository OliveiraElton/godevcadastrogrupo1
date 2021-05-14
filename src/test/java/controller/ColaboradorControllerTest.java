package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.ColaboradorDAO;
import enums.EMDadosPessoais;
import enums.EMDadosPessoais.IdentidadeGenero;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Dependente;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColaboradorControllerTest {
	static Session session = DBConnection.getSession();
	static ColaboradorDAO dao = ColaboradorDAO.getInstance(session);	
	static IdentidadeGenero ig = EMDadosPessoais.IdentidadeGenero.TRANS;
	
	@Test
	public void testCriarColaborador() {		
		Colaborador c = ColaboradorController.criarColaborador("Teste", null, null,
				null, null, null, false, null, null, null, null, null, null, false, 
				false, null, false, null, null, null, null, null, null, null, null, 
				null, null, null, null, null, null, null, null, null, false, 
				null, null, null, null, null, null, null, false);
		Colaborador colaborador = dao.readById(c.getId());
		assertNotNull(colaborador);
	}

	@Test
	public void testDeleteColabordor() {
		Conta conta = new Conta(null, null, null, null);
		Endereco endereco = new Endereco(null, null, null, null, null, null, 
				null, null);
		Contatos contatos = new Contatos(null, null, null, null);
		ExameMedico exameMedico = new ExameMedico(null, null, false);
		Dependente dependente = new Dependente("Joãozinho","Fonseca","Jenifer", 
				null,"Venezuelano","Cidade del Leste", true, null, null,
				endereco, null,  null, null, null, null, true);
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico, dependente);
		dao.create(colaborador);
		ColaboradorController.deleteColabordor(dao.readById(colaborador.getId()));
		assertNull(dao.readById(colaborador.getId()));
	}

	@Test
	public void testAtualizarColaborador() {
		Conta conta = new Conta(null, null, null, null);
		Endereco endereco = new Endereco(null, null, null, null, null, null, 
				null, null);
		Contatos contatos = new Contatos(null, null, null, null);
		ExameMedico exameMedico = new ExameMedico(null, null, false);
		Dependente dependente = new Dependente("Joãozinho","Fonseca","Jenifer", 
				null,"Venezuelano","Cidade del Leste", true, null, null,
				endereco, null,  null, null, null, null, true);
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico, dependente);
		dao.create(colaborador);
		session.clear();
		Integer id = colaborador.getId();
		Colaborador c = ColaboradorController.atualizarColaborador(id, "João2", "sobrenome",
				null,
				null, null, null, false, null, ig, endereco, null, null, contatos, 
			    null, null, false, false, null, false, null, null, null, 
				conta, exameMedico, dependente);
		assertEquals("João2", c.getNome());
	}

	@Test
	public void testBuscarColaboradorPorId() {
		Conta conta = new Conta(null, null, null, null);
		Endereco endereco = new Endereco(null, null, null, null, null, null, 
				null, null);
		Contatos contatos = new Contatos(null, null, null, null);
		ExameMedico exameMedico = new ExameMedico(null, null, false);
		Dependente dependente = new Dependente("Joãozinho","Fonseca","Jenifer", 
				null,"Venezuelano","Cidade del Leste", true, null, null,
				endereco, null,  null, null, null, null, true);
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico, dependente);
		dao.create(colaborador);
		assertEquals(colaborador , ColaboradorController.buscarColaboradorPorId(colaborador.getId()));
		
	}

	@Test
	public void testBuscarTodosColaborador() {
		Conta conta = new Conta(null, null, null, null);
		Endereco endereco = new Endereco(null, null, null, null, null, null, 
				null, null);
		Contatos contatos = new Contatos(null, null, null, null);
		ExameMedico exameMedico = new ExameMedico(null, null, false);
		Dependente dependente = new Dependente("Joãozinho","Fonseca","Jenifer", 
				null,"Venezuelano","Cidade del Leste", true, null, null,
				endereco, null,  null, null, null, null, true);
		Colaborador colaborador = new Colaborador("getAll", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico, dependente);
		dao.create(colaborador);
		List<Colaborador> colaboradores = ColaboradorController.buscarTodosColaborador(); 
		assertEquals("getAll", colaboradores.get(colaboradores.size() - 1).getNome());
	}

}
