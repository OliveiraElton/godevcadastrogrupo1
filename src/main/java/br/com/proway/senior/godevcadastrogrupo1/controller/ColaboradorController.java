package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ExameMedicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

/**
 * Controller do colaborador.
 *
 * Classe que faz a comunicacao dos dados recebidos com os dao relacionados ao
 * colaborador.
 * 
 * @author Bruno Marques <brunoliveira.marques@gmail.com
 * @author Daniella Lira <dev.danilira@gmail.com>
 * @author David Hildebrnadt <davihildebran@gmail.com>
 * @author David Willian <dwillian676@gmail.com>
 * @author Elton Frncisco de Oliveira <eltonf.oliveira22@gmail.com>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6
 *
 */
public class ColaboradorController {

	static Session session = DBConnection.getSession();
	static ColaboradorDAO daoColaborador = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	static DependenteDAO daoDependente = DependenteDAO.getInstance(session);

	/**
	 * Criar Colaborador.
	 * 
	 * Recebe os dados do colaborador separdos e cria todos os dados e chama os DAO
	 * necessarios para a criacao do colaborador e por ultimo chama o DAO do
	 * colaborador para salvar no banco.
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
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
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
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 * @param nomeBanco
	 * @param agencia
	 * @param numeroConta
	 * @param digitoVerificador
	 * 
	 * @return Retorna o Colaborador caso tenha sido cadastrado ou null caso
	 *         contrário
	 */
	public static Colaborador criarColaborador(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, Boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, Integer idCargo, Integer nit, Boolean optanteVT,
			Boolean optanteVAVR, LocalDate dataAdmissao, Boolean optanteDependente, String registro_alistamento,
			String email_corporativo, String titulo_eleitor, String logradouro, Integer numero, String complemento,
			String cep, String bairro, String pais, String cidade, String uf, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, TiposExames tipoExame,
			LocalDate dataExame, Boolean apto, String nomeBanco, String agencia, String numeroConta,
			String digitoVerificador, String nomeDependente, String sobrenomeDependente, String nomeSocialDependente,
			LocalDate dataDeNascimentoDependente, String nacionalidadeDependente, String naturalidadeDependente,
			Boolean pcdDependente, String generoDependente, IdentidadeGenero identidadeGeneroDependente,
			String cpfDependente, String rgDependente, TiposDependentes tipoDependente, Boolean optanteIR) {
		
		PessoaBuilder builder = new PessoaBuilder();
		
		Director.criarColaborador(builder, nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg, idCargo, nit, optanteVT,
				optanteVAVR, dataAdmissao, optanteDependente, registro_alistamento,
				email_corporativo, titulo_eleitor, logradouro, numero, complemento,
				cep, bairro, pais, cidade, uf, telefonePrincipal,
				telefoneSecundario, email, telefoneFamiliar, tipoExame,
				dataExame, apto, nomeBanco, agencia, numeroConta,
				digitoVerificador, nomeDependente, sobrenomeDependente, nomeSocialDependente,
				dataDeNascimentoDependente, nacionalidadeDependente, naturalidadeDependente,
				pcdDependente, generoDependente, identidadeGeneroDependente,
				cpfDependente, rgDependente, tipoDependente, optanteIR);
		Colaborador colaborador = (Colaborador) builder.build();
		return daoColaborador.create(colaborador);
	}
	
	/**
	 * Adicionar Dependente
	 * 
	 * Adiciona um novo dependente, caso o colaborador tenha mais de um.
	 * 
	 * @param colaborador
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
	 * @param tipoDependente
	 * @param optanteIR
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 */
	public static void adicionarDependente(Colaborador colaborador, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, TiposDependentes tipoDependente,
			boolean optanteIR, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf) {
		
		Dependente novoDependente = DependenteController.criarDependente(nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg, tipoDependente,
				optanteIR, logradouro, numero, complemento, cep, bairro,
				pais,cidade, uf);
		
		colaborador.addDependente(novoDependente);
		daoColaborador.update(colaborador);
	}
	
	/**
	 * Adicionado Exame Medico
	 * 
	 * Adiciona novo exame medico ao colaborador, caso necessario.
	 * @param colaborador
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 */
	public static void adicionarExameMedico(Colaborador colaborador,TiposExames tipoExame, LocalDate dataExame, boolean apto){
		ExameMedico novoExame = new ExameMedico(tipoExame, dataExame, apto);
		colaborador.addExameMedico(novoExame);
		daoColaborador.update(colaborador);
	}

