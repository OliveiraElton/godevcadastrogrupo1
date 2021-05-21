package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
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

	
	
	@Test
	public void testBuscarEmpresaPorID() {
		fail("Not yet implemented");
	}

	
	@Before
	public void limparTabela() {
		Session session = DBConnection.getSession();
		EmpresaDAO dao = EmpresaDAO.getInstance(session);
		dao.deletarTodasEmpresas();
	}
	
}
