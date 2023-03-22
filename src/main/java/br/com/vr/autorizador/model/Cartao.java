package br.com.vr.autorizador.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CARTAO")
public class Cartao 
{
	@Id
	@Column(name = "NU_CARTAO", unique = true)
	private String numeroCartao;
	
	@Column(name = "NU_SALDO")
	private BigDecimal saldo;
	
	@Column(name = "NO_SENHA")
	private String senha;

	public Cartao() {
	}
	
	public Cartao(String numero, BigDecimal saldo, String senha) {
		this.numeroCartao = numero;
		this.saldo = saldo;
		this.senha = senha;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCartao, saldo, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return numeroCartao == other.numeroCartao && Objects.equals(saldo, other.saldo) && Objects.equals(senha, other.senha);
	}
}
