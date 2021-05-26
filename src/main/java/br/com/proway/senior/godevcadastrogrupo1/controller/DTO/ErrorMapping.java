package br.com.proway.senior.godevcadastrogrupo1.controller.DTO;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorMapping implements ErrorController{
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public @ResponseBody String imprimeErroGet() {
		return "Erro de parâmetro, endereço na url ou objeto não existe no banco para retornar.";
	}

	@RequestMapping(value = "/error", method = RequestMethod.PUT)
	public @ResponseBody String imprimeErroPut() {
		return "Erro de parâmetro, endereço na url ou objeto não existe para atualizar.";
	}
	@RequestMapping(value = "/error", method = RequestMethod.DELETE)
	public @ResponseBody String imprimeErroDelete() {
		return "Erro de parâmetro, endereço na url ou objeto não existe para deletar. ";
	}
	@RequestMapping(value = "/error", method = RequestMethod.POST)
	public @ResponseBody String imprimeErroPost() {
		return "Erro de parâmetro, endereço na url ou objeto não pode ser criado (null etc).  ";
	}

}
