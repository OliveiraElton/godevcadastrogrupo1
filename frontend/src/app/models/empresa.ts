import { Contatos } from "./contatos";
import { Endereco } from "./endereco";

export interface Empresa {
    id: number;
    razaoSocial: string;
    cnpj: string;
    inicioContrato: Date;
    contatos: Contatos;
    endereco: Endereco;
}
