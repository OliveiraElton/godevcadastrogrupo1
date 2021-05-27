package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.EnderecoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;

/**
 * Classe controller API que busca enderecos para mandar na view.
 * 
 * Classe com metodos que busca no banco de dados, transforma em objeto 
 * {@link EnderecoDTO} e manda para a view de acordo com os criterios de 
 * busca passados no parametro.
 * 
 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
 * 
 */
@RestController
public class EnderecoControllerAPI{

	static Session session = BDConexao.getSessao();
	EnderecoDAO enderecoDao = EnderecoDAO.getInstance(session);
	
	/**
	 * Metodo que busca endereco atraves do colaborador.
	 * 
	 * Metodo que recebe colaborador como parametro, busca o endereco no banco
	 * pelo seu id e retorna objeto transformado em DTO para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
	 * @param {@link Colaborador}
	 * @return {@link EnderecoDTO}
	 */
	@RequestMapping(value = "/endereco/colab/{id}", method = RequestMethod.GET)
	public @ResponseBody EnderecoDTO buscarEnderecoPorColaborador(@PathVariable Integer id){
		return new EnderecoDTO(enderecoDao.readByIdColab(id));
	}

	/**
	 * Metodo que busca endereco atraves do colaborador.
	 * 
	 * Metodo que recebe id como parametro, busca o endereco no banco e 
	 * retorna objeto transformado em DTO para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
	 * @param {@link Integer}
	 * @return {@link EnderecoDTO}
	 */
	@RequestMapping(value = "/endereco/{id}", method = RequestMethod.GET)
	public @ResponseBody EnderecoDTO buscarEnderecoPorId(@PathVariable Integer id) {
		return new EnderecoDTO(enderecoDao.readById(id));
	}
	
	/**
	 * Metodo que busca enderecos.
	 * 
	 * Metodo que busca enderecos no banco e retorna objetos transformados
	 * em DTO para a view.
	 * 
	 * @author Vitor Peres <b>vitor.peres@senior.com.br</b>
	 * @author Gabriel Simon <b>gabrielsimon775@gmail.com</b>
	 * @return {@link EnderecoDTO}
	 */
	@RequestMapping(value = "/endereco", method = RequestMethod.GET)
	public @ResponseBody List<EnderecoDTO> buscarTodosEnderecos() {
		List<EnderecoDTO> listaEnderecoDTO = new ArrayList<EnderecoDTO>();
		for(Endereco endereco :  enderecoDao.getAll()) {
			listaEnderecoDTO.add(new EnderecoDTO(endereco));
		}
		return listaEnderecoDTO;
	}

}

