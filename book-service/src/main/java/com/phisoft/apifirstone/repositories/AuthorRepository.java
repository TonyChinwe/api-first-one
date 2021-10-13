package com.phisoft.apifirstone.repositories;

import com.phisoft.apifirstone.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    /**
     * Fetach author using first name
     * @param name first name
     * @return author
     */
    public Author getAuthorByFirstName(String name);
}
