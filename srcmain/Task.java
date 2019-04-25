package srcmain;

import java.time.LocalDate;

public class Task {

    private String description;
    private int priority;
    private LocalDate dueDate;
    private int status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Task(String description, int priority, LocalDate dueDate, int status) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
    }

     public String toString() {
        return "Description: " + this.getDescription() + " " +
               "Priority: " + this.getPriority() + " " +
               "Due: " + this.getDueDate() + " " +
               "Status: " + this.getStatus();
    }

    //TODO: Implement Changelog<ChangeTask>


}
