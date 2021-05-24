package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

public class ColaboradorDTOTest {

	@Test
	public void testCriarColaboradorDTO() throws Exception {
		Endereco endereco = new Endereco("Rua 15 de Novembro", 1742, "Casa", "89065478", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos = new Contatos("47988154763", "4733259647", "jucazao@gmail.com", "4733124578");
		ExameMedico exame = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.now(), true);
		Conta conta = new Conta("Viacredi", "987", "41057896", "13");
		
		Colaborador colaborador = new Colaborador("Juca", "Dos Santos", "juquinha", LocalDate.of(1996, 07, 11),
				"Brasileiro", "Blumenau", false, "Masculino", EnumDadosPessoais.IdentidadeGenero.CIS, endereco, 
				"95631458974", "8259715", contatos, 8, 1234567891, true, true, LocalDate.now(), false, "1234568777",
				"juca@empresa.com" , "1234565879", conta, exame, null);
		
		
		ColaboradorSimplificadoDTO colaboradorDto = new ColaboradorSimplificadoDTO(colaborador);
		
		assertEquals((Integer) 1234567891, colaboradorDto.getNit());
		assertEquals(colaborador.getId(), colaboradorDto.getId());
		assertEquals(colaborador.getNome(), colaboradorDto.getNome());
		assertEquals(colaborador.getSobrenome(), colaboradorDto.getSobrenome());
		assertEquals(colaborador.getCpf(), colaboradorDto.getCpf());
		assertEquals(colaborador.getIdPostoDeTrabalho(), colaboradorDto.getIdPostoDeTRabalho());
		assertEquals(colaborador.getNit(), colaboradorDto.getNit());
		assertEquals(colaborador.isOptanteVT(), colaboradorDto.getOptanteVT());
		assertEquals(colaborador.isOptanteVAVR(), colaboradorDto.getOptanteVAVR());
		assertEquals(colaborador.getDataAdmissao(), colaboradorDto.getDataAdmissao());
		assertEquals(colaborador.isOptanteDependente(), colaboradorDto.getOptanteDependente());
		assertEquals(colaborador.getEmail_corporativo(), colaboradorDto.getEmail_corporativo());
		assertEquals(colaborador.getConta(), colaboradorDto.getConta());
		assertEquals(colaborador.isPcd(), colaboradorDto.getPcd());
		
	}

}
