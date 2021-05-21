package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ContatosDTO;

public class ContatosControllerApiTest {

	static ContatosControllerApi contatosApi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		contatosApi = new ContatosControllerApi();
	}

	@Test
	public void testBuscarContatosPorId() {
		ContatosDTO contatosDTO = contatosApi.buscarContatosPorId(2);
		assertEquals("elton@gmail.com", contatosDTO.getEmail());
	}
	
	@Test
	public void testBuscarTodosContatos() {
		List<ContatosDTO> listaContatosDTO = contatosApi.buscarTodosContatos();;
		assertEquals(6, listaContatosDTO.size());
	}
}
