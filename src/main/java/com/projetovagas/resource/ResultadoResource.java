package com.projetovagas.resource;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.projetovagas.entity.Resultado;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projetovagas.repository.ResultadoRepository;

@CrossOrigin
@RestController
public class ResultadoResource {
	@Autowired
	private ResultadoRepository repository;

	@RequestMapping("/resultados")
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Resultado> listaResultados() {
		return repository.findAll();
	}

	@GetMapping("/resultados/{id}")
	public ResponseEntity<Resultado> buscaUsuario(@PathVariable long id) {
		return repository.findById(id).map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/resultados")
	public Resultado cadastraUsuario(@RequestBody @Valid Resultado resultado) {
		return repository.save(resultado);
	}

	@DeleteMapping("/resultados/{id}")
	public ResponseEntity<?> deletaUsuario(@PathVariable long id) {
		return repository.findById(id).map(data -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(data);
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/resultados/{id}")
	public ResponseEntity<?> atualizaUsuario(@PathVariable long id, @RequestBody Resultado resultado) {
		return repository.findById(id).map(data -> {
			data.setTeste(resultado.getTeste());
			data.setUsuario(resultado.getUsuario());
			data.setNota(resultado.getNota());
			Resultado atualizada = repository.save(data);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}

}

