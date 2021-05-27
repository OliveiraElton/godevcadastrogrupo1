package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

public class Dao<T> implements InterfaceDao<T>{

	protected Session session;	

	/**
	 * Metodo para inserir dados no banco de dados.
	 * 
	 * Metodo para inserir informacoes no banco de dados, funciona de forma
	 * generica de acordo com a classe DAO que vai herdar esta classe.
	 * 
	 * @param item
	 * @return Item criado	
	 */
	public T cadastrar(T item) {
		try {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		return item;
		}catch(Exception e) {
			session.clear();
			e.getMessage();
		}
		return null;
	}

	/**
	 * Metodo para deletar dados no banco de dados.
	 * 
	 * Metodo para deletar informações no banco de dados, funciona de forma
	 * generica de acordo com a classe DAO que vai herdar esta classe, 
	 * e utiliza o objeto recebido como parametro para saber qual item deletar.
	 * 
	 * @param item
	 * @return
	 */
	public boolean deletar(T item) {
		session.clear();
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
		return true;
	
	}

	/**
	 * Metodo para atualizar informaçoes no banco de dados.
	 * 
	 * Metodo para atualizar informacoes no banco de dados, funciona de forma
	 * generica de acordo com a classe DAO que vai herdar esta classe, 
	 * e utiliza o objeto recebido como parametro para saber qual Objeto atualizar.
	 * 
	 * @param item
	 * @return
	 */
	public T atualizar(T item) {
		try {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
		return item;
		}catch(Exception e) {
			e.getMessage();
			session.clear();
		}
		return item;
	}
	
	/**
	 * Metodo para consultar um ID no banco de dados.
	 * 
	 * Metodo para consultar informacao no banco de dados que funciona de forma generica de acordo com a acao da classe DAO
	 * que vai herdar esta classe, e consulta o objeto retornado por meio dos parametros passados para consultar uma
	 * informacao.
	 * 
	 * @param nomeClasse
	 * @param id
	 * @return
	 */
	public T consultarPorId (Class<T> item, Integer id) {
		return session.get(item, id);
	}
	
	/**
	 * Metodo para consultar todos os registros.
	 * 
	 * Metodo para consultar todos os registros da classe seleciona como parametro do banco de dados.
	 * 
	 * @param nomeClasse
	 * @return
	 * 
	 */
	public List<T> consultarTodos(Class<T> item) {
		session = BDConexao.getSessao();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = criteriaBuilder.createQuery(item);
		criteria.from(item);
		Query query = session.createQuery(criteria);
		List<T> result = query.getResultList();
		return new ArrayList<T>(result);	
	}

	@Override
	public boolean deletarTodos(String tabela) {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE "+tabela+" CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}

	@Override
	public List<T> consultarPorNome(Class<T> item, String nome) {
			Session session = BDConexao.getSessao();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = criteriaBuilder.createQuery(item);
			
			Root<T> root = criteria.from(item);
			Expression<String> selectedColumn = root.get("nome");
			
			String filter = "%" + nome + "%";
			criteria.select(root)
				.where(criteriaBuilder.like(selectedColumn, filter));
				
			Query query = session.createQuery(criteria);
			List<T> results = query.getResultList();
			return new ArrayList<T>(results);
	}
}