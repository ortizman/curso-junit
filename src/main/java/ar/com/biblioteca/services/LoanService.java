package ar.com.biblioteca.services;

import ar.com.biblioteca.entities.LoanBooks;

import java.util.List;

public interface LoanService {
    void registerLoan(LoanBooks loanBooks);

    List<LoanBooks> getLoans();

    long numberOfLoans();

}
