package com.projetovagas.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetovagas.entity.Empresa;
import com.projetovagas.repository.EmpresaRepository;

@CrossOrigin
@RequestMapping("/empresas")
@RestController
public class EmpresaResource {
	@Autowired
	private EmpresaRepository repository;

	@GetMapping
	public @ResponseBody Iterable<Empresa> listaEmpresas() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> buscaEmpresa(@PathVariable long id) {
		return repository.findById(id).map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/login")
	public ResponseEntity<?> logarEmpresa(@RequestBody @Valid Empresa empresa) {
		Empresa[] empresas = repository.findByNome(empresa.getNome());
		for (Empresa u : empresas) {
			if(u.getSenha().equals(empresa.getSenha()) ) {
				return ResponseEntity.ok().body(u);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public Empresa cadastraEmpresa(@RequestBody @Valid Empresa empresa) {
		return repository.save(empresa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaEmpresa(@PathVariable long id) {
		return repository.findById(id).map(data -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(data);
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizaEmpresa(@PathVariable long id, @RequestBody Empresa empresa) {
		return repository.findById(id).map(data -> {
			data.setNome(empresa.getNome());
			data.setSenha(empresa.getSenha());
			data.setRazaoSocial(empresa.getRazaoSocial());
			data.setVagas(empresa.getVagas());
			Empresa atualizada = repository.save(data);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}
}
