package uz.oasis.jdbc_spring_bookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private UUID id;
    private String title;
    private String description;
    private UUID authorId;
    private UUID genreId;

}
