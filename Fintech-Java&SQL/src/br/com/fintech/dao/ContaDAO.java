package br.com.fintech.dao;

import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Conta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {

    public void insert(Conta conta) {
        String sql = "INSERT INTO CONTA (ID_CONTA, TIPO_CONTA, SALDO, STATUS, DATA_ABERTURA, USUARIO_ID_USUARIO) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, conta.getIdConta());
            stmt.setString(2, conta.getTipoConta());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setString(4, conta.getStatus());
            stmt.setDate(5, new java.sql.Date(conta.getDataAbertura().getTime()));
            stmt.setInt(6, conta.getUsuarioId());

            stmt.executeUpdate();
            System.out.println("Conta inserida com sucesso no banco!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir conta: " + e.getMessage());
        }
    }

    public List<Conta> getAll() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM CONTA ORDER BY ID_CONTA";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("ID_CONTA"),
                        rs.getString("TIPO_CONTA"),
                        rs.getDouble("SALDO"),
                        rs.getString("STATUS"),
                        rs.getDate("DATA_ABERTURA"),
                        rs.getInt("USUARIO_ID_USUARIO")
                );
                contas.add(conta);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar contas: " + e.getMessage());
        }

        return contas;
    }
}