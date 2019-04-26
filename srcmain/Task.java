package srcmain;

import java.time.LocalDate;

public class Task {

    private String description;
    private int priority;
    private LocalDate dueDate;
    private int status; //0 for not started, 1 for started, 2 for completed

    public String getDescription() {
        return description;
    }


    public int getPriority() {
        return priority;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }


    public int getStatus() {
        return status;
    }

    public String getStatusString() {
        switch (status) {
            case 0:
                return "Not Started";
            case 1:
                return "In Progress";
            case 2:
                return "Finished";
        }
        return "Something has gone terribly wrong.";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
        return "Description: " + this.getDescription() + "      " +
                "Priority: " + this.getPriority() + "       " +
                "Due: " + this.getDueDate() + "     " +
                "Status: " + this.getStatusString();
    }

    //TODO: Implement Changelog<ChangeTask>


}
