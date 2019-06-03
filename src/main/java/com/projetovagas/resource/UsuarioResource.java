package com.projetovagas.resource;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.projetovagas.entity.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.projetovagas.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class UsuarioResource {
	@Autowired
	private UsuarioRepository repository;

	@RequestMapping("/usuarios")
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Usuario> listaUsuarios() {
		return repository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> buscaUsuario(@PathVariable long id) {
		return repository.findById(id).map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/usuarios")
	public Usuario cadastraUsuario(@RequestBody @Valid Usuario usuario) {
		return repository.save(usuario);
	}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> deletaUsuario(@PathVariable long id) {
		return repository.findById(id).map(data -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(data);
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> atualizaUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
		return repository.findById(id).map(data -> {
			data.setNome(usuario.getNome());
			data.setSenha(usuario.getSenha());
			data.setTipo(usuario.getTipo());
			data.setResultadosUsuario(usuario.getResultadosUsuario());
			Usuario atualizada = repository.save(data);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/usuarios/logar")
	public Usuario logarUsuario(@RequestBody @Valid Usuario usuario) {
		System.out.println(usuario.toString());
		Usuario baseUsuario = repository.findByNome(usuario.getNome()).map(res -> res ).orElse(null);
		if(baseUsuario.getSenha().equals(usuario.getSenha()) ) {
			return baseUsuario;
		} else {
			return null;
		}
	}
}
