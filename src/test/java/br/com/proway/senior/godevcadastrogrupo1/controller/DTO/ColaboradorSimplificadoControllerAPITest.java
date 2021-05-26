package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

/**
 * Classe ColaboradorSimplificadoControllerAPITest.
 * 
 * Testa os m�todos da classe {@link ColaboradorCompletoControllerAPI}.
 * 
 * @author Lucas Walim <b>lucas.walim@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColaboradorSimplificadoControllerAPITest{

	static ColaboradorSimplificadoControllerApi colaboradorControllerApi = new ColaboradorSimplificadoControllerApi();
	static Conta conta = new Conta("Caixa", "105", "2569874", "15");
	static Endereco endereco = new Endereco("Rua xv de Novembro", 154, "Casa", "89065544", "Centro", "Brasil",
			"Blumenau", "SC");
	static String email = "teste@gmail.com";
	static Contatos contatos;
	static ExameMedico exameMedico = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);
	static Session session = DBConnection.getSession();
	static ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static DependenteDAO daoDependente = DependenteDAO.getInstance(session);

	@BeforeClass
	public static void setUpStaticos() throws Exception {
		contatos = new Contatos("47988554466", "4732569874", email, "4798756430");
	}
	@Before
	public void limparTabelas() throws Exception {
		dao.deleteAll();
		daoConta.deleteAll();
		daoContatos.deleteAll();
		daoEndereco.deleteAll();
		daoExameMedico.deleteAll();
		daoDependente.deleteAll();
	}

	@Test
	public void testAReadById() {
		Colaborador colaborador = new Colaborador("Luiza", "Antunes", "Luiza", LocalDate.of(2000, 07, 30), "Brasileira",
				"Blumenau", false, "Masculino", IdentidadeGenero.TRANS, endereco, "21164028324", "45124563", contatos,
				12, 123456789, false, false, LocalDate.now(), false, "12345687552", "luiza@senior.com.br", "5544555",
				conta, exameMedico, new Dependente());
		dao.create(colaborador);
		ColaboradorSimplificadoDTO colaboradorDto = colaboradorControllerApi
				.buscarColaboradorPorId(colaborador.getId());
		assertEquals("luiza@senior.com.br", colaboradorDto.getEmail_corporativo());
	}

	@Test
	public void testBBuscaTodos() throws Exception {

		Conta conta3 = new Conta("Santander", "333", "1231551", "3");
		Endereco endereco3 = new Endereco("Rua Oito", 44, "Casa", "89665422", "Norte", "Brasil", "Blumenau", "SC");
		Contatos contatos3 = new Contatos("47988554466", "4732569874", email, "4798756430");
		ExameMedico exameMedico3 = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);
		Colaborador colaborador = new Colaborador("Luiza", "Fernanda", "Luiza", LocalDate.of(2000, 07, 30),
				"Brasileira", "Blumenau", false, "Feminino", IdentidadeGenero.TRANS, endereco3, "21164028324",
				"45124563", contatos3, 12, 123456789, false, false, LocalDate.now(), false, "12345687552",
				"luiza@senior.com.br", "5544555", conta3, exameMedico3, new Dependente());
		ColaboradorDAO.getInstance(DBConnection.getSession()).create(colaborador);
		Conta conta2 = new Conta("Viacredi", "333", "1231551", "3");
		Endereco endereco2 = new Endereco("Rua 2 de Setembro", 44, "Casa", "89665422", "Itoupava Norte", "Brasil",
				"Blumenau", "SC");
		Contatos contatos2 = new Contatos("47988554466", "4732569874", email, "4798756430");
		ExameMedico exameMedico2 = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);

		Colaborador colaborador2 = new Colaborador("Ana", "Da Silva", "Ana", LocalDate.of(2004, 02, 10), "Brasileira",
				"Blumenau", false, "Feminino", IdentidadeGenero.CIS, endereco2, "21164028324", "45124563", contatos2,
				12, 123456789, false, false, LocalDate.now(), false, "12345687552", "ana@senior.com.br", "5544555",
				conta2, exameMedico2, new Dependente());
		ColaboradorDAO.getInstance(DBConnection.getSession()).create(colaborador2);
		List<ColaboradorSimplificadoDTO> listaColaboradorDto = colaboradorControllerApi.buscarTodos();
		assertEquals(2, listaColaboradorDto.size());
	}

	@Test
	public void testCBuscaPorNome() throws Exception {
		Conta conta3 = new Conta("Santander", "333", "1231551", "3");
		Endereco endereco3 = new Endereco("Rua Oito", 44, "Casa", "89665422", "Norte", "Brasil", "Blumenau", "SC");
		Contatos contatos3 = new Contatos("47988554466", "4732569874", email, "4798756430");
		ExameMedico exameMedico3 = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);

		Colaborador colaborador = new Colaborador("Luiza", "Fernanda", "Luiza", LocalDate.of(2000, 07, 30),
				"Brasileira", "Blumenau", false, "Feminino", IdentidadeGenero.TRANS, endereco3, "21164028324",
				"45124563", contatos3, 12, 123456789, false, false, LocalDate.now(), false, "12345687552",
				"luiza@senior.com.br", "5544555", conta3, exameMedico3, new Dependente());
		dao.create(colaborador);
		List<ColaboradorSimplificadoDTO> lista = colaboradorControllerApi.buscarColaboradorPorNome("Luiza");
		assertEquals(1, lista.size());
	}

	@Test
	public void testCBuscaPorNome2() throws Exception {
		Conta conta3 = new Conta("Santander", "333", "1231551", "3");
		Endereco endereco3 = new Endereco("Rua Oito", 44, "Casa", "89665422", "Norte", "Brasil", "Blumenau", "SC");
		Contatos contatos3 = new Contatos("47988554466", "4732569874", email, "4798756430");
		ExameMedico exameMedico3 = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);

		Colaborador colaborador = new Colaborador("Luiza", "Fernanda", "Luiza", LocalDate.of(2000, 07, 30),
				"Brasileira", "Blumenau", false, "Feminino", IdentidadeGenero.TRANS, endereco3, "21164028324",
				"45124563", contatos3, 12, 123456789, false, false, LocalDate.now(), false, "12345687552",
				"luiza@senior.com.br", "5544555", conta3, exameMedico3, new Dependente());
		dao.create(colaborador);
		Conta conta2 = new Conta("Viacredi", "333", "1231551", "3");
		Endereco endereco2 = new Endereco("Rua 2 de Setembro", 44, "Casa", "89665422", "Itoupava Norte", "Brasil",
				"Blumenau", "SC");
		Contatos contatos2 = new Contatos("47988554466", "4732569874", email, "4798756430");
		ExameMedico exameMedico2 = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);

		Colaborador colaborador2 = new Colaborador("Luiza", "Da Silva", "Ana", LocalDate.of(2004, 02, 10), "Brasileira",
				"Blumenau", false, "Feminino", IdentidadeGenero.CIS, endereco2, "21164028324", "45124563", contatos2,
				12, 123456789, false, false, LocalDate.now(), false, "12345687552", "ana@senior.com.br", "5544555",
				conta2, exameMedico2, new Dependente());
		dao.create(colaborador2);
		List<ColaboradorSimplificadoDTO> lista = colaboradorControllerApi.buscarColaboradorPorNome("Luiza");
		assertEquals(2, lista.size());
	}
	
	
	


}
