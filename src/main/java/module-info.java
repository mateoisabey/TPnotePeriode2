module com.example.tpnoteperiode2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.tpnoteperiode2 to javafx.fxml;
    exports com.example.tpnoteperiode2;
}