module com.example.tpnoteperiode2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.tpnoteperiode2 to javafx.fxml;
    exports com.example.tpnoteperiode2;
}