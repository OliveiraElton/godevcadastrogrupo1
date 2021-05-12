package persistence;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

public class DBConnectionTest {

	@Test
	public void testConnection() {

		SessionFactory sf = DBConnection.getSessionFactory();
		Session session = sf.getCurrentSession();
		assertNotNull(session);

		// String url =
		// "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
		// Connection conn = DriverManager.getConnection(url);
	}

}
