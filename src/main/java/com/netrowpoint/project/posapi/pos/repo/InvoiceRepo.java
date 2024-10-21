package com.netrowpoint.project.posapi.pos.repo;

import com.netrowpoint.project.posapi.pos.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {
}
