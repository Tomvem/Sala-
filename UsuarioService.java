package com.sala1.sala1.service;

import com.sala1.sala1.entity.Usuario;
import com.sala1.sala1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Retorna todos os usuários
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    // Salva um novo usuário
    public Usuario saveUsuario(Usuario usuario) {
        return repository.save(usuario); // Salva o usuário e retorna o salvo
    }

    // Retorna um usuário pelo ID
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    // Edita um usuário existente
    public Usuario editUsuario(Usuario usuario, Long id) {
        Optional<Usuario> userDbOptional = this.findById(id);
        if (userDbOptional.isPresent()) {
            Usuario userDb = userDbOptional.get(); // Obtém o usuário existente

            // Atualiza os campos do usuário
            userDb.setNome(usuario.getNome() != null ? usuario.getNome() : userDb.getNome());
            userDb.setEmail(usuario.getEmail() != null ? usuario.getEmail() : userDb.getEmail());
            userDb.setPhone(usuario.getPhone() != null ? usuario.getPhone() : userDb.getPhone());
            userDb.setCpf(usuario.getCpf() != null ? usuario.getCpf() : userDb.getCpf());
            return repository.save(userDb); // Salva as alterações
        } else {
            return null; // ou lance uma exceção personalizada
        }
    }

    // Exclui um usuário pelo ID
    public void deleteUsuario(Long id) {
        repository.deleteById(id); // Exclui o usuário pelo ID
    }
}
