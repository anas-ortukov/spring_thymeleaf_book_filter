package uz.oasis.jdbc_spring_bookshop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.oasis.jdbc_spring_bookshop.service.AuthorService;
import uz.oasis.jdbc_spring_bookshop.service.GenreService;

import java.util.UUID;

@CrossOrigin
@Controller
@RequestMapping("filter")
@RequiredArgsConstructor
public class FilterController {

    private final GenreService genreService;
    private final AuthorService authorService;

    @GetMapping("genre")
    public ModelAndView filterGenres(@RequestParam UUID genre) {
        return genreService.filterGenres(genre);
    }

    @GetMapping("/genre/author/{id}")
    public ModelAndView filterGenreAuthors(@PathVariable String id) {
        return genreService.filterGenreAuthors(id);
    }

    @GetMapping("author")
    public ModelAndView filterAuthors(@RequestParam UUID author) {
        return authorService.filterAuthors(author);
    }

    @GetMapping("/author/genre/{id}")
    public ModelAndView filterAuthorsGenre(@PathVariable String id) {
        return authorService.filterAuthorsGenres(id);
    }

}
