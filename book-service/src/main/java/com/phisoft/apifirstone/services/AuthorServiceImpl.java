package com.phisoft.apifirstone.services;

import com.phisoft.apifirstone.models.Author;
import com.phisoft.apifirstone.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */

@Service
@Qualifier("author-impl-one")
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;
     @Autowired
    public  AuthorServiceImpl(AuthorRepository authorRepository){
     this.authorRepository=authorRepository;
    }
    /**
     * {@inheritDoc}
     */

    @Override
    public List<Author> findAllAuthors(){
            return authorRepository.findAll();
        }

}
