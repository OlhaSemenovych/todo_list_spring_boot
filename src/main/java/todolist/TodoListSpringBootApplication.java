package todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import todolist.dto.Note;
import todolist.service.NoteService;

@SpringBootApplication
public class TodoListSpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(TodoListSpringBootApplication.class, args);
        NoteService noteService = new NoteService();

        System.out.println(noteService.add(new Note("Title3", "Text3")));
        System.out.println(noteService.getById(2));
        noteService.deleteById(5);
        System.out.println(noteService.listAll());
        noteService.update(new Note("Title 1", "Text test123"));
    }

}