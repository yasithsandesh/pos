package com.netrowpoint.project.posapi.pos.repo;

import com.netrowpoint.project.posapi.pos.entity.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepo extends JpaRepository<InvoiceItems,Integer> {
}
