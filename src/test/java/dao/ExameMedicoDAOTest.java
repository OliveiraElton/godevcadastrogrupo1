package dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

public class ExameMedicoDAOTest {

	Session session = DBConnection.getSession();
	ExameMedicoDAO dao = ExameMedicoDAO.getInstance(session);
	static TiposExames exameAdm = EnumExamesMedicos.TiposExames.ADMISSIONAL;
	static TiposExames exameDem = EnumExamesMedicos.TiposExames.DEMISSIONAL;
	static LocalDate data = LocalDate.now();

	@Test
	public void testReadById() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.create(exameMedico);
		assertEquals(exameMedico, dao.readById(exameMedico.getId()));
	}

	@Test
	public void testGetAll() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, LocalDate.of(2021, 7, 13), false);
		ExameMedico exameMedico2 = new ExameMedico(exameDem, data, true);
		Integer valorAntes = dao.getAll().size();
		dao.create(exameMedico);
		dao.create(exameMedico2);
		assertEquals(valorAntes + 2, dao.getAll().size());
	}

	@Test
	public void testCreate() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		assertEquals(exameMedico.getTipoExame(), dao.create(exameMedico).getTipoExame());
	}

	@Test
	public void testDelete() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.create(exameMedico);
		Integer valorAntes = dao.getAll().size();
		dao.delete(exameMedico);
		assertEquals(valorAntes -1, dao.getAll().size());
	}

	@Test
	public void testUpdate() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.create(exameMedico);
		exameMedico.setTipoExame(exameDem);
		assertEquals(exameMedico, dao.update(exameMedico));
	}

}
