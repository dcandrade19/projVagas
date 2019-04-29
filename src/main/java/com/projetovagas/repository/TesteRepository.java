package com.projetovagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetovagas.entity.Teste;

@Repository
public interface TesteRepository extends JpaRepository<Teste, String>{

}
