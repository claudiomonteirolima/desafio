package br.com.vr.autorizador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vr.autorizador.dto.TransacaoDTO;
import br.com.vr.autorizador.services.TransacaoService;


@RestController
@RequestMapping("transacoes")
public class TransacaoController 
{
	@Autowired
	private TransacaoService service;
	
	public TransacaoController() {}
	
	@PostMapping
	public ResponseEntity<String> post(@RequestBody TransacaoDTO cartao)
	{	
		return service.verificarTransacao(cartao);
	}

}
