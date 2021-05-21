package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorDTO;

public class ColaboradorControllerApiTest {

	static ColaboradorControllerApi colaboradorApi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	colaboradorApi = new ColaboradorControllerApi();
	}
	
	@Test
	public void testReadById() {
		ColaboradorDTO colaboradorDto = colaboradorApi.buscarColaboradorPorId(4);
		assertEquals("maico@gmail.com", colaboradorDto.getEmail_corporativo());
	}
	
	@Test
	public void testBuscaTodos() {
		List<ColaboradorDTO> listaColaboradorDto = colaboradorApi.buscarTodos();
		assertEquals(4, listaColaboradorDto.size());
	}

}
