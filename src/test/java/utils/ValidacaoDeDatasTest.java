package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.utilidades.ValidacaoDeDatas;

public class ValidacaoDeDatasTest {
	
	@Test
	public void validarDataNascimento() {
		assertTrue(ValidacaoDeDatas.validaDataDeNascimento(LocalDate.of(2002, 01, 28)));
		assertFalse(ValidacaoDeDatas.validaDataDeNascimento(LocalDate.of(1500, 01, 28)));
	}

	@Test
	public  void testValidaDataAdmissao() {
		assertTrue(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(2021, 06, 10)));
		assertTrue(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(2021, 05, 28)));
		assertFalse(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(1500, 01, 28)));
		assertFalse(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(2010, 01, 28)));
	}
	
	@Test
	public void testValidaDataPassada() {
		assertTrue(ValidacaoDeDatas.validaDataPassada(LocalDate.of(2010, 5, 10)));
		assertFalse(ValidacaoDeDatas.validaDataPassada(LocalDate.of(2025, 5, 10)));
	}

}
