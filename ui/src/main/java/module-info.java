module com.timehub.ui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.timehub.ui to javafx.fxml;
    exports com.timehub.ui;
}