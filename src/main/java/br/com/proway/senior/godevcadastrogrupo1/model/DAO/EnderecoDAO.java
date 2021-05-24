 package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;

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
	 * Buscar Endereço por Id.
	 * 
	 * Busca no banco o Endereço com o id igual ao passado como parametro.
	 * 
	 * @param id Do endereço desejado
	 * @return Endereço desejado
	 */
	public Endereco readById(Integer id) {
		return session.get(Endereco.class, id);
	}

	/**
	 * Buscar todos os Endereços.
	 * 
	 * Busca no banco de dados todos os endereços cadastrados.
	 * 
	 */
	public List<Endereco> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Endereco> criteria = builder.createQuery(Endereco.class);
		criteria.from(Endereco.class);
		List<Endereco> endereco = session.createQuery(criteria).getResultList();
		return endereco;
	}
	
	/**
	 * Deletar todos os enderecos.
	 * 
	 * Metodo deleta todos os registros de enderecos constantes no banco de dados.
	 * 
	 * @return boolean false, caso nenhum registro tenha sido deletado e true caso ao menos
	 * um registro tenha sido deletado.
	 */
	public boolean deleteAll() {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE endereco CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
	
}