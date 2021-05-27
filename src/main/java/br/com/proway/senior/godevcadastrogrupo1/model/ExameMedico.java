package br.com.proway.senior.godevcadastrogrupo1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.proway.senior.godevcadastrogrupo1.utilidades.EnumExamesMedicos.TiposExames;

/**
 * Classe ExameMedico.
 * 
 * Classe recebe informacoes para cadastro dos exames medicos que serao
 * instanciados na classe {@link Colaborador} para o cadastramento do mesmo.
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	TiposExames tipoExame;
	private LocalDate dataExame;
	private boolean apto;
	
	public ExameMedico() {
		
	}
	
	/**
	 * Construtor padrao da classe.
	 * 
	 * @param tipoExame
	 * @param dataExame
	 * @param apto
	 */
	public ExameMedico(TiposExames tipoExame, LocalDate dataExame, boolean apto) {
		this.setTipoExame(tipoExame);
		this.setDataExame(dataExame);
		this.setApto(apto);
	}
	
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

	public Integer getId() {
		return this.id;
	}
}
