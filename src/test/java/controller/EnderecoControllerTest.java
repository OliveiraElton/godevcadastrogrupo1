package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

public class EnderecoControllerTest {

	static Session session = BDConexao.getSessao();
	static EnderecoDAO enderecoDao = EnderecoDAO.getInstance(session);

	@Before
	public void Before() {
		
		enderecoDao.deletarTodos("endereco");
	}
	
	@Test
	public void testCriarEndereco() {
		Endereco endereco = EnderecoController.cadastrarEndereco("Rua Anapolis", 11, "posto de saude", "89562454",
				"Itoupava", "Brasil", "Blumenau", "SC");
		assertNotNull(endereco);
		//assertNull(endereco);
		assertEquals(endereco, EnderecoController.buscarEnderecoPorId(endereco.getId()));
	}

	@Test
	public void testAtualizarEndereco() {
		Endereco endereco = EnderecoController.cadastrarEndereco("teste", 11, "4567777", "teste3", "brasil", "bluemani", "saas", "sc");

		EnderecoController.atualizarEndereco(endereco.getId(), "logradouro1", 11, "complemento11", "90485858", "velha central", "brasil", "blumenau", "sc");
	}
	
	@Test
	public void testDeletarEndereco() {
		
		 Endereco endereco = EnderecoController.cadastrarEndereco("Rua", 26, "1111111", "Arvore", "USA", "Blumenau", "Barra Velha", "MT");
		 
		int total = EnderecoController.listarTodosEnderecos().size();
		EnderecoController.deletarEndereco(endereco);
		
		assertEquals(total -1 , EnderecoController.listarTodosEnderecos().size());
	}
	
	@Test
	public void testBuscarEnderecoPorId() {
		Endereco endereco = EnderecoController.cadastrarEndereco("Rua 2 de setembro", 1215, "Casa", "8966547", "Centro", "Brasil", "Blumenau", "SC");
		
		Endereco enderecoBuscado = EnderecoController.buscarEnderecoPorId(endereco.getId());
		
		assertEquals(endereco.getBairro(), enderecoBuscado.getBairro());
	}
	
	@Test
	public void testBuscarEnderecoPorIdColab() {
		ColaboradorDAO daoColaborador = ColaboradorDAO.getInstance(session);
		LocalDate data = LocalDate.of(2002, 01, 28);
		Contatos contatos;
		IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
		Conta conta = new Conta("Caixa", "105", "2569874", "15");
		TiposExames em = EnumExamesMedicos.TiposExames.ADMISSIONAL;
		ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
		Endereco endereco = new Endereco("Rua 7 de Setembro", 45, "", "8974335", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", data, "Venezuelano",
				true, "Masculino", IdentidadeGenero.CIS, "09619039610", null, true);
		Colaborador colaborador = new Colaborador("Carla", "Nunes", "Nada consta", data, "Americana", "Los Angeles",
				false, "Feminino", ig, endereco, "21164028324", "45124563", null, null, null, false, false, data,
				false, null, "maria.nunes@gmail.com", "554555", conta, exameMedico, dependente);
		ColaboradorDAO colabDao = ColaboradorDAO.getInstance(session);
		Colaborador colabBanco = colabDao.cadastrar(colaborador);
		Endereco colaboradorCadastrado = EnderecoController.buscarEnderecoPorIdColab(colabBanco.getId());
		assertEquals(endereco.getLogradouro(), colaboradorCadastrado.getLogradouro());
	}
	@Test
	public void testListarTodosOsEnderecos() {
		int quantidadeAnterior = EnderecoController.listarTodosEnderecos().size();
		
		EnderecoController.cadastrarEndereco("Rua Curitiba", 333, "Casa", "434343", "Itoupava Norte", "Brasil", "Blumenau", "SC");
		
		int quantidadeAtual = EnderecoController.listarTodosEnderecos().size();
		
		assertEquals(quantidadeAnterior+1,quantidadeAtual);
	}
	
	@Test
	public void testContrutor() {
		EnderecoController controller = new EnderecoController();
		assertNotNull(controller);
	}
}
