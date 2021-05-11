package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import dao.ColaboradorDAO;
import enums.EMDadosPessoais;
import enums.EMDadosPessoais.IdentidadeGenero;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Endereco;
import model.ExameMedico;

public class ColaboradorControllerTest {
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
		assertEquals("Teste", c.getNome());
	}

	@Test
	public void testDeleteColabordor() {
		ColaboradorDAO cDao = new ColaboradorDAO();
		cDao.create(colaborador);
		assertEquals(true, ColaboradorController.deleteColabordor(colaborador));
	}

	@Test
	public void testAtualizarColaborador() {
		ColaboradorDAO cDao = new ColaboradorDAO();
		cDao.create(colaborador);
		String nome = "João";
		assertEquals(1, (int) ColaboradorController.atualizarColaborador(0, nome, null, null,
				null, null, null, false, null, ig, endereco, null, null, contatos, 
			    null, null, false, false, null, false, null, null, null, 
				conta, exameMedico));
	}

	@Test
	public void testBuscarColaboradorPorId() {
		ColaboradorDAO cDao = new ColaboradorDAO();
		cDao.create(colaborador);
		assertEquals(colaborador , ColaboradorController.buscarColaboradorPorId(1));
		
	}

	@Test
	public void testBuscarColaboradorPorNomeSobrenome() {
		ColaboradorDAO cDao = new ColaboradorDAO();
		cDao.create(colaborador);
		colaborador.setNome("Joesley");
		colaborador.setSobrenome("Batista");
		assertEquals(colaborador,  ColaboradorController.buscarColaboradorPorNomeSobrenome("Joesley", "Batista"));
	}

	@Test
	public void testBuscarTodosColaborador() {
		ColaboradorDAO cDao = new ColaboradorDAO();
		cDao.create(colaborador);
		assertEquals(1, ColaboradorController.buscarTodosColaborador().size());
	}

}
