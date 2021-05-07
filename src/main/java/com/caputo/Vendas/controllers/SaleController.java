package com.caputo.Vendas.controllers;

import com.caputo.Vendas.dto.SaleDTO;

import com.caputo.Vendas.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findALl(Pageable pageable){
        Page<SaleDTO> dto = service.findALl(pageable);
        return ResponseEntity.ok(dto);
    }
}
