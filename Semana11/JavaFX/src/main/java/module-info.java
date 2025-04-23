module org.icesi.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.javafx to javafx.fxml;
    exports org.icesi.javafx;
}