package com.caputo.Vendas.services;

import com.caputo.Vendas.dto.SellerDTO;
import com.caputo.Vendas.entities.Seller;
import com.caputo.Vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Transactional(readOnly = true)
    public List<SellerDTO> findALl(){
        List<Seller> list = repository.findAll();
        return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }
}
