package uz.oasis.jdbc_spring_bookshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uz.oasis.jdbc_spring_bookshop.repo.AuthorRepo;
import uz.oasis.jdbc_spring_bookshop.repo.BookRepo;
import uz.oasis.jdbc_spring_bookshop.repo.GenreRepo;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final GenreRepo genreRepo;

    public ModelAndView homePage() {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");
        view.addObject("books", bookRepo.findAll());
        view.addObject("authors", authorRepo.findAll());
        view.addObject("genres", genreRepo.findAll());
        return view;
    }
}
