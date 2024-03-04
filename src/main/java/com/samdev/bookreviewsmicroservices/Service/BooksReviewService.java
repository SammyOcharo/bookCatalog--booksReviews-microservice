package com.samdev.bookreviewsmicroservices.Service;

import com.samdev.bookreviewsmicroservices.DTO.BookReviewDTO;
import com.samdev.bookreviewsmicroservices.DTO.ReqResponseDTO;

public interface BooksReviewService {
    ReqResponseDTO createReview(BookReviewDTO bookReviewDTO);

    ReqResponseDTO listAllReviews();

    ReqResponseDTO listReviewPerBook(BookReviewDTO bookReviewDTO);

    ReqResponseDTO filterPerMostLikes();

    ReqResponseDTO totalReviewsPerBook();
}
