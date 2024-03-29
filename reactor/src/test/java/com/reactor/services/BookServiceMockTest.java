package com.reactor.services;

import com.reactor.services.exceptions.BookException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class BookServiceMockTest {

    @Mock
    private BookInfoService bookInfoService;

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private BookService bookService;

    @Test
    void getBooksMock() {

        Mockito.when(bookInfoService.getBooksInfo()).thenCallRealMethod();

        Mockito.when(reviewService.getReviews(Mockito.anyLong())).thenCallRealMethod();

        var books = bookService.getBooks();

        StepVerifier.create(books)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void getBooksMockOnError() {

        Mockito.when(bookInfoService.getBooksInfo()).thenCallRealMethod();

        Mockito.when(reviewService.getReviews(Mockito.anyLong()))
                .thenThrow(new IllegalStateException("Exception using Test"));

        var books = bookService.getBooks();

        StepVerifier.create(books)
                .expectError(BookException.class)
                .verify();
    }

    @Test
    void getBooksMockOnErrorRetry() {

        Mockito.when(bookInfoService.getBooksInfo()).thenCallRealMethod();

        Mockito.when(reviewService.getReviews(Mockito.anyLong()))
                .thenThrow(new IllegalStateException("Exception using Test"));

        var books = bookService.getBooksRetry();

        StepVerifier.create(books)
                .expectError(BookException.class)
                .verify();
    }

    @Test
    void getBooksMockOnErrorRetryWhen() {

        Mockito.when(bookInfoService.getBooksInfo()).thenCallRealMethod();

        Mockito.when(reviewService.getReviews(Mockito.anyLong()))
                .thenThrow(new IllegalStateException("Exception using Test"));

        var books = bookService.getBooksRetryWhen();

        StepVerifier.create(books)
                .expectError(BookException.class)
                .verify();
    }

}
