package dao;

import java.util.ArrayList;

/**
 * Implementa m�todos do DAO.
 * Classe respons�vel por implementar de forma gen�rica os m�todos da interface DAO.
 * Deve ser extendida pelas classes espec�ficas para os m�todos serem utiliz�veis.
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 * @param <T>
 * @param <T>
 */
public class DaoFactory<T> implements InterfaceDao<T>{

	public T create(T item) {
		
		return null;
	}

	public T readById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer update(T item) {
		// TODO Auto-generated method stub
		return null;
	}

}
