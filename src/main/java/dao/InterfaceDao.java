package dao;

import java.util.ArrayList;

/**
 * Interface gerenciamento de dados.
 * Interface respons�vel por definir quais ser�o os
 * m�todos que ser�o utilizados no gerenciamento de dados.
 * 
 * @author Bruna <sh4323202@gmail.com>
 * @author Enzo <enzomm.bodyandmind@gmail.com> 
 * @author Sabrina <sabrinaschmidt335@gmail.com>
 * @author Vanderlei <vanderleik@yahoo.com.br>
 * @author Vitor <vitornathang@gmail.com>
 *
 * @param <T>
 */
public interface InterfaceDao<T> {
	
	public boolean create(T item);

	public T readById(T item);

	public ArrayList<T> getAll();

	public boolean delete(T item);
	
	public boolean update(T item, T itemAntigo);
	
}
