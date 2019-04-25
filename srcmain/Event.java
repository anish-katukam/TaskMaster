package srcmain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {
    private String description;
    private String priority;
    private LocalDate dueDate;
    private int status;
    private LocalDateTime modifiedDate;

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Event(String description, String priority, LocalDate dueDate, int status) {
        this.setDescription(description);
        this.setPriority(priority);
        this.setDueDate(dueDate);
        this.setStatus(status);
    }
}
