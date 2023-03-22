package br.com.vr.autorizador.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vr.autorizador.dto.CartaoDTO;
import br.com.vr.autorizador.services.CartaoService;

@RestController
@RequestMapping("cartoes")
public class CartaoController 
{
	@Autowired
	private CartaoService cartaoService;
	
	public CartaoController() {}

	@PostMapping
	public ResponseEntity<CartaoDTO> add(@RequestBody CartaoDTO cartao)
	{	
		return cartaoService.adicionarCartao(cartao);
	}
	
	@GetMapping("{numeroCartao}")
	public ResponseEntity<BigDecimal> get(@PathVariable String numeroCartao)
	{	
		return cartaoService.veircarSaldoCartao(numeroCartao);
	}
	
}
