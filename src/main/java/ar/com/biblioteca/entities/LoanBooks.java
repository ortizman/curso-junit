package ar.com.biblioteca.entities;

import java.time.LocalDate;
import java.util.List;

public class LoanBooks {

    private List<Book> books;
    private LocalDate startDate;
    private LocalDate endDate;

    public LoanBooks() {
    }

    public LoanBooks(List<Book> books, LocalDate startDate, LocalDate endDate) {
        this.books = books;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // setters and getters

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
