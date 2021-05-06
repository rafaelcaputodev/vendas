package com.caputo.Vendas.controllers;

import com.caputo.Vendas.dto.SellerDTO;
import com.caputo.Vendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findALl(){
        List<SellerDTO> dto = service.findALl();
        return ResponseEntity.ok(dto);
    }
}
