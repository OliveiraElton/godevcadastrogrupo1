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
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Classe ColaboradorDAO.
 * 
 * Classe de interação com o banco de dados via hibernate. Extende a {@link Dao} e
 * implementa a interface {@link InterfaceDao}.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6 
 *
 */
public class ColaboradorDAO extends Dao<Colaborador> implements InterfaceDao<Colaborador> {

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
	 * Contrutor da classe, será utilizado para iniciar a sessao,
	 * quando chamado em outras classes.
	 * 
	 * @param Session session
	 */
	public ColaboradorDAO(Session session) {
		this.session = session;
	}

	/**
	 * Buscar Colaborador por Id
	 * 
	 * Busca no banco o colaborador com o id igual ao passado como parametro
	 * 
	 * @param id Do colaborador desejado
	 * @return Colaborador desejado
	 */
	public Colaborador readById(Integer id) {
		return session.get(Colaborador.class, id);
	}

	/**
	 * Buscar Colaborador por email corporativo
	 * 
	 * Busca no banco o colaborador com o email corporativo igual ao passado como parametro
	 * 
	 * @param email corporativo Do colaborador desejado
	 * @return Colaborador desejado
	 */
	public List<Colaborador> readByEmail(String email) {
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
	
	/**
	 * Buscar todos os colaboradores.
	 * 
	 * Método busca todos os registros de colaboradores constantes no banco
	 * e retorna em uma lista.
	 * 
	 * @return List colaborador lista de colaboradores cadastrados.
	 */
	public List<Colaborador> getAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Colaborador> criteria = builder.createQuery(Colaborador.class);
		criteria.from(Colaborador.class);
		List<Colaborador> colaborador = session.createQuery(criteria).getResultList();
		return colaborador;
	}
	
	
	/**
	 * Deletar todos os colaboradores.
	 * 
	 * Metodo deleta todos os registros de colaboradores constantes no banco de dados.
	 * 
	 * @return boolean false, caso nenhum registro tenha sido deletado e true caso ao menos
	 * um registro tenha sido deletado.
	 */
	public boolean deleteAll() {
		if (!this.session.getTransaction().isActive()) {
			this.session.beginTransaction();
		}
		int modificados = this.session.createSQLQuery("TRUNCATE colaborador CASCADE").executeUpdate();
		this.session.getTransaction().commit();
		return modificados > 0 ? true : false;
	}
		
	/**
	 * Buscar colaborador por nome.
	 * 
	 * Metodo busca os colaboradores no banco de dados atraves dos seus respectivos nomes,
	 * eh possivel passar um parametro parcial para retorna todos os registros que contenham
	 * determinado texto em seu nome.
	 * 
	 * @param nomeColaborador nome do(s) colaborador(es) procurado(s).
	 * @return resultados lista de registros localizados.
	 */
	public List<Colaborador> buscarPorNome(String nomeColaborador){
		Session session = DBConnection.getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Colaborador> criteria = criteriaBuilder.createQuery(Colaborador.class);	
		Root<Colaborador> root = criteria.from(Colaborador.class);
		Expression<String> coluna = root.get("nome");
		String filtro = "%" + nomeColaborador + "%";
		criteria.select(root).where(criteriaBuilder.like(coluna, filtro));	
		Query query = session.createQuery(criteria);
		List<Colaborador> resultados = query.getResultList();
		return new ArrayList<Colaborador>(resultados);
	}

}