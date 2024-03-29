package com.samdev.bookreviewsmicroservices.Service.Impl;

import com.samdev.bookreviewsmicroservices.DTO.BookReviewDTO;
import com.samdev.bookreviewsmicroservices.DTO.ReqResponseDTO;
import com.samdev.bookreviewsmicroservices.Entity.BooksReviewEntity;
import com.samdev.bookreviewsmicroservices.Repository.BookReviewRepository;
import com.samdev.bookreviewsmicroservices.Service.BooksReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BooksReviewImpl implements BooksReviewService {

    private final BookReviewRepository bookReviewRepository;

    public BooksReviewImpl(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    @Override
    public ReqResponseDTO createReview(BookReviewDTO bookReviewDTO1) {

        ReqResponseDTO response = new ReqResponseDTO();
        BookReviewDTO bookReviewDTO = new BookReviewDTO();

        BooksReviewEntity booksReviewEntity = new BooksReviewEntity();

        try {
            booksReviewEntity.setReviewLanguage(bookReviewDTO1.getReviewLanguage());
            booksReviewEntity.setIsbn(bookReviewDTO1.getIsbn());
            booksReviewEntity.setUserId(bookReviewDTO1.getUserId());
            booksReviewEntity.setRating(bookReviewDTO1.getRating());
            booksReviewEntity.setReviewText(bookReviewDTO1.getReviewText());
            booksReviewEntity.setReviewTime(LocalDate.now());
            booksReviewEntity.setLikes(bookReviewDTO1.getLikes());
            booksReviewEntity.setDislikes(bookReviewDTO1.getDislikes());
            booksReviewEntity.setRecommendation(bookReviewDTO1.getRecommendation());

            bookReviewRepository.save(booksReviewEntity);
            response.setStatusCode(200);
            response.setResponseMessage("Review saved!");
            response.setBookReviewDTO(bookReviewDTO1);

            return response;

        }catch (Exception e){

            response.setResponseMessage("An error has occurred");
            response.setStatusCode(400);

            return response;
        }
    }

    public BookReviewDTO mapBookReviewEntityToBookReviewDTO(BooksReviewEntity booksReviewEntity){
        BookReviewDTO bookReviewDTO = new BookReviewDTO();
        bookReviewDTO.setReviewLanguage(booksReviewEntity.getReviewLanguage());
        bookReviewDTO.setIsbn(booksReviewEntity.getIsbn());
        bookReviewDTO.setUserId(booksReviewEntity.getUserId());
        bookReviewDTO.setRating(booksReviewEntity.getRating());
        bookReviewDTO.setReviewText(booksReviewEntity.getReviewText());
        bookReviewDTO.setReviewTime(booksReviewEntity.getReviewTime());
        bookReviewDTO.setLikes(booksReviewEntity.getLikes());
        bookReviewDTO.setDislikes(booksReviewEntity.getDislikes());
        bookReviewDTO.setRecommendation(booksReviewEntity.getRecommendation());

        return bookReviewDTO;
    }

    @Override
    public ReqResponseDTO listAllReviews() {
        ReqResponseDTO response = new ReqResponseDTO();

        try{
            List<BookReviewDTO> booksReviewList = bookReviewRepository.findAll()
                    .stream()
                    .map(this::mapBookReviewEntityToBookReviewDTO)
                    .collect(Collectors.groupingBy(BookReviewDTO::getIsbn))
                            .values()
                                    .stream()
                                            .flatMap(List::stream)
                                                    .collect(Collectors.toList());

            response.setBookReviewDTOList(booksReviewList);
            response.setStatusCode(200);
            response.setResponseMessage("All Book views per book");

            return response;


        }catch (Exception e){
            response.setResponseMessage("Error retrieving all reviews!");
            response.setStatusCode(500);

            return response;
        }
    }

    @Override
    public ReqResponseDTO listReviewPerBook(BookReviewDTO bookReviewDTO) {
        ReqResponseDTO response = new ReqResponseDTO();

        try {
            List<BookReviewDTO> booksReviewList = bookReviewRepository.findByIsbn(bookReviewDTO.getIsbn())
                    .stream()
                    .map(this::mapBookReviewEntityToBookReviewDTO)
                    .collect(Collectors.groupingBy(BookReviewDTO::getIsbn))
                    .values()
                    .stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            response.setBookReviewDTOList(booksReviewList);
            response.setStatusCode(200);
            response.setResponseMessage("All Book views per book");

            return response;
        } catch (Exception e) {
            response.setResponseMessage("Error retrieving all reviews!");
            response.setStatusCode(500);

            return response;
        }
    }

    @Override
    public ReqResponseDTO filterPerMostLikes() {
        ReqResponseDTO response = new ReqResponseDTO();

        try {
            List<BookReviewDTO> filterPerLikes = bookReviewRepository.findAll()
                    .stream()
                    .map(this::mapBookReviewEntityToBookReviewDTO)
                    .sorted(Comparator.comparing(BookReviewDTO::getLikes).reversed())
                    .toList();

            response.setBookReviewDTOList(filterPerLikes);
            response.setStatusCode(200);
            response.setResponseMessage("Review likes in descending order!");

            return response;

        }catch (Exception e){
            response.setResponseMessage("Error retrieving all reviews!");
            response.setStatusCode(500);

            return response;
        }
    }

    @Override
    public ReqResponseDTO totalReviewsPerBook(BookReviewDTO bookReviewDTO) {
        ReqResponseDTO response = new ReqResponseDTO();
        BookReviewDTO bookReviewDTO1 = new BookReviewDTO();

        try {

            Map<String, Long> totalReviewsPerBook = bookReviewRepository.findByIsbn(bookReviewDTO.getIsbn())
                    .stream()
                    .map(this::mapBookReviewEntityToBookReviewDTO)
                            .collect(Collectors.groupingBy(
                                    BookReviewDTO::getIsbn,
                                    Collectors.counting()
                            ));
            // If the map is empty, ISBN does not exist
            if (totalReviewsPerBook.isEmpty()) {
                throw new IllegalArgumentException("ISBN does not exist.");
            }

            bookReviewDTO1.setReviewsPerBook(totalReviewsPerBook);

            response.setBookReviewDTO(bookReviewDTO1);

            response.setStatusCode(200);
            response.setResponseMessage("total reviews per book!");

            return response;

        }catch (IllegalArgumentException e){
            response.setResponseMessage(e.getMessage());
            response.setStatusCode(404);

            return response;
        }catch (Exception e){
            response.setResponseMessage("Error retrieving all reviews!");
            response.setStatusCode(500);

            return response;
        }
    }
}
