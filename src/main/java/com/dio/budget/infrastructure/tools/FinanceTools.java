package com.dio.budget.infrastructure.tools;

import com.dio.budget.domain.Transaction;
import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class FinanceTools {

    @Bean
    @Description("Registra movimentações financeiras de entrada ou saída")
    public Function<Transaction, String> registerTransaction() {
        return transaction -> {
            System.out.println("Processando no banco: " + transaction);
            return "Sucesso: " + transaction.type() + " de R$ " + transaction.amount() + " gravada.";
        };
    }
}
