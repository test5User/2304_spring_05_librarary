package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private int pages;
    @ManyToOne
    private Library library;
}
