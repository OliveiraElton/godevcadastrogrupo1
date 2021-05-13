package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import enums.EMOutros;
import enums.EMOutros.TiposExames;
import model.ExameMedico;
import persistence.DBConnection;

public class ExameMedicoDAOTest {

	Session session = DBConnection.getSession();
	ExameMedicoDAO dao = ExameMedicoDAO.getInstance(session);
	static TiposExames exameAdm = EMOutros.TiposExames.ADMISSIONAL;
	static TiposExames exameDem = EMOutros.TiposExames.DEMISSIONAL;
	static LocalDate data = LocalDate.now();
	
	@Before
	public void limparExameMedico() {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.createSQLQuery("DELETE FROM ExameMedico;").executeUpdate();
		session.getTransaction().commit();
	}

	@Test
	public void testReadById() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.create(exameMedico);
		assertEquals(exameMedico, dao.readById(exameMedico.getId()));
	}

	@Test
	public void testGetAll() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		ExameMedico exameMedico2 = new ExameMedico(exameDem, data, true);
		dao.create(exameMedico);
		dao.create(exameMedico2);
		assertEquals(2, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		assertEquals(exameMedico.getTipoExame(), dao.create(exameMedico).getTipoExame());
		assertEquals(1, dao.getAll().size());
	}

	@Test
	public void testDelete() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		ExameMedico exameMedico2 = new ExameMedico(exameDem, data, true);
		dao.create(exameMedico);
		dao.create(exameMedico2);
		assertEquals(true, dao.delete(exameMedico));
		assertEquals(exameMedico2, dao.getAll().get(0));
		assertEquals(1, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.create(exameMedico);
		exameMedico.setTipoExame(exameDem);
		assertEquals(exameMedico, dao.update(exameMedico));
	}

}
