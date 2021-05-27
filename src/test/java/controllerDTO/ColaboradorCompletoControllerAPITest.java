package controllerDTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.DTO.ColaboradorCompletoControllerAPI;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

/**
 * Classe ColaboradorCompletoControllerAPITest.
 * 
 * Testa os m�todos da classe {@link ColaboradorCompletoControllerAPI}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */

public class ColaboradorCompletoControllerAPITest {

	ColaboradorController controllerOriginal = new ColaboradorController();
	ColaboradorCompletoControllerAPI controllerAPI = new ColaboradorCompletoControllerAPI();
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
	static TiposDependentes td = EnumDadosPessoais.TiposDependentes.CONJUGE;

	@Before
	public void limparTabela() {
		dao.deleteAll();
	}
	@Test
	public void testCriarUmColaborador() throws Exception {
		Colaborador colaborador1 = ColaboradorController.criarColaborador("Lucas", "Walim", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Masculino", ig, "09619039610", "mn24588606", 8, 8788881, false,
				false, data, false, "88080888708", "lucas.walim@gmail.com", "04040505050", "Rua 1", 9, "Casa",
				"54126547", "Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103",
				"lucas.walim@empresa.com.br", "1542413655", te, null, true, "banco00", "055", "438614625", "154",
				"joãozinho", "Santos", "Erika", data, "brasileiro", "Blumenauense", true, "Masculino", ig,
				"09619039610", "mn24588606", td, true);

		Colaborador colaboradorCriado1 = controllerAPI.cadastrarColaborador(colaborador1);

		assertEquals(colaboradorCriado1, dao.readById(colaboradorCriado1.getId()));
	}

	@Test
	public void testDeletarUmColaborador() throws Exception {
		Colaborador colaborador2 = ColaboradorController.criarColaborador("gabriel", "simon", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Masculino", ig, "09619039610", "mn24588606", 8, 8788881, false,
				false, data, false, "88080888708", "gabriel.simon@gmail.com", "04040505050", "Rua 1", 9, "Casa",
				"54126547", "Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103",
				"gabriel.simon@empresa.com.br", "1542413655", te, null, true, "banco00", "055", "438614625", "154",
				"Lucia", "Santos", "Erika", data, "brasileiro", "Blumenauense", true, "Feminino", ig, "09619039610",
				"mn24588606", td, true);

		Integer colaboradorCriado2 = controllerAPI.cadastrarColaborador(colaborador2).getId();
		controllerAPI.deletarColaborador(colaboradorCriado2);
		assertEquals(0, dao.getAll().size());
	}

	@Test
	public void testAtualizarUmColaborador() throws Exception{
		Colaborador colaborador3 = ColaboradorController.criarColaborador("gabriel", "simon", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Masculino", ig, "09619039610", "mn24588606", 8, 8788881, false,
				false, data, false, "88080888708", "gabriel.simon@gmail.com", "04040505050", "Rua 1", 9, "Casa",
				"54126547", "Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103",
				"gabriel.simon@empresa.com.br", "1542413655", te, null, true, "banco00", "055", "438614625", "154",
				"Lucia", "Santos", "Erika", data, "brasileiro", "Blumenauense", true, "Feminino", ig, "09619039610",
				"mn24588606", td, true);
		
		Colaborador colaboradorCriado3 = controllerAPI.cadastrarColaborador(colaborador3);
		colaboradorCriado3.setNome("Joao");
		colaboradorCriado3.setNaturalidade("Rio de Janeiro");

		controllerAPI.atualizarColaborador(colaboradorCriado3);
		assertEquals("Joao", dao.readById(colaboradorCriado3.getId()).getNome());
	}
	@Test
	public void testBuscarColaboradorPorId() throws Exception {
		Colaborador colaborador = ColaboradorController.criarColaborador("Joana", "Marla", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false,
				false, data, false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547",
				"Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos", "Erika",
				data, "Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", td, true);
		ColaboradorCompletoDTO retornoDTO = controllerAPI.buscarColaboradorPorId(colaborador.getId());
		assertEquals(colaborador.getNome(), retornoDTO.getNome());
		assertEquals(colaborador.getConta(), retornoDTO.getConta());
		assertEquals(colaborador.getContatos(), retornoDTO.getContatos());
		assertEquals(colaborador.getGenero(), retornoDTO.getGenero());
		assertEquals(colaborador.getDataAdmissao(), retornoDTO.getDataAdmissao());
		assertEquals(colaborador.getEmail_corporativo(), retornoDTO.getEmail_corporativo());
		assertEquals(colaborador.getNacionalidade(), retornoDTO.getNacionalidade());
	}

	@Test
	public void testBuscarTodosColaboradores() throws Exception {
		Colaborador colaborador1 = ColaboradorController.criarColaborador("Joana", "Marla", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false,
				false, data, false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547",
				"Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos", "Erika",
				data, "Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", td, true);
		Colaborador colaborador2 = ColaboradorController.criarColaborador("Joana", "Pereira", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "7878888878", "mg14388606", 8, 8788881, false,
				false, data, false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547",
				"Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos", "Erika",
				data, "Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", td, true);
		ArrayList<ColaboradorCompletoDTO> listaRetorno = (ArrayList<ColaboradorCompletoDTO>) controllerAPI
				.buscarTodosColaboradores();
		assertEquals(2, listaRetorno.size());
		assertEquals(colaborador1.getNome(), listaRetorno.get(0).getNome());
		assertEquals(colaborador1.getConta(), listaRetorno.get(0).getConta());
		assertEquals(colaborador1.getEndereco(), listaRetorno.get(0).getEndereco());
		assertEquals(colaborador2.getEndereco(), listaRetorno.get(1).getEndereco());
		assertEquals(colaborador2.getEndereco(), listaRetorno.get(1).getEndereco());
		assertEquals(colaborador2.getEndereco(), listaRetorno.get(1).getEndereco());
	}

	@Test
	public void testBuscarColaboradorPorNome() throws Exception {
		Colaborador colaborador1 = ColaboradorController.criarColaborador("Joana", "Marla", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false,
				false, data, false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547",
				"Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos", "Erika",
				data, "Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", td, true);
		Colaborador colaborador2 = ColaboradorController.criarColaborador("Joana", "Pereira", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "7878888878", "mg14388606", 8, 8788881, false,
				false, data, false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547",
				"Centro", "Brasil", "Blumenau", "SC", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos", "Erika",
				data, "Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", td, true);
		ArrayList<ColaboradorCompletoDTO> listaRetorno = (ArrayList<ColaboradorCompletoDTO>) controllerAPI
				.buscarColaboradorPorNome("Joana");
		assertEquals(2, listaRetorno.size());
		assertEquals(colaborador1.getNome(), listaRetorno.get(0).getNome());
		assertEquals(colaborador1.getConta(), listaRetorno.get(0).getConta());
		assertEquals(colaborador1.getEndereco(), listaRetorno.get(0).getEndereco());
		assertEquals(colaborador2.getEndereco(), listaRetorno.get(1).getEndereco());
		assertEquals(colaborador2.getEndereco(), listaRetorno.get(1).getEndereco());
		assertEquals(colaborador2.getEndereco(), listaRetorno.get(1).getEndereco());
	}
}
