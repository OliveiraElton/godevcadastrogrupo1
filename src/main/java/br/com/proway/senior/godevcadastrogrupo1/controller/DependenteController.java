package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
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
 * Classe que faz a comunicacao dos dados recebidos com os dao relacionados ao
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
	 * Cadastrar Dependente.
	 * 
	 * Recebe os dados do dependente separados, cria todos os dados e chama os DAO
	 * necessários para a criação do dependente, por fim chama o DAO do dependente
	 * para salvar no banco.
	 * 
	 * @param String nome Nome do dependente.
	 * @param String sobrenome Sobrenome do dependente.
	 * @param String nomeSocial Nome social, se houver.
	 * @param LocalDate dataDeNascimento Data de nascimento.
	 * @param String nacionalidade Nacionalidade do dependente.
	 * @param String naturalidade cidade de nascimento do dependente.
	 * @param Boolean pcd Informa se o dependente eh PCD sim (true) ou nao
	 *                         (false)
	 * @param String genero Genero.
	 * @param IdentidadeGenero identidadeGenero Identidade de genero do dependente.
	 * @param String cpf CPF do dependente (Cadastro de Pessoas Fisicas).
	 * @param String rg RG do dependente (Registro Geral).
	 * @param TiposDependente tipoDependente Define o tipo de dependente: mae, pai,
	 *                         filho, conjuge, etc.
	 * @param optanteIR Informa se o dependente sera considerado para IR sim
	 *                         (true) ou nao (false).
	 * @param String logradouro Nome do logradouro onde o dependente
	 *                         reside.
	 * @param int numero Numero da residencia do dependente.
	 * @param String complemento Complemento do endereco do dependente.
	 * @param String cep CEP da residencia do dependente.
	 * @param String bairro Bairro onde o dependente reside.
	 * @param String pais Pais onde o dependente reside.
	 * @param String cidade Cidade onde o dependente reside.
	 * @param String uf Unidade Federativa onde o dependente reside.
	 * @param String telefonePrincipal Telefone principal.
	 * @param String telefoneSecundario Telefone secundario.
	 * @param String email Email pessoal do dependente.
	 * @param String telefoneFamiliar Telefone familiar, utilizado para contato de emergencia. 
	 * @return Retorna o Dependente caso tenha sido cadastrado ou null caso contrario
	 */
	public static Dependente cadastrarDependente(String nome, String sobrenome, String nomeSocial,
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
	 * @return true caso seja deletado ou false caso contrário
	 */
	public static boolean deleteDependente(Dependente dependente) {
		return daoDependente.delete(dependente);
	}


	/**
	 * Atualizar Dependente.
	 * 
	 * cria um novo dependente com os dados recebidos e os altera no dependente
	 * passado como parametro chamando o DAO do dependente.
	 * 
	 * @param Integer id Identificacao do dependente que sera alterado.
	 * @param String nome Nome do dependente.
	 * @param String sobrenome Sobrenome do dependente.
	 * @param String nomeSocial Nome social, se houver.
	 * @param LocalDate dataDeNascimento Data de nascimento.
	 * @param String nacionalidade Nacionalidade do dependente.
	 * @param String naturalidade cidade de nascimento do dependente.
	 * @param Boolean pcd Informa se o dependente eh PCD sim (true) ou nao
	 *                         (false)
	 * @param String genero Genero.
	 * @param IdentidadeGenero identidadeGenero Identidade de genero do dependente.
	 * @param String cpf CPF do dependente (Cadastro de Pessoas Fisicas).
	 * @param String rg RG do dependente (Registro Geral).
	 * @param TiposDependente tipoDependente Define o tipo de dependente: mae, pai,
	 *                         filho, conjuge, etc.
	 * @param optanteIR Informa se o dependente sera considerado para IR sim
	 *                         (true) ou nao (false).
	 * @param String logradouro Nome do logradouro onde o dependente
	 *                         reside.
	 * @param int numero Numero da residencia do dependente.
	 * @param String complemento Complemento do endereco do dependente.
	 * @param String cep CEP da residencia do dependente.
	 * @param String bairro Bairro onde o dependente reside.
	 * @param String pais Pais onde o dependente reside.
	 * @param String cidade Cidade onde o dependente reside.
	 * @param String uf Unidade Federativa onde o dependente reside.
	 * @return Objeto do registro atualizado.
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
	 * Busca o Dependente cujo id eh igual ao passado como parametro.
	 * 
	 * @param id Do dependente desejado.
	 * 
	 * @return Dependente ou null caso nao encontrado.
	 */
	public static Dependente buscarDependentePorId(Integer id) {
		return daoDependente.readById(id);
	}
	
	/**
	 * Buscar todos os dependentes por nome.
	 * 
	 * Buscar todos os dependentes no banco de dados que tem nome igual ao
	 * passado como parametro.
	 * @param nome
	 * @return
	 */
	public static List<Dependente> buscarDependentePorNome(String nome) {
		return daoDependente.buscarPorNome(nome);
	}
	
	/**
	 * Busca Dependente por id do Colaborador.
	 * 
	 * Busca o Dependente relacionado ao Colaborador cujo id eh igual ao passado como
	 * parametro.
	 * 
	 * @param id do Colaborador desejado.
	 * @return Dependente ou null caso nao encontrado.
	 */
	public static List<Dependente> buscarDependentePorIdColaborador(Integer id){
		return daoDependente.readByIdColab(id);
	}
	
	/**
	 * Busca todos os dependentes do banco de dados.
	 * @return List de {@link Dependente}
	 */
	public static List<Dependente> buscarTodosDependentes(){
		return daoDependente.getAll();
	}
	
	/**
	 * Limpa a tabela para testes.
	 * 
	 */
	public static void deleteAll() {
		daoDependente.deleteAll();
		
	}

}
