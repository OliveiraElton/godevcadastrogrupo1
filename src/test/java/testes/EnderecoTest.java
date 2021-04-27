package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import enums.Cidades;
import enums.Paises;
import enums.UnidadesFederativas;
import model.Endereco;

public class EnderecoTest {

	Endereco enderecoSemComplemento = new Endereco("S�tio C�rrego de Santo Ant�nio", 10, "C�rrego de Santo Antonio",
			Cidades.FLORIANOPOLIS, UnidadesFederativas.SC, "28666971", Paises.BRASIl);

	Endereco enderecoCompleto = new Endereco("Rua Jos� Delepranni, s/n", null, "Alto Caldeir�o", Cidades.PORTO_ALEGRE,
			UnidadesFederativas.RS, "Casa", "29656980", Paises.BRASIl);

	

	@Test
	public void testeEnderecoSemComplemento() {
		assertEquals("S�tio C�rrego de Santo Ant�nio", enderecoSemComplemento.getLogradouro());
		assertEquals(10, enderecoSemComplemento.getNumero().intValue());
		assertEquals("C�rrego de Santo Antonio", enderecoSemComplemento.getBairro());
		assertEquals(Cidades.FLORIANOPOLIS, enderecoSemComplemento.getCidade());
		assertEquals(UnidadesFederativas.SC, enderecoSemComplemento.getUf());
		assertEquals("28666971", enderecoSemComplemento.getCep());
		assertEquals(Paises.BRASIl, enderecoSemComplemento.getPais());
	}

	@Test
	public void testeEnderecoCompleto() {
		assertEquals("Rua Jos� Delepranni, s/n", enderecoCompleto.getLogradouro());
		assertEquals(null, enderecoCompleto.getNumero());
		assertEquals("Alto Caldeir�o", enderecoCompleto.getBairro());
		assertEquals(Cidades.PORTO_ALEGRE, enderecoCompleto.getCidade());
		assertEquals(UnidadesFederativas.RS, enderecoCompleto.getUf());
		assertEquals("Casa", enderecoCompleto.getComplemento());
		assertEquals("29656980", enderecoCompleto.getCep());
		assertEquals(Paises.BRASIl, enderecoCompleto.getPais());
	}
}