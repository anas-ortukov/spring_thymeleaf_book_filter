package uz.oasis.jdbc_spring_bookshop.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uz.oasis.jdbc_spring_bookshop.entity.Book;
import uz.oasis.jdbc_spring_bookshop.repo.AuthorRepo;
import uz.oasis.jdbc_spring_bookshop.repo.BookRepo;
import uz.oasis.jdbc_spring_bookshop.repo.GenreRepo;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final GenreRepo genreRepo;
    private final HttpSession httpSession;

    public ModelAndView filterAuthors(UUID authorId) {
        httpSession.setAttribute("selectedAuthorId", authorId);
        ModelAndView modelAndView = new ModelAndView("authorPage");
        modelAndView.addObject("books", bookRepo.getByAuthorId(authorId));
        modelAndView.addObject("authors", authorRepo.findAll());
        modelAndView.addObject("genres", genreRepo.getByAuthorId(authorId));
        modelAndView.addObject("selectedAuthorId", authorId);
        return modelAndView;
    }

    public ModelAndView filterAuthorsGenres(String paramId) {
        UUID authorId = (UUID) httpSession.getAttribute("selectedAuthorId");
        ModelAndView modelAndView = new ModelAndView("authorPage");
        List<Book> books;
        if (paramId.equals("all")) {
            books = bookRepo.getByAuthorId(authorId);
        }else {
            UUID genreId = UUID.fromString(paramId);
            books = bookRepo.findByAuthorAndGenreId(authorId, genreId);
            modelAndView.addObject("selectedGenreId", genreId);
        }
        modelAndView.addObject("selectedAuthorId", authorId);
        modelAndView.addObject("authors", authorRepo.findAll());
        modelAndView.addObject("books", books);
        modelAndView.addObject("genres", genreRepo.getByAuthorId(authorId));
        return modelAndView;
    }
}
