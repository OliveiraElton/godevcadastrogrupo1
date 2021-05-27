package br.com.proway.senior.godevcadastrogrupo1.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Classe BDConexao.
 * 
 * Classe de interacao direta com o banco de dados. Armazena os parametros e
 * metodos necessarios para interagir com o Postgres.
 * 
 * @author Sprint 5
 *
 */
public class BDConexao {

	private static SessionFactory sessaoFactory;

	private static Session sessao;

	/**
	 * Metodo construirSessaoFactory.
	 * 
	 * Seta as propriedades necessarias para a interacao com o BD e as classes
	 * mapeadas como entidades para uso no Hibernate.
	 * 
	 * @return a conexao criada.
	 */
	private static SessionFactory construirSessaoFactory() {
		try {
			return new Configuration().setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/grupo1")
					.setProperty("hibernate.connection.username", "postgres")
					.setProperty("hibernate.connection.password", "admin")
					.setProperty("hibernate.jdbc.time_zone", "UTC")
					.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
					.setProperty("hibernate.show_sql", "true").setProperty("hibernate.format_sql", "false")
					.setProperty("hibernate.hbm2ddl.auto", "update")
					.setProperty("hibernate.connection.autocommit", "true")
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.Colaborador.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.Conta.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.Contatos.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.Dependente.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.Empresa.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.Endereco.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.ExameMedico.class)
					.addAnnotatedClass(br.com.proway.senior.godevcadastrogrupo1.model.PrestadorServico.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Iniciação da SessionFactory falhou: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	private static SessionFactory getSessionFactory() {
		if (sessaoFactory == null)
			sessaoFactory = construirSessaoFactory();
		return sessaoFactory;
	}

	public static Session getSessao() {
		getSessionFactory();
		if (sessao == null)
			sessao = sessaoFactory.openSession();
		return sessao;
	}

}
