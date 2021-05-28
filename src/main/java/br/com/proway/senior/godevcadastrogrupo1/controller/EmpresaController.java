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
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
/**
 * Classe EmpresaController
 * 
 * Classe de interacao com o DAO {@link EmpresaDAO}, realiza as tratativas
 * necessarias para envio do objeto {@link Empresa} para o banco de dados.
 * 
 * @author Sprint 5
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class EmpresaController {
	static Session session = BDConexao.getSessao();
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);

	/**
	 * Cadastrar Empresa.
	 * 
	 * Recebe os dados da empresa e cria todos os dados e chama os DAO necessarios
	 * para a criacaoo da empresa e por ultimo chama o DAO da empresa para salvar no
	 * banco de dados.
	 * 
	 * @param String nomeEmpresa Nome da empresa que sera cadastrada.
	 * @param LocalDate dataInicioContrato data de inicio do contrato da empresa terceirizada.
	 * @param String Cnpj CNPJ (Cadastro Nacional de Pessoas Juridicas).
	 * @param String telefonePrincipal Telefone principal.
	 * @param String telefoneSecundario Telefone secundario.
	 * @param String email Email.
	 * @param String telefoneFamiliar Contato de emergencia.
	 * @param String logradouro Logradouro da empresa de onde a empresa esta situada.
	 * @param int numero Numero do local onde a empresa esta situada.
	 * @param String complemento Complemento do endereco.
	 * @param String cep CEP do endereco.
	 * @param String bairro Bairro do endereco.
	 * @param String pais Pais do endereco.
	 * @param String cidade Cidade do endereco.
	 * @param String uf UF federativa do endereco.
	 * @return o objeto do registro de Empresa criado.
	 * @throws Exception 
	 */
	public static Empresa cadastrarEmpresa(String nomeEmpresa, LocalDate dataInicioContrato, String Cnpj,
			String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf) throws Exception {

		Contatos contatos = new Contatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);

		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		Empresa empresa = new Empresa(nomeEmpresa, dataInicioContrato, Cnpj, endereco, contatos);
		return daoEmpresa.cadastrar(empresa);
	}

	/**
	 * Deletar Empresa.
	 * 
	 * Deleta o registro de uma Empresa conforme parametro.
	 * 
	 * @param empresa Empresa a ser deletado.
	 * @return true caso seja deletado ou false caso contrario.
	 */
	public static boolean deletarEmpresa(Empresa empresa) {
		return daoEmpresa.deletar(empresa);
	}

	/**
	 * Atualizar empresa.
	 * 
	 * Cria um novo objeto com os dados recebidos e os atualiza a {@link Empresa} informada via 
	 * parametro.
	 * 
	 * @param Integer id Identificacao da empresa que sera atualizada.
	 * @param String nomeEmpresa Nome atualizado.
	 * @param LocalDate dataInicioContrato Data de inicio do contrato atualizada.
	 * @param String cnpj CNPJ alterado.
	 * @param contatos Objeto {@link Contatos} com dados atualizados.
	 * @param endereco Objeto {@link Endereco} com dados atualizados.
	 * @return objeto da {@link Empresa} atualizada.
	 * @throws Exception 
	 */
	public static Empresa atualizarEmpresa(Integer id, String nomeEmpresa, LocalDate dataInicioContrato, String cnpj,
			Contatos contatos, Endereco endereco) throws Exception {

		Empresa empresa = new Empresa(nomeEmpresa, dataInicioContrato, cnpj, endereco, contatos);
		
		empresa.setId(id);
		return daoEmpresa.atualizar(empresa);
	}

	/**
	 * Buscar empresa.
	 * 
	 * Busca a Empresa cujo id é igual ao passado como parametro.
	 * 
	 * @param id Do colaborador desejado.
	 * @return Colaborador ou null caso nao encontrado.
	 */
	public static Empresa buscarEmpresaPorId(Integer id) {
		return daoEmpresa.buscarPorId(Empresa.class, id);
	}

	/**
	 * Busca todas as Empresas.
	 * 
	 * @return lista com todos os registros de {@link Empresa} constantes no banco de dados.
	 */
	public static List<Empresa> buscarTodasEmpresas() {
		return daoEmpresa.buscarTodos(Empresa.class);
	}
	
	/**
	 * Busca empresa por nome.
	 * 
	 * Metodo busca as empresas no banco de dados atraves dos seus respectivos
	 * nomes, eh possivel passar um parametro parcial para retorna todos os registros
	 * que contenham determinado texto em seu nomeEmpresa.
	 * 
	 * @param nomeEmpresa nome dos registros que estao sendo procurados.
	 * @return ArrayList Empresa lista de registros localizados.
	 */
	public static ArrayList<Empresa> buscarEmpresaPorNome(String nomeEmpresa) {
		return (ArrayList<Empresa>) daoEmpresa.buscarPorNome(Empresa.class, nomeEmpresa);
	}

}
