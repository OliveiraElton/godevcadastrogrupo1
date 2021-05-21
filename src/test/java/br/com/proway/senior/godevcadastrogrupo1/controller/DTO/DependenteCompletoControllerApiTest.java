package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;


public class DependenteCompletoControllerApiTest {

	static DependenteCompletoControllerApi  dependenteApi;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dependenteApi = new DependenteCompletoControllerApi();
	}

	@Test
	public void testBuscarDependentePorId() {
		DependenteCompletoDTO dependenteCompeltoDTO = dependenteApi.buscarDependentePorId(1);
		assertEquals("09619039610", dependenteCompeltoDTO.getCpf());
	}
	
	@Test
	public void testBuscarTodosDependente() {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarTodosDependenteCompleto();
		assertEquals(6, listaDependenteCompletoDTO.size());
	}
	
	@Test
	public void testBuscarDependentePorNome() {
		List<DependenteCompletoDTO> listaDependenteCompletoDTO = dependenteApi.buscarDependenteCompletoPorNome("Joãozinho");
		assertEquals(6 ,listaDependenteCompletoDTO.size());
	}
}
