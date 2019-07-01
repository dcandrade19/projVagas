package com.projetovagas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetovagas.entity.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
	Optional<Candidato> findById(Long id);
	Candidato[] findByNome(String nome);
}

