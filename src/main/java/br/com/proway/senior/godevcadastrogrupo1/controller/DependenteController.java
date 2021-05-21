package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;

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
	static DependenteDAO daoDependente = DependenteDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);

	/**
	 * Criar Dependente.
	 * 
	 * Recebe os dados do dependente separados, cria todos os dados e chama os DAO
	 * necessários para a criação do dependente, por fim chama o DAO do dependente
	 * para salvar no banco.
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
	public static Dependente criarDependente(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, TiposDependentes tipoDependente,
			boolean optanteIR, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf) {

		PessoaBuilder builder = new PessoaBuilder();
		Director.criarDependente(builder, nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade,
				pcd, genero, identidadeGenero, cpf, rg, logradouro, numero, complemento, cep, bairro, pais, cidade, uf,
				tipoDependente, optanteIR);
		Dependente dependente = (Dependente) builder.build();
		
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
	public static Dependente atualizarDependente(Integer id, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, TiposDependentes tipoDependente,
			boolean optanteIR, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf) {
		PessoaBuilder builder = new PessoaBuilder(); 
		Director.criarDependente(builder, nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade,
				pcd, genero, identidadeGenero, cpf, rg, logradouro, numero, complemento, cep, bairro, pais, cidade, uf,
				tipoDependente, optanteIR);
		Dependente dependente = (Dependente) builder.build();
		dependente.setId(id);
		return daoDependente.update(dependente);
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
	 * Busca o Dependente relacionado ao Colaborador cujo id é igual ao passado como
	 * parâmetro.
	 * 
	 * @param id do Colaborador desejado.
	 * 
	 * @return Dependente ou null caso não encontrado.
	 */
	public static List<Dependente> buscarTodosDependente() {
		return daoDependente.getAll();
	}
	
	public static List<Dependente> buscarDependentePorNome(String nome) {
		return daoDependente.buscarPorNome(nome);
	}
	public static List<Dependente> buscarDependentePorIdColaborador(Integer id){
		return daoDependente.readByIdColab(id);
	}
	/**
	 * Busca todos os dependentes do banco de dados.
	 * 
	 * @return List de {@link Dependente}
	 */
	public static List<Dependente> buscarTodosDependentes(){
		return daoDependente.getAll();
	}
	/**
	 * Limpa a tabela para testes.
	 * 
	 */
	public static void limparTabela() {
		daoDependente.limparTabela();
	}

}
