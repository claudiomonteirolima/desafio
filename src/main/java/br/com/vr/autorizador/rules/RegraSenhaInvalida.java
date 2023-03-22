package br.com.vr.autorizador.rules;

import br.com.vr.autorizador.Exception.CartaoException;
import br.com.vr.autorizador.dto.TransacaoDTO;
import br.com.vr.autorizador.model.Cartao;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.util.MensagensRetorno;

public class RegraSenhaInvalida implements RegraTransacao
{	
	@Override
	public void validar(TransacaoDTO cartao, CartaoRepositorie repositorie) throws CartaoException 
	{
		Cartao card = repositorie.getById(cartao.getNumeroCartao());
		if(!card.getSenha().equals(cartao.getSenhaCartao()))
		{
			throw new CartaoException(MensagensRetorno.SENHA_INVALIDA.getRetorno());
		}
	}

}
