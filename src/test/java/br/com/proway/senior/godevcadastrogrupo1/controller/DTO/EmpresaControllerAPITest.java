package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.EmpresaController;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EmpresaDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
/**
 * Classe EmpresaControllerAPITest.
 * 
 * Realiza os testes dos m�todos da classe {@link EmpresaControllerAPI}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaControllerAPITest {
	
	EmpresaController controllerOriginal = new EmpresaController();
	EmpresaControllerAPI controllerApi = new EmpresaControllerAPI();
	EmpresaDAO dao = new EmpresaDAO(DBConnection.getSession());
	
	
	@Test
	public void testBuscarEmpresaPorID() throws Exception {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa original = new Empresa("Proway", LocalDate.of(2021, 10, 13), "05.975.585/0001-89", endereco, contatos);
		Empresa empresaCriada = dao.create(original);
		EmpresaDTO dtoRetornada = controllerApi.buscarEmpresaPorId(empresaCriada.getId());
		assertEquals(empresaCriada.getNomeEmpresa(), dtoRetornada.getNomeEmpresa());
		assertEquals(empresaCriada.getCnpj(), dtoRetornada.getCnpj());
		assertEquals(empresaCriada.getDataInicioContrato(), dtoRetornada.getDataInicioContrato());
		assertEquals(empresaCriada.getEndereco(), dtoRetornada.getEndereco());
		assertEquals(empresaCriada.getContato(), dtoRetornada.getContato());	
	}

	@Test
	public void testBuscarTodasEmpresa() throws Exception {
		Endereco endereco1 = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos1 = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa original1 = new Empresa("Proway", LocalDate.of(2021, 10, 13), "05.975.585/0001-89", endereco1, contatos1);
		dao.create(original1);
		Endereco endereco2 = new Endereco("Rua Sete de Setembro", 789, "Nada consta", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47999448899", "47988994455", "contato@shopping.com", "47988553322");
		Empresa original2 = new Empresa("Neumarket Shopping", LocalDate.of(2019, 9, 13), "05.975.585/0001-89", endereco2, contatos2);
		dao.create(original2);
		ArrayList<EmpresaDTO> listaRetorno = (ArrayList<EmpresaDTO>) controllerApi.buscarTodasEmpresas();
		assertFalse(listaRetorno.isEmpty());
	}
	
	@Test
	public void testBuscarEmpresaPorNome() throws Exception {
		Endereco endereco1 = new Endereco("Rua XV", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos1 = new Contatos("47999448899", "47988994455", "contato@magalu.com", "47988553322");
		Empresa original1 = new Empresa("Magalu Rua XV", LocalDate.of(2021, 10, 13), "05.975.585/0001-89", endereco1, contatos1);
		Empresa empresaCriada1 = dao.create(original1);
		Endereco endereco2 = new Endereco("Rua Sete", 789, "Nada consta", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos2 = new Contatos("47999448899", "47988994455", "contato@magalu.com", "47988553322");
		Empresa original2 = new Empresa("Magalu Centro", LocalDate.of(2019, 9, 13), "05.975.585/0001-89", endereco2, contatos2);
		Empresa empresaCriada2 = dao.create(original2);
		ArrayList<EmpresaDTO> listaRetorno = (ArrayList<EmpresaDTO>) controllerApi.buscarEmpresaPorNome("Magalu");
		assertEquals(2, listaRetorno.size());
		assertEquals(empresaCriada1.getNomeEmpresa(), listaRetorno.get(0).getNomeEmpresa());
		assertEquals(empresaCriada1.getContato(), listaRetorno.get(0).getContato());
		assertEquals(empresaCriada1.getEndereco().getLogradouro(), listaRetorno.get(0).getEndereco().getLogradouro());
		assertEquals(empresaCriada2.getNomeEmpresa(), listaRetorno.get(1).getNomeEmpresa());
		assertEquals(empresaCriada2.getCnpj(), listaRetorno.get(1).getCnpj());
		assertEquals(empresaCriada2.getEndereco().getLogradouro(), listaRetorno.get(1).getEndereco().getLogradouro());
	}
	
	@Test
	public void testCriarEmpresa() throws Exception {
		Endereco endereco1 = new Endereco("Rua XV", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos1 = new Contatos("47999448899", "47988994455", "contato@magalu.com", "47988553322");
		Empresa original1 = new Empresa("Magalu Rua XV", LocalDate.of(2021, 10, 13), "05.975.585/0001-89", endereco1, contatos1);
		Empresa empresaCriada1 = controllerApi.criarEmpresa(original1);
		assertEquals(original1.getDataInicioContrato(), empresaCriada1.getDataInicioContrato());
		assertEquals(original1.getEndereco(), empresaCriada1.getEndereco());
		assertEquals(original1.getNomeEmpresa(), empresaCriada1.getNomeEmpresa());
	}
	
	@Test
	public void testDeletarEmpresa() throws Exception {
		Endereco endereco1 = new Endereco("Rua XV", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos1 = new Contatos("47999448899", "47988994455", "contato@magalu.com", "47988553322");
		Empresa original1 = new Empresa("Magalu Rua XV", LocalDate.of(2021, 10, 13), "05.975.585/0001-89", endereco1, contatos1);
		Empresa empresaCriada1 = controllerApi.criarEmpresa(original1);
		controllerApi.deleteEmpresa(empresaCriada1.getId());
		assertTrue(controllerApi.buscarTodasEmpresas().isEmpty());
	}
	
	@Test
	public void testAtualizarEmpresa() throws Exception {
		Endereco endereco1 = new Endereco("Rua XV", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos1 = new Contatos("47999448899", "47988994455", "contato@magalu.com", "47988553322");
		Empresa original1 = new Empresa("Magalu Rua XV", LocalDate.of(2021, 10, 13), "05.975.585/0001-89", endereco1, contatos1);
		Empresa empresaCriada1 = controllerApi.criarEmpresa(original1);
		empresaCriada1.setNomeEmpresa("Magula Loja");
		controllerApi.atualizarEmpresa(empresaCriada1);
		assertEquals("Magula Loja", empresaCriada1.getNomeEmpresa());
	}
	
	
	@Before
	public void limparTabela() {
		dao.deleteAll();
	}
	
}
