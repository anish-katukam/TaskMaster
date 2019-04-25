package srcmain;
import java.io.*;
import java.util.ArrayList;

public class IO {

    public void printReport() {

    }

    public void save() throws IOException {
        FileOutputStream fileOutStream = new FileOutputStream("TaskMaster-List.txt");
        ObjectOutputStream ObjOutStream = new ObjectOutputStream(fileOutStream);
        ObjOutStream.writeObject(activeTasks); // Verify this is where its stored
        ObjOutStream.close();
    }

    public void load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("TaskMaster-List.txt");
        ObjectInputStream ObjectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Club> clubs = (ArrayList<Club>) ObjectInputStream.readObject();
        ObjectInputStream.close();
    }
}