package uz.oasis.jdbc_spring_bookshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.oasis.jdbc_spring_bookshop.service.BookService;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ModelAndView homePage() {
        return bookService.homePage();
    }

}
