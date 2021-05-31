package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
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
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.Escolaridade;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.EstadoCivil;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

/**
 * Classe ColaboradorControllerTest.
 * 
 * Teste os metodos da classe {@link ColaboradorControllerTest}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColaboradorControllerTest {
	static Session session = BDConexao.getSessao();
	static ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static DependenteDAO daoDependente = DependenteDAO.getInstance(session);
	static IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
	static LocalDate data = LocalDate.of(2002, 01, 28);
	static TiposExames te = EnumExamesMedicos.TiposExames.ADMISSIONAL;
	static TiposDependentes tipoDep = EnumDadosPessoais.TiposDependentes.CONJUGE;

	@Test
	public void testCriarColaborador() throws Exception {
		Colaborador colaboradorCriado = ColaboradorController.cadastrarColaborador("Maria", "Pereira", "Maria", data,
				"Brasileira", "Blumenau", false, "Feminino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL,
				"Marta Pereira", "Joao Gomes", "09856889711", "7456897", 8, 123456789, false, true, data, false,
				"124545877", "maria@senior.com", "123154485", "Rua 12", 12, "Apartamento", "89655100", "Itoupava Norte",
				"Brasil", "Blumenau", "SC", "47988554477", "47966335478", "maria@gmail.com", "4733268579", te, data,
				true, "Caixa", "4578", "335566", "45", "Junior", "Pereira", LocalDate.now(), "Brasileiro", false,
				"Masculino", ig, "15489636845", tipoDep, false);

		assertNotNull(colaboradorCriado);
	}

	@Test
	public void testDeleteColabordor() throws Exception {
		Colaborador colaboradorCriado = ColaboradorController.cadastrarColaborador("Jonas", "Santos", "Jonas", data,
				"Brasileira", "Itajai", false, "Masculino", ig, Escolaridade.ATE_QUARTA_SERIE,
				EstadoCivil.UNIAO_ESTAVEL, "Marta Santos", "Joao Santos", "09856889711", "7456897", 8, 123456789, false,
				true, data, false, "124545877", "maria@senior.com", "123154485", "Rua 4", 4, "Casa", "89655100",
				"Itapiranga", "Brasil", "Itajai", "SC", "47988554477", "47966335478", "jonas@gmail.com", "4733268579",
				te, data, true, "Viacredi", "332", "12532", "2", "Maria", "Santos", LocalDate.now(), "Brasileiro",
				false, "69536545879", ig, "Feminino", tipoDep, true);

		ColaboradorController.deletarColaborador(dao.buscarPorId(Colaborador.class, colaboradorCriado.getId()));
		assertNull(dao.buscarPorId(Colaborador.class, colaboradorCriado.getId()));
	}

	@Test
	public void testAtualizarColaborador() throws Exception {
		Colaborador colaboradorCriado = ColaboradorController.cadastrarColaborador("Carolina", "Andrade", "Carol", data,
				"Brasileira", "Blumenau", false, "Feminino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.SOLTEIRO,
				"Marta Pereira", "Joao Gomes", "65478932156", "31231554", 2, 32141512, false, true, data, false,
				"512123215", "carolina@senior.com", "123154485", "Rua 1", 1, "Casa", "89635100", "Itoupava Central",
				"Brasil", "Blumenau", "SC", "47988654789", "47966335478", "carol@gmail.com", "4733268579", te, data,
				true, "Santander", "4578", "335566", "45", "Davi", "Lucca", LocalDate.now(), "Brasileiro", false,
				"13245698465", ig, "Masculino", tipoDep, true);

		session.clear();
		Integer id = colaboradorCriado.getId();

		ColaboradorController.atualizarColaborador(id, "Camila", "Andrade", "Camila", data, "Brasileira", "Blumenau",
				false, "Feminino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL, "Marta Pereira",
				"Joao Gomes", "65478932156", "31231554", 2, 32141512, false, true, data, false, "512123215",
				"carolina@senior.com", "123154485", "Rua XV", 17, "Casa", "89635100", "Itoupava Central", "Brasil",
				"Blumenau", "SC", "47988654789", "47966335478", "carol@gmail.com", "4733268579", te, data, true,
				"Santander", "4578", "335566", "45", "Davi", "Lucca", LocalDate.now(), "Brasileiro", false,
				"36526589456", ig, "Masculino", tipoDep, false);

		assertEquals("Camila", dao.buscarPorId(Colaborador.class, id).getNome());
		assertEquals("Rua XV", dao.buscarPorId(Colaborador.class, id).getEndereco().getLogradouro());
		assertEquals((Integer) 17, dao.buscarPorId(Colaborador.class, id).getEndereco().getNumero());
	}

	@Test
	public void testBuscarColaboradorPorId() throws Exception {
		Conta conta = new Conta("Santander", "0850", "0084044", "0");

		Endereco endereco = new Endereco("Rua 10", 15, "Casa", "54215365", "Centro", "Brasil", "Blumemau", "SC");

		Contatos contatos = new Contatos("4521456985", "4521456985", "teste@teste.com", "4521456985");

		ExameMedico exameMedico = new ExameMedico(te, LocalDate.of(2020, 10, 5), true);

		Dependente dependente = new Dependente("Jenifer", "Fonseca", data, "Brasileira", true, null, null,
				"09619039610", tipoDep, true);

		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "Nada consta", data, "Brasileira", "Blumenau",
				false, "Masculino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL, "Marta Pereira",
				"Joao Gomes", endereco, "21164028324", "45124563", contatos, 1235, 154897987, false, false, data, false,
				"0780848080", "lucas.nunes@gmail.com", "554555", conta, exameMedico, dependente);
		dao.cadastrar(colaborador);
		assertEquals(colaborador, ColaboradorController.buscarColaboradorPorId(colaborador.getId()));

	}

	@Test
	public void testBuscarTodosColaborador() throws Exception {
		Integer valorAntes = ColaboradorController.buscarTodosColaboradores().size();

		ColaboradorController.cadastrarColaborador("Jorge", "Silva", "Jorge", data, "Brasileira", "Gaspar", false,
				"Masculino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL, "Marta Pereira", "Joao Gomes",
				"65478932156", "31231554", 2, 32141512, false, true, data, false, "512123215", "jorge@senior.com",
				"123154485", "Rua XV", 17, "Casa", "89635100", "Itoupava Central", "Brasil", "Blumenau", "SC",
				"47988654789", "47966335478", "jorge@gmail.com", "4733268579", te, data, true, "Bradesco", "314",
				"512335", "2", "Davi", "Lucca", LocalDate.now(), "Brasileiro", false, "02548963256", ig, "Masculino",
				tipoDep, true);

		assertEquals(valorAntes + 1, ColaboradorController.buscarTodosColaboradores().size());
	}

	@Test
	public void testAdicionarNovoDependente() throws Exception {
		Colaborador colaborador = ColaboradorController.cadastrarColaborador("Davi", "Swarts", "Davi", data,
				"Brasileira", "Itajai", false, "Masculino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.SOLTEIRO,
				"Marta Pereira", "Joao Gomes", "12365498536", "21315512", 2, 131245123, false, true, data, false,
				"512123215", "davi@senior.com", "123154485", "Rua XV", 17, "Casa", "89635100", "Itoupava Central",
				"Brasil", "Blumenau", "SC", "47855632145", "47877562536", "davi@gmail.com", "4733268579", te, data,
				true, "Caixa", "314", "512335", "2", "Juca", "Swarts", LocalDate.now(), "Brasileiro", false,
				"12365496354", ig, "Masculino", tipoDep, true);

		ColaboradorController.adicionarDependente(colaborador, "David", "Hilderbrant", null, "Brasileira", true,
				"Rua 1", null, "123.587.893-50", EnumDadosPessoais.TiposDependentes.PAI, false);
		assertEquals(2, colaborador.getDependente().size());
	}

	@Test
	public void testAdicionarNovoExameMedico() throws Exception {
		Colaborador colaborador = ColaboradorController.cadastrarColaborador("Silvio", "Poncio", "Silvio", data,
				"Brasileira", "Blumenau", false, "Masculino", ig, Escolaridade.MEDIO_COMPLETO,
				EstadoCivil.UNIAO_ESTAVEL, "Marta Pereira", "Joao Gomes", "65896523689", "21315512", 2, 131245123,
				false, true, data, false, "512123215", "silvio@senior.com", "123154485", "Rua XV", 17, "Casa",
				"89635100", "Itoupava Central", "Brasil", "Blumenau", "SC", "47855632145", "47877562536",
				"silvio@gmail.com", "4733268579", te, data, true, "Caixa", "314", "512335", "2", "Jeremias", "Poncio",
				LocalDate.now(), "Brasileiro", false, "65874569836", ig, "Masculino", tipoDep, true);

		TiposExames te2 = EnumExamesMedicos.TiposExames.PERIODICO;
		ColaboradorController.adicionarExameMedico(colaborador, te2, data, true);
		assertEquals(2, colaborador.getExameMedico().size());

	}

	@Test
	public void testBuscarPorNome() throws Exception {
		ColaboradorController.cadastrarColaborador("Dennis", "Silva", "dennis", data, "Brasileira", "Itajai", false,
				"Masculino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL, "Marta Pereira", "Joao Gomes",
				"12365498536", "21315512", 2, 131245123, false, true, data, false, "512123215", "davi@senior.com",
				"123154485", "Rua XV", 17, "Casa", "89635100", "Itoupava Central", "Brasil", "Blumenau", "SC",
				"47855632145", "47877562536", "davi@gmail.com", "4733268579", te, data, true, "Caixa", "314", "512335",
				"2", "Juca", "Swarts", LocalDate.now(), "Brasileiro", false, "03569874125", ig, "Feminino", tipoDep,
				true);

		ColaboradorController.cadastrarColaborador("Dennis", "Pereira", "Davi", data, "Brasileira", "Itajai", false,
				"Masculino", ig, Escolaridade.MEDIO_COMPLETO, EstadoCivil.UNIAO_ESTAVEL, "Marta Pereira", "Joao Gomes",
				"12365498536", "21315512", 2, 131245123, false, true, data, false, "512123215", "davi@senior.com",
				"123154485", "Rua XV", 17, "Casa", "89635100", "Itoupava Central", "Brasil", "Blumenau", "SC",
				"47855632145", "47877562536", "davi@gmail.com", "4733268579", te, data, true, "Caixa", "314", "512335",
				"2", "Juca", "Swarts", LocalDate.now(), "Brasileiro", false, "32569874156", ig, "Feminino", tipoDep,
				true);

		ArrayList<Colaborador> listaRetorno = (ArrayList<Colaborador>) ColaboradorController
				.buscarColaboradorPorNome("Dennis");
		assertEquals(2, listaRetorno.size());

	}

	@Test
	public void testConstrutor() {
		ColaboradorController controller = new ColaboradorController();
		assertNotNull(controller);

	}

	@Before
	public void limparTabelas() {
		dao.deletarTodos("colaborador");

	}

}
