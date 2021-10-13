package com.phisoft.apifirstone.services;

import com.phisoft.apifirstone.models.Category;
import com.phisoft.apifirstone.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Qualifier("category-impl-one")
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
     this.categoryRepository=categoryRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Category> findAllBookCategory() {
        return categoryRepository.findAll();
    }
}
