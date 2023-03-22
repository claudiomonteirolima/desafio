package br.com.vr.autorizador.rules;


import br.com.vr.autorizador.Exception.CartaoException;
import br.com.vr.autorizador.dto.CartaoDTO;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.util.MensagensRetorno;

public class RegraSaldoCartao implements RegraCartao 
{
	@Override
	public void validar(CartaoDTO cartao, CartaoRepositorie repositorie) 
	{
		if(repositorie.existsById(cartao.getNumeroCartao()))
		{
			throw new CartaoException(MensagensRetorno.CARTAO_INEXISTENTE.getRetorno());
		}
	}

}
