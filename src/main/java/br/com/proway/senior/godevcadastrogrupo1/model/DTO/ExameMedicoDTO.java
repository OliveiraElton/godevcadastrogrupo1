package br.com.proway.senior.godevcadastrogrupo1.model.DTO;

import java.time.LocalDate;

import br.com.proway.senior.godevcadastrogrupo1.utils.EnumExamesMedicos.TiposExames;

public class ExameMedicoDTO {
	
	private int id;
	TiposExames tipoExame;
	private LocalDate dataExame;
	
	public ExameMedicoDTO(ExameMedicoDTO exameMedicoDTO) {
		this.id = exameMedicoDTO.getId();
		this.tipoExame = exameMedicoDTO.getTipoExame();
		this.dataExame = exameMedicoDTO.getDataExame();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}
