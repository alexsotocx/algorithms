package modeling.library.repositories;

import modeling.library.Author;
import modeling.library.Book;
import modeling.library.components.LibraryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryLibraryRepository implements LibraryRepository {
  private final HashMap<Integer, Author> authorById;
  private HashMap<String, List<Book>> booksByName;
  private HashMap<String, List<Book>> booksByAuthor;
  private List<Book> books;
  private List<Author> authors;

  public MemoryLibraryRepository(List<Author> authors, List<Book> books) {
    this.authors = authors;
    this.books = books;

    authorById = new HashMap<>();
    for(Author author: authors) authorById.put(author.getId(), author);

    booksByName = new HashMap<>();
    for(final Book book: books) {
      List<Book> savedBooks = booksByName.compute(book.getName(), (s, books1) -> {
        if (books1 == null) return new ArrayList<>();
        return books1;
      });

      savedBooks.add(book);
    }

    booksByAuthor = new HashMap<>();
    for(final Book book: books) {
      List<Book> savedBooks = booksByAuthor.compute(book.getAuthor().getName(), (s, books1) -> {
        if (books1 == null) return new ArrayList<>();
        return books1;
      });

      savedBooks.add(book);
    }
  }

  @Override
  public List<Book> findBookByAuthor(int authorId) {
    Author author = this.findAuthor(authorId);
    return booksByAuthor.getOrDefault(author.getName(), new ArrayList<>());
  }

  @Override
  public Author findAuthor(int authorId) {
    return authorById.get(authorId);
  }

  @Override
  public List<Book> findBook(String name) {
    return booksByName.getOrDefault(name, new ArrayList<>());
  }
}
