package ar.com.biblioteca.services;

import ar.com.biblioteca.entities.Book;
import ar.com.biblioteca.entities.Inventory;
import ar.com.biblioteca.entities.LoanBooks;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoanServiceImplTest {

    private LoanService loanService;

    @BeforeAll
    static void initAll() {
        System.out.println("Comienzan los test de LoanServiceImplTest");
    }

    @BeforeEach
    void init() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("book 1", "autor 1", "1001"));
        bookList.add(new Book("book 2", "autor 2", "1002"));
        bookList.add(new Book("book 3", "autor 3", "1003"));

        Inventory inventory = new Inventory();
        inventory.setBooks(bookList);
        loanService = new LoanServiceImpl(inventory);
    }

    @AfterEach
    void tearDown() {
        loanService = null;
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Finalizaron todos los test de la clase LoanServiceImplTest");
    }

    @Test
    public void testCreateLoanBook() {
        Assertions.assertEquals(0, loanService.numberOfLoans());

        Book book2 = new Book("book 2", "autor 2", "1002");

        final LoanBooks loanBooks =
                new LoanBooks(List.of(book2), LocalDate.now(), LocalDate.of(2023, 12, 1));

        loanService.registerLoan(loanBooks);

        Assertions.assertEquals(1, loanService.numberOfLoans(),
                "Debería existir un unico pedido de libros");
    }

    @RepeatedTest(10)
    public void testCreateRandomLoanBook() {
        Assertions.assertEquals(0, loanService.numberOfLoans());

        SecureRandom rand = new SecureRandom();
        final int i = rand.nextInt(1, 5);

        Book book2 = new Book("book " + i, "autor " + i, "100" + i);

        final LoanBooks loanBooks =
                new LoanBooks(List.of(book2), LocalDate.now(), LocalDate.of(2023, 12, 1));

        loanService.registerLoan(loanBooks);

        Assertions.assertEquals(1, loanService.numberOfLoans(),
                "Debería existir un unico pedido de libros");
    }

    @Test
    public void testCreateLoanBookFromInvalidBook() {
        Assertions.assertEquals(0, loanService.numberOfLoans());

        Book book2 = new Book("book 2", "autor 2", "");

        final LoanBooks loanBooks =
                new LoanBooks(List.of(book2), LocalDate.now(), LocalDate.of(2023, 12, 1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> loanService.registerLoan(loanBooks));
    }

    @Test
    public void testCreateLoanBookWithNonExistentBook() {
        Assertions.assertEquals(0, loanService.numberOfLoans());

        Book book2 = new Book("book 2", "autor 2", "2000");

        final LoanBooks loanBooks =
                new LoanBooks(List.of(book2), LocalDate.now(), LocalDate.of(2023, 12, 1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> loanService.registerLoan(loanBooks));

    }

}
