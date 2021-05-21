package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;

/**
 * Classe PrestadorServicoCompletoControllerApiTest.
 * Testa o métodos de busca.
 * 
 * @author Elton Oliveira
 *
 */
public class PrestadorServicoCompletoControllerApiTest {

	static PrestadorServicoCompletoControllerApi  prestadorApi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	prestadorApi = new PrestadorServicoCompletoControllerApi();
	}

	@Test
	public void testBuscarPrestadorServicoPorId() {
		PrestadorServicoCompletoDTO prestadorCompeltoDTO = prestadorApi.buscarPrestadorServicoCompletoPorId(1);
		assertEquals("075.627.229-78", prestadorCompeltoDTO.getCpf());
	}

	@Test
	public void testBuscarTodosPrestadorServico() {
		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = prestadorApi.buscarTodosPrestadorServicoCompleto();
		assertEquals(3, listaPrestadorCompletoDTO.size());
	}
	
	@Test
	public void testBuscarPrestadorServicoPorNome() {
		List<PrestadorServicoCompletoDTO> listaPrestadorCompletoDTO = prestadorApi.buscarPrestadorServicoCompletoPorNome("Elton");
		assertEquals(2 ,listaPrestadorCompletoDTO.size());
	}
}
