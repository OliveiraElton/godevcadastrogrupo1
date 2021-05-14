package testes;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.utils.ValidacaoDeDatas;
import model.Colaborador;
import model.Pessoa;

public class ValidacaoDeDatasTest {

	@Test
	public void validarDataNascimento() {
		assertTrue(ValidacaoDeDatas.validaDataDeNascimento(LocalDate.of(2002, 01, 28)));
		assertFalse(ValidacaoDeDatas.validaDataDeNascimento(LocalDate.of(2500, 01, 28)));
	}

	@Test
	public  void testValidaDataAdmissao() {
		assertTrue(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(2002, 01, 28)));
		assertTrue(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(2020, 02, 28)));
		assertFalse(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(1500, 01, 28)));
		assertFalse(ValidacaoDeDatas.validaDataAdmissao(LocalDate.of(2200, 01, 28)));
	}
}