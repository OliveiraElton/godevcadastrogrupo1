package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;

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
		try {
			return session.get(ExameMedico.class, id);
		}catch(Exception e) {
			session.clear();
		}
		return null;
	}

	/**
	 * Buscar tods os ExameMedico
	 * Busca no banco de dados tdos os Exames Medicos cadastrados
	 * 
	 */
	public List<ExameMedico> getAll() {
		try {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ExameMedico> criteria = builder.createQuery(ExameMedico.class);
		criteria.from(ExameMedico.class);
		List<ExameMedico> exameMedico = session.createQuery(criteria).getResultList();
		return exameMedico;
		}catch(Exception e) {
			session.clear();
		}
		return null;
	}

	/**
	 * Deletar todos os exames medicos.
	 * 
	 * Metodo deleta todos os registros de exames medicos constantes no banco de dados.
	 * 
	 * @return boolean false, caso nenhum registro tenha sido deletado e true caso ao menos
	 * um registro tenha sido deletado.
	 */
	public boolean deleteAll() {
		try {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE examemedico CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
		}catch(Exception e) {
			session.clear();
		}
		return false;
	}
	
}
