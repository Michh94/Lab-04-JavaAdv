module org.example.demolab04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demolab04 to javafx.fxml;
    exports org.example.demolab04;
}