package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.dto.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
