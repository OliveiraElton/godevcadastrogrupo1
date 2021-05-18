package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDocumentos;

public class ValidacaoDocumentosTest {
	
	@Test
	public void testeValidaCPF() {
		assertTrue(ValidacaoDocumentos.validarCPF("21164028324"));
		assertFalse(ValidacaoDocumentos.validarCPF("2116428324"));
	}
	
	@Test
	public void testeValidaCNPJ() {
		assertTrue(ValidacaoDocumentos.validarCNPJ("05975585000189"));
		assertFalse(ValidacaoDocumentos.validarCNPJ("0595585000189"));
	}
	
	@Test
	public void testValidaEmail() {
		assertTrue(ValidacaoDocumentos.validarEmail("email@test.com.br"));
		assertFalse(ValidacaoDocumentos.validarEmail("emailtest.com.br"));
	}
	
	@Test
	public void testValidaCEP() {
		assertTrue(ValidacaoDocumentos.validarCEP("78541256"));
		assertFalse(ValidacaoDocumentos.validarCEP("7854156"));
	}
	
	@Test
	public void testValidaTelefone() {
		assertTrue(ValidacaoDocumentos.validarTamanhoTelefone("52463248965"));
		assertFalse(ValidacaoDocumentos.validarTamanhoTelefone("5246324896555"));
		assertTrue(ValidacaoDocumentos.validarTamanhoTelefone("4785478965"));
	}

}