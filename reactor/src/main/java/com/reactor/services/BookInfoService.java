package com.reactor.services;

import com.reactor.domain.BookInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class BookInfoService {

    public Flux<BookInfo> getBooksInfo() {

        var bookInfos = List.of(
                new BookInfo(1, "Book One", "Author One", "12121212"),
                new BookInfo(2, "Book Two", "Author Two", "42342343"),
                new BookInfo(3, "Book Three", "Author Three", "23425444")
        );

//        List<BookInfo> bookInfos = List.of();
        return Flux.fromIterable(bookInfos);
    }

    public Mono<BookInfo> getBookInfoById(long bookId) {
        var bookInfo = new BookInfo(bookId, "Book One", "Author One", "12121212");
        return Mono.just(bookInfo);
    }

}