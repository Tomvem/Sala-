
package com.sala1.sala1.controller;

import com.sala1.sala1.entity.Usuario;
import com.sala1.sala1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = service.saveUsuario(usuario);
        return ResponseEntity.status(201).body(usuarioSalvo);
    }

    @GetMapping("/{id}")
    public Usuario findByid(@PathVariable Long id) {
        Optional<Usuario> usuario = service.findById(id);
        return usuario.orElse(null);

    }

    @PutMapping("/{id}") // A anotação deve incluir {id} para capturar o ID na URL
    public ResponseEntity<Usuario> editUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioEditado = service.editUsuario(usuario, id);
        return usuarioEditado != null ? ResponseEntity.ok(usuarioEditado) : ResponseEntity.notFound().build();
    }

    // Método para excluir uma reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        service.deleteUsuario(id);
        return ResponseEntity.noContent().build();

    }
}

