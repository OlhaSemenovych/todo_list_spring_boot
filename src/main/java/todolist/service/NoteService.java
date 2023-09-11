package todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todolist.dto.Note;
import todolist.repository.NoteRepository;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(long id) {
        return Optional.of(noteRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(NoSuchElementException::new);
    }

}
