package by.itclass.controllers;

import by.itclass.model.entities.Book;
import by.itclass.model.entities.BookInLibrary;
import by.itclass.model.repositories.BookRepository;
import by.itclass.model.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    private BookRepository bookRepository;
    private LibraryRepository libraryRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping("/addBook/{id}")
    public ModelAndView addBook(
            @PathVariable(name = "id") int id) {
        return new ModelAndView("add-book", "book", new BookInLibrary(id));
    }

    @PostMapping("/saveBook")
    public String saveBook(
            @ModelAttribute(name = "book") BookInLibrary bookInLibrary) {
        var book = new Book(bookInLibrary.getTitle(), bookInLibrary.getAuthor(), bookInLibrary.getPages());
        var library = libraryRepository.findById(bookInLibrary.getLibrary_id()).get();
        book.setLibrary(library);
        bookRepository.save(book);
        return "redirect:/view/" + bookInLibrary.getLibrary_id();
    }

    @PostMapping("/add-book-old")
    public String saveBookOld(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "pages") int pages,
            @RequestParam(name = "library_id") int library_id) {
        var book = new Book(title, author, pages);
        var library = libraryRepository.findById(library_id).get();
        book.setLibrary(library);
        bookRepository.save(book);
        return "redirect:/view/" + library_id;
    }

    @GetMapping("/deleteBook/{book_id}/{library_id}")
    public String deleteBook(
            @PathVariable(name = "book_id") int bookId,
            @PathVariable(name = "library_id") int libraryId) {
        bookRepository.deleteById(bookId);
        return "redirect:/view/" + libraryId;
    }

    @GetMapping("/deleteBookSecond/{book_id}")
    public String deleteBookSecond(
            @PathVariable(name = "book_id") int bookId) {
        var book = bookRepository.findById(bookId).get();
        var libraryId = book.getLibrary().getId();
        bookRepository.delete(book);
        return "redirect:/view/" + libraryId;
    }

    @PostMapping("/upd-book-old")
    public String updateBookOld(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "pages") int pages,
            @RequestParam(name = "library") int library_id) {
        var library = libraryRepository.findById(library_id).get();
        var book = new Book(id, title, author, pages, library);
        bookRepository.save(book);
        return "redirect:/view/" + library_id;
    }
}
