package com.letscode.account.service.impl;

import com.letscode.account.client.CheckUsuarioClient;
import com.letscode.account.dto.ContaRequest;
import com.letscode.account.dto.ContaResponse;
import com.letscode.account.dto.client.InfoUsuario;
import com.letscode.account.exception.ContaException;
import com.letscode.account.model.Conta;
import com.letscode.account.repository.ContaRepository;
import com.letscode.account.service.ContaService;
import com.letscode.account.utils.NumeroConta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ContaServiceImpl implements ContaService {

    private final CheckUsuarioClient checkUsuarioClient;
    private final ContaRepository contaRepository;


    @Override
    public ContaResponse save(ContaRequest contaRequest, Integer id) {
        InfoUsuario usuario = checkUsuarioClient.execute(id);
        Conta conta = new Conta(contaRequest);
        conta.setUsuarioId(usuario.getId());
        conta.setNumero(NumeroConta.numeroConta());
        Conta contaSalva = contaRepository.save(conta);

        return new ContaResponse(contaSalva);
    }

    @Override
    public ContaResponse getById(Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new ContaException());
        return new ContaResponse(conta);
    }

    @Override
    public void delete(Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new ContaException());
        contaRepository.delete(conta);
    }
}
