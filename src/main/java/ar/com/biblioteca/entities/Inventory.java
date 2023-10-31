package ar.com.biblioteca.entities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Book> books = new ArrayList<>();

    private List<LoanBooks> loanBooks = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }


    // setters and getters
    public Inventory() {
    }

    public void setBooks(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public List<LoanBooks> getLoanBooks() {
        return loanBooks;
    }

    public void setLoanBooks(List<LoanBooks> loanBooks) {
        this.loanBooks = loanBooks;
    }

}
