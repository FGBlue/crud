package basic.crud;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class UsuarioController {

    private final UsuarioServico servico;

    
    public UsuarioController(UsuarioServico servico) {
        this.servico = servico;
    }

    public void registrarRotas(Javalin app) {
        app.get("/", ctx -> ctx.result("API Básica de Usuários está online"));

        app.get("/usuarios", this::listar);
        app.get("/usuarios/{id}", this::obter);
        app.post("/usuarios", this::criar);
        app.put("/usuarios/{id}", this::atualizar);
        app.delete("/usuarios/{id}", this::remover);
    }

    private void listar(Context ctx) {
        List<Usuario> usuarios = servico.listar();
        ctx.json(usuarios);
    }

    private void obter(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Usuario usuario = servico.obter(id);
        if (usuario != null)
            ctx.json(usuario);
        else
            ctx.status(404).result("Usuário não encontrado");
    }

    private void criar(Context ctx) {
        Usuario novo = ctx.bodyAsClass(Usuario.class);
        servico.criar(novo);
        ctx.status(201).json(novo);
    }

    private void atualizar(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Usuario atualizado = ctx.bodyAsClass(Usuario.class);
        Usuario result = servico.atualizar(id, atualizado);
        if (result != null)
            ctx.json(result);
        else
            ctx.status(404).result("Usuário não encontrado");
    }

    private void remover(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean removido = servico.remover(id);
        if (removido)
            ctx.status(204);
        else
            ctx.status(404).result("Usuário não encontrado");
    }
}
