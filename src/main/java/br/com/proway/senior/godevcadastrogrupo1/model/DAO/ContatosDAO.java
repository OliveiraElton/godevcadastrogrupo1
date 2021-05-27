package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;

public class ContatosDAO extends Dao<Contatos>{


	protected static ContatosDAO instance;
	

	/**
	 * Singleton
	 * 
	 * @param session
	 * @return
	 */
	public static ContatosDAO getInstance(Session session) {
		if (instance == null)
			instance = new ContatosDAO(session);
		return instance;
	}

	public ContatosDAO(Session session) {
		this.session = session;
	}
	
	public List<Contatos> buscarPorEmail(String email) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Contatos> criteria = builder.createQuery(Contatos.class);
		Root<Contatos> root = criteria.from(Contatos.class);

		CriteriaQuery<Contatos> rootQuery = criteria.select(root);
	
		Expression emailBuscado = (Expression) root.get("email");
		criteria.select(root).where(builder.equal(emailBuscado, email));
		Query query = session.createQuery(criteria);
		List<Contatos> contatos = query.getResultList();
		return contatos;
	}
	
}