package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book bookFirst = new Book("One hundred years of solitude", 416);
        Book bookSecond = new Book("Lord of the Flies", 352);
        Book bookThird = new Book("Clean code", 464);
        Book bookFourth = new Book("The picture of Dorian Gray", 400);

        Book[] books = new Book[4];
        books[0] = bookFirst;
        books[1] = bookSecond;
        books[2] = bookThird;
        books[3] = bookFourth;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getNameBook() + " - " + book.getCount());
        }

        Book number = books[0];
        books[0] = books[3];
        books[3] = number;

        System.out.println();

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            String name = book.getNameBook();

            if (name.equals("Clean code")) {
                System.out.println(book.getNameBook() + " - " + book.getCount());
            }
        }
    }
}
