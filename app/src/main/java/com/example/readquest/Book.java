package com.example.readquest;

public class Book {
    private int id;
    private String cover_image;
    private String title;
    private String author;
    private String publication_year;
    private String[] genre;

//    public Book(int id, String title, String author, int publication_year, String[] genre, String description, String cover_image) {
//        this.id = id;
//        this.title = title;
//        this.author = author  ;
//        this.publication_year = publication_year;
//        this.genre = genre;
//        this.description = description;
//        this.cover_image = cover_image;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    private String description;
}

