package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
/**
 * Classe EmpresaController
 * 
 * Classe de intera��o com o DAO {@link EmpresaDAO}, realiza as tratativas
 * necess�rias para envio do objeto {@link Empresa} para o banco de dados.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaController {
	static Session session = DBConnection.getSession();
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);

	/**
	 * Cria Empresa
	 * 
	 * Recebe os dados da empresa e cria todos os dados e chama os DAO necessários
	 * para a criação da empresa e por ultimo chama o DAO da empresa para salvar no
	 * banco.
	 * 
	 * @param nomeEmpresa
	 * @param dataInicioContrato
	 * @param Cnpj
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @return
	 * @throws Exception 
	 */
	public static Empresa criarEmpresa(String nomeEmpresa, LocalDate dataInicioContrato, String Cnpj,
			String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf) throws Exception {

		Contatos contatos = new Contatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		daoContatos.create(contatos);

		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);
		daoEndereco.create(endereco);

		Empresa empresa = new Empresa(nomeEmpresa, dataInicioContrato, Cnpj, endereco, contatos);

		return daoEmpresa.create(empresa);
	}

	/**
	 * Deletar Empresa.
	 * 
	 * Deleta a Empresa passado como parâmetro.
	 * 
	 * @param empresa Empresa a ser deletado
	 * 
	 * @return true caso seja deletado ou false caso contrário
	 */
	public static boolean deleteEmpresa(Empresa empresa) {
		return daoEmpresa.delete(empresa);
	}

	/**
	 * Metodo que faz a atualização dos dados
	 * 
	 * cria uma nova empresa com os dados recebidos e os altera na empresa passado
	 * como parâmetro chamando o DAO da empresa.
	 * 
	 * @param id
	 * @param nomeEmpresa
	 * @param dataInicioContrato
	 * @param cnpj
	 * @param contatos
	 * @param endereco
	 * @return
	 * @throws Exception 
	 */
	public static Empresa atualizarEmpresa(Integer id, String nomeEmpresa, LocalDate dataInicioContrato, String cnpj,
			Contatos contatos, Endereco endereco) throws Exception {

		Empresa empresa = new Empresa(nomeEmpresa, dataInicioContrato, cnpj, endereco, contatos);
		
		empresa.setId(id);
		return daoEmpresa.update(empresa);
	}

	/**
	 * Busca empresa.
	 * 
	 * Busca a Empresa cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id Do colaborador desejado.
	 * 
	 * @return Colaborador ou null caso não encontrado.
	 */
	public static Empresa buscarEmpresaPorId(Integer id) {
		return daoEmpresa.readById(id);
	}

	/**
	 * Busca todas as Empresa.
	 * 
	 * @return lista com todos as Empresa.
	 */
	public static List<Empresa> buscarTodasEmpresas() {
		return daoEmpresa.getAll();
	}
	
	/**
	 * Busca empresa por nome.
	 * 
	 * M�todo busca as empresas no banco de dados atrav�s dos seus respectivos
	 * nomes, � poss�vel passar um par�metro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeEmpresa.
	 * 
	 * @param nomeEmpresa nome dos registros que est�o sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */
	public static ArrayList<Empresa> buscarEmpresaPorNome(String nomeEmpresa) {
		return (ArrayList<Empresa>) daoEmpresa.buscarPorNome(nomeEmpresa);
	}

}
