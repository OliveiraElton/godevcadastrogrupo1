package modelDAO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

public class ExameMedicoDAOTest {

	Session session = BDConexao.getSessao();
	ExameMedicoDAO dao = ExameMedicoDAO.getInstance(session);
	static TiposExames exameAdm = EnumExamesMedicos.TiposExames.ADMISSIONAL;
	static TiposExames exameDem = EnumExamesMedicos.TiposExames.DEMISSIONAL;
	static LocalDate data = LocalDate.now();

	@Before
	public void limparTabela() {
		dao.deletarTodos("examemedico");
	}
		
	@Test
	public void testReadById() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.cadastrar(exameMedico);
		assertEquals(exameMedico.getId(), dao.consultarPorId(ExameMedico.class, exameMedico.getId()).getId());
	}

	@Test
	public void testGetAll() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, LocalDate.of(2021, 7, 13), false);
		ExameMedico exameMedico2 = new ExameMedico(exameDem, data, true);
		dao.cadastrar(exameMedico);
		dao.cadastrar(exameMedico2);
		assertEquals(2, dao.consultarTodos(ExameMedico.class).size());
	}

	@Test
	public void testCreate() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.cadastrar(exameMedico);
		assertEquals(exameMedico.getTipoExame(), dao.consultarPorId(ExameMedico.class, exameMedico.getId()).getTipoExame());
	}

	@Test
	public void testDelete() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.cadastrar(exameMedico);
		dao.deletar(exameMedico);
		assertEquals(0, dao.consultarTodos(ExameMedico.class).size());
	}

	@Test
	public void testUpdate() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		dao.cadastrar(exameMedico);
		exameMedico.setTipoExame(exameDem);
		assertEquals(exameMedico, dao.atualizar(exameMedico));
		dao.deletar(exameMedico);
	}
	
	@Test
	public void testApto() {
		ExameMedico exameMedico = new ExameMedico(exameAdm, data, true);
		LocalDate hoje = LocalDate.now();
		assertEquals(true , exameMedico.isApto());
		assertEquals(hoje , exameMedico.getDataExame());
		
	}

}
