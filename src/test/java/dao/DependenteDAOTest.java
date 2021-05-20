package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class DependenteDAOTest {

	Session session = DBConnection.getSession();
	DependenteDAO dao = DependenteDAO.getInstance(session);
	static LocalDate data = LocalDate.of(2002, 01, 28);

	@Test
	public void testReadById() {
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, null, "09619039610", null, null, true);
		dao.create(dependente);
		Integer id = dependente.getId();
		assertEquals(dependente, dao.readById(id));
	}

	@Test
	public void testGetAll() {
		int tamanhoAnterior = dao.getAll().size();
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, null, "09619039610", null, null, true);
		Dependente dependente2 = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, null, "09619039610", null, null, true);
		dao.create(dependente);
		dao.create(dependente2);
		assertEquals(tamanhoAnterior + 2, dao.getAll().size());

	}

	@Test
	public void testCreate() {
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, null, "09619039610", null, null, true);
		assertEquals(dependente, dao.create(dependente));
	}

	@Test
	public void testDelete() {
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, null, "09619039610", null, null, true);
		dao.create(dependente);
		assertEquals(true, dao.delete(dependente));
		assertNull(dao.readById(dependente.getId()));
	}
	
	@Test
	public void testUpdate() {
		Dependente dependente = new Dependente("Joãozinho", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, null, null, null, "09619039610", null, null, true);
		dao.create(dependente);
		dependente.setRg("012345678");
		assertEquals("012345678", dao.update(dependente).getRg());

	}
}
