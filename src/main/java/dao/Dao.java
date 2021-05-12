package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

public class Dao<T> implements InterfaceDao<T>{

	private static Dao instance;
	private Session session;
	
	public static Dao getInstance(Session session) {
		if (instance == null)
			instance = new Dao(session);
		return instance;
	}
	
	private Dao(Session session) {
		this.session = session;
	}

	public T create(T item) {
		session.save(item);
		return item;
	}

	public T readById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(T.class);
		criteria.from(T.class);
		List<T> select = session.createQuery(criteria).getResultList();
		return select;
	}

	public boolean delete(T item) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
		return false;
	}

	public Integer update(T item) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
		return null;
	}
	
}
