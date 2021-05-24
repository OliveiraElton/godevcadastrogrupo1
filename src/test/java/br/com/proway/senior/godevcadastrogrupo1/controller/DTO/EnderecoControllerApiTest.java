package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EnderecoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

public class EnderecoControllerApiTest {

	static EnderecoControllerApi enderecoApi;
	static IdentidadeGenero ig;
	static LocalDate data;
	static TiposExames te;
	static TiposDependentes td;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		enderecoApi = new EnderecoControllerApi();
		ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
		data = LocalDate.of(2002, 01, 28);
		te = EnumExamesMedicos.TiposExames.ADMISSIONAL;
		td = EnumDadosPessoais.TiposDependentes.CONJUGE;
	}
	
	@Before
	public void limparTabela() {
		EnderecoDAO.getInstance(DBConnection.getSession()).deleteAll();
	}

	@Test
	public void testBuscarEnderecoDoColaborador() throws Exception {
		Colaborador c = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco", "Teste Endereco", "Teste Endereco", "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		
		EnderecoDTO enderecoDTO = enderecoApi.buscarEnderecoDoColaborador(c);
		assertEquals("Teste Endereco", enderecoDTO.getCidade());
	}

	@Test
	public void testBuscarEnderecoPorId() throws Exception {
		Colaborador c = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco", "Teste Endereco", "Teste Endereco", "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		Endereco endereco = c.getEndereco();
		EnderecoDTO enderecoDTO = enderecoApi.buscarEnderecoPorId(endereco.getId());
		assertEquals("Teste Endereco", enderecoDTO.getCidade());
	}
	
	@Test
	public void testBuscarTodosEnderecos() throws Exception {
		Colaborador colaborador = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco", "Teste Endereco", "Teste Endereco", "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		Colaborador colaborador2 = ColaboradorController.criarColaborador("Brian", "Santos", "Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606", 8, null, false, false, data, false, null,
				"brian@gmail.com", null, null, null, null, "54126547", "Teste Endereco", "Teste Endereco", "Teste Endereco", "Teste Endereco", "4521452015",
				"5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00", "055",
				"438614625", "154","joãozinho", "Santos","Erika", data, "Venezuelano",
				"Blumenauense", true, null, ig, "09619039610", "mg14388606",td, true);
		assertEquals(2, enderecoApi.buscarTodosEnderecos().size());
	
	}
}
