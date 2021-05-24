package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe DependenteCompletoDTOTest.
 * 
 * Testa os metodos da classe {@link DependenteCompletoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class DependenteCompletoDTOTest {
	
	@Before
	public void limparTabela() {
		DependenteController.deleteAll();
	}
  
	@Test
	public void testDependenteCompletoDTO() {
		Dependente original = new Dependente("Maria", "Silva", "Nada consta", LocalDate.of(2000, 12, 3), "Brasileiro", "Blumenau", true, "Feminino",
				IdentidadeGenero.TRANS, new Endereco(), "03209507832", "545454", TiposDependentes.FILHO, false);
		DependenteCompletoDTO dto = new DependenteCompletoDTO(original);
		assertEquals(0, dto.getId());
		assertEquals(dto.getNome(), original.getNome());
		assertEquals(dto.getSobrenome(), original.getSobrenome());
		assertEquals(dto.getDataDeNascimento(), original.getDataDeNascimento());
		assertEquals(dto.isOptanteIR(), original.isOptanteIR());
		assertEquals(dto.isPcd(), original.isPcd());
		assertEquals(dto.getTipoDependente(), original.getTipoDependente());
		assertEquals(dto.getCpf(), original.getCpf());
		assertEquals(dto.getNomeSocial(), original.getNomeSocial());
		assertEquals(dto.getNacionalidade(), original.getNacionalidade());
		assertEquals(dto.getNaturalidade(), original.getNaturalidade());
		assertEquals(dto.getGenero(), original.getGenero());
		assertEquals(dto.getIdentidadeGenero(), original.getIdentidadeGenero());
		assertEquals(dto.getRg(), original.getRg());
		
	}

}
