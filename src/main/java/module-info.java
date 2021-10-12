module nl.hsleiden.iipsene2applicatie {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens nl.hsleiden.iipsene2applicatie to javafx.fxml;
    exports nl.hsleiden.iipsene2applicatie;
    exports nl.hsleiden.controller;
    opens nl.hsleiden.controller to javafx.fxml;
}