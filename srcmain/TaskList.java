package srcmain;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {

    ArrayList<Task> activeTasks = new ArrayList<Task>();

    public void add(Task task) {

    }

    public void delete(Task task) {

    }

    public void complete(Task task) {

    }

    public void changeTask(Task task, int field, String newDescription) {
        //TODO: Figure out how to implement this with enum and generic parameters so we don't have to overload methods?
    }

    public void changeTask(Task task, int field, int newPriorityorStatus) {
        //TODO: How do you implement seperate methods for priority and status when they have the same method signature?
    }

    public void changeTask(Task task, int field, LocalDate newDueDate) {
    }


}
