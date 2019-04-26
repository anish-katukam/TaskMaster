package srcmain;

import com.jfoenix.controls.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    @FXML
    JFXTextArea descriptionEntry = new JFXTextArea();

    @FXML
    JFXTextField priorityEntry = new JFXTextField();

    @FXML
    JFXDatePicker dueDateEntry = new JFXDatePicker();

    @FXML
    JFXListView<Task> display = new JFXListView<>();

    @FXML
    JFXButton addTaskButton = new JFXButton();

    @FXML
    JFXButton updateTaskButton = new JFXButton();

    @FXML
    JFXButton editTaskButton = new JFXButton();

    @FXML
    JFXButton deleteTaskButton = new JFXButton();

    @FXML
    private Node root;

    @FXML
    private JFXButton contextLeftButton = new JFXButton();

    @FXML
    private JFXButton contextMiddleButton = new JFXButton();

    @FXML
    private JFXButton contextRightButton = new JFXButton();

    @FXML
    private JFXButton newDescriptionButton = new JFXButton();

    @FXML
    private JFXTextArea newDescriptionEntry = new JFXTextArea();

    ObservableList<Task> list = FXCollections.observableArrayList();

    boolean bypassValidation = false;

    public void initialize() {

        newDescriptionButton.getStyleClass().add("add-button-raised");
        newDescriptionButton.setDisable(true);

        addTaskButton.setDisable(true);
        addTaskButton.getStyleClass().add("add-button-raised");
        updateTaskButton.getStyleClass().add("update-button-raised");
        editTaskButton.getStyleClass().add("edit-button-raised");
        deleteTaskButton.getStyleClass().add("delete-button-raised");

        contextLeftButton.getStyleClass().add("context-button-raised");
        contextMiddleButton.getStyleClass().add("context-button-raised");
        contextRightButton.getStyleClass().add("context-button-raised");

        deactivateContextButtons();
        deactivateItemButtons();

        dueDateEntry.getEditor().setStyle("-fx-opacity: 1.0;");
        display.getStyleClass().add("list-view");
        dueDateEntry.getEditor().setDisable(true);

        display.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
            @Override
            public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
                activateItemButtons();
            }
        });

    }

    @FXML
    private void attemptDescriptionValidation() {
        if (!newDescriptionEntry.getText().equals("")) {
            newDescriptionButton.setDisable(false);
        } else {
            addTaskButton.setDisable(true);
        }
    }

    @FXML
    private void attemptInputValidation() {
        if ((!descriptionEntry.getText().equals("") && priorityEntry.getText().matches("[0-9]+") && dueDateEntry.getValue() != null) || bypassValidation) {
            addTaskButton.setDisable(false);
        } else {
            addTaskButton.setDisable(true);
        }
    }

    private void activateItemButtons() {
        updateTaskButton.setDisable(false);
        editTaskButton.setDisable(false);
        deleteTaskButton.setDisable(false);
    }

    private void deactivateItemButtons() {
        updateTaskButton.setDisable(true);
        editTaskButton.setDisable(true);
        deleteTaskButton.setDisable(true);
    }

    private void activateContextButtons() {
        contextLeftButton.setDisable(false);
        contextMiddleButton.setDisable(false);
        contextRightButton.setDisable(false);
    }

    private void deactivateContextButtons() {
        contextLeftButton.setDisable(true);
        contextLeftButton.setText("");
        contextMiddleButton.setDisable(true);
        contextMiddleButton.setText("");
        contextRightButton.setDisable(true);
        contextRightButton.setText("");
    }

    @FXML
    private void addTask() {
        String description = descriptionEntry.getText();
        String priority = priorityEntry.getText();
        int priorityNum = Integer.parseInt(priority);
        LocalDate dueDate = dueDateEntry.getValue();
        EventLog.addEventToAddedTaskLog(new Event(description, priorityNum, dueDate, 0, LocalDateTime.now()));
        list.add(new Task(description, priorityNum, dueDate, 0));
        display.setItems(list);
        refresh();
    }

    @FXML
    private void updateTask() {
        contextLeftButton.setText("Not Started");
        contextLeftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                display.getSelectionModel().getSelectedItem().setStatus(0);
                display.refresh();
                deactivateContextButtons();
            }
        });
        contextMiddleButton.setText("In Progress");
        contextMiddleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                display.getSelectionModel().getSelectedItem().setStatus(1);
                display.refresh();
                deactivateContextButtons();
            }
        });
        contextRightButton.setText("Finished");
        contextRightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                display.getSelectionModel().getSelectedItem().setStatus(2);
                display.refresh();
                deactivateContextButtons();
            }
        });
        activateContextButtons();
    }

    @FXML
    private void editTask() {
        contextLeftButton.setText("Change Description");
        contextLeftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addTaskButton.setText("Set New Description");
                addTaskButton.setDisable(false);
                bypassValidation = true;
                addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!descriptionEntry.getText().equals("")) {
                            display.getSelectionModel().getSelectedItem().setDescription(descriptionEntry.getText());
                            display.refresh();
                            bypassValidation = false;
                            addTaskButton.setText("Add Task");
                            addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    addTask();
                                }
                            });
                        }
                    }
                });
                display.refresh();
                deactivateContextButtons();
            }
        });
        contextMiddleButton.setText("Change Priority");
        contextMiddleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addTaskButton.setText("Set New Priority");
                addTaskButton.setDisable(false);
                bypassValidation = true;
                addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (priorityEntry.getText().matches("[0-9]+")) {
                            display.getSelectionModel().getSelectedItem().setPriority(Integer.parseInt(priorityEntry.getText()));
                            display.refresh();
                            bypassValidation = false;
                            addTaskButton.setText("Add Task");
                            addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    addTask();
                                }
                            });
                        }
                    }
                });
                display.refresh();
                deactivateContextButtons();
            }
        });
        contextRightButton.setText("Change Due Date");
        contextRightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addTaskButton.setText("Set New Due Date");
                addTaskButton.setDisable(false);
                bypassValidation = true;
                addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (dueDateEntry.getValue() != null) {
                            display.getSelectionModel().getSelectedItem().setDueDate(dueDateEntry.getValue());
                            display.refresh();
                            bypassValidation = false;
                            addTaskButton.setText("Add Task");
                            addTaskButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    addTask();
                                }
                            });
                        }
                    }
                });
                display.refresh();
                deactivateContextButtons();
            }
        });
        activateContextButtons();
    }

    @FXML
    private void deleteTask() {
        list.remove(display.getSelectionModel().getSelectedIndex());
        display.setItems(list);
        //#TODO: ADD DELETE EVENT
    }

    public void saveFile() throws IOException {
        try {
            File fileName = new File("TaskMaster-List.txt");
            FileWriter fw = new FileWriter(fileName);
            Writer output = new BufferedWriter(fw);

            for (int i = 0; i < list.size(); i++) {
                output.write(list.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void refresh() {
        descriptionEntry.setText("");
        priorityEntry.setText("");
        dueDateEntry.setValue(null);
    }

}
