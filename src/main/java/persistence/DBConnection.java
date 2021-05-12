package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Colaborador;
import model.Conta;
import model.Contatos;
import model.Dependente;
import model.Empresa;
import model.Endereco;
import model.ExameMedico;
import model.PrestadorServico;

public class DBConnection {
	
	private static SessionFactory sessionFactory;
	
	private static Session session;
    
    private static SessionFactory buildSessionFactory() {
        try {
        	return new Configuration()
        			.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
					.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/grupo1")
					.setProperty("hibernate.connection.username","postgres")
					.setProperty("hibernate.connection.password","admin")
					.setProperty("hibernate.jdbc.time_zone","UTC")
					.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect")
					.setProperty("hibernate.show_sql","true")
					.setProperty("hibernate.format_sql","false")
					.setProperty("hibernate.hbm2ddl.auto","update")
					.setProperty("hibernate.connection.autocommit","true")
					.addAnnotatedClass(Colaborador.class)
					.addAnnotatedClass(Conta.class)
					.addAnnotatedClass(Contatos.class)
					.addAnnotatedClass(Dependente.class)
					.addAnnotatedClass(Empresa.class)
					.addAnnotatedClass(Endereco.class)
					.addAnnotatedClass(ExameMedico.class)
					.addAnnotatedClass(PrestadorServico.class)
					.buildSessionFactory();
        }
        catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    private static SessionFactory getSessionFactory() {
    	if(sessionFactory == null)
    		sessionFactory = buildSessionFactory();
    	return sessionFactory;
    }
  
    public static void shutdown() {
    	session.close();
        getSessionFactory().close();
    }
    
    public static Session getSession() {
    	getSessionFactory();    	
    	if(session == null) 
			session = sessionFactory.openSession();
 		return session;
 	}

}
