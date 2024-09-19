package dio.web.api.repository;

import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepository() {
        // Adicionando alguns usuários de exemplo na lista
        usuarios.add(new Usuario("vinicius", "password"));
        usuarios.add(new Usuario("lara", "masterpass"));
    }

    public void save(Usuario usuario) {
        if (usuario.getLogin() == null) {
            throw new CampoObrigatorioException("login");
        }
        if (usuario.getPassword() == null) {
            throw new CampoObrigatorioException("password"); // Corrigido o campo para "login"
        }
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
        usuarios.add(usuario); // Salvando na lista (simulação)
    }

    public void update(Usuario usuario) {

        Usuario usuarioExistente = findByName(usuario.getLogin());
        if (usuarioExistente != null) {
            usuarios.remove(usuarioExistente); // Removendo o usuário antigo
            usuarios.add(usuario); // Adicionando o usuário atualizado
            System.out.println("UPDATE - Usuário atualizado com sucesso");
            System.out.println(usuario);
        } else {
            System.out.println("UPDATE - Usuário não encontrado para atualização");
        }
    }

    public void remove(Integer id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            usuarios.remove(usuario); // Removendo o usuário da lista (simulação)
            System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        } else {
            System.out.println(String.format("DELETE/id - Usuário com id %d não encontrado", id));
        }
    }

    public List<Usuario> listAll() {
        System.out.println("LIST - Retornando todos os usuários");
        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
        if (id < usuarios.size()) {
            return usuarios.get(id); // Simulação de busca por índice (ajustar para um banco de dados real)
        }
        System.out.println("GET/id - Usuário não encontrado");
        return null;
    }

    public Usuario findByName(String username) {
        System.out.println(String.format("GET/username - Buscando o usuário com login: %s", username));
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(username)) {
                System.out.println("Cliente localizado");
                return usuario;
            }
        }
        System.out.println("Cliente não localizado");
        return null;
    }
}
