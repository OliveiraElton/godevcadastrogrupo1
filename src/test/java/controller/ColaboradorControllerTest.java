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
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;
/**
 * Classe ColaboradorControllerTest.
 * 
 * Teste os m�todos da classe {@link ColaboradorControllerTest}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColaboradorControllerTest {
	static Session session = DBConnection.getSession();
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
		Colaborador colaboradorCriado = ColaboradorController.criarColaborador("Rodrigo", "Moraes", "Nada consta", data, "Brasileira", "Blumenau", true, 
				"Masculino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data, false, "88080888708", "rodrigo@gmail.com", "04040505050", 
				"Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Florian�polis", "SC", "4521452015", "5421452103", "rodrigo@empresa.com.br", "1542413655", 
				te, LocalDate.of(2020, 10, 5), true, "Caixa", "055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", 
				true, "Feminino", ig, "09619039610", "mg14388606", tipoDep, true);
		assertNotNull(colaboradorCriado);
	}

	@Test
	public void testDeleteColabordor() throws Exception {
		Colaborador colaboradorCriado = ColaboradorController.criarColaborador("Carlos", "Moraes", "Nada consta", data, "Brasileira", "Blumenau", true, 
				"Masculino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data, false, "88080888708", "carlos@gmail.com", "04040505050", 
				"Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Florian�polis", "SC", "4521452015", "5421452103", "carlos@empresa.com.br", "1542413655", 
				te, LocalDate.of(2020, 10, 5), true, "Caixa", "055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", 
				true, "Feminino", ig, "09619039610", "mg14388606", tipoDep, true);
		ColaboradorController.deleteColabordor(dao.readById(colaboradorCriado.getId()));
		assertNull(dao.readById(colaboradorCriado.getId()));
	}

	@Test
	public void testAtualizarColaborador() throws Exception {
		Colaborador colaboradorCriado = ColaboradorController.criarColaborador("Camila", "Moraes", "Nada consta", data,
				"Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "camila@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "camila@empresa.com.br", "1542413655", te, LocalDate.of(2020, 10, 5), true, "Caixa",
				"055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", 
				"mg14388606", tipoDep, true);
		session.clear();
		Integer id = colaboradorCriado.getId();
		ColaboradorController.atualizarColaborador(id, "Camila", "Moraes", "Nada consta", data, "Brasileira", "Blumenau", true, "Feminino", ig, 
				"09619039610", "mg14388606", 8, 8788881, false, false, data, false, "88080888708", "camila@gmail.com", "04040505050", "Rua XV", 17, 
				"Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "joana@empresa.com.br", "1542413655", te, 
				LocalDate.of(2020, 10, 5), true, "Caixa", "055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", 
				true, "Feminino", ig, "09619039610", "mg14388606", tipoDep, true);
		assertEquals("Camila", dao.readById(id).getNome());
		assertEquals("Rua XV", dao.readById(id).getEndereco().getLogradouro());
		assertEquals((Integer) 17, dao.readById(id).getEndereco().getNumero());
	}

	@Test
	public void testBuscarColaboradorPorId() throws Exception {
		Conta conta = new Conta("Santander", "0850", "0084044", "0");
		Endereco endereco = new Endereco("Rua 10", 15, "Casa", "54215365", "Centro", "Brasil", "Blumemau", "SC");
		Contatos contatos = new Contatos("4521456985", "4521456985", "teste@teste.com", "4521456985");
		ExameMedico exameMedico = new ExameMedico(te, LocalDate.of(2020, 10, 5), true);
		Dependente dependente = new Dependente("Jenifer", "Fonseca", "Jenifer", data, "Brasileira",
				"Blumenau", true, null, null, endereco, "09619039610", null, tipoDep, true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "Nada consta", data, "Brasileira", "Blumenau", false,
				"Masculino", ig, endereco, "21164028324", "45124563", contatos, 1235, 154897987, false, false, data, false,
				"0780848080", "lucas.nunes@gmail.com", "554555", conta, exameMedico, dependente);
		dao.create(colaborador);
		assertEquals(colaborador, ColaboradorController.buscarColaboradorPorId(colaborador.getId()));

	}

	@Test
	public void testBuscarTodosColaborador() throws Exception {
		Integer valorAntes = ColaboradorController.buscarTodosColaboradores().size();
		ColaboradorController.criarColaborador("Carlos", "Moraes", "Nada consta", data, "Brasileira", "Blumenau", true, "Masculino", ig, "09619039610", 
				"mg14388606", 8, 8788881, false, false, data, false, "88080888708", "carlos@gmail.com", "04040505050", "Rua 1", 9, "Casa", 
				"54126547", "Centro", "Brasil", "Florian�polis", "SC", "4521452015", "5421452103", "carlos@empresa.com.br", "1542413655", te, 
				LocalDate.of(2020, 10, 5), true, "Caixa", "055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", 
				true, "Feminino", ig, "09619039610", "mg14388606", tipoDep, true);
		assertEquals(valorAntes + 1, ColaboradorController.buscarTodosColaboradores().size());
	}

	@Test
	public void testAdicionarNovoDependente() throws Exception {
		Colaborador colaborador = ColaboradorController.criarColaborador("Camila", "Moraes", "Nada consta", data,
				"Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "camila@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "camila@empresa.com.br", "1542413655", te, LocalDate.of(2020, 10, 5), true, "Caixa",
				"055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", 
				"mg14388606", tipoDep, true);
		ColaboradorController.adicionarDependente(colaborador, "David", "Hilderbrant", "Nada consta", null, "Brasileira",
				"Blumenau", true, "Rua 1", null, "123.587.893-50", "Mg-14.388.606",
				EnumDadosPessoais.TiposDependentes.PAI, false, "Rua 15", 666, "Casa", "89032180",
				"Garcia", "Brasil", "Brusque", "SC");
		assertEquals(2, colaborador.getDependente().size());
	}

	@Test
	public void testAdicionarNovoExameMedico() throws Exception {
		Colaborador colaborador = ColaboradorController.criarColaborador("Maria", "Santos", "Nada consta", data,
				"Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "maria@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "maria@empresa.com.br", "1542413655", te, LocalDate.of(2020, 10, 5), true, "Caixa",
				"055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", 
				"mg14388606", tipoDep, true);
		TiposExames te2 = EnumExamesMedicos.TiposExames.PERIODICO;
		ColaboradorController.adicionarExameMedico(colaborador, te2, data, true);
		assertEquals(2, colaborador.getExameMedico().size());

	}

	@Test
	public void testBuscarPorNome() throws Exception {
		Colaborador colaborador1 = ColaboradorController.criarColaborador("Joana", "Marla", "Nada consta", data,
				"Brasileira", "Blumenau", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "joana@empresa.com.br", "1542413655", te, LocalDate.of(2021, 10, 5), true, "Caixa",
				"055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", true,
				"Feminino", ig, "09619039610", "mg14388606", tipoDep, true);
		Colaborador colaborador2 = ColaboradorController.criarColaborador("Joana", "Pereira", "Nada consta", data,
				"Brasileira", "Blumenau", true, "Feminino", ig, "7878888878", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "joana@empresa.com.br", "1542413655", te, LocalDate.of(2021, 10, 5), true, "BB",
				"055", "438614625", "154", "Carlos", "Santos", "Erika", data, "Brasileira", "Blumenau", true,
				"Feminino", ig, "09619039610", "mg14388606", tipoDep, true);
		
		ArrayList<Colaborador> listaRetorno = (ArrayList<Colaborador>) ColaboradorController.buscarColaboradorPorNome("Joana");
		assertEquals(2, listaRetorno.size());
		
	}
	
	@Test
	public void testConstrutor() {
		ColaboradorController controller = new ColaboradorController();
		assertNotNull(controller);
		
	}
	
	@Before
	public void limparTabelas() {
		dao.deleteAll();
		daoConta.deleteAll();
		daoContatos.deleteAll();
		daoEndereco.deleteAll();
		daoExameMedico.deleteAll();
		daoDependente.deleteAll();
	}

}
