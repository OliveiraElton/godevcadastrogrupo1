package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe ColaboradorCompletoDTOTest.
 * 
 * Testa os métodos da classe {@link ColaboradorCompletoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class ColaboradorCompletoDTOTest {

	@Test
	public void testColaboradorCompletoDTO() {
		Colaborador original = new Colaborador("Clara", "Souza", "Claudio Souza", LocalDate.of(1985, 11, 2), "Argentina", "Buenos Aires", false, "Feminino", 
				IdentidadeGenero.TRANS, new Endereco(), "03208509736", "78878", new Contatos(), 12, 1111144477, true, true, LocalDate.of(2021, 05, 11), false,
				null, "claudio@empresa.com", "1111444888333", new Conta(), new ExameMedico(), null);
		ColaboradorCompletoDTO dto = new ColaboradorCompletoDTO(original);
		assertEquals((Integer) 0, dto.getId());
		assertEquals(original.getNome(), dto.getNome());
		assertEquals(original.getSobrenome(), dto.getSobrenome());
		assertEquals(original.getNomeSocial(), dto.getNomeSocial());
		assertEquals(original.getDataDeNascimento(), dto.getDataDeNascimento());
		assertEquals(original.getNacionalidade(), dto.getNacionalidade());
		assertEquals(original.getNaturalidade(), dto.getNaturalidade());
		assertEquals(original.isPcd(), dto.getPcd());
		assertEquals(original.getGenero(), dto.getGenero());
		assertEquals(original.getIdentidadeGenero(), dto.getIdentidadeGenero());
		assertEquals(original.getEndereco(), dto.getEndereco());
		assertEquals(original.getCpf(), dto.getCpf());
		assertEquals(original.getRg(), dto.getRg());
		assertEquals(original.getContatos(), dto.getContatos());
		assertEquals(original.getIdPostoDeTrabalho(), dto.getIdPostoDeTrabalho());
		assertEquals(original.getNit(), dto.getNit());
		assertEquals(original.isOptanteVT(), dto.getOptanteVT());
		assertEquals(original.isOptanteVAVR(), dto.getOptanteVAVR());
		assertEquals(original.getDataAdmissao(), dto.getDataAdmissao());
		assertEquals(original.isOptanteDependente(), dto.getOptanteDependente());
		assertEquals(original.getRegistro_alistamento(), dto.getRegistro_alistamento());
		assertEquals(original.getEmail_corporativo(), dto.getEmail_corporativo());
		assertEquals(original.getTitulo_eleitor(), dto.getTitulo_eleitor());
		assertEquals(original.getConta(), dto.getConta());
		assertEquals(original.getExameMedico(), dto.getExameMedico());
		assertEquals(original.getDependente(), dto.getDependente());
	}
}
