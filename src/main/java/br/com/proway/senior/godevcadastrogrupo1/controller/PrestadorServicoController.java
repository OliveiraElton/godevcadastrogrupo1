package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

public class PrestadorServicoController {

	static Session session = DBConnection.getSession();
	static PrestadorServicoDAO daoPrestadorServico = PrestadorServicoDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	/**
	 * Criar Prestador de Serviço.
	 * 
	 * Recebe os dados do prestador de serviço e cria todos os dados, chama os DAO
	 * necessários para a criação do prestador de serviço e por último chama o DAO
	 * do prestador para salvar no banco.
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
	 * @param endereco
	 * @param cpf
	 * @param rg
	 * @param contatos
	 * @param dataInicioContrato
	 * @param empresa
	 * @param idSetor
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
	 *
	 */
	public static PrestadorServico criarPrestadorServico(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg,
			LocalDate dataInicioContrato, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf, Empresa empresa) {
		PessoaBuilder builder = new PessoaBuilder();
		Director.criarPrestadorServico(builder, nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg,
				dataInicioContrato, idSetor, telefonePrincipal,
				telefoneSecundario, email, telefoneFamiliar, logradouro, numero,
				complemento, cep, bairro, pais, cidade, uf, empresa);
		PrestadorServico prestadorServico = (PrestadorServico) builder.build();
		return daoPrestadorServico.create(prestadorServico);
	}

	/**
	 * Deletar Prestador de servico.
	 * 
	 * Deleta o Prestador de servico passado como parâmetro.
	 * 
	 * @param prestadorServico a ser deletado.
	 * @return
	 * 
	 */
	public static boolean deletePrestadorServico(PrestadorServico prestadorServico) {
		return daoPrestadorServico.delete(prestadorServico);
	}

	/**
	 * Busca Prestador de servico.
	 * 
	 * Busca o Prestador de servico cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id
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
	 * @param dataInicioContrato
	 * @param empresa
	 * @param idSetor
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
	 * 
	 */
	public static PrestadorServico atualizarPrestadorServico(Integer id, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg,
			LocalDate dataInicioContrato, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf, Empresa empresa) {
		PessoaBuilder builder = new PessoaBuilder();
		Director.criarPrestadorServico(builder, nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg,
				dataInicioContrato, idSetor, telefonePrincipal,
				telefoneSecundario, email, telefoneFamiliar, logradouro, numero,
				complemento, cep, bairro, pais, cidade, uf, empresa);
		PrestadorServico prestadorServico = (PrestadorServico) builder.build();
		prestadorServico.setId(id);
		session.clear();
		prestadorServico.setId(id);
		return daoPrestadorServico.update(prestadorServico);
	}

	/**
	 * Busca Prestador de servico.
	 * 
	 * Busca o Prestador de Servico cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id
	 * @return
	 */
	public static PrestadorServico buscarPrestadorServicoPorId(Integer id) {
		return daoPrestadorServico.readById(id);
	}

	/**
	 * Busca todos os Prestadores de servico.
	 * 
	 * @return
	 */
	public static List<PrestadorServico> buscarTodosPrestadorServico() {
		return daoPrestadorServico.getAll();
	}
	/**
	 * Busca todos os prestadores de serviço pelo nome.
	 * @param String nome
	 * @return List<nome>
	 */
	public static List<PrestadorServico> buscarPrestadorServicoPorNome(String nome) {
		return daoPrestadorServico.buscarPorNome(nome);
	}
	
	public void limpaTabela() {
		daoPrestadorServico.limparTabela();
	}
}
