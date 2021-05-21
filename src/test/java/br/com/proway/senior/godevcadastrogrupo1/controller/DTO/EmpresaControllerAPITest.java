package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
 * Realiza os testes dos métodos da classe {@link EmpresaControllerAPI}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaControllerAPITest {
	
	EmpresaController controllerOriginal = new EmpresaController();
	EmpresaControllerAPI controllerApi = new EmpresaControllerAPI();
	EmpresaDAO dao = new EmpresaDAO(DBConnection.getSession());
	
	
	@Test
	public void testBuscarEmpresaPorID() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa original = new Empresa("Proway", LocalDate.of(2021, 10, 13), "89123987000112", endereco, contatos);
		Empresa empresaCriada = dao.create(original);
		EmpresaDTO dtoRetornada = controllerApi.buscarEmpresaPorId(empresaCriada.getId());
		assertEquals(empresaCriada.getNomeEmpresa(), dtoRetornada.getNomeEmpresa());
		assertEquals(empresaCriada.getCnpj(), dtoRetornada.getCnpj());
		assertEquals(empresaCriada.getDataInicioContrato(), dtoRetornada.getDataInicioContrato());
		assertEquals(empresaCriada.getEndereco(), dtoRetornada.getEndereco());
		assertEquals(empresaCriada.getContato(), dtoRetornada.getContato());	
	}

	
//	@Before
//	public void limparTabela() {
//		Session session = DBConnection.getSession();
//		EmpresaDAO dao = EmpresaDAO.getInstance(session);
//		dao.deleteAll();
//	}
//	
}
