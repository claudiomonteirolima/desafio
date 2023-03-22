package br.com.vr.autorizador.util;

public enum MensagensRetorno 
{
	SALDO_INSUFICIENTE("SALDO_INSUFICIENTE"),
	SENHA_INVALIDA("SENHA_INVALIDA"),
	CARTAO_INEXISTENTE("CARTAO_INEXISTENTE"),
	CARTAO_EXISTENTE("CARTAO_EXISTENTE"),
	OK("OK");
	
	private String retorno;

	MensagensRetorno(String retorno) 
	{
		this.retorno = retorno;
	}

	public String getRetorno()
	{
		return retorno;
	}
}
