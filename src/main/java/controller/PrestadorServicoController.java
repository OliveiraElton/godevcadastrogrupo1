package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import dao.ContatosDAO;
import dao.EnderecoDAO;
import dao.PrestadorServicoDAO;
import enums.EMDadosPessoais.IdentidadeGenero;
import model.Contatos;
import model.Empresa;
import model.Endereco;
import model.PrestadorServico;

public class PrestadorServicoController {

	private static PrestadorServicoDAO prestadorServicoDAO = new PrestadorServicoDAO();

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
	 * @author Elton F Oliveira.
	 */
	public static PrestadorServico criarPrestadorServico(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, Endereco endereco, String cpf, String rg, Contatos contatos,
			LocalDate dataInicioContrato, Empresa empresa, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf) {

		Contatos contatosPrestador = new Contatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		ContatosDAO contatosDao = new ContatosDAO();
		contatosDao.create(contatosPrestador);

		Endereco enderecoPrestador = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.create(enderecoPrestador);

		PrestadorServico prestadorServico = new PrestadorServico(nome, sobrenome, nomeSocial, dataDeNascimento,
				nacionalidade, naturalidade, pcd, genero, identidadeGenero, endereco, cpf, rg, contatos,
				dataInicioContrato, empresa, idSetor);

		return prestadorServicoDAO.create(prestadorServico);
	}
	
	/**
	 * Deletar Prestador de servico.
	 * 
	 * Deleta o Prestador de servico passado como parâmetro.
	 * 
	 * @param prestadorServico a ser deletado.
	 * @return
	 * 
	 * @author Elton F Oliveira.
	 */
	public static boolean deletePrestadorServico(PrestadorServico prestadorServico) {
		return prestadorServicoDAO.delete(prestadorServico);
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
	 * @author Elton F Oliveira.
	 */
	public static Integer atualizarPrestadorServico(Integer id, String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, Endereco endereco, String cpf, String rg, Contatos contatos,
			LocalDate dataInicioContrato, Empresa empresa, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf) {
	
		PrestadorServico prestadorServico = new PrestadorServico(nome, sobrenome, nomeSocial, dataDeNascimento,
				nacionalidade, naturalidade, pcd, genero, identidadeGenero, endereco, cpf, rg, contatos,
				dataInicioContrato, empresa, idSetor);
		
		return prestadorServicoDAO.update(id, prestadorServico);
	}
	
	/**
	 * Busca Prestador de servico.
	 * 
	 * Busca o Prestador de Servico cujo id é igual ao passado como parâmetro.
	 * 
	 * @param id
	 * @return
	 * @author Elton F Oliveira.
	 */
	public static PrestadorServico buscarPrestadorServicoPorId(Integer id) {
		return prestadorServicoDAO.readById(id);
	}
	
	/**
	 * Busca Prestador de servico.
	 * 
	 * Busca o Prestador de servico cujo nome e sobrenome são iguais aos passados como 
	 * parâmetro.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @return
	 * @author Elton F Oliveira.
	 */
	public static PrestadorServico buscarPrestadorServicoPorNomeSobrenome(String nome, String sobrenome) {
		return prestadorServicoDAO.readByNomeSobrenome(nome, sobrenome);
	
	}
	
	/**
	 * Busca todos os Prestadores de servico.
	 * @return
	 * @author Elton F Oliveira.
	 */
	public static ArrayList<PrestadorServico> buscarTodosPrestadorServico(){
		return prestadorServicoDAO.getAll();
	}
}
