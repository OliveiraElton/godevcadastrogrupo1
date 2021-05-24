package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.controller.DTO.ColaboradorSimplificadoControllerApi;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

/**
 * Classe ColaboradorDAOTest.
 * 
 * Realiza os testes da classe {@link ColaboradorDAO}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 * @author Lucas Walim <b>lucas.walim@senior.com.br</b> - Sprint 6
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColaboradorDAOTest {

	ColaboradorSimplificadoControllerApi colabControllerApi = new ColaboradorSimplificadoControllerApi();
	static Session session = DBConnection.getSession();
	static ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static DependenteDAO daoDependente = DependenteDAO.getInstance(session);
	static IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
	static TiposExames em = EnumExamesMedicos.TiposExames.ADMISSIONAL;
	static LocalDate data = LocalDate.of(2002, 01, 28);
	Conta conta = new Conta("Caixa", "105", "2569874", "15");
	Endereco endereco = new Endereco("Rua XV de Novembro", 154, "Casa", "89065544", "Centro", "Brasil", "Blumenau",
			"SC");
	static Contatos contatos;
	ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
	ExameMedico exameMedico2 = new ExameMedico(em, LocalDate.now(), false);
	ExameMedico exameMedico3 = new ExameMedico(em, LocalDate.now(), true);
	Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano", "Cidade del Leste",
			true, null, null, endereco, "09619039610", null, null, true);

	@Before
	public void limparTabelas() throws Exception {
		dao.deleteAll();
		daoConta.deleteAll();
		daoContatos.deleteAll();
		daoEndereco.deleteAll();
		daoExameMedico.deleteAll();
		daoDependente.deleteAll();
		contatos = new Contatos("47988554466", "47325698740", "teste@teste.com", "47988554466");
	}

	@Test
	public void testBReadById() {
		Colaborador colaborador = new Colaborador("Carla", "Nunes", "Nada consta", data, "Americana", "Los Angeles",
				false, "Feminino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data,
				false, null, "maria.nunes@gmail.com", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		Integer id = colaborador.getId();
		assertEquals(colaborador, dao.readById(id));

	}

	@Test
	public void testCGetAll() {
		int tamanhoAntes = dao.getAll().size();
		Colaborador colaborador = new Colaborador("Maria", "Souza", "Maria Souza", data, "Brasileira", "Blumenau",
				false, "Masculino", ig, endereco, "21164028324", "45124563", contatos, null, null, false, false, data,
				false, null, "maria.souza@outlook.com.br", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		assertEquals(tamanhoAntes + 1, dao.getAll().size());
	}

	@Test
	public void testACreate() {
		int antes = colabControllerApi.buscarTodos().size();
		Colaborador colaborador = new Colaborador("Mario", "Pinheiro", "Nada consta", LocalDate.of(2000, 01, 02),
				"Brasileiro", "Blumenau", false, "Masculino", ig, endereco, "21164028324", "45124563", contatos, 12,
				123456789, false, false, LocalDate.now(), false, "12345687552", "lucas.nunes@senior.com.br", "5544555",
				conta, exameMedico, dependente);
		Colaborador colaborador2 = new Colaborador("Maria", "Silva", "Maria", LocalDate.of(1998, 07, 11), "Brasileira",
				"Joinville", false, "Feminino", IdentidadeGenero.CIS, endereco, "87872123445", "3322584", contatos, 12,
				98851456, false, false, LocalDate.now(), false, "123111444", "maria@senior.com.br", "6564645", conta,
				exameMedico2, new Dependente());
		Colaborador colaborador3 = new Colaborador("Junior", "Santos", "Juninho", LocalDate.of(1980, 4, 12),
				"Brasileira", "Blumenau", false, "Feminino", IdentidadeGenero.TRANS, endereco, "555412354", "98794455",
				contatos, 12, 1234587, false, false, LocalDate.now(), false, "123111444", "junior@senior.com.br",
				"3124551", conta, exameMedico3, new Dependente());
		dao.create(colaborador);
		dao.create(colaborador2);
		dao.create(colaborador3);
		assertEquals(antes + 3, colabControllerApi.buscarTodos().size());
	}

	@Test
	public void testGDelete() {
		Colaborador colaborador = new Colaborador("Fernanda", "Brito", "Nada consta", data, "Brasileira", "Bag�", false,
				"Feminino", ig, endereco, "21164028324", "45124563", contatos, 1, 84536112, false, false, data, false,
				"1234555688", "fernanda@gmail.com", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		Integer id = colaborador.getId();
		assertEquals(true, dao.delete(colaborador));
		assertNull(dao.readById(id));
	}

	@Test
	public void testFUpdate() {
		Colaborador colaborador = new Colaborador("Pedro", "dos Anjos", "Pedro", data, "Brasileira", "Rio do Sul",
				false, "Masculino", ig, endereco, "21164028324", "45124563", contatos, 2, 65448896, false, false,
				LocalDate.of(2021, 01, 25), false, "989555633", "pedro@senior.com.br", "322321555", conta, exameMedico,
				dependente);
		dao.create(colaborador);

		colaborador.setCpf("99999999999");
		colaborador.setNome("Mariana");
		colaborador.setIdentidadeGenero(IdentidadeGenero.TRANS);
		colaborador.setNacionalidade("Brasil");
		colaborador.setDataDeNascimento(LocalDate.of(1985, 8, 23));
		dao.update(colaborador);
		assertEquals("Mariana", colaborador.getNome());
	}

	@Test
	public void testEReadByEmail() {
		Colaborador colaborador = new Colaborador("Daniela", "Goncalves", "Dani", data, "Brasileira", "Blumenau", false,
				"Masculino", ig, endereco, "15553232", "6566522354", contatos, 5, 555112324, false, false,
				LocalDate.of(2020, 4, 17), false, "65123478", "daniela.goncalves@gmail.com", "554555", conta,
				exameMedico, dependente);
		dao.create(colaborador);
		assertNotNull(dao.readByEmail("daniela.goncalves@gmail.com"));
	}

	@Test
	public void testHDeletarTodosColaboradores() {
		Colaborador colaborador = new Colaborador("Maria", "Silva", "Nada consta", data, "Brasileira", "Blumenau",
				false, "Masculino", ig, endereco, "15553232", "6566522354", contatos, 5, 555112324, false, false,
				LocalDate.of(2020, 4, 17), false, "65123478", "maria@gmail.com", "554555", conta, exameMedico,
				dependente);
		dao.create(colaborador);
		dao.deleteAll();
		assertEquals(0, dao.getAll().size());
		assertFalse(dao.deleteAll());
	}

	@Test
	public void testDBuscarPorNome() {
		Dependente dependente1 = new Dependente("Marta", "Fonseca", "Marta", data, "Venezuelano", "Cidade del Leste",
				true, "Feminino", ig, endereco, "09619039610", "8808080", TiposDependentes.FILHO, true);
		Colaborador colaborador1 = new Colaborador("Joana", "Silva", "Nada consta", data, "Americano", "Blumenau",
				false, "Feminino", ig, endereco, "15553232", "6566522354", contatos, 5, 555112324, false, false,
				LocalDate.of(2020, 4, 17), false, "65123478", "joana@gmail.com", "554555",
				new Conta("Santander", "0506", "05050505", "1"),
				new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.of(2021, 8, 7), true), dependente1);
		dao.create(colaborador1);
		Dependente dependente2 = new Dependente("Clementina", "Fonseca", "Clementina", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", ig, endereco, "09619039610", "808080", TiposDependentes.MAE,
				true);
		Colaborador colaborador2 = new Colaborador("Joana", "Pinheiro", "Nada consta", data, "Americano", "Blumenau",
				false, "Masculino", ig, endereco, "15553232", "6566522354", contatos, 5, 555112324, false, false,
				LocalDate.of(2020, 4, 17), false, "65123478", "joana@gmail.com", "554555",
				new Conta("Caixa", "0506", "05050505", "1"),
				new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.of(2020, 8, 7), false), dependente2);
		dao.create(colaborador2);
		ArrayList<Colaborador> listaRetorno = (ArrayList<Colaborador>) dao.buscarPorNome("Joana");
		assertEquals(colaborador1.getNome(), listaRetorno.get(0).getNome());
		assertEquals(colaborador1.getCpf(), listaRetorno.get(0).getCpf());
		assertEquals(colaborador1.getConta(), listaRetorno.get(0).getConta());
		assertEquals(colaborador2.getNome(), listaRetorno.get(1).getNome());
		assertEquals(colaborador2.getCpf(), listaRetorno.get(1).getCpf());
		assertEquals(colaborador2.getConta(), listaRetorno.get(1).getConta());
	}

	@Test
	public void testContrutor() {
		ColaboradorDAO colabDAO = new ColaboradorDAO(DBConnection.getSession());
		assertNotNull(colabDAO);
	}
	
}
