package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;

public class ContatosDTOTest {

	static Contatos contatos = new Contatos("Telefone Principal", "Telefone Secundário", "Email", "Telefone Familiar");
	static ContatosDTO contatosDTO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		contatosDTO = new ContatosDTO(contatos);
	}

	@Test
	public void testContatosDTO() {
		assertNotNull(contatosDTO);
	}

	@Test
	public void testGetTelefonePrincipal() {
		assertEquals("Telefone Principal", contatosDTO.getTelefonePrincipal());
	}

	@Test
	public void testGetTelefoneSecundario() {
		assertEquals("Telefone Secundário", contatosDTO.getTelefoneSecundario());	
	}

	@Test
	public void testGetEmail() {
		assertEquals("Email", contatosDTO.getEmail());
	}

	@Test
	public void testGetTelefoneFamiliar() {
		assertEquals("Telefone Familiar", contatosDTO.getTelefoneFamiliar());
	}

}
