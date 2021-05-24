package br.com.proway.senior.godevcadastrogrupo1.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Classe EmpresaTest.
 * 
 * Realiza os testes dos metodos da classe {@link Empresa}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaTest {
	
	Endereco endereco = new Endereco("Rua XV", 123, "Casa", "89035183", "Centro", 
			"Brasil", "Blumenau", "SC");
	Contatos contatos = new Contatos("47984563214", "47985632145", "proway@proway.com", "47985632144");

	@Test
	public void testConstrutor() {
		Empresa empresa = new Empresa("Proway", LocalDate.of(2021, 12, 05), "99.272.968/0001-34", 
				endereco, contatos);
		assertNotNull(empresa);
	}
	
	@Test 
	public void testSetEGetNomeEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setNomeEmpresa("Proway");
		assertEquals("Proway", empresa.getNomeEmpresa());
	}

}
