package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.ColaboradorDAO;
import enums.EMDadosPessoais;
import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMDadosPessoais.TiposDependentes;
import enums.EMOutros;
import enums.EMOutros.TiposExames;
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
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static TiposExames te = EMOutros.TiposExames.ADMISSIONAL;
	static TiposDependentes td = EMDadosPessoais.TiposDependentes.CONJUGE;

	@Test
	public void testCriarColaborador() {
		Colaborador c = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", null, null, null, null, "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		assertNotNull(c);
	}

	@Test
	public void testDeleteColabordor() {
		Colaborador c = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", null, null, null, null, "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		ColaboradorController.deleteColabordor(dao.readById(c.getId()));
		assertNull(dao.readById(c.getId()));
	}

	@Test
	public void testAtualizarColaborador() {
		Colaborador c = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", null, null, null, null, "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		session.clear();
		Integer id = colaborador.getId();
		ColaboradorController.atualizarColaborador(id, "João2", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		assertEquals("João2", dao.readById(id).getNome());
	}

	@Test
	public void testBuscarColaboradorPorId() {
		Conta conta = new Conta(null, null, null, null);
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Contatos contatos = new Contatos("4521456985", "4521456985", "Jenifer", "4521456985");
		ExameMedico exameMedico = new ExameMedico(null, null, false);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, td, true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		assertEquals(colaborador, ColaboradorController.buscarColaboradorPorId(colaborador.getId()));

	}

	@Test
	public void testBuscarTodosColaborador() {
		Conta conta = new Conta(null, null, null, null);
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Contatos contatos = new Contatos("4521456985", "4521456985", "Jenifer", "4521456985");
		ExameMedico exameMedico = new ExameMedico(null, null, false);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, td, true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		List<Colaborador> colaboradores = ColaboradorController.buscarTodosColaborador();
		assertEquals("Lucas", colaboradores.get(colaboradores.size() - 1).getNome());
	}

}
