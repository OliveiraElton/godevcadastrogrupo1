package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ErrorMappingTest {

	static ErrorMapping error;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		error = new ErrorMapping();
	}

	@Test
	public void testImprimeErroGet() {
		assertEquals("<h1>Erro de parâmetro, endereço na url ou objeto não existe no banco para retornar.</h1>", error.imprimeErroGet());
	}

	@Test
	public void testImprimeErroPut() {
		assertEquals("<h1>Erro de parâmetro, endereço na url ou objeto não existe para atualizar.</h1>", error.imprimeErroPut());
	}

	@Test
	public void testImprimeErroDelete() {
		assertEquals("<h1>Erro de parâmetro, endereço na url ou objeto não existe para deletar.</h1>", error.imprimeErroDelete());
	}

	@Test
	public void testImprimeErroPost() {
		assertEquals("<h1>Erro de parâmetro, endereço na url ou objeto não pode ser criado (null etc).</h1>", error.imprimeErroPost());
	}

}
