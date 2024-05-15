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
public class GenreService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final GenreRepo genreRepo;
    private final HttpSession httpSession;


    public ModelAndView filterGenres(UUID genreId) {
        httpSession.setAttribute("selectedGenreId", genreId);
        ModelAndView modelAndView = new ModelAndView("genrePage");
        modelAndView.addObject("books", bookRepo.getByGenreId(genreId));
        modelAndView.addObject("authors", authorRepo.getByGenreId(genreId));
        modelAndView.addObject("genres", genreRepo.findAll());
        modelAndView.addObject("selectedGenreId", genreId);
        return modelAndView;
    }

    public ModelAndView filterGenreAuthors(String paramId) {
        UUID genreId = (UUID) httpSession.getAttribute("selectedGenreId");
        ModelAndView modelAndView = new ModelAndView("genrePage");
        List<Book> books;
        if (paramId.equals("all")) {
            books = bookRepo.getByGenreId(genreId);
        }else {
            UUID authorId = UUID.fromString(paramId);
            books = bookRepo.findByAuthorAndGenreId(authorId, genreId);
            modelAndView.addObject("selectedAuthorId", authorId);
        }
        modelAndView.addObject("selectedGenreId", genreId);
        modelAndView.addObject("authors", authorRepo.getByGenreId(genreId));
        modelAndView.addObject("books", books);
        modelAndView.addObject("genres", genreRepo.findAll());
        return modelAndView;
    }
}
