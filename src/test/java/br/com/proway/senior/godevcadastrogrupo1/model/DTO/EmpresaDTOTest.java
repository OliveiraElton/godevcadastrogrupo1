package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

/**
 * Classe EmpresaDTOTest.
 * 
 * Testa os métodos da classe {@link EmpresaDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class EmpresaDTOTest {

	@Test
	public void testEmpresaDTO() {
		Empresa original = new Empresa("Selecionar", LocalDate.of(2021, 04, 06), "89123654000123", new Endereco(), new Contatos());
		EmpresaDTO dto = new EmpresaDTO(original);
		assertEquals(0, dto.getId());
		assertEquals(original.getNomeEmpresa(), dto.getNomeEmpresa());
		assertEquals(original.getDataInicioContrato(), dto.getDataInicioContrato());
		assertEquals(original.getCnpj(), dto.getCnpj());
		assertEquals(original.getEndereco(), dto.getEndereco());
		assertEquals(original.getContato(), dto.getContato());
	}

}
