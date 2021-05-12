package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enums.EMOutros.TiposExames;

/**
 * Classe ExameMedico.
 * 
 * Classe recebe informa��es para cadastro dos exames m�dicos que ser�o
 * instanciados na classe Colaborador para o cadastramento do mesmo.
 * 
 * Deve ser instanciada utilizando o ExameMedicoBuilder.
 * 
 * @author Lorran Pereira dos Santos, Samuel Levi, Sarah Neuburger Brito, Thiago
 *         Luiz Barbieri e Vitor Nathan Gon�alves.
 *         
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 */

@Entity
public class ExameMedico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	TiposExames tipoExame;
	private LocalDate dataExame;
	private boolean apto;

	/**
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 */
	public ExameMedico(TiposExames tipoExame, LocalDate dataExame, boolean apto) {
		this.tipoExame = tipoExame;
		this.dataExame = dataExame;
		this.apto = apto;
	}

//	public ExameMedico() {
//
//	}

	public TiposExames getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(TiposExames tipoExame) {
		this.tipoExame = tipoExame;
	}

	public LocalDate getDataExame() {
		return dataExame;
	}

	public void setDataExame(LocalDate dataExame) {
		this.dataExame = dataExame;
	}

	public boolean isApto() {
		return apto;
	}

	public void setApto(boolean apto) {
		this.apto = apto;
	}

	/**
	 * Cria ExameMedico.
	 *
	 * � utilizado para criar um objeto da classe ExameMedico.
	 * 
	 * Exemplo de uso:
	 * ExameMedico exameMedico = new ExameMedico.ExameMedicoBuilder().
				tipoExame(TiposExames.ADMISSIONAL).dataExame(LocalDate.of(2016, 11, 5)).
				apto(true).criarExameMedico();
	 *
	 * @author Bruna <sh4323202@gmail.com>
	 * @author Enzo <enzomm.bodyandmind@gmail.com> 
	 * @author Sabrina <sabrinaschmidt335@gmail.com>
	 * @author Vanderlei <vanderleik@yahoo.com.br>
	 * @author Vitor <vitornathang@gmail.com>
	 */
	public static class ExameMedicoBuilder {

		TiposExames tipoExame;
		private LocalDate dataExame;
		private boolean apto;

		public ExameMedicoBuilder tipoExame(TiposExames tipoExame) {
			this.tipoExame = tipoExame;
			return this;
		}

		public ExameMedicoBuilder dataExame(LocalDate dataExame) {
			this.dataExame = dataExame;
			return this;
		}

		public ExameMedicoBuilder apto(boolean apto) {
			this.apto = apto;
			return this;
		}

		public ExameMedico criarExameMedico() {
			return new ExameMedico(tipoExame, dataExame, apto);
		}
	}

	@Override
	public String toString() {
		return "ExameMedico [tipoExame=" + tipoExame + ", dataExame=" + dataExame + ", apto=" + apto;
	}
}
