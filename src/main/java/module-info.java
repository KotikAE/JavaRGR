module com.example.javalabs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.javalabs to javafx.fxml;
    exports com.example.javalabs;
    exports com.example.javalabs.ProjectModels;
    opens com.example.javalabs.ProjectModels to javafx.fxml;
    exports com.example.javalabs.Controllers;
    opens com.example.javalabs.Controllers to javafx.fxml;
    exports com.example.javalabs.Interfaces;
    opens com.example.javalabs.Interfaces to javafx.fxml;
    exports com.example.javalabs.ConnectionSupport;
    opens com.example.javalabs.ConnectionSupport to javafx.fxml;
    exports com.example.javalabs.ParentClasses;
    opens com.example.javalabs.ParentClasses to javafx.fxml;
    exports com.example.javalabs.ParentClasses.Children;
    opens com.example.javalabs.ParentClasses.Children to javafx.fxml;
}