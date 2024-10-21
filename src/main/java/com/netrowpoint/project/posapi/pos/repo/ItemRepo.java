package com.netrowpoint.project.posapi.pos.repo;

import com.netrowpoint.project.posapi.pos.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameEqualsAndActiveStatusEquals(String itemName, Boolean status);

    List<Item> findAllByActiveStatusEquals(Boolean status);

    Page<Item> findAllByActiveStatusEquals(Boolean status, Pageable pageable);

    int countAllByActiveStatusEquals(Boolean status);
}
