package controllerDTO;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.controller.DTO.DependenteSimplificadoControllerAPI;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.DependenteDAO;
import br.com.proway.senior.godevcadastrogrupo1.model.DTO.DependenteSimplificadoDTO;
import br.com.proway.senior.godevcadastrogrupo1.persistencia.BDConexao;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.IdentidadeGenero;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumDadosPessoais.TiposDependentes;
import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;
/**
 * Classe DependenteSimplificadoControllerApiTest
 * 
 * Testes dos metodos da classe {@link DependenteSimplificadoControllerAPI}.
 * 
 * @author Sprint 5
 * @author Vitor Cesar Peres <b>vitor.peres@senior.com.br</b>
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 *
 */
public class DependenteSimplificadoControllerApiTest{
	
	static LocalDate data;
	static Session session;
	static DependenteDAO dao;
	static ColaboradorDAO daoColab;
	static DependenteSimplificadoControllerAPI dependenteApi;
	
	@Before
	public void limparTabela(){
		dao.deleteAll();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	data = LocalDate.of(2002, 01, 28);
	session = BDConexao.getSessao();
	dao = DependenteDAO.getInstance(session);
	daoColab = ColaboradorDAO.getInstance(session);
	dependenteApi = new DependenteSimplificadoControllerAPI();
	
	}
	@Test
	public void testBuscarDependentePorId() {
		Endereco endereco = new Endereco("Rua 10", 5, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		
		DependenteSimplificadoDTO dependenteDTO = new DependenteSimplificadoDTO(dependente);
		DependenteSimplificadoDTO dependenteDTORetorno = dependenteApi.buscarDependentePorId(dependenteDTO.getId());
		assertEquals(dependenteDTO.getId(), dependenteDTORetorno.getId());
		assertEquals(dependenteDTO.getDataDeNascimento(), dependenteDTORetorno.getDataDeNascimento());
		assertEquals(dependenteDTO.getCpf(), dependenteDTORetorno.getCpf());
	}

	@Test
	public void testBuscarDependentePorIdColaborador() throws Exception {
		IdentidadeGenero ig = EnumDadosPessoais.IdentidadeGenero.TRANS;
		LocalDate data = LocalDate.of(2002, 01, 28);
		TiposExames te = EnumExamesMedicos.TiposExames.ADMISSIONAL;
		TiposDependentes td = EnumDadosPessoais.TiposDependentes.CONJUGE;
		Colaborador colaborador = ColaboradorController.cadastrarColaborador("Joana", "Marla", "Nada consta", data,
				"Venezuelano", "Blumenauense", true, "Feminino", ig, "09619039610", "mg14388606", 8, 8788881, false, false, data,
				false, "88080888708", "joana@gmail.com", "04040505050", "Rua 1", 9, "Casa", "54126547", "Centro", "Brasil", "Blumenau", "SC",
				"4521452015", "5421452103", "brian.santos@empresa.com.br", "1542413655", te, null, true, "banco00",
				"055", "438614625", "154", "joãozinho", "Santos", "Erika", data, "Venezuelano", "Blumenauense", true,
				"Feminino", ig, "09619039610", "mg14388606", td, true);
	
		List<DependenteSimplificadoDTO> listaDependenteSimplificadoDTO = dependenteApi.buscarDependentePorIdColaborador(colaborador.getId());
		assertEquals("joãozinho" ,listaDependenteSimplificadoDTO.get(0).getNome());
	}
	
	@Test
	public void testBuscarTodosDependentes() {
		Endereco endereco = new Endereco("Rua Brasil", 5, "Casa", "54215365", "Centro", "Brasil", "Blumanau", "SC");
		Dependente dependente = new Dependente("Joao", "Fonseca", "Jenifer", data, "Brasileira",
				"Blumenau", true, "Masculino", IdentidadeGenero.TRANS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		Dependente dependente2 = new Dependente("Carla", "Fonseca", "Nada consta", data, "Brasileira",
				"Blumenau", true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610","123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente2);
		List<DependenteSimplificadoDTO> listaDependenteDTO = new ArrayList<DependenteSimplificadoDTO>();
		listaDependenteDTO.add(new DependenteSimplificadoDTO(dependente));
		listaDependenteDTO.add(new DependenteSimplificadoDTO(dependente2));
		assertEquals(listaDependenteDTO.size(), dependenteApi.buscarTodosDependentes().size());

	}
	@Test
	public void testBuscarDependentePorNome() {
		Endereco endereco = new Endereco("Rua 10", 10, "Casa", "54215365", "Centro", "Brasil", "Blumenau", "SC");
		Dependente dependente = new Dependente("Carolina", "Fonseca", "Jenifer", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610", "123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente);
		Dependente dependente2 = new Dependente("Barbara", "Fonseca", "Nada consta", data, "Venezuelano",
				"Cidade del Leste", true, "Feminino", IdentidadeGenero.CIS, endereco, "09619039610", "123", 
				EnumDadosPessoais.TiposDependentes.FILHO, true);
		dao.create(dependente2);
		List<DependenteSimplificadoDTO> listaDependenteSimplificadoDTO = dependenteApi.buscarDependentePorNome("Barbara");
		assertEquals(1 ,listaDependenteSimplificadoDTO.size());
	}

}
