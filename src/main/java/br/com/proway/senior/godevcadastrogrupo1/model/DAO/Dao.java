package br.com.proway.senior.godevcadastrogrupo1.model.DAO;

import org.hibernate.Session;

public abstract class Dao<T>{

	protected Session session;	

	/**
	 * Metodo para inserir dados no banco de dados
	 * 
	 * Metodo para inserir informacoes no banco de dados, funciona de forma
	 * generica de acordo com a classe DAO que vai herdar esta classe.
	 * 
	 * @param item
	 * @return Item criado
	 */
	public T create(T item) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		return item;
	}

	/**
	 * Metodo para deletar dados no banco de dados
	 * 
	 * Metodo para deletar informações no banco de dados, funciona de forma
	 * generica de acordo com a classe DAO que vai herdar esta classe, 
	 * e utiliza o objeto recebido como parametro para saber qual item deletar.
	 * 
	 * @param item
	 * @return
	 */
	public boolean delete(T item) {
		session.clear();
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
		return true;
	}

	/**
	 * Metodo para atualizar informaçoes no banco de dados
	 * 
	 * Metodo para atualizar informacoes no banco de dados, funciona de forma
	 * generica de acordo com a classe DAO que vai herdar esta classe, 
	 * e utiliza o objeto recebido como parametro para saber qual Objeto atualizar.
	 * 
	 * @param item
	 * @return
	 */
	public T update(T item) {
		if (!session.getTransaction().isActive())
			session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
		return item;
	}
	
}
