import { Contatos } from "./contatos";
import { Endereco } from "./endereco";

export interface Empresa {
    razaoSocial: String;
    cnpj: String;
    inicioContrato: Date;
    contatos: Contatos;
    endereco: Endereco;
}
