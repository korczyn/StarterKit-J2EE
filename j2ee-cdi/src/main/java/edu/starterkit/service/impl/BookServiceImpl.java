package edu.starterkit.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.starterkit.aop.Logging;
import edu.starterkit.dao.BookDao;
import edu.starterkit.dao.impl.DefaultDao;
import edu.starterkit.service.BookService;
import edu.starterkit.to.BookTo;

@Logging
public class BookServiceImpl implements BookService {

	@Inject @DefaultDao
	private BookDao bookDao;

	@Override
	public List<BookTo> findAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public List<BookTo> findBooksByTitle(String title) {
		return bookDao.findBookByTitle(title);
	}

	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		return bookDao.findBooksByAuthor(author);
	}

	@Override
	public BookTo saveBook(BookTo book) {
		return bookDao.save(book);
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
