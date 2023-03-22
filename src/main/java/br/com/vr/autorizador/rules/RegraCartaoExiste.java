package br.com.vr.autorizador.rules;


import br.com.vr.autorizador.Exception.CartaoException;
import br.com.vr.autorizador.dto.TransacaoDTO;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.util.MensagensRetorno;

public class RegraCartaoExiste implements RegraTransacao
{	
	@Override
	public void validar(TransacaoDTO cartao, CartaoRepositorie repositorie) throws CartaoException 
	{
		if(!repositorie.existsById(cartao.getNumeroCartao()))
		{
			throw new CartaoException(MensagensRetorno.CARTAO_INEXISTENTE.getRetorno());
		}
	}

}
