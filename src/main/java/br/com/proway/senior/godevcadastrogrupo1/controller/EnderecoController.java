package br.com.proway.senior.godevcadastrogrupo1.controller;

import java.util.List;
import org.hibernate.Session;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Controller do Endereco.
 * 
 * Classe que faz a comunicacao dos dados recebidos com o DAO relacionado ao Endereco.
 *  
 * @author Gabriel Simon <gabrielsimon775@gmail.com>
 */
public class EnderecoController {
	static Session session = DBConnection.getSession();
	static EnderecoDAO enderecoDao = EnderecoDAO.getInstance(session);

	/**
	 * Cria o Endereco.
	 * 
	 * Recebe os dados do endereco, cria os dados e chama o DAO, cria e salva no banco de dados
	 * um endereco.
	 * 
	 * @param idEndereco
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @return enderecoDao
	 */
	public static Endereco criarEndereco(String logradouro, Integer numero, String complemento,
			String cep, String bairro, String pais, String cidade, String uf) {

		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		return enderecoDao.create(endereco);
	}

	/**
	 * Deleta o Endereco.
	 * 
	 * Vai deletar o Endereco passado como parametro.
	 * 
	 * @param enderecoDeletar
	 * @return vai retornar true se for deletaco com sucesso ou falso caso nao for deletado
	 */
	public static boolean deletarEndereco(Endereco enderecoDeletar) {
		return EnderecoDAO.getInstance(session).delete(enderecoDeletar);
	}

	/**
	 * Atualiza o Endereco.
	 * 
	 * Cria um novo Endereco com base nos parametros passados.
	 *  
	 * @param idEndereco
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
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
	 * Busca o Endereco pelo ID.
	 * 
	 * Vai no banco de dados e procura o respectivo endereco pelo ID informado como parametro.
	 * 
	 * @param id
	 * @return retorna um endereco informado pelo ID
	 */
	public static Endereco buscarEnderecoPorId(int id) {
		return enderecoDao.readById(id);
	}

	/**
	 * Lista todos os Enderecos.
	 * 
	 * Vai no banco de dados e retorna todos os enderecos inseridos no banco.
	 * 
	 * @return List<Endereco>
	 */
	public static List<Endereco> listarTodosEnderecos() {
		return enderecoDao.getAll();
	}
	
	public static void limparTabela() {
		enderecoDao.limparTabela();
	}
}
