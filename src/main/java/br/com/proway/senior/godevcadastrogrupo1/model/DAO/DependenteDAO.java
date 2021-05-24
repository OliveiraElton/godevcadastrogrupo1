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

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;

public class DependenteDAO extends Dao<Dependente> implements InterfaceDao<Dependente>{

	protected static DependenteDAO instance;
	
		
	public static DependenteDAO getInstance(Session session) {
		if (instance == null)
			instance = new DependenteDAO(session);
		return instance;
	}

	private DependenteDAO(Session session) {
		this.session = session;
	}

	/**
	 * Buscar Dependente por Id
	 * 
	 * Busca no banco o dependente com o id igual ao passado como parametro
	 * 
	 * @param id Do dependente desejado
	 * @return Dependente desejado
	 */

	public Dependente readById(Integer id) {
		return session.get(Dependente.class, id);
	}

	public List<Dependente> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Dependente> criteria = builder.createQuery(Dependente.class);
		criteria.from(Dependente.class);
		List<Dependente> dependente = session.createQuery(criteria).getResultList();
		return dependente;
	}

	public List<Dependente> readByIdColab(Integer id) {
		Colaborador colaborador = session.get(Colaborador.class, id);
		return colaborador.getDependente();
	}
	
	public List<Dependente> buscarPorNome(String valorColuna){
		Session session = DBConnection.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Dependente> criteria = criteriaBuilder.createQuery(Dependente.class);
		
		Root<Dependente> root = criteria.from(Dependente.class);
		Expression<String> selectedColumn = root.get("nome");
		
		String filter = "%" + valorColuna + "%";
		criteria.select(root)
			.where(criteriaBuilder.like(selectedColumn, filter));
			
		Query query = session.createQuery(criteria);
		List<Dependente> results = query.getResultList();
		return new ArrayList<Dependente>(results);
	}

	public boolean limparTabela() {
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		try {
		
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaDelete<Dependente> criteriaDelete = builder.createCriteriaDelete(Dependente.class);
			criteriaDelete.from(Dependente.class);
			Query query = session.createQuery(criteriaDelete);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	/**
	 * Deletar todos os dependentes.
	 * 
	 * Metodo deleta todos os registros de dependentes constantes no banco de dados.
	 * 
	 * @return boolean false, caso nenhum registro tenha sido deletado e true caso ao menos
	 * um registro tenha sido deletado.
	 */
	public boolean deleteAll() {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE dependente CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
}
	
	
		