package com.samdev.bookreviewsmicroservices.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqResponseDTO {

    private BookReviewDTO bookReviewDTO;

    private List<BookReviewDTO> bookReviewDTOList;

    private String responseMessage;
    private Integer statusCode;

    private Integer otp;
    private String username;


    public ReqResponseDTO() {
    }

    public ReqResponseDTO(BookReviewDTO bookReviewDTO,
                          List<BookReviewDTO> bookReviewDTOList,
                          String responseMessage,
                          Integer statusCode,
                          Integer otp,
                          String username) {
        this.bookReviewDTO = bookReviewDTO;
        this.bookReviewDTOList = bookReviewDTOList;
        this.responseMessage = responseMessage;
        this.statusCode = statusCode;
        this.otp = otp;
        this.username = username;
    }

    public BookReviewDTO getBookReviewDTO() {
        return bookReviewDTO;
    }

    public void setBookReviewDTO(BookReviewDTO bookReviewDTO) {
        this.bookReviewDTO = bookReviewDTO;
    }

    public List<BookReviewDTO> getBookReviewDTOList() {
        return bookReviewDTOList;
    }

    public void setBookReviewDTOList(List<BookReviewDTO> bookReviewDTOList) {
        this.bookReviewDTOList = bookReviewDTOList;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

