package modeling.library.components;

import modeling.library.Author;
import modeling.library.Book;

import java.util.List;

public interface LibraryRepository {
  List<Book> findBookByAuthor(int authorId);
  Author findAuthor(int authorId);
  List<Book> findBook(String name);
}
