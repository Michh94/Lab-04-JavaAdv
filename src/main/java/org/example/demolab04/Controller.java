package org.example.demolab04;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.regex.Pattern;

public class Controller {

    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listView;

    @FXML
    private Text errorMessage;

    private ObservableList<String> itemList;

    public Controller() {
        itemList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        listView.setItems(itemList);
        addButton.setOnAction(event -> addItem());
        deleteButton.setOnAction(event -> deleteItem());
    }

    private void addItem() {
        String item = nameField.getText();
        if (isValidName(item)) {
            itemList.add(item);
            nameField.clear();
            errorMessage.setText("");  // Clear error message
        } else {
            errorMessage.setText("Invalid name. Name must start with an uppercase letter and be at least 5 characters long.");
        }
    }

    private void deleteItem() {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            itemList.remove(selectedItem);
        }
    }

    private boolean isValidName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (name.length() < 5) {
            return false;
        }
        return Pattern.matches("[A-Z][a-zA-Z]*", name);
    }
}
