package com.projetovagas.resource;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.projetovagas.entity.Candidato;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.projetovagas.repository.CandidatoRepository;

@CrossOrigin
@RequestMapping("/candidatos")
@RestController
public class CandidatoResource {
	@Autowired
	private CandidatoRepository repository;

	@GetMapping
	public @ResponseBody Iterable<Candidato> listaCandidatos() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Candidato> buscaCandidato(@PathVariable long id) {
		return repository.findById(id).map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/login")
	public ResponseEntity<?> logarCandidato(@RequestBody @Valid Candidato candidato) {
		Candidato[] candidatos = repository.findByNome(candidato.getNome());
		for (Candidato u : candidatos) {
			if(u.getSenha().equals(candidato.getSenha()) ) {
				return ResponseEntity.ok().body(u);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Candidato cadastraCandidato(@RequestBody @Valid Candidato candidato) {
		return repository.save(candidato);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaCandidato(@PathVariable long id) {
		return repository.findById(id).map(data -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(data);
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizaCandidato(@PathVariable long id, @RequestBody Candidato candidato) {
		return repository.findById(id).map(data -> {
			data.setNome(candidato.getNome());
			data.setSenha(candidato.getSenha());
			data.setResultadosCandidato(candidato.getResultadosCandidato());
			Candidato atualizada = repository.save(data);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
