package br.com.fintech.dao;

import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Pagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    public void insert(Pagamento pagamento) {
        // Query ajustada para o nome da tabela no Oracle (PAGAMENTO) e colunas
        String sql = "INSERT INTO PAGAMENTO (ID_PAGAMENTO, ID_CONTA, TIPO_PAGAMENTO, VALOR, DATA_PAGAMENTO, DESCRICAO, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, pagamento.getIdPagamento());
            stmt.setInt(2, pagamento.getIdConta());
            stmt.setString(3, pagamento.getTipoPagamento());
            stmt.setDouble(4, pagamento.getValor());
            stmt.setDate(5, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            stmt.setString(6, pagamento.getDescricao());
            stmt.setString(7, pagamento.getStatus());

            stmt.executeUpdate();
            System.out.println("Pagamento/Despesa inserido(a) com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir pagamento: " + e.getMessage());
        }
    }

    public List<Pagamento> getAll() {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM PAGAMENTO ORDER BY ID_PAGAMENTO";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getInt("ID_PAGAMENTO"),
                        rs.getInt("ID_CONTA"),
                        rs.getString("TIPO_PAGAMENTO"),
                        rs.getDouble("VALOR"),
                        rs.getDate("DATA_PAGAMENTO"),
                        rs.getString("DESCRICAO"),
                        rs.getString("STATUS")
                );
                pagamentos.add(pagamento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar pagamentos: " + e.getMessage());
        }

        return pagamentos;
    }
}