package srcmain;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Controller {

    @FXML
    private JFXTextArea descript = new JFXTextArea();

    @FXML
    private JFXTextField prior = new JFXTextField();

    @FXML
    private JFXDatePicker due = new JFXDatePicker();

    @FXML
    ListView<Event> eventList;

    @FXML
    ObservableList<Event> list = FXCollections.observableArrayList();

    //adds the task to the list
    public void addTask(ActionEvent actionEvent) {
        String description = descript.getText();
        String priority = prior.getText();
        LocalDate dueDate = due.getValue();

        list.add(new Event(description, priority, dueDate, 0));

        eventList.setItems(list);
    }
}
