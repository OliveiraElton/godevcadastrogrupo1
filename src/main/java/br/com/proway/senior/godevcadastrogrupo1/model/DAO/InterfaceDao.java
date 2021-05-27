package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import java.util.List;

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
	
	public T cadastrar(T item);

	public T consultarPorId(Class <T> item, Integer id);

	public List<T> consultarTodos(Class <T> item);

	public boolean deletar(T item);
	
	public boolean deletarTodos(String tabela);
	
	public T atualizar(T item);
	
}
