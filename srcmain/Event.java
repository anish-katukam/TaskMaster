package srcmain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Event {

    private String description;
    private int priority;
    private LocalDate dueDate;
    private int status;
    private LocalDateTime modifiedDate;
}
