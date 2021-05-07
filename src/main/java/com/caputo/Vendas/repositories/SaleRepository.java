package com.caputo.Vendas.repositories;

import com.caputo.Vendas.dto.SaleSuccessDTO;
import com.caputo.Vendas.dto.SaleSumDTO;
import com.caputo.Vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.caputo.Vendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.caputo.Vendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
            + " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
