package ru.astondevs.orderservice.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.astondevs.orderservice.exception.ExceptionDetails;
import ru.astondevs.orderservice.exception.NotEnoughProductException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NotEnoughProductException.class)
    public ResponseEntity<ExceptionDetails> exceptionAdsNotFoundHandler() {
        ExceptionDetails notFoundDetails = new ExceptionDetails();
        notFoundDetails.setMessage("Не достаточно товаров на складе");
        return ResponseEntity
                .badRequest()
                .body(notFoundDetails);
    }
}
