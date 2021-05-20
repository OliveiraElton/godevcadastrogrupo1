package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Conta;

public class ContaDTOTest {

	@Test
	public void testCriarContaDTO() {
		Conta conta = new Conta("Caixa", "102", "25985", "14");
		
		ContaDTO contaDto = new ContaDTO(conta);
		
		assertEquals("Caixa", contaDto.getNomeBanco());
		assertEquals("102", contaDto.getAgencia());
		assertNotEquals("25986", contaDto.getNumeroConta());
		assertEquals("14", contaDto.getDigitoVerificador());
		assertEquals(0, contaDto.getId());
	}

}