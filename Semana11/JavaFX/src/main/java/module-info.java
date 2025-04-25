module org.icesi.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.javafx to javafx.fxml;
    exports org.icesi.javafx;
    exports org.icesi.javafx.control;
    opens org.icesi.javafx.control to javafx.fxml;
}