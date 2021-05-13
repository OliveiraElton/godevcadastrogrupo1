package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.hibernate.Session;
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

	Session session = DBConnection.getSession();
	ColaboradorDAO dao = ColaboradorDAO.getInstance(session);
	static IdentidadeGenero ig = EMDadosPessoais.IdentidadeGenero.TRANS;
	static TiposExames em = EMOutros.TiposExames.ADMISSIONAL;
	static Conta conta = new Conta(null, null, null, null);
	static Endereco endereco = new Endereco(null, null, null, null, null, null, 
			null, null);
	static Contatos contatos = new Contatos(null, null, null, null);
	static ExameMedico exameMedico = new ExameMedico(em, LocalDate.now(), true);
	static Colaborador colaborador = new Colaborador("Teste", null, null, null, null,
			null, false, null, ig, endereco, null, null, contatos, null, null, 
			false, false, null, false, null, null, null, conta, exameMedico);
	
	@Test
	public void testReadById() {
		dao.create(colaborador);
		assertEquals(colaborador, dao.readById(1));
	}

	@Test
	public void testGetAll() {
		dao.create(colaborador);
		assertEquals(1, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
