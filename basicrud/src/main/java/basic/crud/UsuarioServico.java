package basic.crud;

import java.util.List;

public class UsuarioServico {

    private final UsuarioRepositorio repositorio = new UsuarioRepositorio();

    public List<Usuario> listar() {
        return repositorio.listar();
    }

    public Usuario obter(int id) {
        return repositorio.obter(id);
    }

    public void criar(Usuario usuario) {
        repositorio.criar(usuario);
    }

    public Usuario atualizar(int id, Usuario usuario) {
        return repositorio.atualizar(id, usuario);
    }

    public boolean remover(int id) {
        return repositorio.remover(id);
    }
}
