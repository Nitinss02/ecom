package com.shop.shops.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.shops.Model.Category;
import com.shop.shops.Repository.categoryRepo;
import com.shop.shops.service.categoryService;

@Service
public class categoryServiceImpl implements categoryService {

    @Autowired
    private categoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public boolean existCategory(String name) {

        return categoryRepo.existsByProductName(name);
    }

}
