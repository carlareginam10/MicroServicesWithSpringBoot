package br.com.impacta.fullstack.saldoextrato;
import brave.Span;
import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@EnableCircuitBreaker
@RequestMapping(("/api/v1/saldoextrato"))
public class SaldoExtratoController {

    private final SaldoExtratoService saldoExtratoService;
    @Autowired
    private Tracer tracer;
    public SaldoExtratoController(SaldoExtratoService saldoExtratoService) {
        this.saldoExtratoService = saldoExtratoService;
    }

    @GetMapping
    public SaldoExtrato get() throws UnknownHostException {
        System.out.println("Hostname: " + InetAddress.getLocalHost().getHostName());
        SaldoExtrato saldoExtrato = saldoExtratoService.get();
        return saldoExtrato;
    }

    @GetMapping
    @RequestMapping("/mobile")
    public SaldoExtrato getBff() throws UnknownHostException {
        System.out.println("Hostname: " + InetAddress.getLocalHost().getHostName());
        SaldoExtrato saldoExtrato = saldoExtratoService.getBff();
        return saldoExtrato;
    }

}