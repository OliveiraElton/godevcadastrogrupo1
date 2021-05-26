package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.proway.senior.godevcadastrogrupo1.controller.PrestadorServicoController;
import br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.PrestadorServicoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.PrestadorServicoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

/**
 * Classe PrestadorServicoSimplificadoControllerApi
 * 
 * Classe disponibilizada para consulta dos dados de prestador de servico via API Rest.
 * Implementa os metodos do {@link PrestadorServicoController} e atributos
 * dos models {@link PrestadorServicoDTO} e {@link PrestadorServico}.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class PrestadorServicoSimplificadoControllerApi {

	static Session session = DBConnection.getSession();
	PrestadorServicoDAO daoPrestador = PrestadorServicoDAO.getInstance(session);

	/**
	 * Criar prestador de servico.
	 * 
	 * Metodo cria um registro de novo prestador de servico no banco de dados.
	 * Recebe um objeto da {@link PrestadorServico} que sera criado.
	 * 
	 * @param empresa {@link PrestadorServico}.
	 * @return objeto do registro criado.
	 */
	@RequestMapping(value = "/prestadorSimplificado", method = RequestMethod.POST)
	public @ResponseBody PrestadorServico cadastrarPrestadorServico(@RequestBody PrestadorServico prestador) {
		return daoPrestador.create(prestador);
	}

	/**
	 * Deletar um prestador de servico.
	 * 
	 * Metodo exclui um registro de prestador de servico do banco de dados, conforme
	 * id informada.
	 * 
	 * @param id identificacao do prestador que sera excluido.
	 * @return boolean
	 */
	@RequestMapping(value = "/prestadorSimplificado/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deletePrestadorServico(@PathVariable("id") Integer id) {
		PrestadorServico prestador = daoPrestador.readById(id);
		return daoPrestador.delete(prestador);
	}

	/**
	 * Atualizar prestador servico.
	 * 
	 * Metodo atualiza o prestador de servico no banco de dados, recebe o objeto do
	 * prestador que sera alterado e um objeto prestador com as informacoes
	 * atualizadas, inclusive com id referenciada.
	 * 
	 * @param prestador objeto {@link PrestadorServico}.
	 * @return objeto {@link PrestadorServico} atualizado.
	 */
	@RequestMapping(value = "/prestadorSimplificado", method = RequestMethod.PUT)
	public @ResponseBody PrestadorServico atualizarPrestadorServico(@RequestBody PrestadorServico prestador) {
		return daoPrestador.update(prestador);
	}

	/**
	 * Busca Prestador de servico.
	 * 
	 * Busca o Prestador de Servico cujo id é igual ao passado como parâmetro,
	 * transforma em objeto DTO e manda para view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @param id
	 * @return PrestadorServicoDTO
	 */
	@RequestMapping(value = "/prestadorSimplificado/{id}", method = RequestMethod.GET)
	public @ResponseBody PrestadorServicoDTO buscarPrestadorServicoPorId(@PathVariable("id") Integer id) {
		PrestadorServicoDTO prestadorDTO = new PrestadorServicoDTO(daoPrestador.readById(id));
		return prestadorDTO;
	}

	/**
	 * Busca todos os Prestadores de servico.
	 * 
	 * Busca todos os prestadores de serviço cadastrados no banco de dados,
	 * transforma em objetos DTO e manda para a view como lista.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @return
	 */
	@RequestMapping(value = "/prestadorSimplificado", method = RequestMethod.GET)
	public @ResponseBody List<PrestadorServicoDTO> buscarTodosPrestadorServico() {
		List<PrestadorServicoDTO> listaPrestadorDTO = new ArrayList<PrestadorServicoDTO>();
		for (PrestadorServico prestador : daoPrestador.getAll()) {
			listaPrestadorDTO.add(new PrestadorServicoDTO(prestador));
		}
		return listaPrestadorDTO;
	}

	/**
	 * Busca todos os prestadores de serviço pelo nome.
	 * 
	 * Busca todos os prestadores de serviço cadastrados no banco de dados,
	 * transforma em objetos DTO e manda para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @param String nome
	 * @return List<nome>
	 */
	@RequestMapping(value = "/prestadorSimplificado/{nome}", method = RequestMethod.GET)
	public List<PrestadorServicoDTO> buscarPrestadorServicoPorNome(@PathVariable("nome") String nome) {
		List<PrestadorServicoDTO> listaPrestadorDTO = new ArrayList<PrestadorServicoDTO>();
		for (PrestadorServico prestador : daoPrestador.buscarPorNome(nome)) {
			listaPrestadorDTO.add(new PrestadorServicoDTO(prestador));
		}
		return listaPrestadorDTO;
	}

}
