import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class Model {
    private String url = "jdbc:mysql://localhost:3306/contabancaria"; // URL do banco de dados
    private String user = "root"; // Usuário do MySQL
    private String password = "Vini240804"; // Senha do MySQL

    public void inserirDados(String nome, String agencia, int numero, double saldo) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO dados (nome, agencia, numero, saldo) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, agencia);
            statement.setInt(3, numero);
            statement.setDouble(4, saldo);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\nDados inseridos com sucesso!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean recuperarDadosPorAgenciaENumero(String agencia, int numero) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT nome, saldo FROM dados WHERE agencia = ? AND numero = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, agencia);
            statement.setInt(2, numero);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                double saldo = resultSet.getDouble("saldo");

                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                String saldoFormatado = formatoMoeda.format(saldo);

                System.out.println("Bem-vindo(a) de volta " + nome + "! \n\nAgência: " + agencia + "\nNúmero da conta: " + numero + "\nSaldo: " + saldoFormatado);
                return true;
            } else {
                System.out.println("Conta não encontrada.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void sacarSaldo(String agencia, int numero, double valorSaque) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT saldo FROM dados WHERE agencia = ? AND numero = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, agencia);
            statement.setInt(2, numero);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double saldoAtual = resultSet.getDouble("saldo");

                if (saldoAtual >= valorSaque) {
                    saldoAtual -= valorSaque;
                    String updateSql = "UPDATE dados SET saldo = ? WHERE agencia = ? AND numero = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                    updateStatement.setDouble(1, saldoAtual);
                    updateStatement.setString(2, agencia);
                    updateStatement.setInt(3, numero);
                    updateStatement.executeUpdate();
                    System.out.println("Saque realizado com sucesso! Seu novo saldo é: " + NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(saldoAtual));
                } else {
                    System.out.println("Saldo insuficiente para realizar o saque.");
                }
            } else {
                System.out.println("Conta não encontrada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void transferirSaldo(String agenciaOrigem, int numeroOrigem, String agenciaDestino, int numeroDestino, double valorTransferencia) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);

            // Verificar saldo da conta de origem
            String sqlOrigem = "SELECT saldo FROM dados WHERE agencia = ? AND numero = ?";
            statement = connection.prepareStatement(sqlOrigem);
            statement.setString(1, agenciaOrigem);
            statement.setInt(2, numeroOrigem);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double saldoOrigem = resultSet.getDouble("saldo");

                if (saldoOrigem >= valorTransferencia) {
                    // Verificar se a conta de destino existe
                    String sqlDestino = "SELECT saldo FROM dados WHERE agencia = ? AND numero = ?";
                    statement = connection.prepareStatement(sqlDestino);
                    statement.setString(1, agenciaDestino);
                    statement.setInt(2, numeroDestino);
                    ResultSet resultSetDestino = statement.executeQuery();

                    if (resultSetDestino.next()) {
                        double saldoDestino = resultSetDestino.getDouble("saldo");

                        // Subtrair da conta de origem
                        saldoOrigem -= valorTransferencia;
                        String updateOrigem = "UPDATE dados SET saldo = ? WHERE agencia = ? AND numero = ?";
                        PreparedStatement updateStatementOrigem = connection.prepareStatement(updateOrigem);
                        updateStatementOrigem.setDouble(1, saldoOrigem);
                        updateStatementOrigem.setString(2, agenciaOrigem);
                        updateStatementOrigem.setInt(3, numeroOrigem);
                        updateStatementOrigem.executeUpdate();

                        // Somar na conta de destino
                        saldoDestino += valorTransferencia;
                        String updateDestino = "UPDATE dados SET saldo = ? WHERE agencia = ? AND numero = ?";
                        PreparedStatement updateStatementDestino = connection.prepareStatement(updateDestino);
                        updateStatementDestino.setDouble(1, saldoDestino);
                        updateStatementDestino.setString(2, agenciaDestino);
                        updateStatementDestino.setInt(3, numeroDestino);
                        updateStatementDestino.executeUpdate();

                        System.out.println("Transferência realizada com sucesso! Seu novo saldo é: " + NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(saldoOrigem));
                    } else {
                        System.out.println("Conta destino não encontrada.");
                    }

                } else {
                    System.out.println("Saldo insuficiente para realizar a transferência.");
                }
            } else {
                System.out.println("Conta origem não encontrada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean contaExiste(String agencia, int numero) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT 1 FROM dados WHERE agencia = ? AND numero = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, agencia);
            statement.setInt(2, numero);

            resultSet = statement.executeQuery();

            // Se o resultado da consulta retornar algum valor, a conta existe
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
