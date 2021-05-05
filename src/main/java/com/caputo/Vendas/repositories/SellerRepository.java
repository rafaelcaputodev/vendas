package com.caputo.Vendas.repositories;

import com.caputo.Vendas.entities.Sale;
import com.caputo.Vendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
