package controllerDTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.DTO.EnderecoControllerAPI;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EnderecoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

public class EnderecoControllerApiTest {

	static EnderecoControllerAPI enderecoApi;
	static IdentidadeGenero ig;
	static LocalDate data;
	static TiposExames te;
	static TiposDependentes td;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		enderecoApi = new EnderecoControllerAPI();
		ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
		data = LocalDate.of(2002, 01, 28);
		te = EnumExamesMedicos.TiposExames.ADMISSIONAL;
		td = EnumDadosPessoais.TiposDependentes.CONJUGE;
		EnderecoDAO dao = EnderecoDAO.getInstance(BDConexao.getSessao());
	}

	@Before
	public void limparTabela() {
		EnderecoDAO.getInstance(BDConexao.getSessao()).deletarTodos("endereco");
	}

	@Test
	public void testBuscarEnderecoDoColaborador() throws Exception {
		Colaborador c = ColaboradorController.cadastrarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco",
				"Teste Endereco", "Teste Endereco", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "Joãozinho", "Santos",
				data, "Venezuelano", true, null, ig, "09619039610", td, true);

		EnderecoDTO enderecoDTO = enderecoApi.buscarEnderecoPorColaborador(c.getId());
		assertEquals("Teste Endereco", enderecoDTO.getCidade());
	}

	@Test
	public void testBuscarEnderecoPorId() throws Exception {
		Colaborador c = ColaboradorController.cadastrarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco",
				"Teste Endereco", "Teste Endereco", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "joãozinho", "Santos",
				data, "Venezuelano", true, null, ig, "09619039610", td, true);

		Endereco endereco = c.getEndereco();
		EnderecoDTO enderecoDTO = enderecoApi.buscarEnderecoPorId(endereco.getId());
		assertEquals("Teste Endereco", enderecoDTO.getCidade());
	}

	@Test
	public void testBuscarTodosEnderecos() throws Exception {
		Colaborador colaborador = ColaboradorController.cadastrarColaborador("Brian", "Santos", "Erika", data,
				"Venezuelano", "Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data,
				false, null, "brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco",
				"Teste Endereco", "Teste Endereco", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "Joãozinho", "Santos",
				data, "Venezuelano", true, null, ig, "09619039610", td, true);

		Colaborador colaborador2 = ColaboradorController.cadastrarColaborador("Brian", "Santos", "Erika", data,
				"Venezuelano", "Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data,
				false, null, "brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco",
				"Teste Endereco", "Teste Endereco", "4521452015", "5421452103", "brian.santos@empresa.com.br",
				"1542413655", te, null, true, "banco00", "055", "438614625", "154", "Joãozinho", "Santos",
				data, "Venezuelano", true, null, ig, "09619039610", td, true);
		assertEquals(2, enderecoApi.buscarTodosEnderecos().size());

	}
}
