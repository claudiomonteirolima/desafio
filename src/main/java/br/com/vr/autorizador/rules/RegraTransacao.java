package br.com.vr.autorizador.rules;

import br.com.vr.autorizador.dto.TransacaoDTO;
import br.com.vr.autorizador.repositories.CartaoRepositorie;

public interface RegraTransacao
{
	void validar(TransacaoDTO transacaoDTOa, CartaoRepositorie cartaoRepositorie);
}