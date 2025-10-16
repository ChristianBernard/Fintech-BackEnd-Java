package br.com.fintech.test;

import br.com.fintech.dao.PagamentoDAO;
import br.com.fintech.model.Pagamento;
import java.util.Date;
import java.util.List;

public class TestePagamento {
    public static void main(String[] args) {

        PagamentoDAO dao = new PagamentoDAO();

        System.out.println("--- TESTE DESPESA (PAGAMENTO) ---");
        System.out.println("--- REQUISITO 4: Inserir 5 registros ---");

        // OBS: O ID_CONTA = 1 deve existir na tabela CONTA (já inserimos antes!)
        dao.insert(new Pagamento(1, 1, "Boleto", 550.0, new Date(), "Conta de Luz", "PAGO"));
        dao.insert(new Pagamento(2, 1, "Cartao", 120.0, new Date(), "Streaming Netflix", "PENDENTE"));
        dao.insert(new Pagamento(3, 1, "PIX", 50.0, new Date(), "Lanche", "PAGO"));
        dao.insert(new Pagamento(4, 1, "Débito", 30.0, new Date(), "Transporte", "PAGO"));
        dao.insert(new Pagamento(5, 1, "Boleto", 80.0, new Date(), "Internet", "PAGO"));

        System.out.println("\n--- REQUISITO 4: Consulta (getAll) ---");

        List<Pagamento> pagamentos = dao.getAll();

        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento/despesa recuperado(a).");
        } else {
            System.out.println("ID | Conta | Valor | Descrição | Status");
            System.out.println("----------------------------------------------");
            for (Pagamento p : pagamentos) {
                System.out.println(
                        p.getIdPagamento() + " | " +
                                p.getIdConta() + " | " +
                                p.getValor() + " | " +
                                p.getDescricao() + " | " +
                                p.getStatus()
                );
            }
        }
    }
}