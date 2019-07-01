package com.projetovagas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetovagas.entity.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
	Optional<Vaga> findById(Long id);

	@Query(value = "select id_vaga, cidade, data, descricao, estado, nome, periodo, empresa from vaga", nativeQuery = true)
	List<Vaga> findAll();

	@Query(value = "select id_vaga, cidade, data, descricao, estado, nome, periodo, empresa from vaga where vaga.empresa = :idEmpresa", nativeQuery = true)
	List<Vaga> findByEmpresa(Long idEmpresa);
}
