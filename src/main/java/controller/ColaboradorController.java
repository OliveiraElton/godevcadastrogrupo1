package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.ColaboradorDAO;
import dao.ContaDAO;
import dao.ContatosDAO;
import dao.EnderecoDAO;
import dao.ExameMedicoDAO;
import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMOutros.TiposExames;
import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Endereco;
import model.ExameMedico;
import persistence.DBConnection;

/**
 * Controller do colaborador.
 *
 * Classe que faz a comunicação dos dados recebidos com os dao relacionados ao
 * colaborador.
 * 
 * @author Bruno Marques <brunoliveira.marques@gmail.com
 * @author Daniella Lira <dev.danilira@gmail.com>
 * @author David Hildebrnadt <davihildebran@gmail.com>
 * @author David Willian <dwillian676@gmail.com>
 * @author Elton Frncisco de Oliveira <eltonf.oliveira22@gmail.com>
 *
 */
public class ColaboradorController {

	static Session session = DBConnection.getSession();
	static ColaboradorDAO daoColaborador = ColaboradorDAO.getInstance(session);
	static ContaDAO daoConta = ContaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);
	static ExameMedicoDAO daoExameMedico = ExameMedicoDAO.getInstance(session);
	
	/**
	 * Criar Colaborador. 
	 * 
	 * Recebe os dados do colaborador separdos e cria todos os dados e chama os 
	 * DAO necessários para a criação do colaborador e por último chama o DAO do
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
	 * @return Retorna o Colaborador caso tenha sido cadastrado ou null caso contrário
	 */
	public static Colaborador criarColaborador(String nome, String sobrenome, String nomeSocial, 
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade,
			boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg, Integer idCargo, Integer nit, 
			boolean optanteVT, boolean optanteVAVR, LocalDate dataAdmissao, 
			boolean optanteDependente, String registro_alistamento, 
			String email_corporativo, String titulo_eleitor,
			String logradouro, Integer numero, 
            String complemento, String cep, String bairro, String pais, String cidade, 
			String uf, String telefonePrincipal, String telefoneSecundario, String email, 
			String telefoneFamiliar, TiposExames tipoExame, LocalDate dataExame, boolean apto,
			String nomeBanco, String agencia, String numeroConta, String digitoVerificador) {
		
		Contatos contatos = new Contatos(telefonePrincipal, telefoneSecundario, 
				email, telefoneFamiliar);
		daoContatos.create(contatos);
		
		Conta conta = new Conta(nomeBanco, agencia, numeroConta, digitoVerificador);
		daoConta.create(conta);
		
		ExameMedico exameMedico = new ExameMedico(tipoExame, dataExame, apto);
		daoExameMedico.create(exameMedico);
		
		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, 
				bairro, pais, cidade, uf);
		daoEndereco.create(endereco);
		
		Colaborador colaborador = new Colaborador(nome, sobrenome, nomeSocial, 
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero, 
				identidadeGenero, endereco, cpf, rg, contatos, idCargo, nit, 
				optanteVT, optanteVAVR, dataAdmissao, optanteDependente, 
				registro_alistamento, email_corporativo, titulo_eleitor, conta, 
				exameMedico);
		
		return daoColaborador.create(colaborador);
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
	public static boolean deleteColabordor(Colaborador colaborador) {
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
	public static Colaborador atualizarColaborador(Integer id, String nome, String sobrenome,
			String nomeSocial, LocalDate dataDeNascimento, String nacionalidade, 
			String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero, 
			Endereco endereco, String cpf, String rg, Contatos contatos, Integer idCargo, 
			Integer nit, boolean optanteVT, boolean optanteVAVR, LocalDate dataAdmissao, 
			boolean optanteDependente, String registro_alistamento, String email_corporativo,
			String titulo_eleitor, Conta conta, ExameMedico exameMedico) {
		
		Colaborador colab = new Colaborador(nome, sobrenome, nomeSocial, 
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero, 
				identidadeGenero, endereco, cpf, rg, contatos, idCargo, nit, 
				optanteVT, optanteVAVR, dataAdmissao, optanteDependente, 
				registro_alistamento, email_corporativo, titulo_eleitor, conta, 
				exameMedico);
		session.clear();
		colab.setId(id);		
		return daoColaborador.update(colab);
	}
	
	/**
	 * Busca Colaborador.
	 * 
	 * Busca o Colaborador cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id Do colaborador desejado.
	 * 
	 * @return Colaborador ou null caso não encontrado. 
	 */
	public static Colaborador buscarColaboradorPorId(Integer id) {		
		return daoColaborador.readById(id);
	}
	
//	/**
//	 * Busca Colaborador.
//	 * 
//	 * Busca o Colaborador cujo nome e sobrenome são iguais aos passados como 
//	 * parâmetro.
//	 * 
//	 * @param nome Do colaborador desejado.
//	 * @param sobrenome Do colaborador desejado.
//	 * 
//	 * @return Colaborador ou null caso colaborador não encontrado. 
//	 */
//	public static Colaborador buscarColaboradorPorNomeSobrenome(String nome, String sobrenome) {		
//		return daoColaborador.readByNomeSobrenome(nome, sobrenome);
//	}
	
	/**
	 * Busca todos os Colaboradores.
	 * 
	 * @return lista com todos os Colaboradores.
	 */
	public static List<Colaborador> buscarTodosColaborador() {		
		return daoColaborador.getAll();
	}

}
