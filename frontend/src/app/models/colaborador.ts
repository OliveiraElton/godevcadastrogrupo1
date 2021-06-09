import { R3ResolvedDependencyType } from "@angular/compiler";

export interface Colaborador {

    // String nome, String sobrenome, String nomeSocial, LocalDate dataDeNascimento,
			//String nacionalidade, String naturalidade, Boolean pcd, String genero, IdentidadeGenero identidadeGenero,
			//Escolaridade escolaridade, EstadoCivil estadoCivil, String nomeMae, String nomePai, Endereco endereco,
			//String cpf, String rg, Contatos contatos, Integer idPostoDeTrabalho, Integer nit, Boolean optanteVT,
			//Boolean optanteVAVR, LocalDate dataAdmissao, Boolean optanteDependente, String registro_alistamento,
			//String email_corporativo, String titulo_eleitor, Conta conta, ExameMedico exameMedico,
			//Dependente dependente

    nomeColab: String;
    sobrenomeColab: String;
    nomeSocialColab: String;
    dataNascColab: Date;
    nacionalidadeColab: String;
    naturalidadeColabo: String;
    ehPcdColab: Boolean;
    generoColab: String;
    identGeneroColab: String;
    escolaridadeColab: String;
    estadoCivilColab: String;
    nomeMaeColab: String;
    nomePaiColab: String;
    endereco: Endereco;
    cpfColab: String;
    rgColab: String;
    contatos: Contatos;
    idPostoTrabalho: Number;
    pisColab: Number;
    ehOptanteVTColab: Boolean;
    ehOptanteVAVRColab: Boolean;
    dataInicioColab: Date;
    ehOptanteDepColab: Boolean;
    reservistaColab: String;
    emailCorpColab: String;
    tituloColab: String;
    conta: Conta:
    exameMedico: ExameMedico;
    dependente: Dependente;    
}
