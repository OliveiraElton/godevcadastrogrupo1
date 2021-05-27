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
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

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
