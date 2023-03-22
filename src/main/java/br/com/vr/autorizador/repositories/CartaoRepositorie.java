package br.com.vr.autorizador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vr.autorizador.model.Cartao;


public interface CartaoRepositorie extends JpaRepository<Cartao, String>{

}
