package com.phisoft.apifirstone.repositories;

import com.phisoft.apifirstone.models.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Book-type repository
 */
@Repository
public interface BookTypeRepository extends JpaRepository<BookType,Long> {

}
