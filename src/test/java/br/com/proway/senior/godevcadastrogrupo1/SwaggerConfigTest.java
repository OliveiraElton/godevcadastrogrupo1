package br.com.proway.senior.godevcadastrogrupo1;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigTest {

	@Test
	public void testApi() {
		final SwaggerConfig sw = new SwaggerConfig();
		assertNotNull(sw);
		Docket dock = sw.api();
		assertNotNull(dock);
	}

}
