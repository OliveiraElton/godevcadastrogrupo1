package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.PrestadorServico;

public class PrestadorServicoDAO extends Dao<PrestadorServico> implements InterfaceDao<PrestadorServico> {

	protected static PrestadorServicoDAO instance;

	public static PrestadorServicoDAO getInstance(Session session) {
		if (instance == null)
			instance = new PrestadorServicoDAO(session);
		return instance;
	}

	private PrestadorServicoDAO(Session session) {
		this.session = session;
	}

	/**
	 * Buscar PrestadorServico por Id
	 * 
	 * Busca no banco o PrestadorServico com o id igual ao passado como parametro
	 * 
	 * @param id Do PrestadorServico desejado
	 * @return PrestadorServico desejado
	 */
	public PrestadorServico readById(Integer id) {
		return session.get(PrestadorServico.class, id);
	}

	/**
	 * Buscar todos os PrestadorServico Busca no banco de dados todos os
	 * PrestadorServico cadastrados
	 * 
	 */
	public List<PrestadorServico> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PrestadorServico> criteria = builder.createQuery(PrestadorServico.class);
		criteria.from(PrestadorServico.class);
		List<PrestadorServico> prestadorServico = session.createQuery(criteria).getResultList();
		return prestadorServico;
	}

}
