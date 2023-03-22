package br.com.vr.autorizador.dto;

import java.math.BigDecimal;

public class CartaoDTO 
{
	private String senha;
	private String numeroCartao;
	private BigDecimal saldo;
	
	public String getSenha() 
	{
		return senha;
	}

	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	
	public String getNumeroCartao() 
	{
		return numeroCartao;
	}
	
	public void setNumeroCartao(String numeroCartao) 
	{
		this.numeroCartao = numeroCartao;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}
