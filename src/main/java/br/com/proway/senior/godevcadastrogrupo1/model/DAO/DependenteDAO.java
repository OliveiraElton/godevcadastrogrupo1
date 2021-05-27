package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
/**
 * DependenteDAO.
 * 
 * Classe de interacao com o banco de dados atraves do Hibernate.
 * Extende a classe {@link Dao} que possui os metodos CRUD.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 *
 */
public class DependenteDAO extends Dao<Dependente> {

	protected static DependenteDAO instancia;
	
	
	public static DependenteDAO getInstance(Session session) {
		if (instancia == null)
			instancia = new DependenteDAO(session);
		return instancia;
	}

	/**
	 * Contrutor da classe que recebe uma Session como parametro para conexao com o 
	 * Hibernate.
	 * 
	 * @param Seseion session
	 */
	private DependenteDAO(Session sessao) {
		this.session = sessao;
	}

	/**
	 * Buscar dependentes conforme ID do colaborador.
	 * 
	 * Metodos retorna os dependentes relacionados a determinado colaborador,
	 * conforme ID informada via parametro.
	 * 
	 * @param id Identificacao do colaborador.
	 * @return lista de dependentes do colaborador.
	 */
	public List<Dependente> buscarDependentesPorIdColaborador(Integer id) {
		ColaboradorDAO colabDAO = new ColaboradorDAO(BDConexao.getSessao());
		Colaborador colabRetornado = colabDAO.consultarPorId(Colaborador.class, id);
		return colabRetornado.getDependente();
	}
	
	
	
}
	
	
		