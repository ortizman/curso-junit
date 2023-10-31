package ar.com.biblioteca.services;

import ar.com.biblioteca.entities.Inventory;
import ar.com.biblioteca.entities.LoanBooks;

import java.util.List;

public class LoanServiceImpl implements LoanService{

    private Inventory inventory = new Inventory();

    public LoanServiceImpl() {

    }

    public LoanServiceImpl(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void registerLoan(LoanBooks loanBooks) {
        inventory.getLoanBooks().add(loanBooks);
        inventory.getBooks().removeAll(loanBooks.getBooks());
    }

    @Override
    public List<LoanBooks> getLoans() {
        return inventory.getLoanBooks();
    }

    @Override
    public long numberOfLoans() {
        return inventory.getLoanBooks().size();
    }

}
