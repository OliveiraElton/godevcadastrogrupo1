 package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

public class EnderecoDAO extends Dao<Endereco>{

	protected static EnderecoDAO instance;
	static Session session = BDConexao.getSessao();
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ColaboradorDAO daoColaborador = ColaboradorDAO.getInstance(session);


	public static EnderecoDAO getInstance(Session session) {
		if (instance == null)
			instance = new EnderecoDAO(session);
		return instance;
	}

	private EnderecoDAO(Session session) {
		this.session = session;
	}

	
	/**
	 * Buscar Endereço por Id do colaborador.
	 * 
	 * Busca no banco o Endereço com o id do colaborador igual ao passado como parametro.
	 * 
	 * @param id Do colaborador
	 * @return Endereço desejado
	 */
		public Endereco buscarEnderecoPorIdColaborador(Integer idColaborador) {
			Colaborador colaborador = session.get(Colaborador.class, idColaborador);
			return colaborador.getEndereco();
		}
}

//		buscar colab
//		a partir do colab pegar objeto Endereco
//	}
//}