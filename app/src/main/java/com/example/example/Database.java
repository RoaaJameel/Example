package com.example.example;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Book> books = new ArrayList<>();

    public Database() {
        books.add(new Book("Professional Android Development ", "John", "Programming"));
        books.add(new Book("Database Syatems  ", "Elmasri", "Database "));
        books.add(new Book("Beginning Python ", "Mark", "Programming"));
        books.add(new Book("HTML 5 ", "Mark", "Web"));
    }

    public List<Book> getBooks(String cat) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getCategory().equals(cat)) {
                result.add(b);
            }

        }
         return result;

    }
}