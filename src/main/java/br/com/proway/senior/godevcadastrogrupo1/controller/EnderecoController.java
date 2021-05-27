package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.util.List;
import org.hibernate.Session;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * Controller do Endereco.
 * 
 * Classe que faz a comunicacao dos dados recebidos com o DAO relacionado ao Endereco.
 *  
 * @author Gabriel Simon <gabrielsimon775@gmail.com>
 */
public class EnderecoController {
	static Session session = BDConexao.getSessao();
	static EnderecoDAO enderecoDao = EnderecoDAO.getInstance(session);

	/**
	 * Cadastrar um Endereco.
	 * 
	 * Recebe os dados do endereco e salva no banco de dados, atraves da interacao
	 * com o DAO.
	 * 
	 * @param String logradouro Tipo e nome do logradouro (Exemplo: Rua 10, AV Central).
	 * @param String numero Numero da residencia.
	 * @param String complemento Complemento para facilitar a localizacao do endereco.
	 * @param String cep CEP do logradouro.
	 * @param String bairro Bairro do endereco.
	 * @param String pais Pais do endereco.
	 * @param String cidade Cidade do endereco.
	 * @param String uf Unidade Federativa do endereco.
	 * @return o objeto do {@link Endereco} cadastrado no banco de dados.
	 */
	public static Endereco cadastrarEndereco(String logradouro, Integer numero, String complemento,
			String cep, String bairro, String pais, String cidade, String uf) {

		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		return enderecoDao.create(endereco);
	}

	/**
	 * Deletar um Endereco.
	 * 
	 * Vai deletar o Endereco passado como parametro.
	 * 
	 * @param enderecoDeletar Objeto do endereco que sera delerado.
	 * @return vai retornar true se for deletaco com sucesso ou falso caso nao for deletado
	 */
	public static boolean deletarEndereco(Endereco enderecoDeletar) {
		  return enderecoDao.delete(enderecoDeletar);
	}

	/**
	 * Atualizar um Endereco.
	 * 
	 * Cria um novo Endereco com base nos parametros passados.
	 *  
	 * @param Integer idEndereco identificacao do endereco que sera atualizado.
	 * @param String logradouro Logradouro atualizado.
	 * @param int numero Numero atualizado.
	 * @param String complemento Complemento atualizado.
	 * @param String cep CEP atualizado.
	 * @param String bairro Bairro atualizado.
	 * @param String pais Pais atualizado.
	 * @param String cidade Cidade atualizada.
	 * @param String uf Unidade Federativa atualizada.
	 * @return vai retornar um id do endereco caso o endereco for atualizado ou false caso contrario
	 */
	public static Endereco atualizarEndereco(Integer id, String logradouro, Integer numero, String complemento,
			String cep, String bairro, String pais, String cidade, String uf) {

		Endereco enderecoAtualizar = new Endereco(logradouro, numero, complemento, cep, bairro, pais,
				cidade, uf);
		session.clear();
		enderecoAtualizar.setNumero(numero);
		enderecoAtualizar.setId(id);
		return enderecoDao.update(enderecoAtualizar);
	}

	/**
	 * Buscae um Endereco pelo ID.
	 * 
	 * Busca no banco de dados o endereco, conforme informada ID como parametro.
	 * 
	 * @param id Identificacao do endereco procurado.
	 * @return retorna o objeto um {@link Endereco} localizado no banco.
	 */
	public static Endereco buscarEnderecoPorId(int id) {
		return enderecoDao.readById(id);
	}
	
	/**
	 * Buscar Endereço por Id do colaborador.
	 * 
	 * Busca no banco o Endereço com o id do colaborador igual ao passado como parametro.
	 * 
	 * @param id Identificacao do colaborador procurado.
	 * @return retorna o objeto um {@link Endereco} desejado.
	 */
	public static Endereco buscarEnderecoPorIdColab(int id) {
		return enderecoDao.readByIdColab(id);
	}

	/**
	 * Listar todos os Enderecos.
	 * 
	 * Retorna todos registros de enderecos inseridos no banco.
	 * 
	 * @return List Endereco Lista de enderecos localizados.
	 */
	public static List<Endereco> listarTodosEnderecos() {
		return enderecoDao.getAll();
	}
}
