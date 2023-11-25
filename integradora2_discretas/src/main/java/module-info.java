module com.example.integradora2_discretas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integradora2_discretas to javafx.fxml;
    exports com.example.integradora2_discretas;
}