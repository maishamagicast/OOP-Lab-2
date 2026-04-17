import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
// import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Text text1=new Text("Name : ");
        Text text2=new Text("Register : ");
        TextField textField1=new TextField();
        ComboBox comboBox=new ComboBox();

        Button button1= new Button("Save");
        Button button2= new Button("Remove");


        GridPane root=new GridPane();

        root.setMinSize(600, 400);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10,10,10,10));
        root.add(text1,0,0);
        root.add(textField1,1,0);
        root.add(button1,1,1);

        root.add(text2,0,2);
        root.add(comboBox,1,2);

        root.add(button2,1,3);

        button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
        button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
        
        text1.setStyle("-fx-font: normal bold 20px 'serif'");
        text2.setStyle("-fx-font: normal bold 20px 'serif'");
        root.setStyle("-fx-background-color: BEIGE");

        // Label titleLabel= new Label("Movie Library System");
        // root.add(titleLabel);

        Scene scene=new Scene(root);
        stage.setTitle("Movie Library System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}