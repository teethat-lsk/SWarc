package com.solid.book;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookPublisher implements Publish{

    BookPublisher(){}

    public static void main(String[] args) {
        Book book = new Book("Tyland", List.of("I", "moved", "here", "recently", "too"));
        BookPublisher publisher = new BookPublisher();
        publisher.printToFile(book);
    }

    @Override
    public void printToFile(Book book) {
        boolean isEven = false;
        String previousPage = "";
        try {
            FileWriter fileWriter = new FileWriter(book.getTitle() + ".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            do {
                if (isEven) {
                    previousPage = book.getCurrentPage();
                    isEven = false;
                } else {
                    printWriter.printf("%-25s : %25s%n", previousPage, book.getCurrentPage());
                    isEven = true;
                }
            } while (book.turnToNextPage());
            printWriter.close();
        } catch (IOException ex) {
            System.out.println("Cannot print this book due to IOException");
        }
    }
        
    
}
