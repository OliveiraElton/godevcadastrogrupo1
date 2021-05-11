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
 */
public class DaoFactory<T> implements InterfaceDao<T>{
	
	public ArrayList<T> itens = new ArrayList<T>();
	
	/**
	 * Cadastrar algo
	 * 
	 * Insere algo de determinado tipo no ArrayList de determinado tipo
	 * 
	 * @param item; de tipo flex�vel  
	 * @return true; cadastro realizado com sucesso
	 */
	public boolean create(T item) {
		itens.add(item);
		return true;
	}

	/**
	 * Retorna algo
	 * 
	 * Retorna algo de determiando tipo contido no ArrayList de determinado tipo
	 * 
	 * @param item; de tipo flex�vel  
	 * @return item; algo desejado existe 
	 * @return null; cadastro n�o existe
	 */
	public T readById(T item) {
		if (itens.contains(item)) {
			return (item);
		} else {
			return null;
		}
	}

	/**
	 * Retorna ArrayList
	 * 
	 * Retorna o ArrayList de determinado tipo	  
	 * 
	 * @return itens; ArrayList que cont�m todos os cadastros
	 */
	public ArrayList<T> getAll() {
		return itens;
	}

	/**
	 * Deleta algo
	 * 
	 * Tira algo de determinado tipo do ArrayList de determinado tipo
	 * 
	 * @param item; de tipo flex�vel  
	 * @return true; deleta��o realizada com sucesso
	 */
	public boolean delete(T item) {
		itens.remove(item);
		return true;
	}

	/**
	 * Atualiza algo
	 * 
	 * Troca algo de determinado tipo no ArrayList de determinado tipo por outro do mesmo tipo;
	 * 
	 * @param item; de tipo flex�vel  
	 * @param itemAntigo; de tipo flex�vel 
	 * @return true; atualiza��o realizada com sucesso
	 */
	public boolean update(T item, T itemAntigo) {
		int indice = itens.indexOf(itemAntigo);
		itens.set(indice, item);
		return true;
	}

}
