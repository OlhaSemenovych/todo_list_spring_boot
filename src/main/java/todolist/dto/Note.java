package todolist.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public class Note {

    /*
    Please disregard ID creating, this is a temporary functionality.
    AtomicInteger value will be removed after database setup with autoincrement ID column.
     */
    private static final AtomicInteger autoId = new AtomicInteger(0);
    private Long id = Long.valueOf(String.valueOf(autoId.getAndIncrement()));
    private String title;
    private String content;

    public Note() {
    }

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
