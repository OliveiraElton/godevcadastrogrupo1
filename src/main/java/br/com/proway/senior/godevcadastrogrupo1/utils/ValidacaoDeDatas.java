package br.com.proway.senior.godevcadastrogrupo1.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe ValidacaoDatas.
 * 
 * Classe utilizada na validacao das datas do cadastro, os metodos serao
 * utilizados nas classes {@link Pessoa}, {@link Colaborador}, {@link Empresa},
 * e {@link PrestadorServico},
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com>
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 */
public class ValidacaoDeDatas {

	public static final int IDADE_MAXIMA_PARA_PESSOA = 120;
	public static final int IDADE_MINIMA_PARA_CONTRATO = 14;

	/**
	 * Corresponde ao tempo maximo (em anos) estimado que um colaborador podera
	 * trabalhar, levando em conta a idade minima para contratacao e tempo maximo
	 * que se espera que um ser humano viva.
	 */
	public static final int TEMPO_MAXIMO_PARA_ADMISSAO = IDADE_MAXIMA_PARA_PESSOA - IDADE_MINIMA_PARA_CONTRATO;

	/**
	 * Validar a data de nascimento de uma {@link Pessoa}.
	 * 
	 * Verifica se a data de nascimento informada esta entre 0 e 120 anos.
	 * 
	 * @param data Data de nascimento que sera verificada.
	 * @return true, caso a data seja valida.
	 */
	public static boolean validaDataDeNascimento(LocalDate data) {
		if (!(data.until(LocalDate.now(), ChronoUnit.YEARS) <= IDADE_MAXIMA_PARA_PESSOA)) {
			return false;
		}
		return true;
	}

	/**
	 * Validar data de admissao.
	 * 
	 * Verifica se a data informada eh condizente com uma data de admissao,
	 * considerando que pode ser retroativa em ate 30 dias e futura tambem em 30
	 * dias.
	 * 
	 * @param data Data de admissao que sera verificada.
	 * @return true, caso a data seja valida
	 */
	public static boolean validaDataAdmissao(LocalDate data) {
		if (data.until(LocalDate.now(), ChronoUnit.DAYS) <= 30) {
			return true;
		}
		return false;
	}

	/**
	 * Validar data de inicio do contrato.
	 * 
	 * Verifica se a data informada eh condizente com uma data de contrato entre a
	 * empresa e o Prestador de Servico.
	 * 
	 * @param data Data de inicio que sera verificada.
	 * @return true, caso a data seja valida
	 */
	public static boolean validaDataInicioContrato(LocalDate data) {
		if (data.until(LocalDate.now(), ChronoUnit.DAYS) >= 30) {
			return true;
		}
		return false;
	}

	/**
	 * Validar data passada.
	 * 
	 * Verifica se a data informada eh retroativa.
	 * 
	 * @param data Data que sera analisada.
	 * @return true, caso a data seja retroativa.
	 */
	public static boolean validaDataPassada(LocalDate data) {
		if (data.until(LocalDate.now(), ChronoUnit.YEARS) > 0) {
			return true;
		}
		return false;
	}

}
