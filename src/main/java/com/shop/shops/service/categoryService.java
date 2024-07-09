package com.shop.shops.service;

import java.util.List;

import com.shop.shops.Model.Category;

public interface categoryService {
    public Category saveCategory(Category category);

    public boolean existCategory(String name);

    public List<Category> getAllCategory();
}
