package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

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

	
	
	@Test
	public void testBuscarEmpresaPorID() {
		Endereco endereco = new Endereco("Rua Sete de Setembro", 123, "Taruma Office", "89035193", "Centro", "Brasil", "Blumenau", "SC");
		Contatos contatos = new Contatos("47999448899", "47988994455", "proway@proway.com", "47988553322");
		Empresa original = new Empresa("Proway", LocalDate.of(2021, 10, 13), "89123987000112", endereco, contatos);
		EmpresaDTO dto = new EmpresaDTO(original);
	}

	
	@Before
	public void limparTabela() {
		Session session = DBConnection.getSession();
		EmpresaDAO dao = EmpresaDAO.getInstance(session);
		dao.deletarTodasEmpresas();
	}
	
}
