package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.BeforeClass;
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
	static ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static IdentidadeGenero ig = EMDadosPessoais.IdentidadeGenero.TRANS;
	static TiposExames em = EMOutros.TiposExames.ADMISSIONAL;
	static Conta conta = new Conta(null, null, null, null);
	static Endereco endereco = new Endereco(null, null, null, null, null, null, 
			null, null);
	static Contatos contatos = new Contatos(null, null, null, null);
	static ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
	
	@BeforeClass
	public static void criarTabelas() {
		daoConta.create(conta);
		daoContatos.create(contatos);
		daoEndereco.create(endereco);
		daoExameMedico.create(exameMedico);
	}
	
	@Ignore
	public void testReadById() {
		dao.create(colaborador);
		assertEquals(colaborador, dao.readById(1));
	}

	@Ignore
	public void testGetAll() {
		dao.create(colaborador);
		assertEquals(1, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
				null, false, null, ig, endereco, null, null, contatos, null, null, 
				false, false, null, false, null, null, null, conta, exameMedico);	
		assertEquals(colaborador, dao.create(colaborador));
	}

	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
