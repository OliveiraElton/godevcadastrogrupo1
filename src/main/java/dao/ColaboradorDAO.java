package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Colaborador;

public class ColaboradorDAO extends Dao<Colaborador> implements InterfaceDao<Colaborador>{

	protected static ColaboradorDAO instance;
	
	/**
	 * Method responsible for instantiating the CollaboratorDAO class.
	 * 
	 * @param session the database session.
	 * 
	 * @return instance
	 */
	public static ColaboradorDAO getInstance(Session session) {
		if (instance == null)
			instance = new ColaboradorDAO(session);
		return instance;
	}

	private ColaboradorDAO(Session session) {
		this.session = session;
	}
	
	/**
	 * Buscar Colaborador por Id
	 * 
	 * Busca no banco o colaborador com o id igual ao passado como parametro
	 * 
	 * @param id Do colaborador desejado
	 * @return Colaborador desejado
	 */
	public Colaborador readById(Integer id) {
		return null;
	}

	public List<Colaborador> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Colaborador> criteria = builder.createQuery(Colaborador.class);
		criteria.from(Colaborador.class);
		List<Colaborador> colaborador = session.createQuery(criteria).getResultList();
		return colaborador;
	}
	
	
}