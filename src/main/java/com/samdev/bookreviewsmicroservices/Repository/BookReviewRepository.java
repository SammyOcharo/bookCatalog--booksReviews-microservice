package com.samdev.bookreviewsmicroservices.Repository;

import com.samdev.bookreviewsmicroservices.Entity.BooksReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookReviewRepository extends JpaRepository<BooksReviewEntity, Long> {

    Optional<BooksReviewEntity> findByReviewLanguage(String reviewLanguage);
}
