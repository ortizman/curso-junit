package ar.com.biblioteca.services;

import ar.com.biblioteca.entities.Book;
import ar.com.biblioteca.entities.Inventory;
import ar.com.biblioteca.entities.LoanBooks;
import org.junit.platform.commons.util.StringUtils;

import java.awt.datatransfer.StringSelection;
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
        loanBooks.getBooks().forEach(book -> checkBook(book));
        inventory.getLoanBooks().add(loanBooks);
        inventory.getBooks().removeAll(loanBooks.getBooks());
    }

    private void checkBook(Book book) {
        if (StringUtils.isBlank(book.getIsbn())) {
            throw new IllegalArgumentException("El ISBN no puede ser nulo o vacio");
        }

        if (!inventory.getBooks().contains(book)) {
            throw new IllegalArgumentException("El libro, con ISBN " + book.getIsbn() + ", no existe en el catalogo");
        }
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
