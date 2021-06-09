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
   /* empresa: number; */
    setor: string;
    dataInicio: Date;
    telefonePrincipal: number;
    telefoneSecundario: number;
    telefoneFamiliar: number;
    email: string;
}
