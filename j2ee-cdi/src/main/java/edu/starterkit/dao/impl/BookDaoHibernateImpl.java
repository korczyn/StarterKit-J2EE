package edu.starterkit.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import edu.starterkit.aop.NullableId;
import edu.starterkit.common.Sequence;
import edu.starterkit.dao.BookDao;
import edu.starterkit.to.BookTo;

@HibernateDao
public class BookDaoHibernateImpl implements BookDao{
	private final Set<BookTo> ALL_BOOKS = new HashSet<>();

    private Sequence sequence;


    @Override
    public List<BookTo> findAll() {
        return new ArrayList<>(ALL_BOOKS);
    }

    @Override
    public List<BookTo> findBookByTitle(String title) {
        return null;
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    @NullableId
    public BookTo save(BookTo book) {
        if (book.getId() == null) {
            book.setId(sequence.nextValue(ALL_BOOKS));
        }
        ALL_BOOKS.add(book);
        return book;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    @Inject
    private void addTestBooks() {
        ALL_BOOKS.add(new BookTo(1L, "1Romeo i Julia", "Wiliam Szekspir"));
        ALL_BOOKS.add(new BookTo(2L, "1Opium w rosole", "Hanna Ożogowska"));
        ALL_BOOKS.add(new BookTo(3L, "1Przygody Odyseusza", "Jan Parandowski"));
        ALL_BOOKS.add(new BookTo(4L, "1Awantura w Niekłaju", "Edmund Niziurski"));
        ALL_BOOKS.add(new BookTo(5L, "1Pan Samochodzik i Fantomas", "Zbigniew Nienacki"));
        ALL_BOOKS.add(new BookTo(6L, "1Zemsta", "Aleksander Fredro"));
    }
}
