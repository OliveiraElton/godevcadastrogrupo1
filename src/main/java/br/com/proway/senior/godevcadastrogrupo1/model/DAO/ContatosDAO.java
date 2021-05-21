package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;

public class ContatosDAO extends Dao<Contatos> implements InterfaceDao<Contatos>{


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

	
	/**
	 * Busca contatos por ID
	 * 
	 * Recebe um id como parametro e busca o contato que possúi este id 
	 * no banco de dados
	 * @param Id do contato que vai buscar
	 * @return contato do id buscado, caso exista
	 */
	public Contatos readById(Integer id) {
		return session.get(Contatos.class, id);
	}

	/**
	 * Busca todos os Contatos
	 * Busca todos os contatos cadastrados no banco de dados
	 * @return Uma lista com todos os contatos cadastrados
	 */
	public List<Contatos> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Contatos> criteria = builder.createQuery(Contatos.class);
		criteria.from(Contatos.class);
		List<Contatos> contatos = session.createQuery(criteria).getResultList();
		return contatos;
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
	
	public boolean deleteAll() {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE contatos CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
}