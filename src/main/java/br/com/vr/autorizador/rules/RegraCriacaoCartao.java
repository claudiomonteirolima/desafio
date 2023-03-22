package br.com.vr.autorizador.rules;


import java.math.BigDecimal;

import br.com.vr.autorizador.Exception.CartaoException;
import br.com.vr.autorizador.dto.CartaoDTO;
import br.com.vr.autorizador.model.Cartao;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.util.MensagensRetorno;

public class RegraCriacaoCartao implements RegraCartao 
{

	@Override
	public void validar(CartaoDTO cartao, CartaoRepositorie repositorie) 
	{
		if(repositorie.existsById(cartao.getNumeroCartao()))
		{
			throw new CartaoException(MensagensRetorno.CARTAO_EXISTENTE.getRetorno());
		}
		
		repositorie.save(new Cartao(cartao.getNumeroCartao(),new BigDecimal("500"), cartao.getSenha()));
	}

}
