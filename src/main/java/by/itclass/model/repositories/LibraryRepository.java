package by.itclass.model.repositories;

import by.itclass.model.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
