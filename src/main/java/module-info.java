module nl.hsleiden.iipsene2applicatie {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.hsleiden.iipsene2applicatie to javafx.fxml;
    exports nl.hsleiden.iipsene2applicatie;
    exports nl.hsleiden.controller;
    exports nl.hsleiden.view;
    opens nl.hsleiden.view to javafx.fxml;
    opens nl.hsleiden.controller to javafx.fxml;
}