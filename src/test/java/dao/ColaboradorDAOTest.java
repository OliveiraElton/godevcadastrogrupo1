package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import enums.EMDadosPessoais;
import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMOutros;
import enums.EMOutros.TiposExames;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Dependente;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

public class ColaboradorDAOTest {

	static Session session = DBConnection.getSession();
	ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static DependenteDAO daoDependente = DependenteDAO.getInstance(session);
	static IdentidadeGenero ig = EMDadosPessoais.IdentidadeGenero.TRANS;
	static TiposExames em = EMOutros.TiposExames.ADMISSIONAL;
	static LocalDate data = LocalDate.of(2002, 01, 28);
	Conta conta = new Conta(null, null, null, null);
	Endereco endereco = new Endereco(null, null, null, null, null, null, null, null);
	String email = "teste@gmail.com";
	Contatos contatos = new Contatos(null, null, email, null);
	ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
	ExameMedico exameMedico2 = new ExameMedico(em, LocalDate.now(), false);
	Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano", "Cidade del Leste",
			true, null, null, endereco, "09619039610", null, null, true);

	@Before
	public void criarTabelas() {
		daoConta.create(conta);
		daoContatos.create(contatos);
		daoEndereco.create(endereco);
		daoExameMedico.create(exameMedico);
		daoExameMedico.create(exameMedico2);
		daoDependente.create(dependente);
	}

	@Test
	public void testReadById() {
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		Integer id = colaborador.getId();
		assertEquals(colaborador, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		int tamanhoAntes = dao.getAll().size();
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		Colaborador colaborador2 = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		dao.create(colaborador2);
		assertEquals(tamanhoAntes + 2, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		assertEquals(colaborador, dao.create(colaborador));
	}

	@Test
	public void testDelete() {
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		Integer id = colaborador.getId();
		assertEquals(true, dao.delete(colaborador));
		assertNull(dao.readById(id));
	}

	@Test
	public void testUpdate() {
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
	}

	@Ignore
	public void testReadByEmail() {
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		assertEquals(colaborador, dao.readByEmail("email@empresa.com.br"));
	}

}
