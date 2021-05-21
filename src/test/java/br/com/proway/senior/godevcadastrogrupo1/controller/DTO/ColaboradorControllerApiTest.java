package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ColaboradorSimplificadoDTO;

public class ColaboradorControllerApiTest {

	static ColaboradorSimplificadoControllerApi colaboradorApi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	colaboradorApi = new ColaboradorSimplificadoControllerApi();
	}
	
	@Test
	public void testReadById() {
		ColaboradorSimplificadoDTO colaboradorDto = colaboradorApi.buscarColaboradorPorId(4);
		assertEquals("maico@gmail.com", colaboradorDto.getEmail_corporativo());
	}
	
	@Test
	public void testBuscaTodos() {
		List<ColaboradorSimplificadoDTO> listaColaboradorDto = colaboradorApi.buscarTodos();
		assertEquals(4, listaColaboradorDto.size());
	}

}
