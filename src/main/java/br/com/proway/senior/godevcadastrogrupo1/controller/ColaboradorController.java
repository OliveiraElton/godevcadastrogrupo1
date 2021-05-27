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
 * Classe que faz a comunicacao dos dados recebidos com os DAOs relacionados ao
 * colaborador.
 * 
 * @author Bruno Marques <brunoliveira.marques@gmail.com
 * @author Daniella Lira <dev.danilira@gmail.com>
 * @author David Hildebrnadt <davihildebran@gmail.com>
 * @author David Willian <dwillian676@gmail.com>
 * @author Elton Frncisco de Oliveira <eltonf.oliveira22@gmail.com>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b> - Sprint 6 e 7
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

	public ColaboradorController() {
	}

	/**
	 * Cadastrar Colaborador.
	 * 
	 * Recebe os dados do colaborador separdos e cria todos os dados e chama os DAO
	 * necessarios para a criacao do colaborador e por ultimo chama o DAO do
	 * colaborador para salvar no banco.
	 * 
	 * @param String nome Nome do colaborador.
	 * @param String sobrenome Sobrenome do colaborador.
	 * @param String nomeSocial Nome social do colaborador, caso se
	 *                         aplique.
	 * @param LocalDate dataDeNascimento data de nascimento do colaborador.
	 * @param String nacionalidade nacionalidade do colaborador.
	 * @param String naturalidade cidade de nascimento do colaborador
	 * @param Boolean pcd Informa se o colaborador eh PCD sim (true) ou nao
	 *                         (false).
	 * @param String genero Genero do colaborador
	 * @param IdentidadeGenero identidadeGenero Identidade de genero colaborador.
	 * @param String cpf CPF valido do colaborador (Cadastro de Pessoa
	 *                         Fisica).
	 * @param String rg RG do colaborador (Registro Geral).
	 * @param int idPostoDeTrabalho Identificacao do Posto de Trabalha
	 *                         ao qual o colaborador sera vinculado, dados do modulo
	 *                         Cargos e Salarios com informacoes de cargo, setor,
	 *                         salario, etc.
	 * @param Integer nit NIT do colaborador (Numero de Inscrição do
	 *                         Trabalhador).
	 * @param Boolean optanteVT Informa se o colaborador eh optante de VT
	 *                         sim (true) ou nao (false).
	 * @param Boolean optanteVAVR Informa se o colaborador eh optante de
	 *                         VAVR sim (true) ou nao (false).
	 * @param LocalDate dataAdmissao Data de inicio do colaborador na
	 *                         empresa.
	 * @param Boolean optanteDependente Informa se o colaborador possui
	 *                         dependente sim (true) ou nao (false).
	 * @param String registro_alistamento Numero do registro de
	 *                         alistamento do colaborador, caso genero masculino.
	 * @param String email_corporativo Email corporativo do colaborador.
	 * @param String titulo_eleitor Titulo de eleitor do colaborador.
	 * @param String logradouro Nome do logradouro onde o colaborador
	 *                         reside.
	 * @param int numero Numero da residencia do colaborador.
	 * @param String complemento Complemento do endereco do colaborador.
	 * @param String cep CEP da residencia do colaborador.
	 * @param String bairro Bairro onde o colaborador reside.
	 * @param String pais Pais onde o colaborador reside.
	 * @param String cidade Cidade onde o colaborador reside.
	 * @param String uf Unidade Federativa onde o colaborador reside.
	 * @param String telefonePrincipal Telefone principal do colaborador.
	 * @param String telefoneSecundario Telefone secundario do
	 *                         colaborador.
	 * @param String email Email pessoal do colaborador.
	 * @param String telefoneFamiliar Telefone de um familiar do
	 *                         colaborador, utilizado em emergencias.
	 * @param TiposExames tipoExame Tipo do exame que o colaborador realizou
	 *                         (admissional, demissional e periodico).
	 * @param LocalDate dataExame Data em que o exame foi realizado.
	 * @param Boolean apto Resultado do exame, sendo apto (true) ou inapto
	 *                         (false).
	 * @param String nomeBanco Nome do banco onde colaborador recebera o
	 *                         salario.
	 * @param String agencia Agencia da conta do colaborador.
	 * @param String numeroConta Numero da conta do colaborador.
	 * @param String digitoVerificador Digito verificador da conta.
	 * 
	 * @return Retorna o Colaborador caso tenha sido cadastrado ou null caso
	 *         contrario
	 * @throws Exception
	 */
	public static Colaborador cadastrarColaborador(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, Boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, Integer idPostoDeTrabalho, Integer nit,
			Boolean optanteVT, Boolean optanteVAVR, LocalDate dataAdmissao, Boolean optanteDependente,
			String registro_alistamento, String email_corporativo, String titulo_eleitor, String logradouro,
			Integer numero, String complemento, String cep, String bairro, String pais, String cidade, String uf,
			String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar,
			TiposExames tipoExame, LocalDate dataExame, Boolean apto, String nomeBanco, String agencia,
			String numeroConta, String digitoVerificador, String nomeDependente, String sobrenomeDependente,
			String nomeSocialDependente, LocalDate dataDeNascimentoDependente, String nacionalidadeDependente,
			String naturalidadeDependente, Boolean pcdDependente, String generoDependente,
			IdentidadeGenero identidadeGeneroDependente, String cpfDependente, String rgDependente,
			TiposDependentes tipoDependente, Boolean optanteIR) throws Exception {

		PessoaBuilder builder = new PessoaBuilder();

		Director.criarColaborador(builder, nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade,
				pcd, genero, identidadeGenero, cpf, rg, idPostoDeTrabalho, nit, optanteVT, optanteVAVR, dataAdmissao,
				optanteDependente, registro_alistamento, email_corporativo, titulo_eleitor, logradouro, numero,
				complemento, cep, bairro, pais, cidade, uf, telefonePrincipal, telefoneSecundario, email,
				telefoneFamiliar, tipoExame, dataExame, apto, nomeBanco, agencia, numeroConta, digitoVerificador,
				nomeDependente, sobrenomeDependente, nomeSocialDependente, dataDeNascimentoDependente,
				nacionalidadeDependente, naturalidadeDependente, pcdDependente, generoDependente,
				identidadeGeneroDependente, cpfDependente, rgDependente, tipoDependente, optanteIR);
		Colaborador colaborador = (Colaborador) builder.build();
		return daoColaborador.create(colaborador);
	}

	/**
	 * Adicionar Dependente
	 * 
	 * Adiciona um novo dependente, caso o colaborador tenha mais de um.
	 * 
	 * @param Colaborador      colaborador Colaborador que sera vinculado ao
	 *                         dependente.
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
	 * @param TiposDependente  tipoDependente Define o tipo de dependente: mae, pai,
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
	 */
	public static void adicionarDependente(Colaborador colaborador, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, TiposDependentes tipoDependente,
			boolean optanteIR, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf) {

		Dependente novoDependente = DependenteController.cadastrarDependente(nome, sobrenome, nomeSocial, dataDeNascimento,
				nacionalidade, naturalidade, pcd, genero, identidadeGenero, cpf, rg, tipoDependente, optanteIR,
				logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		colaborador.addDependente(novoDependente);
		daoColaborador.update(colaborador);
	}

	/**
	 * Adicionado Exame Medico
	 * 
	 * Adiciona novo exame medico ao colaborador, caso necessario.
	 * 
	 * @param colaborador
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 */
	public static void adicionarExameMedico(Colaborador colaborador, TiposExames tipoExame, LocalDate dataExame,
			boolean apto) {
		ExameMedico novoExame = new ExameMedico(tipoExame, dataExame, apto);
		colaborador.addExameMedico(novoExame);
		daoColaborador.update(colaborador);
	}

	/**
	 * Deletar Colaborador.
	 * 
	 * Deleta o Colaborador passado como parametro.
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
	 * passado como parametro chamando o DAO do colaborador.
	 * 
	 * @param Intger id Do Colaborador a ser alterado.
	 * @param String nome Nome alterado.
	 * @param String sobrenome Sobrenome alterado.
	 * @param String nomeSocial Nome social alterado.
	 * @param LocalDate dataDeNascimento Data de nascimento alterada.
	 * @param String nacionalidade Nacionalidade alterada.
	 * @param String naturalidade Naturalidade alterada.
	 * @param Boolean pcd Informacao se eh PCD sim ou nao.
	 * @param String genero genero alterado
	 * @param IdentidadeGenero  identidadeGenero Identidade de Genero alterada.
	 * @param Endereco endereco objeto do endereco alterado.
	 * @param String cpf CPF alterado.
	 * @param String rg RG alterado.
	 * @param Contatos contatos objeto dos contatos alterados.
	 * @param Integer idPostoDeTrabalho Id do posto de trabalha alterada.
	 * @param Integer nit NIT alterado.
	 * @param Boolean optanteVT Informa se eh optante sim ou nao.
	 * @param Boolean optanteVAVR Informa se eh optante sim ou nao.
	 * @param LocalDate dataAdmissao
	 * @param optanteDependente Informa se eh optante sim ou nao.
	 * @param String registro_alistamento Registro de alistamento
	 *                          atualizado.
	 * @param String email_corporativo Email corporativo atualizado.
	 * @param String titulo_eleitor titulo de leitor atualizado.
	 * @param Conta conta objeto da conta alterado.
	 * @param ExameMedico exameMedico objeto do exame medico alterado.
	 * 
	 * @return id do colaborador caso seja atualizado ou false caso contrário.
	 * @throws Exception
	 */
	public static Colaborador atualizarColaborador(Integer id, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, Boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg, Integer idPostoDeTrabalho, Integer nit,
			Boolean optanteVT, Boolean optanteVAVR, LocalDate dataAdmissao, Boolean optanteDependente,
			String registro_alistamento, String email_corporativo, String titulo_eleitor, String logradouro,
			Integer numero, String complemento, String cep, String bairro, String pais, String cidade, String uf,
			String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar,
			TiposExames tipoExame, LocalDate dataExame, Boolean apto, String nomeBanco, String agencia,
			String numeroConta, String digitoVerificador, String nomeDependente, String sobrenomeDependente,
			String nomeSocialDependente, LocalDate dataDeNascimentoDependente, String nacionalidadeDependente,
			String naturalidadeDependente, Boolean pcdDependente, String generoDependente,
			IdentidadeGenero identidadeGeneroDependente, String cpfDependente, String rgDependente,
			TiposDependentes tipoDependente, Boolean optanteIR) throws Exception {

		PessoaBuilder builder = new PessoaBuilder();

		Director.criarColaborador(builder, nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade,
				pcd, genero, identidadeGenero, cpf, rg, idPostoDeTrabalho, nit, optanteVT, optanteVAVR, dataAdmissao,
				optanteDependente, registro_alistamento, email_corporativo, titulo_eleitor, logradouro, numero,
				complemento, cep, bairro, pais, cidade, uf, telefonePrincipal, telefoneSecundario, email,
				telefoneFamiliar, tipoExame, dataExame, apto, nomeBanco, agencia, numeroConta, digitoVerificador,
				nomeDependente, sobrenomeDependente, nomeSocialDependente, dataDeNascimentoDependente,
				nacionalidadeDependente, naturalidadeDependente, pcdDependente, generoDependente,
				identidadeGeneroDependente, cpfDependente, rgDependente, tipoDependente, optanteIR);
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
	 * Metodo busca os colaboradores no banco de dados atraves dos seus respectivos
	 * nomes, eh possivel passar um parametro parcial para retorna todos os
	 * registros que contenham determinado texto em seu nome.
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
	 * Metodo realiza a busca no banco de todos os colaboradores e retorna os
	 * registros em uma lista.
	 * 
	 * @return lista com todos os colaboradores cadastrados.
	 */
	public static List<Colaborador> buscarTodosColaboradores() {
		return daoColaborador.getAll();
	}

}
