package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;

public class ExameMedicoDAO extends Dao<ExameMedico> {

protected static ExameMedicoDAO instance;
	
	public static ExameMedicoDAO getInstance(Session session) {
		if (instance == null)
			instance = new ExameMedicoDAO(session);
		return instance;
	}

	private ExameMedicoDAO(Session session) {
		this.session = session;
	}
}
