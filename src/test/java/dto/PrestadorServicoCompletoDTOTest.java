package dto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoCompletoDTO;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

public class PrestadorServicoCompletoDTOTest {

	@Test
	public void testPrestadorServicoDTO() {
		PrestadorServico novo = new PrestadorServico("Joao", "Costa", null, LocalDate.of(1990, 02, 03), "xxx", "yyy",
				false, "Masculino", IdentidadeGenero.CIS, null, null, null, null, null, null, null);
	PrestadorServicoCompletoDTO dto = new PrestadorServicoCompletoDTO(novo);
	assertEquals(0, dto.getId());
	assertEquals(novo.getNome(), dto.getNome());
	assertEquals(novo.getSobrenome(), dto.getSobrenome());
	assertEquals(novo.getNomeSocial (), dto.getNomeSocial());
	assertEquals(novo.getDataDeNascimento(), dto.getDataDeNascimento());
	assertEquals(novo.getNacionalidade(), dto.getNacionalidade());
	assertEquals(novo.getNaturalidade(), dto.getNaturalidade());
	assertEquals(novo.isPcd(), dto.isPcd());
	assertEquals(novo.getGenero(), dto.getGenero());
	assertEquals(novo.getIdentidadeGenero(), dto.getIdentidadeGenero());
	assertEquals(novo.getEndereco(), dto.getEndereco());
	assertEquals(novo.getCpf(), dto.getCpf());
	assertEquals(novo.getRg(), dto.getRg());
	assertEquals(novo.getDataInicioContrato(), dto.getDataInicioContrato());
	assertEquals(novo.getEmpresa(), dto.getEmpresa());
	assertEquals(novo.getIdSetor(), dto.getIdSetor());
	assertEquals(novo.getContatos(), dto.getContatos());
	
	}
}