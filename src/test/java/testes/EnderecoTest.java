package testes;

import org.junit.Test;

import enums.EMDadosGeograficos.Cidades;
import enums.EMDadosGeograficos.Pais;
import enums.EMDadosGeograficos.UF;
import model.Endereco;

public class EnderecoTest {

	@Test
	public void testeEnderecoBuilder() {
		Endereco endereco = new Endereco.EnderecoBuilder().logradouro("Rua 7 de Setembro").
				numero(461).bairro("Caldas Novas").cidade(Cidades.BLUMENAU).uf(UF.SC).
				complemento("beco no fim da rua").cep("1254789").pais(Pais.ARGENTINA).criarEndereco();
		System.out.println(endereco.toString());
	}
}