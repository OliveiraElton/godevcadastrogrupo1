package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.Colaborador;

public class ColaboradorDAO extends Dao<Colaborador> 
							implements InterfaceDao<Colaborador> {

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
		return session.get(Colaborador.class, id);
	}

	/**
	 * Buscar Colaborador por Nome
	 * 
	 * Busca no banco o colaborador com o nome igual ao passado como parametro
	 * 
	 * @param nome Do colaborador desejado
	 * @return Colaborador desejado
	 */
	public Colaborador readByEmail(String email) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Colaborador> criteria = builder.createQuery(Colaborador.class);
		criteria.from(Colaborador.class);
		Root<Colaborador> root = criteria.from(Colaborador.class);
		Query query = session.createQuery(criteria);
		CriteriaQuery<Colaborador> rootQuery = criteria.select(root);
		Expression emailBuscado = (Expression) root.get("email");
		criteria.select(root).where(builder.equal(emailBuscado, email));
		Colaborador colaborador = (Colaborador) query.getSingleResult();
		return colaborador;
	}
	
	public List<Colaborador> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Colaborador> criteria = builder.createQuery(Colaborador.class);
		criteria.from(Colaborador.class);
		List<Colaborador> colaborador = session.createQuery(criteria).getResultList();
		return colaborador;
	}

}