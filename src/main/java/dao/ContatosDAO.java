package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Contatos;
import model.Endereco;

public class ContatosDAO extends Dao<Contatos> implements InterfaceDao<Contatos>{


	protected static ContatosDAO instance;
	

	public static ContatosDAO getInstance(Session session) {
		if (instance == null)
			instance = new ContatosDAO(session);
		return instance;
	}

	private ContatosDAO(Session session) {
		this.session = session;
	}

	
	
	public Contatos readById(Integer id) {
		return session.get(Contatos.class, id);
	}

	public List<Contatos> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Contatos> criteria = builder.createQuery(Contatos.class);
		criteria.from(Contatos.class);
		List<Contatos> contatos = session.createQuery(criteria).getResultList();
		return contatos;
	}
	

	
	
	
}
