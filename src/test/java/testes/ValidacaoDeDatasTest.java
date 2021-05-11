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

		Pessoa p = new Pessoa();
		Pessoa p2 = new Pessoa();
		Pessoa p3 = new Pessoa();
		Pessoa p4 = new Pessoa();

		ValidacaoDeDatas validaData = new ValidacaoDeDatas();

		p.setDataDeNascimento(LocalDate.of(2002, 01, 28));
		p2.setDataDeNascimento(LocalDate.of(2020, 02, 28));
		p3.setDataDeNascimento(LocalDate.of(1500, 01, 28));
		p4.setDataDeNascimento(LocalDate.of(2500, 01, 28));

		assertTrue(validaData.validaDataDeNascimento(p));
		assertTrue(validaData.validaDataDeNascimento(p2));
		assertFalse(validaData.validaDataDeNascimento(p3));
		assertFalse(validaData.validaDataDeNascimento(p4));
	}

	@Test
	public void testValidaDataDeNascimentoColaborador() {
		Colaborador p = new Colaborador.ColaboradorBuilder().criarColaborador();
		Colaborador p2 = new Colaborador.ColaboradorBuilder().criarColaborador();
		Colaborador p3 = new Colaborador.ColaboradorBuilder().criarColaborador();

		ValidacaoDeDatas validaData = new ValidacaoDeDatas();

		p.getPessoa().setDataDeNascimento(LocalDate.of(2002, 01, 28));
		p2.getPessoa().setDataDeNascimento(LocalDate.of(2020, 02, 28));
		p3.getPessoa().setDataDeNascimento(LocalDate.of(1500, 01, 28));

		assertTrue(validaData.validaDataDeNascimentoColaborador(p));
		assertFalse(validaData.validaDataDeNascimentoColaborador(p2));
		assertFalse(validaData.validaDataDeNascimentoColaborador(p3));
	}

	@Test
	public void testValidaDataAdmissao() {
		Colaborador p = new Colaborador();
		Colaborador p2 = new Colaborador();
		Colaborador p3 = new Colaborador();
		Colaborador p4 = new Colaborador();

		ValidacaoDeDatas validaData = new ValidacaoDeDatas();

		p.setDataAdmissao(LocalDate.of(2002, 01, 28));
		p2.setDataAdmissao(LocalDate.of(2020, 02, 28));
		p3.setDataAdmissao(LocalDate.of(1500, 01, 28));
		p4.setDataAdmissao(LocalDate.of(2200, 01, 28));

		assertTrue(validaData.validaDataAdmissao(p));
		assertTrue(validaData.validaDataAdmissao(p2));
		assertFalse(validaData.validaDataAdmissao(p3));
		assertFalse(validaData.validaDataAdmissao(p4));
	}
}