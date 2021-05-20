package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;

public class PrestadorServicoControllerApiTest {

	static PrestadorServicoControllerApi prestadorApi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	prestadorApi = new PrestadorServicoControllerApi();
	}

	@Test
	public void testBuscarPrestadorServicoPorId() {
		PrestadorServicoDTO prestadorDTO = prestadorApi.buscarPrestadorServicoPorId(7);
		assertEquals("256.103.800-90", prestadorDTO.getCpf());
	}

	@Test
	public void testBuscarTodosPrestadorServico() {
		List<PrestadorServicoDTO> listaPrestadorDTO = prestadorApi.buscarTodosPrestadorServico();
		assertEquals(6, listaPrestadorDTO.size());
	}
	
	@Test
	public void testBuscarPrestadorServicoPorNome() {
		List<PrestadorServicoDTO> listaPrestadorDTO = prestadorApi.buscarPrestadorServicoPorNome("Vampeta");
		assertEquals(2 ,listaPrestadorDTO.size());
	}

}
