package uz.oasis.jdbc_spring_bookshop.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.oasis.jdbc_spring_bookshop.entity.Book;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BookRepo {

    private final JdbcTemplate jdbcTemplate;

    public void save(Book book) {
        var sql = "INSERT INTO book (title, description, author_id, genre_id)  VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getDescription(), book.getAuthorId(), book.getGenreId());
    }

    public List<Book> findAll() {
        var sql = "SELECT * FROM book";
        var bookRowMapper = new BeanPropertyRowMapper<>(Book.class);
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    public List<Book> getByGenreId(UUID genreId) {
        var sql = "SELECT * FROM book WHERE genre_id = ?";
        var bookRowMapper = new BeanPropertyRowMapper<>(Book.class);
        return jdbcTemplate.query(sql, bookRowMapper, genreId);
    }

    public List<Book> getByAuthorId(UUID authorId) {
        var sql = "SELECT * FROM book WHERE author_id = ?";
        var bookRowMapper = new BeanPropertyRowMapper<>(Book.class);
        return jdbcTemplate.query(sql, bookRowMapper, authorId);
    }

    public List<Book> findByAuthorAndGenreId(UUID authorId, UUID genreId) {
        var sql = "SELECT * FROM book WHERE author_id = ? AND genre_id = ?";
        var bookRowMapper = new BeanPropertyRowMapper<>(Book.class);
        return jdbcTemplate.query(sql, bookRowMapper, authorId, genreId);
    }
}
