package br.com.vr.autorizador.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vr.autorizador.dto.TransacaoDTO;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.rules.RegraCartaoExiste;
import br.com.vr.autorizador.rules.RegraSaldoInvalido;
import br.com.vr.autorizador.rules.RegraSenhaInvalida;
import br.com.vr.autorizador.rules.RegraTransacao;
import br.com.vr.autorizador.util.MensagensRetorno;

@Service
public class TransacaoService
{
	private CartaoRepositorie repositorie;
	
	private List<RegraTransacao> regras;
	
	public TransacaoService(CartaoRepositorie repositorie) 
	{
		this.repositorie = repositorie;
		regras = new ArrayList<RegraTransacao>();
		regras.add(new RegraCartaoExiste());
		regras.add(new RegraSenhaInvalida());
		regras.add(new RegraSaldoInvalido());
	}
	
	@Transactional
	public ResponseEntity<String> verificarTransacao(TransacaoDTO cartao)
	{
		try 
		{
			regras.forEach(t -> t.validar(cartao, repositorie));
			return new ResponseEntity<String>(MensagensRetorno.OK.getRetorno(), HttpStatus.CREATED);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<String>(e.getMessage().toString(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
