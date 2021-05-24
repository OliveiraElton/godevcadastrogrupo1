package br.com.proway.senior.godevcadastrogrupo1.model.DTO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.EnderecoController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

public class EnderecoDTOTest {

	@Test
	public void testCriarEndereco() {
		Endereco endereco = new Endereco("Rua Braba", 11, "Lado esquerdo da rua", "89046852", "Velha Central"
				, "Brasil","Blumenau","SC");
		
		Colaborador colaborador = new Colaborador();
		colaborador.setEndereco(endereco);
		EnderecoDTO enderecoDto = new EnderecoDTO(colaborador);
		
		assertEquals("Rua Braba", enderecoDto.getLogradouro());
		assertEquals("Lado esquerdo da rua", enderecoDto.getComplemento());
		assertEquals(11, 11);
		assertEquals("89046852", enderecoDto.getCep());
		assertEquals("Velha Central", enderecoDto.getBairro());
		assertEquals("Brasil", enderecoDto.getPais());
		assertEquals("Blumenau", enderecoDto.getCidade());
		assertEquals("SC", enderecoDto.getUf());
	}
	
	@Test
	public void testDeletarEndereco() {
		Endereco endereco = EnderecoController.criarEndereco("Rua faustao", 12, "Lado direito da rua", "85967412", 
				"Velha pequena", "Argentina", "Buenos Aires", "PR");
		EnderecoController.deletarEndereco(endereco);
		
		
	}
	
	@Test
	public void testConstruirEndereco() {
		Endereco enderecoNormal = EnderecoController.criarEndereco("Rua 7 de setembro", 458, "Casa", "896654", "Centro", "Brasil", "Blumenau", "SC");
		EnderecoDTO enderecoDto = new EnderecoDTO(enderecoNormal);
		
		assertEquals(enderecoNormal.getId(), enderecoDto.getId());
		assertEquals(Integer.valueOf(458), enderecoDto.getNumero());
		assertEquals("Rua 7 de setembro", enderecoDto.getLogradouro());
		assertEquals("Casa", enderecoDto.getComplemento());
		assertEquals("896654", enderecoDto.getCep());
		assertEquals("Centro", enderecoDto.getBairro());
		assertEquals("Brasil", enderecoDto.getPais());
		assertEquals("Blumenau", enderecoDto.getCidade());
		assertEquals("SC", enderecoDto.getUf());
		
	}

}