package srcmain;
import java.io.*;
import java.nio.Buffer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class IO {

    public void save(ArrayList<Task> activeTasks, ArrayList<Event> DeletedTaskLog, ArrayList<Event> CompletedTaskLog) throws IOException {
        try {
            File fileName = new File("TaskMaster-List.txt");
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);
            int size = activeTasks.size();
            for (int i = 0; i < activeTasks.size(); i++) {
                output.write(activeTasks.get(i).toString() + "\n");
            }
            for (int i = 0; i < DeletedTaskLog.size(); i++) {
                output.write(DeletedTaskLog.get(i).toString() + "\n");
            }
            for (int i = 0; i < DeletedTaskLog.size(); i++) {
                output.write(DeletedTaskLog.get(i).toString() + "\n");
            }
            for (int i = 0; i < CompletedTaskLog.size(); i++) {
                output.write(CompletedTaskLog.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    private String description;
    private int priority;
    private LocalDate dueDate;
    private int status;
    private LocalDateTime modifiedDate;


    public void load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("TaskMaster-List.txt");
        ObjectInputStream ObjectInputStream = new ObjectInputStream(fileInputStream);
        //ArrayList<Club> clubs = (ArrayList<Club>) ObjectInputStream.readObject();
        ObjectInputStream.close();
    }
}