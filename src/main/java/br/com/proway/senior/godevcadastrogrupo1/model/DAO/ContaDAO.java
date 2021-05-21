package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Conta;

public class ContaDAO extends Dao<Conta> implements InterfaceDao<Conta>{
	
protected static ContaDAO instance;
	

	public static ContaDAO getInstance(Session session) {
		if (instance == null)
			instance = new ContaDAO(session);
		return instance;
	}

	private ContaDAO(Session session) {
		this.session = session;
	}
	
	/**
	 * Buscar Conta por Id.
	 * 
	 * Busca no banco a Conta com o id igual ao passado como parametro.
	 * 
	 * @param id da conta desejado
	 * @return Conta desejado
	 * @author Elton F Oliveira
	 */
	public Conta readById(Integer id) {
		return session.get(Conta.class, id);
		
	}

	/**
	 * Buscar tods as Contas Bancarias.
	 * Busca no banco de dados todas as Contas Bancarias.
	 *
	 * @author Elton F Oliveira
	 */
	public List<Conta> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Conta> criteria = builder.createQuery(Conta.class);
		criteria.from(Conta.class);
		List<Conta> conta = session.createQuery(criteria).getResultList();
		return conta;
	}

	/**
	 * Deletar todas as contas.
	 * 
	 * Metodo deleta todos os registros de contas constantes no banco de dados.
	 * 
	 * @return boolean false, caso nenhum registro tenha sido deletado e true caso ao menos
	 * um registro tenha sido deletado.
	 */
	public boolean deleteAll() {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE conta CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
	
}
