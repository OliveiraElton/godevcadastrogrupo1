package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;

/**
 * Classe ColaboradorDAO.
 * 
 * Classe de intera��o com o banco de dados via hibernate. Extende a {@link Dao} e
 * implementa a interface {@link InterfaceDao}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6 
 *
 */
public class ColaboradorDAO extends Dao<Colaborador>{

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
	
	/**
	 * Contrutor da classe, ser� utilizado para iniciar a sessao,
	 * quando chamado em outras classes.
	 * 
	 * @param Session session
	 */
	public ColaboradorDAO(Session session) {
		this.session = session;
	}


}