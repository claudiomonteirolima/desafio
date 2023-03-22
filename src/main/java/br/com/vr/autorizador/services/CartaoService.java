package br.com.vr.autorizador.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vr.autorizador.Exception.CartaoException;
import br.com.vr.autorizador.dto.CartaoDTO;
import br.com.vr.autorizador.repositories.CartaoRepositorie;
import br.com.vr.autorizador.rules.RegraCartao;
import br.com.vr.autorizador.rules.RegraCriacaoCartao;
import br.com.vr.autorizador.util.MensagensRetorno;

@Service
public class CartaoService
{
	private CartaoRepositorie repositorie;
	
	private List<RegraCartao> regras;
	
	public CartaoService(CartaoRepositorie repositorie) 
	{
		this.repositorie = repositorie;
		regras = new ArrayList<RegraCartao>();
	}
	
	@Transactional
	public ResponseEntity<CartaoDTO> adicionarCartao(CartaoDTO cartao)
	{
		try 
		{
			regras.add(new RegraCriacaoCartao());
			regras.forEach(c -> c.validar(cartao, repositorie));
			
			return new ResponseEntity<CartaoDTO>(cartao,HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<CartaoDTO>(cartao,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		finally 
		{
			repositorie.flush();
		}
	}
	
	@Transactional
	public ResponseEntity<BigDecimal> veircarSaldoCartao(String numeorCartao)
	{
		try 
		{
			if(!repositorie.existsById(numeorCartao))
			{
				throw new CartaoException(MensagensRetorno.CARTAO_EXISTENTE.getRetorno());
			}
			
			return new ResponseEntity<BigDecimal>(repositorie.getById(numeorCartao).getSaldo(),HttpStatus.OK);
		}
		catch (Exception e) 
		{
			return new ResponseEntity<BigDecimal>(HttpStatus.NOT_FOUND);
		}
	}	

}
