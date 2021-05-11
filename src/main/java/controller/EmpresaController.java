package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import dao.ContatosDAO;
import dao.EmpresaDAO;
import dao.EnderecoDAO;
import model.Contatos;
import model.Empresa;
import model.Endereco;

public class EmpresaController {
	private EmpresaDAO empresaDAO = new EmpresaDAO();

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
	 */
	public Empresa criarEmpresa(String nomeEmpresa, LocalDate dataInicioContrato, String Cnpj,
			String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf) {

		Contatos contatos = new Contatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		ContatosDAO contatosDao = new ContatosDAO();
		contatosDao.create(contatos);

		Endereco endereco = new Endereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);
		EnderecoDAO enderecoDao = new EnderecoDAO();
		enderecoDao.create(endereco);

		Empresa empresa = new Empresa(nomeEmpresa, dataInicioContrato, Cnpj, endereco, contatos);
		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.create(empresa);

		return empresaDAO.create(empresa);
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
	public boolean deleteEmpresa(Empresa empresa) {
		return empresaDAO.delete(empresa);
	}
	/**
	 * Metodo que faz a atualização dos dados
	 * 
	 * cria uma nova empresa com os dados recebidos e os altera na empresa
	 * passado como parâmetro chamando o DAO da empresa.
	 * @param id
	 * @param nomeEmpresa
	 * @param dataInicioContrato
	 * @param cnpj
	 * @param contatos
	 * @param endereco
	 * @return
	 */
	public Integer atualizarEmpresa(Integer id, String nomeEmpresa, LocalDate dataInicioContrato, String cnpj,
			Contatos contatos, Endereco endereco) {

		Empresa empresa = new Empresa(nomeEmpresa, dataInicioContrato, cnpj, endereco, contatos);

		return empresaDAO.update(id, empresa);
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
	public Empresa buscarEmpresaPorId(Integer id) {		
		return empresaDAO.readById(id);
	}
	
	/**
	 * Busca Empresa.
	 * 
	 * Busca a Empresa cujo nome é iguais ao passado como 
	 * parâmetro.
	 * 
	 * @param nome Da Empresa desejada.
	 * 
	 * @return Empresa ou null caso Empresa não encontrada. 
	 */
	public  Empresa buscarCEmpresaPorNome(String nome) {		
		return empresaDAO.readByNome(nome);
	}
	
	/**
	 * Busca todas as Empresa.
	 * 
	 * @return lista com todos as Empresa.
	 */
	public ArrayList<Empresa> buscarTodasEmpresas() {		
		return empresaDAO.getAll();
	}
}
