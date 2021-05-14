package controller;

import java.time.LocalDate;

import org.hibernate.Session;

import dao.ColaboradorDAO;
import dao.ContaDAO;
import dao.ContatosDAO;
import dao.DependenteDAO;
import dao.EnderecoDAO;
import dao.ExameMedicoDAO;
import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMDadosPessoais.TiposDependentes;
import model.Contatos;
import model.Dependente;
import model.Endereco;
import persistence.DBConnection;

/**
* Controller do dependente.
*
* Classe que faz a comunicação dos dados recebidos com os dao relacionados ao
* dependente.
* 
* @author Bruno Marques <brunoliveira.marques@gmail.com
*
*/
public class DependenteController {
	
	static Session session = DBConnection.getSession();
	static DependenteDAO daoDependente= DependenteDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	
		
	/**
	 * Criar Dependente. 
	 * 
	 * Recebe os dados do dependente separados, cria todos os dados e chama os 
	 * DAO necessários para a criação do dependente, por fim chama o DAO do
	 * dependente para salvar no banco.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param cpf
	 * @param rg
	 * @param idDependente
	 * @param idColaborador
	 * @param tipoDependente
	 * @param optanteIR
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * 
	 * @return Retorna o Dependente caso tenha sido cadastrado ou null caso contrário
	 */
	public static Dependente criarDependente(String nome, String sobrenome, 
			String nomeSocial, LocalDate dataDeNascimento, String nacionalidade,
			String naturalidade, boolean pcd, String genero, IdentidadeGenero 
			identidadeGenero, String cpf, String rg, Integer idDependente, 
			Integer idColaborador, TiposDependentes tipoDependente, boolean optanteIR,
			String email_corporativo, String titulo_eleitor,String logradouro, 
			Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf, String telefonePrincipal, String telefoneSecundario,
			String email, String telefoneFamiliar) {		

		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, 
				bairro, pais, cidade, uf);
			daoEndereco.create(endereco);
		
		Dependente dependente = new Dependente(nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero, 
				identidadeGenero, endereco, cpf, rg, idDependente, 
				idColaborador, tipoDependente, optanteIR);		
		
		return daoDependente.create(dependente);
	}
	
	/**
	 * Deleta Dependente.
	 * 
	 * Deleta o Dependente passado como parâmetro.
	 * 
	 * @param dependente DEpendente a ser deletado
	 * 
	 * @return true caso seja deletado ou false caso contrário
	 */
	public static boolean deleteDependente(Dependente dependente) {
		return daoDependente.delete(dependente);
	}
	
	/**
	 * Atualizar Dependente.
	 * 
	 * cria um novo dependente com os dados recebidos e os altera no dependente
	 * passado como parâmetro chamando o DAO do dependente.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param cpf
	 * @param rg
	 * @param idDependente
	 * @param idColaborador
	 * @param tipoDependente
	 * @param optanteIR
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param endereco
	 * @param contatos
	 * @return id do dependente caso seja atualizado ou false caso contrário.
	 */
	public static Integer atualizarDependente(String nome, String sobrenome, 
			String nomeSocial, LocalDate dataDeNascimento, String nacionalidade,
			String naturalidade, boolean pcd, String genero, IdentidadeGenero 
			identidadeGenero, String cpf, String rg, Integer idDependente, 
			Integer idColaborador, TiposDependentes tipoDependente, boolean optanteIR,
			String email_corporativo, String titulo_eleitor, Endereco endereco,
			Contatos contatos) {
		
		Dependente dependente = new Dependente(nome, sobrenome, nomeSocial, dataDeNascimento,
				nacionalidade, naturalidade, pcd, genero, identidadeGenero,
				endereco, cpf, rg, idDependente, idColaborador,
				tipoDependente, optanteIR);
		
		return daoDependente.update(idDependente, dependente);
	}
	
	/**
	 * Busca Dependente por id.
	 * 
	 * Busca o Dependente cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id Do dependente desejado.
	 * 
	 * @return Dependente ou null caso não encontrado. 
	 */
	public static Dependente buscarDependentePorId(Integer id) {		
		return daoDependente.readById(id);
	}
	
	/**
	 * Busca Dependente por id do Colaborador.
	 * 
	 * Busca o Dependente relacionado ao Colaborador cujo id é igual ao passado 
	 * como parâmetro.
	 * 
	 * @param id do Colaborador desejado.
	 * 
	 * @return Dependente ou null caso não encontrado. 
	 */
	public static Dependente buscarDependentePorIdColaborador(Integer id) {		
		return daoDependente.readByIdColab(id);
	}
	
	
}
