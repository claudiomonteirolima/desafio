package br.com.vr.autorizador.rules;


import java.math.BigDecimal;

import br.com.vr.autorizador.Exception.CartaoException;
import br.com.vr.autorizador.dto.TransacaoDTO;
import br.com.vr.autorizador.model.Cartao;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.util.MensagensRetorno;

public class RegraSaldoInvalido implements RegraTransacao
{	
	@Override
	public void validar(TransacaoDTO cartao, CartaoRepositorie repositorie) throws CartaoException 
	{
		System.out.println(cartao.getValor());
		
		Cartao card = repositorie.getById(cartao.getNumeroCartao());
		BigDecimal saldo = card.getSaldo();
		saldo = saldo.subtract(cartao.getValor());
		
		System.out.println("SALDO: " + saldo.toString());
		
		if(saldo.compareTo(BigDecimal.ZERO) < 0)
		{
			throw new CartaoException(MensagensRetorno.SALDO_INSUFICIENTE.getRetorno());
		}

		card.setSaldo(saldo);
		repositorie.save(card);
	}
}
