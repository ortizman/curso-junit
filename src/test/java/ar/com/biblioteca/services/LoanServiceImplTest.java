package ar.com.biblioteca.services;

import ar.com.biblioteca.entities.Book;
import ar.com.biblioteca.entities.Inventory;
import ar.com.biblioteca.entities.LoanBooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class LoanServiceImplTest {

    private LoanService loanService;

    @Test
    public void testCreateLoanBook() {

        final Book book1 = new Book("book 1", "autor 1", "1001");
        final Book book2 = new Book("book 2", "autor 2", "1002");
        final Book book3 = new Book("book 3", "autor 3", "1003");

        final Inventory inventory = new Inventory();
        inventory.setBooks(List.of(book1, book2, book3));
        loanService = new LoanServiceImpl(inventory);

        Assertions.assertEquals(0, loanService.numberOfLoans());

        final LoanBooks loanBooks =
                new LoanBooks(List.of(book2), LocalDate.now(), LocalDate.of(2023, 12, 1));

        loanService.registerLoan(loanBooks);

        Assertions.assertEquals(1, loanService.numberOfLoans(),
                "Debería existir un unico pedido de libros");


    }

}
