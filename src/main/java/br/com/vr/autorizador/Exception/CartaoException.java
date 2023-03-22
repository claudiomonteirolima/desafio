package br.com.vr.autorizador.Exception;

public class CartaoException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public CartaoException(String mensagem) 
	{
		super(mensagem);
	}
}
