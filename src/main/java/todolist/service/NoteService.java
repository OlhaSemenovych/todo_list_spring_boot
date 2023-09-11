package todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import todolist.dto.Note;
import todolist.repository.NoteRepository;

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

    public Optional<Note> getById(long id) {
        return noteRepository.findById(id);
    }

}
