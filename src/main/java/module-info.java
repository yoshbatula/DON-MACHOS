module org.example.donmachos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.example.donmachos to javafx.fxml;
    exports org.example.donmachos;
}