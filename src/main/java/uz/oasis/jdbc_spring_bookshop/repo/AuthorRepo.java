package uz.oasis.jdbc_spring_bookshop.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.oasis.jdbc_spring_bookshop.entity.Author;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AuthorRepo {

    private final JdbcTemplate jdbcTemplate;

    public void save(Author author) {
        var sql = "INSERT INTO author (full_name)  VALUES (?)";
        jdbcTemplate.update(sql, author.getFullName());
    }

    public List<Author> findAll() {
        var sql = "SELECT * FROM author";
        var bookRowMapper = new BeanPropertyRowMapper<>(Author.class);
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    public List<UUID> findAllIds() {
        var sql = "SELECT id FROM author";
        var bookRowMapper = new BeanPropertyRowMapper<>(UUID.class);
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    public List<Author> getByGenreId(UUID genreId) {
        var sql = "SELECT a.id, a.full_name FROM author a JOIN book b on a.id = b.author_id WHERE b.genre_id = ?";
        var bookRowMapper = new BeanPropertyRowMapper<>(Author.class);
        return jdbcTemplate.query(sql, bookRowMapper, genreId);
    }
}
