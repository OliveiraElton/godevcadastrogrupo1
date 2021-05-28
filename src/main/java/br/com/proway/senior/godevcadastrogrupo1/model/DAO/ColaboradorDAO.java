package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;

/**
 * Classe ColaboradorDAO.
 * 
 * Classe de interacao com o banco de dados via hibernate. Extende a {@link Dao} e
 * implementa a interface {@link InterfaceDao}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6 
 *
 */
public class ColaboradorDAO extends Dao<Colaborador>{

	protected static ColaboradorDAO instance;

	public static ColaboradorDAO getInstance(Session session) {
		if (instance == null)
			instance = new ColaboradorDAO(session);
		return instance;
	}
	
	/**
	 * Contrutor da classe, sera utilizado para iniciar a sessao,
	 * quando chamado em outras classes.
	 * 
	 * @param Session session
	 */
	public ColaboradorDAO(Session session) {
		this.session = session;
	}
	
	public List<Colaborador> buscarPorEmail(String email) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Colaborador> criteria = builder.createQuery(Colaborador.class);
		Root<Colaborador> root = criteria.from(Colaborador.class);
		CriteriaQuery<Colaborador> rootQuery = criteria.select(root);
		Expression emailBuscado = (Expression) root.get("email_corporativo");
		criteria.select(root).where(builder.equal(emailBuscado, email));
		Query query = session.createQuery(criteria);
		List<Colaborador> colaborador = query.getResultList();
		return colaborador;
	}


}