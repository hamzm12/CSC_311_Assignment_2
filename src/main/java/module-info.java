module com.example.csc_311_assignment_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc_311_assignment_2 to javafx.fxml;
    exports com.example.csc_311_assignment_2;
}