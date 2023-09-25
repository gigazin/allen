module com.github.gigazin.allen {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.dv8tion.jda;
    requires mysql.connector.j;
    requires java.sql;
    requires annotations;

    opens com.github.gigazin.allen.launcher to javafx.fxml;
    exports com.github.gigazin.allen.launcher;
}