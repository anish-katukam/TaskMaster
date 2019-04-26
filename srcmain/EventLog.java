package srcmain;

import java.util.ArrayList;

public class EventLog {

    private static ArrayList<Event> AddedTaskLog = new ArrayList<Event>();
    private static ArrayList<Event> DeletedTaskLog = new ArrayList<Event>();
    private static ArrayList<Event> CompletedTaskLog = new ArrayList<Event>();

    public static void addEventToAddedTaskLog(Event event) {
        AddedTaskLog.add(event);
        System.out.println("event added to addlog");
    }

    public static void addEventToDeletedTaskLog(Event event) {
        DeletedTaskLog.add(event);
    }

    public static void addEventToCompletedTaskLog(Event event) {
        CompletedTaskLog.add(event);
    }
}
