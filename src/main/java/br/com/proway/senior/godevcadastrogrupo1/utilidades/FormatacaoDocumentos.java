package br.com.proway.senior.godevcadastrogrupo1.utilidades;

/**
 * Classe FormatacaoDocumentos.
 * 
 * Classe responsavel por conter todos os metodos de formatacao de dados. 
 * Eh utilizada em conjunto com a classe {@link ValidacaoDocumentos}.
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 *
 */
public class FormatacaoDocumentos {
	
	/**
	 * Remove caracteres.
	 * 
	 * Formata uma String para que possua apenas algarismos.
	 * 
	 * @param String entrada
	 * @return String
	 */
	public static String removerCaracteres(String entrada) {
		String output = "";
		for (byte code : entrada.getBytes()) {
			if (code - 48 < 10 && code - 48 >= 0) {
				output += Character.toString((char) code);
			}
		}
		return output;
	}	
}