package com.samdev.bookreviewsmicroservices.Repository;

import com.samdev.bookreviewsmicroservices.Entity.BooksReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewRepository extends JpaRepository<BooksReviewEntity, Long> {
}
