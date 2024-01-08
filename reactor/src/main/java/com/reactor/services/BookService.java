package com.reactor.services;

import com.reactor.domain.Book;
import com.reactor.domain.Review;
import com.reactor.services.exceptions.BookException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;

import java.time.Duration;
import java.util.List;

@Slf4j
public class BookService {

    private BookInfoService bookInfoService;
    private ReviewService reviewService;

    public BookService(BookInfoService bookInfoService, ReviewService reviewService) {
        this.bookInfoService = bookInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Book> getBooks() {
        var allBooksInfo = bookInfoService.getBooksInfo();
        return allBooksInfo
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews =
                            reviewService.getReviews(bookInfo.getBookId()).collectList();
                    return reviews
                            .map(review -> new Book(bookInfo, review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is :" + throwable);
                    return new BookException("Exception occurred while fetching Books");
                })
                .log();
    }

    public Mono<Book> getBookById(long bookId) {
        var book = bookInfoService.getBookInfoById(bookId);
        var review = reviewService
                .getReviews(bookId)
                .collectList();

        return book
                .zipWith(review, Book::new);
    }

    public Flux<Book> getBooksRetry() {
        var allBooks = bookInfoService.getBooksInfo();
        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews =
                            reviewService.getReviews(bookInfo.getBookId()).collectList();
                    return reviews
                            .map(review -> new Book(bookInfo, review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is :" + throwable);
                    return new BookException("Exception occurred while fetching Books");
                })
                .retry(3)
                .log();
    }

    public Flux<Book> getBooksRetryWhen() {
        var allBooks = bookInfoService.getBooksInfo();
        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews =
                            reviewService.getReviews(bookInfo.getBookId()).collectList();
                    return reviews
                            .map(review -> new Book(bookInfo, review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is :" + throwable);
                    return new BookException("Exception occurred while fetching Books");
                })
                .retryWhen(getRetryBackoffSpec())
                .log();
    }

    private RetryBackoffSpec getRetryBackoffSpec() {
        return Retry.backoff(3, Duration.ofMillis(1000))
                .filter(throwable -> throwable instanceof BookException)
                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) ->
                        Exceptions.propagate(retrySignal.failure())
                );
    }

}
