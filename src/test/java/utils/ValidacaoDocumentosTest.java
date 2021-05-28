package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.utils.FormatacaoDocumentos;
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
	public void testValidaEmail() throws Exception{
		assertTrue(ValidacaoDocumentos.validarEmail("email@test.com.br"));
		
	}
	
	@Test
	public void testValidaCEP() {
		assertTrue(ValidacaoDocumentos.validarCEP("89065891"));
		assertFalse(ValidacaoDocumentos.validarCEP("7854156"));
	}
	
	@Test
	public void testValidaTelefone() throws Exception {
		assertTrue(ValidacaoDocumentos.validarTamanhoTelefone("52463248965"));
		assertTrue(ValidacaoDocumentos.validarTamanhoTelefone("4785478965"));
		
	}

	@Test(expected = Exception.class)
	public void testExceptions() throws Exception{
		assertFalse(ValidacaoDocumentos.validarEmail("emailtest.com.br"));
		assertFalse(ValidacaoDocumentos.validarTamanhoTelefone("5246324896555"));
	}
	
	@Test
	public void testLimpa() {
		System.out.println(FormatacaoDocumentos.removerCaracteresEspeciais("3-2.56dsijdijsadji5//6.3232."));
	}
	
	@Test
	public void testNovoCNPJ() {
		System.out.println(ValidacaoDocumentos.validarCnpj2("29.945.724/0001-90"));
	}
}
