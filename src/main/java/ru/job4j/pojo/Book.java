package ru.job4j.pojo;

public class Book {
    private String nameBook;
    private int count;

    public Book(String nameBook, int count) {
        this.nameBook = nameBook;
        this.count = count;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
