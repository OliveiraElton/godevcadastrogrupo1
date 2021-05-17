package utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.utils.FormatacaoDocumentos;

public class TesteFormatacaoDocumentos {
	
FormatacaoDocumentos fd = new FormatacaoDocumentos();
	
	@Test
	public void testeFormataCPF() {
		assertEquals(FormatacaoDocumentos.removerCaracteres("211.640.283-24"), "21164028324");
	}
	
	@Test
	public void testeFormataCNPJ() {
		assertEquals(FormatacaoDocumentos.removerCaracteres("05.975.585/0001-89"), "05975585000189");
	}
	
	@Test
	public void testeFormataCEP() {
		assertEquals(FormatacaoDocumentos.removerCaracteres("891100-00"), "89110000");
	}
	
	@Test
	public void testeFormataTelefone() {
		assertEquals(FormatacaoDocumentos.removerCaracteres("4002-8922"), "40028922");
	}

}
