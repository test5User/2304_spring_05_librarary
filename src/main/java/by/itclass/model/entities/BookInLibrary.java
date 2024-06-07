package by.itclass.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class BookInLibrary {
    private String title;
    private String author;
    private int pages;
    @NonNull
    private int library_id;
}
