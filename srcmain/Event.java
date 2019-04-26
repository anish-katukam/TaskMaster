package srcmain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {

    private String description;
    private int priority;
    private LocalDate dueDate;
    private int status;
    private LocalDateTime modifiedDate;

    public Event(String description, int priority, LocalDate dueDate, int status, LocalDateTime modifiedDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
        this.modifiedDate = modifiedDate;
    }



}
