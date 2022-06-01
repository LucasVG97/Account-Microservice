package com.letscode.account.dto;

import com.letscode.account.enums.TipoConta;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class ContaRequest {

    private Integer agencia;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    private BigDecimal saldo;
}
