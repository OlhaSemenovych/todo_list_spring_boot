package todolist.service;

import org.springframework.stereotype.Service;
import todolist.dto.Note;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteService {

    private final Map<Long, Note> notes;

    public NoteService() {
        notes = new HashMap<>();
    }

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note add(Note note) {
        if (!notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        }
        return note;
    }

    public void deleteById(long id) {
        Optional.ofNullable(notes.get(id))
                .map(n -> notes.remove(id))
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Can't delete note. Note with id - %s doesn't exist!", id)));
    }

    public void update(Note note) {
        Optional.ofNullable(notes.get(note.getId()))
                .map(n -> {
                    Note noteNew = notes.get(note.getId());
                    noteNew.setContent(note.getContent());
                    noteNew.setTitle(note.getTitle());
                    return noteNew;
                })
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Can't update note. Note with id - %s doesn't exist!", note.getId())));
    }

    public Note getById(long id) {
        return Optional.ofNullable(notes.get(id))
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Can't get note. Note with id - %s doesn't exist!", id)));
    }

}
