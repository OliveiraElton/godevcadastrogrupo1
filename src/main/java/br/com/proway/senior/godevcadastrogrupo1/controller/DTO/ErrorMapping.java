package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Classe ErrorMapping.
 * 
 * Implementa e personaliza as respostas que serao retornadas
 * ao utilizar as APIs do sistema.
 * 
 * @author Vitor Cesar Peres <b>vitor.peres@senior.com.br</b>
 *
 */
@RestController
public class ErrorMapping implements ErrorController{
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public @ResponseBody String imprimeErroGet() {
		return "<h1>Erro de parâmetro, endereço na url ou objeto não existe no banco para retornar.</h1>";
	}

	@RequestMapping(value = "/error", method = RequestMethod.PUT)
	public @ResponseBody String imprimeErroPut() {
		return "<h1>Erro de parâmetro, endereço na url ou objeto não existe para atualizar.</h1>";
	}
	@RequestMapping(value = "/error", method = RequestMethod.DELETE)
	public @ResponseBody String imprimeErroDelete() {
		return "<h1>Erro de parâmetro, endereço na url ou objeto não existe para deletar.</h1>";
	}
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public @ResponseBody String imprimeErroPost() {
		return "<h1>Erro de parâmetro, endereço na url ou objeto não pode ser criado (null etc).</h1>";
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
