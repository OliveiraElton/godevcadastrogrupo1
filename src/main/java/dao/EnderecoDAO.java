package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Endereco;

public class EnderecoDAO extends Dao<Endereco> implements InterfaceDao<Endereco>{

	protected static EnderecoDAO instance;
	

	public static EnderecoDAO getInstance(Session session) {
		if (instance == null)
			instance = new EnderecoDAO(session);
		return instance;
	}

	private EnderecoDAO(Session session) {
		this.session = session;
	}
	
	/**
	 * Buscar Endereço por Id
	 * 
	 * Busca no banco o Endereço com o id igual ao passado como parametro
	 * 
	 * @param id Do endereço desejado
	 * @return Endereço desejado
	 */
	public Endereco readById(Integer id) {
		return session.get(Endereco.class, id);
	}

	/**
	 * Buscar tods os Endereços
	 * Busca no banco de dados tdos os endereços cadastrados
	 * 
	 */
	public List<Endereco> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Endereco> criteria = builder.createQuery(Endereco.class);
		criteria.from(Endereco.class);
		List<Endereco> endereco = session.createQuery(criteria).getResultList();
		return endereco;
	}
	
	
}