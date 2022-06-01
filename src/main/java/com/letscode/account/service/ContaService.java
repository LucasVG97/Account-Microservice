package com.letscode.account.service;

import com.letscode.account.dto.ContaRequest;
import com.letscode.account.dto.ContaResponse;

public interface ContaService {

    ContaResponse save(ContaRequest contaRequest, Integer id);

    ContaResponse getById(Integer id);

    void delete(Integer id);

}
