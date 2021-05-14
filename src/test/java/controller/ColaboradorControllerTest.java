package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import dao.ColaboradorDAO;
import enums.EMDadosPessoais;
import enums.EMDadosPessoais.IdentidadeGenero;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

public class ColaboradorControllerTest {
	static Session session = DBConnection.getSession();
	static ColaboradorDAO dao = ColaboradorDAO.getInstance(session);	
	static IdentidadeGenero ig = EMDadosPessoais.IdentidadeGenero.TRANS;
	static Conta conta = new Conta(null, null, null, null);
	static Endereco endereco = new Endereco(null, null, null, null, null, null, 
			null, null);
	static Contatos contatos = new Contatos(null, null, null, null);
	static ExameMedico exameMedico = new ExameMedico(null, null, false);
	static Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
			null, false, null, ig, endereco, null, null, contatos, null, null, 
			false, false, null, false, null, null, null, conta, exameMedico);
	
	@Test
	public void testCriarColaborador() {		
		Colaborador c = ColaboradorController.criarColaborador("Teste", null, null,
				null, null, null, false, null, null, null, null, null, null, false, 
				false, null, false, null, null, null, null, null, null, null, null, 
				null, null, null, null, null, null, null, null, null, false, 
				null, null, null, null);
		Colaborador colaborador = dao.readById(c.getId());
		assertNotNull(colaborador);
	}

	@Test
	public void testDeleteColabordor() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
			false, false, null, false, null, null, null, conta, exameMedico);
		dao.create(colaborador);
		ColaboradorController.deleteColabordor(colaborador);
		assertNull(dao.readById(colaborador.getId()));
	}

	@Test
	public void testAtualizarColaborador() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
			false, false, null, false, null, null, null, conta, exameMedico);
		dao.create(colaborador);
		Integer id = colaborador.getId();
		Colaborador c = ColaboradorController.atualizarColaborador(id, "João2", "sobrenome",
				null,
				null, null, null, false, null, ig, endereco, null, null, contatos, 
			    null, null, false, false, null, false, null, null, null, 
				conta, exameMedico);
		assertEquals("João2", c.getNome());
	}

	@Test
	public void testBuscarColaboradorPorId() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
			false, false, null, false, null, null, null, conta, exameMedico);
		dao.create(colaborador);
		assertEquals(colaborador , ColaboradorController.buscarColaboradorPorId(colaborador.getId()));
		
	}

//	@Ignore
//	public void testBuscarColaboradorPorNomeSobrenome() {
//		ColaboradorDAO cDao = new ColaboradorDAO();
//		cDao.create(colaborador);
//		colaborador.setNome("Joesley");
//		colaborador.setSobrenome("Batista");
//		assertEquals(colaborador,  ColaboradorController.buscarColaboradorPorNomeSobrenome("Joesley", "Batista"));
//	}

	@Test
	public void testBuscarTodosColaborador() {
		Colaborador colaborador = new Colaborador("getAll", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
			false, false, null, false, null, null, null, conta, exameMedico);
		dao.create(colaborador);
		List<Colaborador> colaboradores = ColaboradorController.buscarTodosColaborador(); 
		assertEquals("getAll", colaboradores.get(colaboradores.size() - 1).getNome());
	}

}
