package br.com.fintech.test;

import br.com.fintech.dao.ContaDAO;
import br.com.fintech.model.Conta;
import java.util.Date;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        ContaDAO dao = new ContaDAO();

        System.out.println("--- INICIANDO TESTE DE CADASTRO (REQUISITO 2) ---");

        // Inserção de 5 registros (com IDs manuais para evitar ORA-01400)
        dao.insert(new Conta(1, "Corrente", 1500.0, "Ativa", new Date(), 1));
        dao.insert(new Conta(2, "Poupança", 3000.0, "Ativa", new Date(), 1));
        dao.insert(new Conta(3, "Salário", 800.0, "Ativa", new Date(), 1));
        dao.insert(new Conta(4, "Investimento", 5000.0, "Inativa", new Date(), 1));
        dao.insert(new Conta(5, "Digital", 200.0, "Ativa", new Date(), 1));

        System.out.println("\n--- INICIANDO TESTE DE CONSULTA (REQUISITO 3) ---");

        List<Conta> contas = dao.getAll();

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta recuperada do banco.");
        } else {
            System.out.println("ID | Tipo | Saldo | Status | Data Abertura");
            System.out.println("----------------------------------------------");
            for (Conta c : contas) {
                System.out.println(
                        c.getIdConta() + " | " +
                                c.getTipoConta() + " | " +
                                c.getSaldo() + " | " +
                                c.getStatus() + " | " +
                                c.getDataAbertura()
                );
            }
        }
    }
}