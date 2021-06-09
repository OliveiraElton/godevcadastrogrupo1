import { R3ResolvedDependencyType } from "@angular/compiler";
import { Contatos } from "./contatos";
import { Dependentes } from "./dependentes";
import { Endereco } from "./endereco";
import { ExameMedico } from "./exameMedico";

export interface Colaborador {

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
    dependente: Dependentes;    
}
