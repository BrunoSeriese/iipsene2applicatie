module nl.hsleiden.iipsene2applicatie {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires org.apache.commons.io;
    requires json;

    exports nl.hsleiden.iipsene2applicatie;
    exports nl.hsleiden.controller;
    exports nl.hsleiden.view;
    exports nl.hsleiden.model;

    opens nl.hsleiden.iipsene2applicatie to javafx.fxml;
    opens nl.hsleiden.view to javafx.fxml;
    opens nl.hsleiden.controller to javafx.fxml;
}