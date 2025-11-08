package basic.crud;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {

    private final List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario obter(int id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void criar(Usuario usuario) {
        usuario.setId(proximoId++);
        usuarios.add(usuario);
    }

    public Usuario atualizar(int id, Usuario usuarioAtualizado) {
        Usuario existente = obter(id);
        if (existente != null) {
            existente.setNome(usuarioAtualizado.getNome());
            existente.setEmail(usuarioAtualizado.getEmail());
            return existente;
        }
        return null;
    }

    public boolean remover(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }
}
