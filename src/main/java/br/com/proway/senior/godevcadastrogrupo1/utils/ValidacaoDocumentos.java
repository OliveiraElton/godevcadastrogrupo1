package br.com.proway.senior.godevcadastrogrupo1.utils;

/**
 * Classe responsavel por validar os dados dos documentos. Utilizado em conjunto
 * com a classe FormatacaoDocumentos.
 *
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com>
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 *
 */
public class ValidacaoDocumentos {

	/**
	 * Validar CPF.
	 * 
	 * Utiliza o algoritmo para verificar se o CPF contido na String eh valido.
	 * 
	 * @param String CPF que sera validado.
	 * @return boolean
	 */
	public static boolean validarCPF(String CPF) {

		String CPFFormatado = FormatacaoDocumentos.removerCaracteres(CPF);
		if (CPFFormatado.length() != 11) {

			return false;
		}

		return validaPrimeiroDigitoCPF(CPFFormatado) && validaSegundoDigitoCPF(CPFFormatado);
	}

	/**
	 * Valida primeiro digito CPF.
	 * 
	 * Metodo utilizado para verificar se o CPF eh valido atraves do primeiro
	 * digito, conforme regra do governo.
	 * 
	 * @param String CPFFormatado CPF que sera verificado.
	 * @return boolean
	 */
	private static boolean validaPrimeiroDigitoCPF(String CPFFormatado) {
		int soma = 0;
		int mult = 10;

		for (int i = 0; i < 9; i++) {
			soma += mult * ((CPFFormatado.charAt(i) - 48));
			mult--;
		}

		return ((11 - soma % 11 == CPFFormatado.charAt(9) - 48)
				^ (11 - soma % 11 == 10 && CPFFormatado.charAt(9) - 48 == 0));
	}

	/**
	 * Valida segundo digito CPF.
	 * 
	 * Metodo utilizado para verificar se o CPF eh valido atraves do segundo digito,
	 * conforme regra do governo.
	 * 
	 * @param String CPFFormatado CPF que sera verificado.
	 * @return boolean
	 */
	private static boolean validaSegundoDigitoCPF(String CPFFormatado) {
		int soma = 0;
		int mult = 11;

		for (int i = 0; i < 10; i++) {
			soma += mult * ((CPFFormatado.charAt(i) - 48));
			mult--;
		}
		return ((11 - soma % 11 == CPFFormatado.charAt(10) - 48)
				^ (11 - soma % 11 == 10 && CPFFormatado.charAt(10) - 48 == 0));
	}

	/**
	 * Valida o tamanho do telefone
	 * 
	 * Este metodo verifica se ha 11 ou 10 digitos no telefone. Se houver ele
	 * retorna true caso contraio, retorna false.
	 * 
	 * @param String telefone que sera verificado.
	 * @return boolean
	 * @throws Exception
	 */

	public static boolean validarTamanhoTelefone(String telefone) throws Exception {
		if (telefone.length() == 11 || telefone.length() == 10) {
			return true;
		}
		throw new Exception("Numero de digitos incorretos");
	}

	/**
	 * Validar email
	 * 
	 * Realiza validacao do email para verificar se possui o caracter "@".
	 * 
	 * @param String email que sera verificado.
	 * @return boolean
	 */
	public static boolean validarEmail(String email) throws Exception {
		if (email.contains("@") && email.contains(".com")) {
			return true;
		}
		throw new Exception("Email informado inválido");
	}

	/**
	 * Verifica se CEP contem 8 digitos
	 * 
	 * @param String cep CEP que sera verificado.
	 * @return boolean.
	 */
	public static boolean validarCEP(String cep) {
		if (FormatacaoDocumentos.removerCaracteres(cep).length() != 8) {
			return false;
		}
		return true;
	}

	/**
	 * Verifica se um numero de CNPJ eh valido.
	 * 
	 * Retorna true, caso o CNPJ seja valido
	 * 
	 * @param String cnpj que sera verificado.
	 * @return boolean
	 */
	public static boolean validarCNPJ(String cnpj) {
		String cnpjFormatado = FormatacaoDocumentos.removerCaracteresCnpj(cnpj);

		if (cnpjFormatado.length() != 14) {
			return false;
		}

		int primeiroDigito;
		int soma = 0;
		int resultado = 0;
		for (int i = 0, j = 5; i < 12; i++, j--) {
			if (j == 1) {
				j = 9;
				soma += (cnpjFormatado.charAt(i) - 48) * j;
			} else {
				soma += (cnpjFormatado.charAt(i) - 48) * j;
			}
		}

		resultado = soma % 11;
		if (resultado < 2) {
			primeiroDigito = 0;
			if ((cnpjFormatado.charAt(12) - 48) != primeiroDigito) {
				return false;
			}
		} else {
			primeiroDigito = 11 - resultado;
			if ((cnpjFormatado.charAt(12) - 48) != primeiroDigito) {
				return false;
			}
		}

		// Etapa do Segundo Digito
		int segundoDigito;
		int soma2 = 0;
		int resultado2 = 0;
		for (int i = 0, j = 6; i <= 12; i++, j--) {
			if (j == 1) {
				j = 9;
				soma2 += (cnpjFormatado.charAt(i) - 48) * j;
			} else {
				soma2 += (cnpjFormatado.charAt(i) - 48) * j;
			}
		}
		
		resultado2 = soma2 % 11;

		if (resultado2 < 2) {
			segundoDigito = 0;
			if ((cnpjFormatado.charAt(13) - 48) != segundoDigito) {
				return false;
			}
		} else {
			segundoDigito = 11 - resultado2;
			if ((cnpjFormatado.charAt(13) - 48) != segundoDigito) {
				return false;
			}
		}

		return true;
	}

}
