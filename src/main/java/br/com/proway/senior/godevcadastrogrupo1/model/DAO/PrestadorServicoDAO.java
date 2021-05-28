package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;

public class PrestadorServicoDAO extends Dao<PrestadorServico>{

	protected static PrestadorServicoDAO instance;

	public static PrestadorServicoDAO getInstance(Session session) {
		if (instance == null)
			instance = new PrestadorServicoDAO(session);
		return instance;
	}

	private PrestadorServicoDAO(Session session) {
		this.session = session;
	}


}
