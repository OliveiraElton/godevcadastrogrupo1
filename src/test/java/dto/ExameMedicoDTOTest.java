package dto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.ExameMedicoDTO;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;


public class ExameMedicoDTOTest {

	@Test
	public void testExameMedicoDTO() {
		ExameMedico novo = new ExameMedico(TiposExames.ADMISSIONAL, LocalDate.of(2021, 5, 19), true);
		ExameMedicoDTO dto = new ExameMedicoDTO(novo);
		assertEquals(0, dto.getId());
		assertEquals(novo.getTipoExame(), dto.getTipoExame());
		assertEquals(novo.getDataExame(), dto.getDataExame());
		assertEquals(novo.isApto(), dto.isApto());
	}

}
