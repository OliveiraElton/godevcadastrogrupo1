package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EnderecoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class EnderecoDAOTest {

	Session session = DBConnection.getSession();
	EnderecoDAO dao = EnderecoDAO.getInstance(session);


	@Test
	public void testReadById() {
		Endereco endereco = new Endereco("Rua joao pessoa", 985, "lado esquerdo da rua", "8965123", 
				"Centro", "Brasil", "Blumenau", "SC");
		dao.create(endereco);
		assertEquals(endereco, dao.readById(endereco.getId()));
	}

	@Test
	public void testGetAll() {
		Endereco endereco = new Endereco("Rua xv de Novembro", 1234, "", "8977445", "Centro", "Brasil", "Blumenau",
				"SC");
		Endereco endereco2 = new Endereco("Rua 7 de Setembro", 45, "", "8974335", "Centro", "Brasil", "Blumenau", "SC");
		Integer valorAntes = dao.getAll().size();
		dao.create(endereco);
		dao.create(endereco2);
		assertEquals(valorAntes + 2, dao.getAll().size());

	}


//	@Test
//	public void testCreate() {
//		Endereco endereco = new Endereco("Rua 2 de Setembro", 2, "", "8765512", "Itoupava Norte", "Brasil", "Blumenau",
//				"SC");
//		dao.create(endereco);
//		assertEquals("Rua 2 de Setembro", endereco.getLogradouro());
//		//falta o do numero da casa
//		assertEquals("8765512", endereco.getCep());
//		assertEquals("Itoupava Norte", endereco.getBairro());
//		assertEquals("Brasil", endereco.getPais());
//		assertEquals("Blumenau", endereco.getCidade());
//		assertEquals("SC", endereco.getUf());
//
//	}
	
	
//	Endereco enderecoNormal = EnderecoController.criarEndereco("Rua 7 de setembro", 458, "Casa", "896654", "Centro", "Brasil", "Blumenau", "SC");
//	EnderecoDTO enderecoDto = new EnderecoDTO(enderecoNormal);
//	
//	assertEquals(enderecoNormal.getId(), enderecoDto.getId());
//	assertEquals(Integer.valueOf(458), enderecoDto.getNumero());
//	assertEquals("Rua 7 de setembro", enderecoDto.getLogradouro());
//	assertEquals("Casa", enderecoDto.getComplemento());
//	assertEquals("896654", enderecoDto.getCep());
//	assertEquals("Centro", enderecoDto.getBairro());
//	assertEquals("Brasil", enderecoDto.getPais());
//	assertEquals("Blumenau", enderecoDto.getC
	
	@Test
	public void testCreate() throws Exception{
		Endereco endereco = new Endereco(); 
		endereco.setComplemento("Perto do posto de saude");
		endereco.setLogradouro("Rua Luciano Hang");
		endereco.setNumero(2);
		endereco.setCep("8765512");
		endereco.setBairro("Itoupava Norte");
		endereco.setPais("Brasil");
		endereco.setCidade("Blumenau");
		endereco.setUf("SC");
		dao.create(endereco);
		
		assertEquals();
		assertEquals("Perto do posto de saude", endereco.getComplemento());
		assertEquals("Rua Luciano Hang", endereco.getLogradouro());
		assertEquals(Integer.valueOf(2), endereco.getNumero());
		assertEquals("8765512", endereco.getCep());
		assertEquals("Itoupava Norte", endereco.getBairro());
		assertEquals("Brasil", endereco.getPais());
		assertEquals("Blumenau", endereco.getCidade());
		assertEquals("SC", endereco.getUf());

	}
	///dao.create(prestadorServico);
	//Integer id = prestadorServico.getId();
	//assertEquals(prestadorServico, dao.readById(id));


	@Test
	public void testDelete() {
		Endereco endereco = new Endereco("Rua joao pessoa", null, null, null, null, null, null, null);
		dao.create(endereco);
		
		Integer valorAntes = dao.getAll().size();
		
		dao.delete(endereco);
		assertEquals(valorAntes - 1, dao.getAll().size());
	}

	@Test
	public void testDeleteAll() {
		EnderecoDAO dao = EnderecoDAO.getInstance(session);
		dao.deleteAll();
		assertFalse(dao.getAll().size() > 0);
	}
	
	@Test
	public void test() {
		
	}

}
