import { Contatos } from "./contatos";
import { Empresa } from "./empresa";

export interface Prestador {
    id: number;
    nome: string;
    sobrenome: string;
    cpf: string;
    nomeSocial: string;
    genero: string;
    identidadeGenero: string;
    dataNascimento: Date;
    nacionalidade: string;
    naturalidade: string;
    rg: string;
    empresa: Empresa;
    idSetor: number;
    dataInicio: Date;
    contatos: Contatos;
}
