package br.com.proway.senior.godevcadastrogrupo1.utilidades;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Classe de apoio para ser utilizada em {@link Pessoa} para setar a
 * identidade de genero e em {@link Dependente} para setar o tipos de 
 * depenente.
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com>
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 */

public class EnumDadosPessoais {
	
	
	public enum IdentidadeGenero {
		TRANS, CIS
	}

	public enum TiposDependentes {
		FILHO, CONJUGE, MAE, PAI
	}
	
	public enum Escolaridade{
		ANALFABETO, ATE_QUARTA_SERIE, FUNDAMENTAL_COMPLETO, MEDIO_INCOMPLETO,
		MEDIO_COMPLETO, SUPERIOR_INCOMPLETO, SUPERIOR_COMPLETO, POS_GRADUACAO, MESTRADO, DOUTORADO
	}
	
	public enum EstadoCivil{
		SOLTEIRO, CASADO, UNIAO_ESTAVEL, VIUVO, DIVORCIADO, SEPARADO
	}
}