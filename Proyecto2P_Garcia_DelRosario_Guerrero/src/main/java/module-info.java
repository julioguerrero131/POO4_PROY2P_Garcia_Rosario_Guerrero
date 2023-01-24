module com.mycompany.proyecto2p_garcia_delrosario_guerrero {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2p_garcia_delrosario_guerrero to javafx.fxml;
    exports com.mycompany.proyecto2p_garcia_delrosario_guerrero;
}
