package com.letscode.account.client;

import com.letscode.account.dto.client.InfoUsuario;
import com.letscode.account.exception.UsuarioException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CheckUsuarioClient {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    private final String API_USUARIO = "http://localhost:8082/usuario/";

    public InfoUsuario execute(Integer id){
        httpHeaders.set(httpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<InfoUsuario> responseEntity = restTemplate.exchange(
                API_USUARIO + id,
                HttpMethod.GET,
                entity,
                InfoUsuario.class
        );

        if (responseEntity.getStatusCode().isError()) throw new UsuarioException();
        return responseEntity.getBody();
    }
}