	/**
	 * Deletar Colaborador.
	 * 
	 * Deleta o Colaborador passado como parâmetro.
	 * 
	 * @param colaborador Colaborador a ser deletado
	 * 
	 * @return true caso seja deletado ou false caso contrário
	 */
	public static Boolean deleteColabordor(Colaborador colaborador) {
		return daoColaborador.delete(colaborador);
	}

	/**
	 * Atualizar Colaborador.
	 * 
	 * cria um novo colaborador com os dados recebidos e os altera no colaborador
	 * passado como parâmetro chamando o DAO do colaborador.
	 * 
	 * @param id Do Colaborador a ser alterado.
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param endereco
	 * @param cpf
	 * @param rg
	 * @param contatos
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param conta
	 * @param exameMedico
	 * 
	 * @return id do colaborador caso seja atualizado ou false caso contrário.
	 */
	public static Colaborador atualizarColaborador(Integer id, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, Boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, Integer idCargo, Integer nit, Boolean optanteVT,
			Boolean optanteVAVR, LocalDate dataAdmissao, Boolean optanteDependente, String registro_alistamento,
			String email_corporativo, String titulo_eleitor, String logradouro, Integer numero, String complemento,
			String cep, String bairro, String pais, String cidade, String uf, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, TiposExames tipoExame,
			LocalDate dataExame, Boolean apto, String nomeBanco, String agencia, String numeroConta,
			String digitoVerificador, String nomeDependente, String sobrenomeDependente, String nomeSocialDependente,
			LocalDate dataDeNascimentoDependente, String nacionalidadeDependente, String naturalidadeDependente,
			Boolean pcdDependente, String generoDependente, IdentidadeGenero identidadeGeneroDependente,
			String cpfDependente, String rgDependente, TiposDependentes tipoDependente, Boolean optanteIR) {
		
		PessoaBuilder builder = new PessoaBuilder();
		
		Director.criarColaborador(builder, nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg, idCargo, nit, optanteVT,
				optanteVAVR, dataAdmissao, optanteDependente, registro_alistamento,
				email_corporativo, titulo_eleitor, logradouro, numero, complemento,
				cep, bairro, pais, cidade, uf, telefonePrincipal,
				telefoneSecundario, email, telefoneFamiliar, tipoExame,
				dataExame, apto, nomeBanco, agencia, numeroConta,
				digitoVerificador, nomeDependente, sobrenomeDependente, nomeSocialDependente,
				dataDeNascimentoDependente, nacionalidadeDependente, naturalidadeDependente,
				pcdDependente, generoDependente, identidadeGeneroDependente,
				cpfDependente, rgDependente, tipoDependente, optanteIR);
		Colaborador colaborador = (Colaborador) builder.build();
		session.clear();
		colaborador.setId(id);
		return daoColaborador.update(colaborador);
	}

	/**
	 * Busca colaborador por id.
	 * 
	 * Busca o colaborador cujo id eh igual ao passado como parametro.
	 * 
	 * @param id do colaborador desejado.
	 * 
	 * @return objeto colaborador ou objeto vazio caso nao encontrado.
	 */
	public static Colaborador buscarColaboradorPorId(Integer id) {
		return daoColaborador.readById(id);
	}

	/**
	 * Busca colaborador por nome.
	 * 
	 * Metodo busca os colaboradores no banco de dados atraves dos seus respectivos nomes,
	 * eh possivel passar um parametro parcial para retorna todos os registros que contenham
	 * determinado texto em seu nome.
	 * 
	 * @param nome do colaborador desejado.
	 * @return List Colaborador lista de colaborador localizados. 
	 */
	public static List<Colaborador> buscarColaboradorPorNome(String nomeColaborador) {		
		return daoColaborador.buscarPorNome(nomeColaborador);
	}

	/**
	 * Busca todos os colaboradores.
	 * 
	 * Metodo realiza a busca no banco de todos os colaboradores e retorna 
	 * os registros em uma lista.
	 * 
	 * @return lista com todos os colaboradores cadastrados.
	 */
	public static List<Colaborador> buscarTodosColaboradores() {
		return daoColaborador.getAll();
	}

	
	

}
