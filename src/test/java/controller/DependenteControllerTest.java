package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;

public class DependenteControllerTest {
	
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static Session session = DBConnection.getSession();
	static DependenteDAO dao = DependenteDAO.getInstance(session);
	static ColaboradorDAO daoColab = ColaboradorDAO.getInstance(session);
	
	@Test
	public void testCriarDependente() {
		Dependente d = DependenteController.criarDependente("Jorge", "Maravilha", "jessica",
				data, "Brasileiro", null, true, null,
				null, "256.103.800-90", "mg14388606", EnumDadosPessoais.TiposDependentes.FILHO,
				true, "Rua das oliveiras", 32, "casa", "89032640", "Passo Manso",
				"Brasil", "Blumenau", "SC");
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
		Dependente d = DependenteController.criarDependente("Jorge", "Maravilha", "jessica",
				data, "Brasileiro", null, true, null,
				null, "256.103.800-90", "mg14388606", EnumDadosPessoais.TiposDependentes.FILHO,
				true, "Rua das oliveiras", 32, "casa", "89032640", "Passo Manso",
				"Brasil", "Blumenau", "SC");
		dao.create(d);
		session.clear();
		DependenteController.atualizarDependente(d.getId(), "Brunão", "Maravilha", "jessica",
				data, "Brasileiro", null, true, null,
				null, "256.103.800-90", "mg14388606", EnumDadosPessoais.TiposDependentes.CONJUGE,
				true, "Rua das oliveiras", 32, "casa", "89032640", "Passo Manso",
				"Brasil", "Blumenau", "SC");
		List<Dependente> dependentes = dao.getAll();
		assertEquals("Brunão", dependentes.get(dependentes.size() -1).getNome());
		
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
	//Buscar todos funciona, mas não da pra testar pq metodo limpar nao esta funcionando
	//devido a chave estrangeira que esta na tabela colaborador_dependente
	// (cascade somente do registro da relacao entre colaborador e dependente(?))
//	@Test
//	public void testBuscarTodosDependentes() {
//		Dependente d = DependenteController.criarDependente("Jorge", "Maravilha", "jessica",
//				data, "Brasileiro", null, true, null,
//				null, "256.103.800-90", "mg14388606", EnumDadosPessoais.TiposDependentes.FILHO,
//				true, "Rua das oliveiras", 32, "casa", "89032640", "Passo Manso",
//				"Brasil", "Blumenau", "SC");
//		
//		assertEquals(DependenteController.buscarTodosDependentes().size());
//		
//	}

}
