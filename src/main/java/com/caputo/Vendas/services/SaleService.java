package com.caputo.Vendas.services;

import com.caputo.Vendas.dto.SaleDTO;

import com.caputo.Vendas.dto.SaleSuccessDTO;
import com.caputo.Vendas.dto.SaleSumDTO;
import com.caputo.Vendas.entities.Sale;

import com.caputo.Vendas.repositories.SaleRepository;

import com.caputo.Vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findALl(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> list = repository.findAll(pageable);
        return list.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller(){
       return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return repository.successGroupedBySeller();
    }

}
