package com.letscode.account.dto;

import com.letscode.account.enums.TipoConta;
import com.letscode.account.model.Conta;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ContaResponse {

    private Integer id;
    private Integer numero;
    private Integer agencia;
    private TipoConta tipoConta;
    private BigDecimal saldo;
    private Integer usuarioId;

    public ContaResponse(Conta conta) {
        this.id = conta.getId();
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.tipoConta = conta.getTipoConta();
        this.saldo = conta.getSaldo();
        this.usuarioId = conta.getUsuarioId();
    }
}
