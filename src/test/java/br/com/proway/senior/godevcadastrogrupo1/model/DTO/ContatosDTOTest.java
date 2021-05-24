package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;

public class ContatosDTOTest {

	static Contatos contatos;

	static ContatosDTO contatosDTO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		contatos = new Contatos("95631458974", "9563145897", "teste@teste.com.br", "95631458974");
		contatosDTO = new ContatosDTO(contatos);
	}

	@Test
	public void testContatosDTO() {
		assertNotNull(contatosDTO);
	}

	@Test
	public void testGetTelefonePrincipal() {
		assertEquals("95631458974", contatosDTO.getTelefonePrincipal());
	}

	@Test
	public void testGetTelefoneSecundario() {
		assertEquals("9563145897", contatosDTO.getTelefoneSecundario());	
	}

	@Test
	public void testGetEmail() {
		assertEquals("teste@teste.com.br", contatosDTO.getEmail());
	}

	@Test
	public void testGetTelefoneFamiliar() {
		assertEquals("95631458974", contatosDTO.getTelefoneFamiliar());
	}

}
