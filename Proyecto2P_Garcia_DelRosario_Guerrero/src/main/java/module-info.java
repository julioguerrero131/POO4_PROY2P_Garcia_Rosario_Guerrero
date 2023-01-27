module com.mycompany.proyecto2p_garcia_delrosario_guerrero {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base; //nofx

    opens com.mycompany.proyecto2p_garcia_delrosario_guerrero to javafx.fxml;
    opens modelo to javafx.base ;
    exports com.mycompany.proyecto2p_garcia_delrosario_guerrero;
    //opens com.mycompany.proyecto2p_garcia_delrosario_guerrero to javafx.base;
}
