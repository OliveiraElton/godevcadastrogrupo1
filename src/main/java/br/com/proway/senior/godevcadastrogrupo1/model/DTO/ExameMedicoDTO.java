package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico;
import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

/**
* Classe ExameMedicoDTO.
* 
* Classe para interação via Controller API, tem referência com {@link Colaborador}.
* 
* @author Elton Oliveira <elton.oliveira@senior.com.br>
 */
public class ExameMedicoDTO {
	
	private int id;
	TiposExames tipoExame;
	private LocalDate dataExame;
	private boolean apto;
	
	public ExameMedicoDTO(ExameMedico exameMedico) {
		this.id = exameMedico.getId();
		this.tipoExame = exameMedico.getTipoExame();
		this.dataExame = exameMedico.getDataExame();
		this.apto = exameMedico.isApto();
	}

	public int getId() {
		return id;
	}

	public TiposExames getTipoExame() {
		return tipoExame;
	}

	public LocalDate getDataExame() {
		return dataExame;
	}

	public boolean isApto() {
		return apto;
	}


	

}
