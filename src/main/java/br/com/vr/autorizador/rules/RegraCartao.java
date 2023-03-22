package br.com.vr.autorizador.rules;

import br.com.vr.autorizador.dto.CartaoDTO;
import br.com.vr.autorizador.repositories.CartaoRepositorie;

public interface RegraCartao 
{
	void validar(CartaoDTO dto, CartaoRepositorie repositorie);
}
