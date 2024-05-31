package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "library")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private List<Book> books;

    public Library(int id, @NonNull String name, @NonNull String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
