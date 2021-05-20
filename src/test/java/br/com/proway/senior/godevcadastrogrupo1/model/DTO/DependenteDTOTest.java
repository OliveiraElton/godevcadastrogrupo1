package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe DependenteDTOTest
 * 
 * Testa os métodos da classe {@link DependenteDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class DependenteDTOTest {

	
	
	@Test
	public void testDependenteDTO() {
		Dependente original = new Dependente("Maria", "Silva", "Nada consta", LocalDate.of(2000, 12, 3), "Brasileiro", "Blumenau", true, "Feminino",
				IdentidadeGenero.TRANS, new Endereco(), "03209507832", "545454", TiposDependentes.FILHO, false);
		DependenteDTO dto = new DependenteDTO(original);
		assertEquals(0, dto.getId());
		assertEquals(original.getNome(), dto.getNome());
		assertEquals(original.getSobrenome(), dto.getSobrenome());
		assertEquals(original.getDataDeNascimento(), dto.getDataDeNascimento());
		assertEquals(original.isOptanteIR(), dto.isOptanteIR());
		assertEquals(original.isPcd(), dto.isPcd());
		assertEquals(original.getTipoDependente(), dto.getTipoDependente());
		assertEquals(original.getCpf(), dto.getCpf());
	}

}
