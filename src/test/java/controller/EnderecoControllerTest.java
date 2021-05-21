package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class EnderecoControllerTest {

	static Session session = DBConnection.getSession();
	static EnderecoDAO enderecoDao = EnderecoDAO.getInstance(session);

	

	@Test

	public void testCriarEndereco() {
		Endereco endereco = EnderecoController.criarEndereco("Rua Anapolis", 11, "posto de saude", "89562454",
				"Itoupava", "Brasil", "Blumenau", "SC");
		assertNotNull(endereco);
		assertEquals(endereco, enderecoDao.readById(endereco.getId()));
	}

	@Test
	public void testDeletarEndereco() {

	}

	@Test
	public void testAtualizarEndereco() {
		Endereco endereco = EnderecoController.criarEndereco("teste", 11, "4567777", "teste3", "brasil", "bluemani", "saas", "sc");
		enderecoDao.create(endereco);

		EnderecoController.atualizarEndereco(endereco.getId(), "logradouro1", 11, "complemento11", "90485858", "velha central", "brasil", "blumenau", "sc");
	}
}
