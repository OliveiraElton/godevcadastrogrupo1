package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;

/**
 * EmpresaDAO.
 * 
 * Classe de interação com o banco de dados através do Hibernate.
 * Extende a classe {@link Dao} que possui os métodos create, update e delete..
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 *
 */

public class EmpresaDAO extends Dao<Empresa> {

	protected static EmpresaDAO instancia;
	
	/**
	 * Método getInstance.
	 * 
	 * Verifica se já há uma sessão instanciada e, caso não, inicia uma.
	 * 
	 * @param Session session.
	 * @return instance retorna a instância da conexão.
	 */
	public static EmpresaDAO getInstance(Session session) {
		if (instancia == null)
			instancia = new EmpresaDAO(session);
		return instancia;
	}

	/**
	 * Contrutor da classe que recebe uma Session como parâmetro para conexão com o 
	 * Hibernate.
	 * 
	 * @param Seseion session
	 */
	public EmpresaDAO(Session session) {
		this.session = session;
	}

}



	