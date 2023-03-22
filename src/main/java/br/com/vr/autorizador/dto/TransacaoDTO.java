package br.com.vr.autorizador.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TransacaoDTO 
{
    private String numeroCartao;
    private String senhaCartao;
    private BigDecimal valor;
	
    public String getNumeroCartao() 
    {
		return numeroCartao;
	}
    
	public void setNumeroCartao(String numeroCartao) 
	{
		this.numeroCartao = numeroCartao;
	}
	
	public String getSenhaCartao() 
	{
		return senhaCartao;
	}
	
	public void setSenhaCartao(String senhaCartao) 
	{
		this.senhaCartao = senhaCartao;
	}
	
	public BigDecimal getValor() 
	{
		return valor;
	}

	public void setValor(BigDecimal valor)
	{
		this.valor = valor;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(numeroCartao, senhaCartao, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoDTO other = (TransacaoDTO) obj;
		return Objects.equals(numeroCartao, other.numeroCartao) && Objects.equals(senhaCartao, other.senhaCartao)
				&& Objects.equals(valor, other.valor);
	}
}
