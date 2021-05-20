package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Conta;
import br.com.proway.senior.godevcadastrogrupo1.model.Contatos;
import br.com.proway.senior.godevcadastrogrupo1.model.Dependente;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumDadosPessoais.IdentidadeGenero;

/**
 * Classe ColaboradorCompletoDTO.
 * 
 * Classe para interação via Controller API, referencia a {@link Colaborador}.
 * Oferece as informações completas do colaborador, podendo ser utilizada para 
 * relatórios. As informações simplificadas para os demais módulos do sistema,
 * estão disponíveis em {@link ColaboradorSimplificadoDTO}.
 * 
 * @author Sarah Neuburger Brito <b>sarah.brito@senior.com.br</b>
 */
public class ColaboradorCompletoDTO {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private LocalDate dataDeNascimento;
	private String nacionalidade;
	private String naturalidade;
	private Boolean pcd; 
	private String genero; 
	private IdentidadeGenero identidadeGenero;
	private Endereco endereco; 
	private String cpf; 
	private String rg; 
	private Contatos contatos; 
	private Integer idPostoDeTrabalho;
	private Integer nit; 
	private Boolean optanteVT; 
	private Boolean optanteVAVR;
	private LocalDate dataAdmissao;
	private Boolean optanteDependente;
	private String registro_alistamento; 
	private String email_corporativo;
	private String titulo_eleitor;
	private Conta conta; 
	private ExameMedico exameMedico;
	private Dependente dependente;
	
}
