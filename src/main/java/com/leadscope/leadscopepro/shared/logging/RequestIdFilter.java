package com.leadscope.leadscopepro.shared.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

// Filtro que adiciona um X-Request-Id em toda resposta HTTP.
// Ajuda a rastrear requisições em logs.
@Component
public class RequestIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        // Gera um id único por requisição
        var id = UUID.randomUUID().toString();

        // Escreve no header de resposta (cliente pode enviar de volta em suporte)
        ((HttpServletResponse) res).setHeader("X-Request-Id", id);

        // Continua a cadeia de filtros até o controller
        chain.doFilter(req, res);
    }
}
