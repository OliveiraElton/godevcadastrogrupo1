package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.DependenteController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class DependenteSimplificadoControllerApiTest{
	
	static LocalDate data;
	static Session session;
	static DependenteDAO dao;
	static ColaboradorDAO daoColab;
	static DependenteSimplificadoControllerApi dependenteApi;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	data = LocalDate.of(2002, 01, 28);
	session = DBConnection.getSession();
	dao = DependenteDAO.getInstance(session);
	daoColab = ColaboradorDAO.getInstance(session);
	dependenteApi = new DependenteSimplificadoControllerApi();
	
	}

	@Before
	public void limpaTabela() {
		DependenteController.limparTabela();
	}
	@Test
	public void testBuscarDependentePorId() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		DependenteSimplificadoDTO dependenteDTO = new DependenteSimplificadoDTO(dependente);
		assertEquals(dependenteDTO.getId(), dependenteApi.buscarDependentePorId(dependenteDTO.getId()).getId());
	}

	@Test
	public void testBuscarDependentePorIdColaborador() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		Conta conta = new Conta(null, null, null, null);
		String email = "teste@gmail.com";
		Contatos contatos = new Contatos(null, null, email, null);
		ExameMedico exameMedico = new ExameMedico(null, LocalDate.now(), true);
		Colaborador colaborador = new Colaborador("Lucas", "Nunes", "luquinha", data, "Americano", "burro", false,
				"Masculino", null, endereco, "21164028324", "45124563", contatos, null, null, false, false, data, false,
				null, "lucas.nunes@senior.com.br", "554555", conta, exameMedico, dependente);
		daoColab.create(colaborador);
		dao.create(dependente);
		DependenteSimplificadoDTO dependenteDTO = new DependenteSimplificadoDTO(dependente);
		Integer idColaborador = colaborador.getId();
		assertEquals(1, dependenteApi.buscarDependentePorIdColaborador(idColaborador).size());
	}
	
	@Test
	public void testBuscarTodosDependentes() {
		Endereco endereco = new Endereco(null, null, null, "54215365", null, null, null, null);
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Teste todos dependentes",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente);
		Dependente dependente2 = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Teste todos dependentes",
				"Cidade del Leste", true, null, null, endereco, "09619039610", null, null, true);
		dao.create(dependente2);
		List<DependenteSimplificadoDTO> listaDependenteDTO = new ArrayList<DependenteSimplificadoDTO>();
		listaDependenteDTO.add(new DependenteSimplificadoDTO(dependente));
		listaDependenteDTO.add(new DependenteSimplificadoDTO(dependente2));
		assertEquals(listaDependenteDTO.size(), dependenteApi.buscarTodosDependentes().size());

	}

}
