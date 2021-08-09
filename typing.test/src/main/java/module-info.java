module ut.javafx.app.typing.test {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens ut.javafx.app.typing.test to javafx.fxml;
    exports ut.javafx.app.typing.test;
}
