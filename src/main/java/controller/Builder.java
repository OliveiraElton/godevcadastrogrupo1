package controller;

import java.time.LocalDate;

import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMDadosPessoais.TiposDependentes;
import enums.EMOutros.TiposExames;
import model.Dependente;
import model.Empresa;
import model.Endereco;

public interface Builder {
	
	public void setNome(String nome);
	public void setSobrenome(String sobrenome);
	public void setNomeSocial(String nomeSocial);
	public void setDataDeNascimento(LocalDate dataNascimento);
	public void setNacionalidade(String nacionalidade);
	public void setNaturalidade(String naturalidade);
	public void setPcd(Boolean pcd);
	public void setGenero(String genero);
	public void setIdentidadeGenero(IdentidadeGenero identidadeGenero);
	public void setEndereco(String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf);
	public void setCpf(String cpf);
	public void setRg(String rg);
	public void setIdCargo(Integer idCargo);
	public void setNit(Integer nit);
	public void setOptanteVT(Boolean optanteVT);
	public void setOptanteVAVR(Boolean optanteVAVR);
	public void setDataAdmissao(LocalDate dataAdmissao);
	public void setOptanteDependente(Boolean optanteDependente);
	public void setRegistro_alistamento(String ra);
	public void setEmail_corporativo(String emailCorporatico);
	public void setTitulo_eleitor(String tituloElitor);
	public void setConta(String nomeBanco, String agencia, String numeroConta, String digitoVerificador);
	public void setContatos(String telefonePrincipal, String telefoneSecundario, String email,
			String telefoneFamiliar);
	public void setExameMedico(TiposExames tipoExame, LocalDate dataExame, Boolean apto);
	public void setDependente(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, Boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg,
			TiposDependentes tipoDependente, Boolean optanteIR);
	public void setTipoDependente(TiposDependentes tipoDependente);
	public void setOptanteIR(Boolean optanteIR);
	public void setDataInicioContrato(LocalDate dataInicioContrato);
	public void setEmpresa(Empresa empresa);
	public void setIdSetor(Integer setor);
	
}