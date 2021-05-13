package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import model.Empresa;


public class EmpresaDAO extends Dao<Empresa> implements InterfaceDao<Empresa>{

	protected static EmpresaDAO instance;
	

	public static EmpresaDAO getInstance(Session session) {
		if (instance == null)
			instance = new EmpresaDAO(session);
		return instance;
	}

	private EmpresaDAO(Session session) {
		this.session = session;
	}
	
	/**
	 * Buscar Empresa por Id
	 * 
	 * Busca no banco a Empresa com o id igual ao passado como parametro
	 * 
	 * @param id Da Empresa desejada
	 * @return Empresa desejado
	 */
	public Empresa readById(Integer id) {
		return session.get(Empresa.class, id);
	}
	/**
	 * Buscar tods os Endereços
	 * Busca no banco de dados tdos os endereços cadastrados
	 * 
	 */
	public List<Empresa> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Empresa> criteria = builder.createQuery(Empresa.class);
		criteria.from(Empresa.class);
		List<Empresa> empresa = session.createQuery(criteria).getResultList();
		return empresa;
	}
	
}



	