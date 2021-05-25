package br.com.proway.senior.godevcadastrogrupo1.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.BeforeClass;
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

	Endereco endereco = new Endereco("Rua XV", 123, "Casa", "89035183", "Centro", "Brasil", "Blumenau", "SC");
	static Contatos contatos;

	@BeforeClass
	public static void setaContato() throws Exception{
		contatos = new Contatos("47984563214", "47985632145", "proway@proway.com", "47985632144");
		
	}
	@Test
	public void testConstrutor() throws Exception{
		Empresa empresa = new Empresa("Proway", LocalDate.of(2021, 12, 05), "05.975.585/0001-89", endereco, contatos);
		assertNotNull(empresa);
	}

	@Test
	public void testSetEGetId() {
		Empresa empresa = new Empresa();
		empresa.setId(150);
		;
		assertEquals((Integer) 150, empresa.getId());
	}

	@Test
	public void testSetEGetNomeEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setNomeEmpresa("Proway");
		assertEquals("Proway", empresa.getNomeEmpresa());
	}

	@Test
	public void testSetEGetDataInicio() {
		Empresa empresa = new Empresa();
		empresa.setDataInicioContrato(LocalDate.of(2021, 10, 15));
		assertEquals(LocalDate.of(2021, 10, 15), empresa.getDataInicioContrato());
	}

	@Test
	public void testSetEGetCNPJCorreto() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setCnpj("05975585000189");
		assertEquals("05975585000189", empresa.getCnpj());
	}

	@Test(expected = Exception.class)
	public void testSetEGetCNPJIncorreto() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setCnpj("819930900001");
	}

	@Test
	public void testSetEGetEndereco() {
		Empresa empresa = new Empresa();
		empresa.setEndereco(endereco);
		assertEquals(endereco, empresa.getEndereco());
		assertEquals(endereco.getLogradouro(), empresa.getEndereco().getLogradouro());
		assertEquals(endereco.getComplemento(), empresa.getEndereco().getComplemento());
	}

	@Test
	public void testSetEGetContatos() {
		Empresa empresa = new Empresa();
		empresa.setContato(contatos);
		assertEquals(contatos, empresa.getContato());
		assertEquals(contatos.getEmail(), empresa.getContato().getEmail());
		assertEquals(contatos.getTelefoneFamiliar(), empresa.getContato().getTelefoneFamiliar());
	}

}
