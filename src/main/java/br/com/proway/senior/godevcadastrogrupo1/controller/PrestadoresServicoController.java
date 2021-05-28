package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.model.Empresa;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ContatosDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EmpresaDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
/**
 * Classe PrestadorServicoController
 * 
 * Classe de interacao com o DAO {@link PrestadorServicoDAO}, realiza as tratativas
 * necessarias para envio do objeto {@link PrestadorServico} para o banco de dados.
 * 
 * @author Sprint 5
 *
 */
public class PrestadoresServicoController {

	static Session session = BDConexao.getSessao();
	static PrestadorServicoDAO daoPrestadorServico = PrestadorServicoDAO.getInstance(session);
	static ContatosDAO daoContatos = ContatosDAO.getInstance(session);
	static EmpresaDAO daoEmpresa = EmpresaDAO.getInstance(session);

	/**
	 * Cadastrar Prestador de Servico.
	 * 
	 * Recebe os dados do prestador de servico e interage com o DAO
	 * para salvar o registro no banco de dados.
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
	 * @return o objeto do registro salvo no banco de dados.
	 * @throws Exception 
	 */
	public static PrestadorServico cadastrarPrestadorServico(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg,
			LocalDate dataInicioContrato, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf, Empresa empresa) throws Exception {
		PessoaBuilder builder = new PessoaBuilder();
		Director.cadastrarPrestadorServico(builder, nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg,
				dataInicioContrato, idSetor, telefonePrincipal,
				telefoneSecundario, email, telefoneFamiliar, logradouro, numero,
				complemento, cep, bairro, pais, cidade, uf, empresa);
		PrestadorServico prestadorServico = (PrestadorServico) builder.build();
		return daoPrestadorServico.cadastrar(prestadorServico);
	}

	/**
	 * Deletar Prestador de Servico.
	 * 
	 * Deleta o Prestador de servico conforme objeto informado como parametro.
	 * 
	 * @param prestadorServico objeto que sera deletado.
	 * @return boolean 
	 */
	public static boolean deletarPrestadorServico(PrestadorServico prestadorServico) {
		return daoPrestadorServico.deletar(prestadorServico);
	}

	/**
	 * Atualizar Prestador de Servico.
	 * 
	 * Atualiza um registro de Prestador de Servico ja existente no banco de dados
	 * conforme parametros informados.
	 * 
	 * @param id Identificacao do Prestador de Servico que sera alterado.
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
	 * @return o objeto do Prestador de Servico atualizado.
	 * @throws Exception 
	 * 
	 */
	public static PrestadorServico atualizarPrestadorServico(Integer id, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, String cpf, String rg,
			LocalDate dataInicioContrato, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf, Empresa empresa) throws Exception {
		PessoaBuilder builder = new PessoaBuilder();
		Director.cadastrarPrestadorServico(builder, nome, sobrenome, nomeSocial,
				dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg,
				dataInicioContrato, idSetor, telefonePrincipal,
				telefoneSecundario, email, telefoneFamiliar, logradouro, numero,
				complemento, cep, bairro, pais, cidade, uf, empresa);
		PrestadorServico prestadorServico = (PrestadorServico) builder.build();
		prestadorServico.setId(id);
		session.clear();
		prestadorServico.setId(id);
		return daoPrestadorServico.atualizar(prestadorServico);
	}

	/**
	 * Buscar Prestador de Servico.
	 * 
	 * Busca o Prestador de Servico cujo id eh igual ao passado como parametro.
	 * 
	 * @param id Identificacao do Prestador de Servico procurado. 
	 * @return objeto do Prestador de Servico localizado.
	 */
	public static PrestadorServico buscarPrestadorServicoPorId(Integer id) {
		return daoPrestadorServico.buscarPorId(PrestadorServico.class, id);
	}

	/**
	 * Buscar todos os Prestadores de Servico.
	 * 
	 * Realiza a busca no banco de todos os registros de Prestadores de Servico
	 * constantes no banco de dados.
	 * 
	 * @return lista de regsitros localizados.
	 */
	public static List<PrestadorServico> buscarTodosPrestadoresServico() {
		return daoPrestadorServico.buscarTodos(PrestadorServico.class);
	}
	
	/**
	 * Buscar Prestadores de Servico pelo nome.
	 * 
	 * Realiza a busca no banco de todos os registros de Prestadores de Servico
	 * conforme parametro de nome informado.
	 * 
	 * @param String nome Nome do Prestador de Servico procurado.
	 * @return lista de regsitros localizados.
	 */
	public static List<PrestadorServico> buscarPrestadorServicoPorNome(String nome) {
		return daoPrestadorServico.buscarPorNome(PrestadorServico.class, nome);
	}
	
	
	/**
	 * Deletar todos os registros.
	 * 
	 * Metodo deletar todos os registros de Prestadores de Servico constantes
	 * no banco. Utilizado para testes.
	 */
	public static void deletarTodosPrestadoresServico() {
		daoPrestadorServico.deletarTodos("prestadorservico");
	}
}
