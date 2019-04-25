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
    JFXTextArea descript = new JFXTextArea();

    @FXML
    JFXTextField prior = new JFXTextField();

    @FXML
    JFXDatePicker due = new JFXDatePicker();

    @FXML
    ListView<Task> display = new ListView<Task>();

    ObservableList<Task> list = FXCollections.observableArrayList();

    @FXML
    private void addTask(ActionEvent event) {
        String description = descript.getText();
        String priority = prior.getText();
        int priorityNum = Integer.parseInt(priority);
        LocalDate dueDate = due.getValue();
        list.add(new Task(description, priorityNum, dueDate, 0));
        display.setItems(list);
        refresh();
    }

    private void refresh() {
        descript.setText("");
        prior.setText("");
        due.setValue(null);
    }

}
