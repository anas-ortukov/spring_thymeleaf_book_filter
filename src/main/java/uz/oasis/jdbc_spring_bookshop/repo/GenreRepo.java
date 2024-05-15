package uz.oasis.jdbc_spring_bookshop.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.oasis.jdbc_spring_bookshop.entity.Genre;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GenreRepo {

    private final JdbcTemplate jdbcTemplate;

    public List<Genre> findAll() {
        var sql = "SELECT * FROM genres";
        var bookRowMapper = new BeanPropertyRowMapper<>(Genre.class);
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    public List<Genre> getByAuthorId(UUID authorId) {
        var sql = "SELECT g.* FROM book b JOIN genres g on g.id = b.genre_id WHERE b.author_id = ?";
        var bookRowMapper = new BeanPropertyRowMapper<>(Genre.class);
        return jdbcTemplate.query(sql, bookRowMapper, authorId);
    }
}
