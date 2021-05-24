package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;

public class PrestadorServicoDTOTest {

	static PrestadorServico prestador = new PrestadorServico();
	static PrestadorServicoDTO prestadorDTO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prestador.setId(1);
		prestador.setDataInicioContrato(LocalDate.of(2021, 05, 21));
		Empresa empresa = new Empresa();
		empresa.setNomeEmpresa("Empresa teste");
		prestador.setEmpresa(empresa);
		prestador.setIdSetor(1);
		Contatos contatos = new Contatos();
		contatos.setEmail("teste@teste.com.br");
		prestador.setContatos(contatos);
		prestador.setNome("Nome");
		prestador.setSobrenome("Sobrenome");
		prestador.setCpf("100.280.329-26");
		
		prestadorDTO = new PrestadorServicoDTO(prestador);
	}

	@Test
	public void testPrestadorServicoDTO() {
		assertNotNull(prestadorDTO);
	}

	@Test
	public void testGetId() {
		assertEquals(1, prestadorDTO.getId());
	}

	@Test
	public void testGetDataInicioContrato() {
		assertEquals(LocalDate.of(2021, 05, 21), prestadorDTO.getDataInicioContrato());
	}

	@Test
	public void testGetEmpresa() {
		assertEquals("Empresa teste", prestadorDTO.getEmpresa().getNomeEmpresa());
	}

	@Test
	public void testGetIdSetor() {
		assertEquals(1, prestadorDTO.getIdSetor());
	}

	@Test
	public void testGetContatos() {
		assertEquals("teste@teste.com.br", prestadorDTO.getContatos().getEmail());
	}

	@Test
	public void testGetNome() {
		assertEquals("Nome", prestadorDTO.getNome());
	}

	@Test
	public void testGetSobrenome() {
		assertEquals("Sobrenome", prestadorDTO.getSobrenome());
	}

	@Test
	public void testGetCpf() {
		assertEquals("100.280.329-26", prestadorDTO.getCpf());
	}

}
