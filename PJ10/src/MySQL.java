import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
    private Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/nubank";
            String user = "root";  // Usuário do MySQL
            String password = "Vini240804";  // Senha do MySQL
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
        return conn;
    }

    // Inserir nome e senha
    public void insertNameAndPassword(String nome, String senha) {
        String sql = "INSERT INTO conta (nome, senha) VALUES (?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, senha);
            pstmt.executeUpdate();
            System.out.println("Conta criada e dados inseridos com sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Obter a lista de nomes
    public List<String> getNomes() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM conta";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nomes;
    }
}
