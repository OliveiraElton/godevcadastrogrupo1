package br.com.proway.senior.godevcadastrogrupo1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.proway.senior.godevcadastrogrupo1.model.DAO.ColaboradorDAO;

public class ApplicationTest {

	@Test
	public void testMain() {
		final Application app = new Application(); 
		String[] args = {"",""};
		assertNotNull(app);
	}

}
