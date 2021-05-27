package modelDTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

/**
 * Classe DependenteDTOTest
 * 
 * Testa os metodos da classe {@link DependenteSimplificadoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class DependenteSimplificadoDTOTest {
	
	@Before
	public void limparTabela() {
		DependenteController.deleteAll();
	}

	@Test
	public void testDependenteDTO() {
		Dependente original = new Dependente("Maria", "Silva", "Nada consta", LocalDate.of(2000, 12, 3), "Brasileiro", "Blumenau", true, "Feminino",
				IdentidadeGenero.TRANS, new Endereco(), "03209507832", "545454", TiposDependentes.FILHO, false);
		DependenteSimplificadoDTO dto = new DependenteSimplificadoDTO(original);
		assertEquals(0, dto.getId());
		assertEquals(dto.getNome(), original.getNome());
		assertEquals(dto.getSobrenome(), original.getSobrenome());
		assertEquals(dto.getDataDeNascimento(), original.getDataDeNascimento());
		assertEquals(dto.isOptanteIR(), original.isOptanteIR());
		assertEquals(dto.isPcd(), original.isPcd());
		assertEquals(dto.getTipoDependente(), original.getTipoDependente());
		assertEquals(dto.getCpf(), original.getCpf());
	}

}
