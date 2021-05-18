package controller;

import java.time.LocalDate;

import enums.EMDadosPessoais.IdentidadeGenero;
import enums.EMDadosPessoais.TiposDependentes;
import enums.EMOutros.TiposExames;
import model.Contatos;
import model.Empresa;
import model.Endereco;

public class Director {

	private static PessoaBuilder builder = new PessoaBuilder();

	private static void criarPessoa(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf) {
		builder.setNome(nome);
		builder.setSobrenome(sobrenome);
		builder.setNomeSocial(nomeSocial);
		builder.setDataDeNascimento(dataDeNascimento);
		builder.setNacionalidade(nacionalidade);
		builder.setNaturalidade(naturalidade);
		builder.setPcd(pcd);
		builder.setGenero(genero);
		builder.setIdentidadeGenero(identidadeGenero);
		builder.setEndereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);
		builder.setCpf(cpf);
		builder.setRg(rg);
	}

	private static void criarPessoa(String nome, String sobrenome, LocalDate dataDeNascimento, String cpf, String rg,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf) {
		builder.setNome(nome);
		builder.setSobrenome(sobrenome);
		builder.setDataDeNascimento(dataDeNascimento);
		builder.setEndereco(logradouro, numero, complemento, cep, bairro, pais, cidade, uf);
		builder.setCpf(cpf);
		builder.setRg(rg);
	}

	/**
	 * Colaborador completo com dependente
	 * 
	 * 
	 * @param builder
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param cpf
	 * @param rg
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 * @param nomeBanco
	 * @param agencia
	 * @param numeroConta
	 * @param digitoVerificador
	 * @param nomeDependente
	 * @param sobrenomeDependente
	 * @param nomeSocialDependente
	 * @param dataDeNascimentoDependente
	 * @param nacionalidadeDependente
	 * @param naturalidadeDependente
	 * @param pcdDependente
	 * @param generoDependente
	 * @param identidadeGeneroDependente
	 * @param cpfDependente
	 * @param rgDependente
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public static void criarColaborador(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg, Integer idCargo, Integer nit, boolean optanteVT, boolean optanteVAVR,
			LocalDate dataAdmissao, boolean optanteDependente, String registro_alistamento, String email_corporativo,
			String titulo_eleitor, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf, String telefonePrincipal, String telefoneSecundario, String email,
			String telefoneFamiliar, TiposExames tipoExame, LocalDate dataExame, boolean apto, String nomeBanco,
			String agencia, String numeroConta, String digitoVerificador, String nomeDependente,
			String sobrenomeDependente, String nomeSocialDependente, LocalDate dataDeNascimentoDependente,
			String nacionalidadeDependente, String naturalidadeDependente, boolean pcdDependente,
			String generoDependente, IdentidadeGenero identidadeGeneroDependente, String cpfDependente,
			String rgDependente, TiposDependentes tipoDependente, boolean optanteIR) {

		criarPessoa(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg, logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		builder.setContatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		builder.setIdCargo(idCargo);
		builder.setNit(nit);
		builder.setOptanteVT(optanteVT);
		builder.setOptanteVAVR(optanteVAVR);
		builder.setDataAdmissao(dataAdmissao);
		builder.setOptanteDependente(optanteDependente);
		builder.setRegistro_alistamento(registro_alistamento);
		builder.setEmail_corporativo(email_corporativo);
		builder.setTitulo_eleitor(titulo_eleitor);
		builder.setConta(nomeBanco, agencia, numeroConta, digitoVerificador);
		builder.setExameMedico(tipoExame, dataExame, apto);
		builder.setDependente(nomeDependente, sobrenomeDependente, nomeSocialDependente, dataDeNascimentoDependente,
				nacionalidadeDependente, naturalidadeDependente, pcdDependente, generoDependente,
				identidadeGeneroDependente, cpfDependente, rgDependente, tipoDependente, optanteIR);
	}

	/**
	 * Colaborador completo sem dependente
	 * 
	 * @param builder
	 * @param nome
	 * @param sobrenome
	 * @param nomeSocial
	 * @param dataDeNascimento
	 * @param nacionalidade
	 * @param naturalidade
	 * @param pcd
	 * @param genero
	 * @param identidadeGenero
	 * @param cpf
	 * @param rg
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 * @param nomeBanco
	 * @param agencia
	 * @param numeroConta
	 * @param digitoVerificador
	 * @param nomeDependente
	 * @param sobrenomeDependente
	 * @param nomeSocialDependente
	 * @param dataDeNascimentoDependente
	 * @param nacionalidadeDependente
	 * @param naturalidadeDependente
	 * @param pcdDependente
	 * @param generoDependente
	 * @param identidadeGeneroDependente
	 * @param cpfDependente
	 * @param rgDependente
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public static void criarColaborador(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String cpf, String rg, Integer idCargo, Integer nit, boolean optanteVT, boolean optanteVAVR,
			LocalDate dataAdmissao, boolean optanteDependente, String registro_alistamento, String email_corporativo,
			String titulo_eleitor, String logradouro, Integer numero, String complemento, String cep, String bairro,
			String pais, String cidade, String uf, String telefonePrincipal, String telefoneSecundario, String email,
			String telefoneFamiliar, TiposExames tipoExame, LocalDate dataExame, boolean apto, String nomeBanco,
			String agencia, String numeroConta, String digitoVerificador) {

		criarPessoa(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg, logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		builder.setContatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		builder.setIdCargo(idCargo);
		builder.setNit(nit);
		builder.setOptanteVT(optanteVT);
		builder.setOptanteVAVR(optanteVAVR);
		builder.setDataAdmissao(dataAdmissao);
		builder.setOptanteDependente(optanteDependente);
		builder.setRegistro_alistamento(registro_alistamento);
		builder.setEmail_corporativo(email_corporativo);
		builder.setTitulo_eleitor(titulo_eleitor);
		builder.setConta(nomeBanco, agencia, numeroConta, digitoVerificador);
		builder.setExameMedico(tipoExame, dataExame, apto);
	}

	/**
	 * Colaborador só com atributos obrigatórios sem dependente
	 * 
	 * @param builder
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param cpf
	 * @param rg
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 * @param nomeBanco
	 * @param agencia
	 * @param numeroConta
	 * @param digitoVerificador
	 */
	public static void criarColaborador(String nome, String sobrenome, LocalDate dataDeNascimento, String cpf,
			String rg, Integer idCargo, Integer nit, boolean optanteVT, boolean optanteVAVR, LocalDate dataAdmissao,
			boolean optanteDependente, String registro_alistamento, String email_corporativo, String titulo_eleitor,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf, String telefonePrincipal, String telefoneSecundario, String email,
			String telefoneFamiliar, TiposExames tipoExame, LocalDate dataExame, boolean apto, String nomeBanco,
			String agencia, String numeroConta, String digitoVerificador) {

		criarPessoa(nome, sobrenome, dataDeNascimento, cpf, rg, logradouro, numero, complemento, cep, bairro, pais,
				cidade, uf);

		builder.setContatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		builder.setIdCargo(idCargo);
		builder.setNit(nit);
		builder.setOptanteVT(optanteVT);
		builder.setOptanteVAVR(optanteVAVR);
		builder.setDataAdmissao(dataAdmissao);
		builder.setOptanteDependente(optanteDependente);
		builder.setRegistro_alistamento(registro_alistamento);
		builder.setEmail_corporativo(email_corporativo);
		builder.setTitulo_eleitor(titulo_eleitor);
		builder.setConta(nomeBanco, agencia, numeroConta, digitoVerificador);
		builder.setExameMedico(tipoExame, dataExame, apto);
	}

	/**
	 * Colaborador Só com atributos obrigatorios com dependente
	 * 
	 * @param builder
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param cpf
	 * @param rg
	 * @param idCargo
	 * @param nit
	 * @param optanteVT
	 * @param optanteVAVR
	 * @param dataAdmissao
	 * @param optanteDependente
	 * @param registro_alistamento
	 * @param email_corporativo
	 * @param titulo_eleitor
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param telefonePrincipal
	 * @param telefoneSecundario
	 * @param email
	 * @param telefoneFamiliar
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 * @param nomeBanco
	 * @param agencia
	 * @param numeroConta
	 * @param digitoVerificador
	 * @param nomeDependente
	 * @param sobrenomeDependente
	 * @param nomeSocialDependente
	 * @param dataDeNascimentoDependente
	 * @param nacionalidadeDependente
	 * @param naturalidadeDependente
	 * @param pcdDependente
	 * @param generoDependente
	 * @param identidadeGeneroDependente
	 * @param cpfDependente
	 * @param rgDependente
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public static void criarColaborador(String nome, String sobrenome, LocalDate dataDeNascimento, String cpf,
			String rg, Integer idCargo, Integer nit, boolean optanteVT, boolean optanteVAVR, LocalDate dataAdmissao,
			boolean optanteDependente, String registro_alistamento, String email_corporativo, String titulo_eleitor,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf, String telefonePrincipal, String telefoneSecundario, String email,
			String telefoneFamiliar, TiposExames tipoExame, LocalDate dataExame, boolean apto, String nomeBanco,
			String agencia, String numeroConta, String digitoVerificador, String nomeDependente,
			String sobrenomeDependente, String nomeSocialDependente, LocalDate dataDeNascimentoDependente,
			String nacionalidadeDependente, String naturalidadeDependente, boolean pcdDependente,
			String generoDependente, IdentidadeGenero identidadeGeneroDependente, String cpfDependente,
			String rgDependente, TiposDependentes tipoDependente, boolean optanteIR) {

		criarPessoa(nome, sobrenome, dataDeNascimento, cpf, rg, logradouro, numero, complemento, cep, bairro, pais,
				cidade, uf);

		builder.setContatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		builder.setIdCargo(idCargo);
		builder.setNit(nit);
		builder.setOptanteVT(optanteVT);
		builder.setOptanteVAVR(optanteVAVR);
		builder.setDataAdmissao(dataAdmissao);
		builder.setOptanteDependente(optanteDependente);
		builder.setRegistro_alistamento(registro_alistamento);
		builder.setEmail_corporativo(email_corporativo);
		builder.setTitulo_eleitor(titulo_eleitor);
		builder.setConta(nomeBanco, agencia, numeroConta, digitoVerificador);
		builder.setExameMedico(tipoExame, dataExame, apto);
		builder.setDependente(nomeDependente, sobrenomeDependente, nomeSocialDependente, dataDeNascimentoDependente,
				nacionalidadeDependente, naturalidadeDependente, pcdDependente, generoDependente,
				identidadeGeneroDependente, cpfDependente, rgDependente, tipoDependente, optanteIR);
	}

	/**
	 * Prestador de serviço completo
	 * 
	 * @param builder
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
	 * @param nomeEmpresa
	 * @param cnpj
	 */
	public static void criarPrestadorServico(String nome, String sobrenome, String nomeSocial,
			LocalDate dataDeNascimento, String nacionalidade, String naturalidade, boolean pcd, String genero,
			IdentidadeGenero identidadeGenero, Endereco endereco, String cpf, String rg, Contatos contatos,
			LocalDate dataInicioContrato, Empresa empresa, Integer idSetor, String telefonePrincipal,
			String telefoneSecundario, String email, String telefoneFamiliar, String logradouro, Integer numero,
			String complemento, String cep, String bairro, String pais, String cidade, String uf, String nomeEmpresa,
			String cnpj) {
		criarPessoa(nome, sobrenome, nomeSocial, dataDeNascimento, nacionalidade, naturalidade, pcd, genero,
				identidadeGenero, cpf, rg, logradouro, numero, complemento, cep, bairro, pais, cidade, uf);

		builder.setContatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		builder.setEmpresa(empresa);
		builder.setIdSetor(idSetor);
		builder.setDataInicioContrato(dataInicioContrato);
	}

	/**
	 * Prestador de serviço só com atributtos obrigatórios
	 * 
	 * @param builder
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
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
	 * @param nomeEmpresa
	 * @param cnpj
	 */
	public static void criarPrestadorServico(String nome, String sobrenome, LocalDate dataDeNascimento,
			Endereco endereco, String cpf, String rg, Contatos contatos, LocalDate dataInicioContrato, Empresa empresa,
			Integer idSetor, String telefonePrincipal, String telefoneSecundario, String email, String telefoneFamiliar,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf, String nomeEmpresa, String cnpj) {
		criarPessoa(nome, sobrenome, dataDeNascimento, cpf, rg, logradouro, numero, complemento, cep, bairro, pais,
				cidade, uf);

		builder.setContatos(telefonePrincipal, telefoneSecundario, email, telefoneFamiliar);
		builder.setEmpresa(empresa);
		builder.setIdSetor(idSetor);
		builder.setDataInicioContrato(dataInicioContrato);
	}

	/**
	 * Dependente só com atributos obrigatórios.
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param cpf
	 * @param rg
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public static void criarDependente(String nome, String sobrenome, LocalDate dataDeNascimento, String logradouro,
			Integer numero, String complemento, String cep, String bairro, String pais, String cidade, String uf,
			String cpf, String rg, TiposDependentes tipoDependente, boolean optanteIR) {
		criarPessoa(nome, sobrenome, dataDeNascimento, cpf, rg, logradouro, numero, complemento, cep, bairro, pais,
				cidade, uf);
		builder.setTipoDependente(tipoDependente);
		builder.setOptanteIR(optanteIR);
	}

	/**
	 * Dependente só com atributos obrigatórios.
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
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param cep
	 * @param bairro
	 * @param pais
	 * @param cidade
	 * @param uf
	 * @param cpf
	 * @param rg
	 * @param tipoDependente
	 * @param optanteIR
	 */
	public static void criarDependente(String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			String nacionalidade, String naturalidade, boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			String logradouro, Integer numero, String complemento, String cep, String bairro, String pais,
			String cidade, String uf, String cpf, String rg, TiposDependentes tipoDependente, boolean optanteIR) {
		criarPessoa(nome, sobrenome, dataDeNascimento, cpf, rg, logradouro, numero, complemento, cep, bairro, pais,
				cidade, uf);
		builder.setTipoDependente(tipoDependente);
		builder.setOptanteIR(optanteIR);
	}

}
