import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Customers extends Application {

    @Override
    public void start(Stage stage) {

        Text text1 = new Text("Name:");
        Text text2 = new Text("Phone:");
        Text text3 = new Text("Email:");
        Text text4 = new Text(" Remove:");


        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setEditable(true);

        Button button1 = new Button("Save");
        button1.setMaxWidth(Double.MAX_VALUE);

        Button button2 = new Button("Remove");
        button2.setMaxWidth(Double.MAX_VALUE);


        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);

        gridPane.add(text2, 0, 1);
        gridPane.add(textField2, 1, 1);

        gridPane.add(text3, 0, 2);
        gridPane.add(textField3, 1, 2);

        gridPane.add(button1, 1,3);

        gridPane.add(text4, 0,4);
        gridPane.add(comboBox,1,4);

        gridPane.add(button2,1,5);




        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
        comboBox.setStyle(
                "-fx-background-color: white;" +
                        "-fx-border-color: darkslateblue;" +
                        "-fx-border-width: 2px;" +
                        "-fx-font-size: 13pt;"
        );

        text1.setStyle("-fx-font: normal bold 20px 'serif';");
        text2.setStyle("-fx-font: normal bold 20px 'serif';");
        text3.setStyle("-fx-font: normal bold 20px 'serif';");
        text4.setStyle("-fx-font: normal bold 20px 'serif';");

        gridPane.setStyle("-fx-background-color: WHITE;");


        Scene scene = new Scene(gridPane);
        stage.setTitle("Video Library");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
