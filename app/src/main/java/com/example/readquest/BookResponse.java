package com.example.readquest;

import java.util.List;

public class BookResponse {
    private List<Book> bookList;
    public List<Book> getData() {
        return bookList;
    }
    public void setData(List<Book> bookList) {
        this.bookList = bookList;
    }
}
