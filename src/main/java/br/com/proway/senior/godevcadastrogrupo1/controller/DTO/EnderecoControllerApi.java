package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import org.hibernate.Session;

import br.com.proway.senior.godevcadastrogrupo1.controller.ColaboradorController;
import br.com.proway.senior.godevcadastrogrupo1.model.Colaborador;
import br.com.proway.senior.godevcadastrogrupo1.model.Endereco;
import br.com.proway.senior.godevcadastrogrupo1.model.DAO.EnderecoDAO;
import br.com.proway.senior.godevcadastrogrupo1.persistence.DBConnection;

public class EnderecoControllerApi {

	static Session session = DBConnection.getSession();
	static EnderecoDAO daoEndereco = EnderecoDAO.getInstance(session);

	public static Colaborador buscarEnderecoDoColaborador(int id) {
		ColaboradorController colaboradorController = new ColaboradorController();
		Colaborador colaborador = colaboradorController.buscarColaboradorPorId(id);
		Endereco end = EnderecoDTO(colaborador);
		return end;
	}

	private static Endereco EnderecoDTO(Colaborador colaborador) {
		return null;
	}

}

