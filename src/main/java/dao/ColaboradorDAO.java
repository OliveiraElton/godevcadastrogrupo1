package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import model.Colaborador;

public class ColaboradorDAO implements InterfaceDao<Colaborador>{
	private static ColaboradorDAO instance;
	private Session session;
	
	public static ColaboradorDAO getInstance(Session session) {
		if (instance == null)
			instance = new ColaboradorDAO(session);
		return instance;
	}
	
	private ColaboradorDAO(Session session) {
		this.session = session;
	}

	public Colaborador create(Colaborador item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Colaborador readById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Colaborador readByNomeSobrenome(String nome, String sobrenome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Colaborador> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Colaborador item) {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer update(Integer id, Colaborador itemAntigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
