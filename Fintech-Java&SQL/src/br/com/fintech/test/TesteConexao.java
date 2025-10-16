package br.com.fintech.test;

import br.com.fintech.factory.ConnectionFactory;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Tentando conectar...");
        try (Connection con = ConnectionFactory.getConnection()) {
            System.out.println("✅ Conectado com sucesso ao Oracle!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}