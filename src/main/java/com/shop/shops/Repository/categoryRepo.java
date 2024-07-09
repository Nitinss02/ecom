package com.shop.shops.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.shops.Model.Category;

public interface categoryRepo extends JpaRepository<Category, Integer> {
    public boolean existsByProductName(String name);
}
