package com.samdev.bookreviewsmicroservices.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookReviewDTO {
    private String isbn;
    private String userId;
    private Integer rating;
    private String reviewText;
    private Integer likes;
    private Integer dislikes;
    private String recommendation;
    private LocalDate reviewTime;
    private String reviewLanguage;

    public BookReviewDTO() {
    }

    public BookReviewDTO(String isbn, String userId, Integer rating, String reviewText, Integer likes, Integer dislikes, String recommendation, LocalDate reviewTime, String reviewLanguage) {
        this.isbn = isbn;
        this.userId = userId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.likes = likes;
        this.dislikes = dislikes;
        this.recommendation = recommendation;
        this.reviewTime = reviewTime;
        this.reviewLanguage = reviewLanguage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public LocalDate getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalDate reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewLanguage() {
        return reviewLanguage;
    }

    public void setReviewLanguage(String reviewLanguage) {
        this.reviewLanguage = reviewLanguage;
    }
}
