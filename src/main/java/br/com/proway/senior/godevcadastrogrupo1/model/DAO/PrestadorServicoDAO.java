package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class PrestadorServicoDAO extends Dao<PrestadorServico> implements InterfaceDao<PrestadorServico>{

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
	
	/**
	 * Buscar todos os {@link PrestadorServico} no banco de dados com nome igual
	 * ao passado como parametro.
	 * @param String nome
	 * @return List<PrestadorServico>
	 */
	public List<PrestadorServico> buscarPorNome(String nome){
			Session session = DBConnection.getSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<PrestadorServico> criteria = criteriaBuilder.createQuery(PrestadorServico.class);
			
			Root<PrestadorServico> root = criteria.from(PrestadorServico.class);
			Expression<String> selectedColumn = root.get("nome");
			
			String filter = "%" + nome + "%";
			criteria.select(root)
				.where(criteriaBuilder.like(selectedColumn, filter));
				
			Query query = session.createQuery(criteria);
			List<PrestadorServico> results = query.getResultList();
			return new ArrayList<PrestadorServico>(results);
		}
  
	/**
	 * Deletar todos os prestadores de servico.
	 * 
	 * Metodo deleta todos os registros de prestadores de servico constantes no banco de dados.
	 * 
	 * @return boolean false, caso nenhum registro tenha sido deletado e true caso ao menos
	 * um registro tenha sido deletado.
	 */

	public boolean deleteAll() {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE prestadorservico CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}

}
