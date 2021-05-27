package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

public class EnderecoControllerTest {

	static Session session = BDConexao.getSessao();
	static EnderecoDAO enderecoDao = EnderecoDAO.getInstance(session);

	@BeforeClass
	public static void Before() {
		
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
