module com.example.javalabs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.javalabs to javafx.fxml;
    exports com.example.javalabs;
}