package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import enums.EMDadosPessoais;
import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMOutros;
import enums.EMOutros.TiposExames;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

public class ColaboradorDAOTest {

	static Session session = DBConnection.getSession();
	ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static IdentidadeGenero ig = EMDadosPessoais.IdentidadeGenero.TRANS;
	static TiposExames em = EMOutros.TiposExames.ADMISSIONAL;
	Conta conta = new Conta(null, null, null, null);
	Endereco endereco = new Endereco(null, null, null, null, null, null, 
			null, null);
	String email = "teste@gmail.com";
	Contatos contatos = new Contatos(null, null, email, null);
	ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
	ExameMedico exameMedico2 = new ExameMedico(em, LocalDate.now(), false);
	
	@Before
	public void criarTabelas() {
		daoConta.create(conta);	
		daoContatos.create(contatos);
		daoEndereco.create(endereco);
		daoExameMedico.create(exameMedico);
		daoExameMedico.create(exameMedico2);
	}
	
	@Test
	public void testReadById() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico);	
		dao.create(colaborador);
		Integer id = colaborador.getId();
		assertEquals(colaborador, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		int tamanhoAntes = dao.getAll().size();
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico);	
		Colaborador colaborador1 = new Colaborador("Teste2", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico2);	
		dao.create(colaborador);
		dao.create(colaborador1);		
		assertEquals(tamanhoAntes + 2, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico);	
		assertEquals(colaborador, dao.create(colaborador));
	}

	@Test
	public void testDelete() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico);
		dao.create(colaborador);
		Integer id = colaborador.getId();
		assertEquals(true, dao.delete(colaborador));
		assertNull(dao.readById(id));
	}

	@Test
	public void testUpdate() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico);
		dao.create(colaborador);	
	}
	
	@Ignore
	public void testReadByEmail() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, "email@empresa.com.br", null, conta, exameMedico);	
		dao.create(colaborador);
		assertEquals(colaborador, dao.readByEmail("email@empresa.com.br"));
	}

}
