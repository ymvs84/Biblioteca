module com.ymvs84.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens com.ymvs84.biblioteca to javafx.fxml;
    opens com.ymvs84.biblioteca.controller to javafx.fxml;
    opens com.ymvs84.biblioteca.model to javafx.base;
    exports com.ymvs84.biblioteca;
}