package com.projetovagas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetovagas.entity.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
	Optional<Resultado> findById(Long id);
}


