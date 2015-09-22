package edu.starterkit.dao;


import java.util.List;

import edu.starterkit.to.BookTo;

public interface BookDao {

    List<BookTo> findAll();

    List<BookTo> findBookByTitle(String title);

    List<BookTo> findBooksByAuthor(String author);

    BookTo save(BookTo book);
}
