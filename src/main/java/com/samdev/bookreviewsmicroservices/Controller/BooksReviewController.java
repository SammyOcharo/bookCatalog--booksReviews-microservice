package com.samdev.bookreviewsmicroservices.Controller;

import com.samdev.bookreviewsmicroservices.DTO.BookReviewDTO;
import com.samdev.bookreviewsmicroservices.DTO.ReqResponseDTO;
import com.samdev.bookreviewsmicroservices.Service.BooksReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apps/api/v1/books-reviews/")
public class BooksReviewController {

    private final BooksReviewService booksReviewService;

    public BooksReviewController(BooksReviewService booksReviewService) {
        this.booksReviewService = booksReviewService;
    }

    //create review
    @PostMapping("add-review/")
    public ResponseEntity<ReqResponseDTO> createReview(@RequestBody BookReviewDTO bookReviewDTO){
        return new ResponseEntity<>(booksReviewService.createReview(bookReviewDTO), HttpStatus.OK);
    }
    //see all reviews
    @GetMapping("list-all-reviews/")
    public ResponseEntity<ReqResponseDTO> listAllReviews(){
        return new ResponseEntity<>(booksReviewService.listAllReviews(), HttpStatus.OK);
    }
    // see all reviews per books
    @PostMapping("list-all-reviews-per-book/")
    public ResponseEntity<ReqResponseDTO> listReviewPerBook(@RequestBody BookReviewDTO bookReviewDTO){
        return new ResponseEntity<>(booksReviewService.listReviewPerBook(bookReviewDTO), HttpStatus.OK);
    }

    //filter books per likes in descending order
    @GetMapping("filter-per-most-likes/")
    public ResponseEntity<ReqResponseDTO> filterPerMostLikes(){
        return new ResponseEntity<>(booksReviewService.filterPerMostLikes(), HttpStatus.OK);
    }

    //see total number of reviews per book
    @PostMapping("total-reviews-per-book/")
    public ResponseEntity<ReqResponseDTO> totalReviewsPerBook(@RequestBody BookReviewDTO bookReviewDTO){
        return new ResponseEntity<>(booksReviewService.totalReviewsPerBook(bookReviewDTO), HttpStatus.OK);
    }
}
