package com.projetovagas.resource;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.projetovagas.entity.Vaga;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projetovagas.repository.TesteRepository;
import com.projetovagas.repository.VagaRepository;

@CrossOrigin
@RestController
public class VagaResource {
	private TesteRepository testeRepository;
	@Autowired
	private VagaRepository repository;

	@RequestMapping("/vagas")
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Vaga> listaVagas() {
		return repository.findAll();
	}

	@GetMapping("/vagas/{id}")
	public ResponseEntity<Vaga> buscaVaga(@PathVariable long id) {
		return repository.findById(id).map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/vagas")
	public Vaga cadastraVaga(@RequestBody @Valid Vaga vaga) {
		return repository.save(vaga);
	}

	@DeleteMapping("/vagas/{id}")
	public ResponseEntity<?> deletaVaga(@PathVariable long id) {
		return repository.findById(id).map(data -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(data);
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/vagas/{id}")
	public ResponseEntity<?> atualizaVaga(@PathVariable long id, @RequestBody Vaga vaga) {
		return repository.findById(id).map(data -> {
			data.setNome(vaga.getNome());
			data.setDescricao(vaga.getDescricao());
			data.setCidade(vaga.getCidade());
			data.setData(vaga.getData());
			data.setEmpresa(vaga.getEmpresa());
			data.setEstado(vaga.getEstado());
			data.setPeriodo(vaga.getPeriodo());
			data.setTestes(vaga.getTestes());
			Vaga atualizada = repository.save(data);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}

}
