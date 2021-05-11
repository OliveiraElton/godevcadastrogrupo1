package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDocumentos;

public class ValidacaoDocumentosTest {

	ValidacaoDocumentos vd = new ValidacaoDocumentos();
	
	@Test
	public void testeValidaCPF() {
		assertTrue(vd.validarCPF("21164028324"));
		assertFalse(vd.validarCPF("2116428324"));
	}
	
	@Test
	public void testeValidaCNPJ() {
		assertTrue(vd.validarCNPJ("05975585000189"));
		assertFalse(vd.validarCNPJ("0595585000189"));
	}
	
	@Test
	public void testValidaEmail() {
		assertTrue(vd.validarEmail("email@test.com.br"));
		assertFalse(vd.validarEmail("emailtest.com.br"));
	}
	
	@Test
	public void testValidaCEP() {
		assertTrue(vd.validarCEP("78541256"));
		assertFalse(vd.validarCEP("7854156"));
	}
	
	@Test
	public void testValidaTelefoneMovel() {
		assertTrue(vd.validarTamanhoTelMovel("47940028922"));
		assertFalse(vd.validarTamanhoTelMovel("4794002822"));
	}
	
	@Test
	public void testValidaTelefoneFixo() {
		assertTrue(vd.validarTamanhoTelFixo("4740028922"));
		assertFalse(vd.validarTamanhoTelFixo("47940028922"));
	}
}