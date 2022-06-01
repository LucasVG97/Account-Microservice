package com.letscode.account.controller;


import com.letscode.account.dto.ContaRequest;
import com.letscode.account.dto.ContaResponse;
import com.letscode.account.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @GetMapping("/{id}")
    public ContaResponse getById(@PathVariable Integer id) {
        return contaService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public ContaResponse save(@PathVariable Integer id, @RequestBody ContaRequest contaRequest){
        return contaService.save(contaRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        contaService.delete(id);
    }
}
