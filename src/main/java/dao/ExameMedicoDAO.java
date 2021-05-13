package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Endereco;
import model.ExameMedico;

public class ExameMedicoDAO extends Dao<ExameMedico> implements InterfaceDao<ExameMedico>{

protected static ExameMedicoDAO instance;
	

	public static ExameMedicoDAO getInstance(Session session) {
		if (instance == null)
			instance = new ExameMedicoDAO(session);
		return instance;
	}

	private ExameMedicoDAO(Session session) {
		this.session = session;
	}
	
	/**
	 * Buscar ExameMedico por Id
	 * 
	 * Busca no banco o ExameMedico com o id igual ao passado como parametro
	 * 
	 * @param id Do ExameMedico desejado
	 * @return ExameMedico desejado
	 */
	public ExameMedico readById(Integer id) {
		return session.get(ExameMedico.class, id);
	}

	/**
	 * Buscar tods os ExameMedico
	 * Busca no banco de dados tdos os Exames Medicos cadastrados
	 * 
	 */
	public List<ExameMedico> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ExameMedico> criteria = builder.createQuery(ExameMedico.class);
		criteria.from(ExameMedico.class);
		List<ExameMedico> exameMedico = session.createQuery(criteria).getResultList();
		return exameMedico;
	}

	
}
