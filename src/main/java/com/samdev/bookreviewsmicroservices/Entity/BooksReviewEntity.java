package com.samdev.bookreviewsmicroservices.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "BOOK_REVIEW")
public class BooksReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewID;
    private String isbn;
    private String userId;
    private int rating;
    private String reviewText;
    private LocalDate reviewTime;
    private int likes;
    private int dislikes;
    private String recommendation;
    private String reviewLanguage;

    public BooksReviewEntity() {
    }

    public BooksReviewEntity(
            Long reviewID,
            String isbn,
            String userId,
            int rating,
            String reviewText,
            LocalDate reviewTime,
            int likes,
            int dislikes,
            String recommendation,
            String reviewLanguage) {
        this.reviewID = reviewID;
        this.isbn = isbn;
        this.userId = userId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewTime = reviewTime;
        this.likes = likes;
        this.dislikes = dislikes;
        this.recommendation = recommendation;
        this.reviewLanguage = reviewLanguage;
    }

    public Long getReviewID() {
        return reviewID;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalDate reviewTime) {
        this.reviewTime = reviewTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getReviewLanguage() {
        return reviewLanguage;
    }

    public void setReviewLanguage(String reviewLanguage) {
        this.reviewLanguage = reviewLanguage;
    }
}
