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

public class Movie extends Application {

    @Override
    public void start(Stage stage) {
        Text text1=new Text("Name : ");
        Text text2=new Text("Register : ");
        Text text3=new Text("Genres : ");
        TextField textField1=new TextField();
        ComboBox comboBox1=new ComboBox();
        ComboBox comboBox2=new ComboBox();

        Button button1= new Button("Save");
        Button button2= new Button("Remove");


        GridPane root=new GridPane();

        root.setMinSize(600, 400);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10,10,10,10));
        root.add(text3,0,0);
        root.add(text1,0,1);
        root.add(comboBox1,1,0);
        root.add(textField1,1,1);
        root.add(button1,1,2);

        root.add(text2,0,3);
        root.add(comboBox2,1,3);

        root.add(button2,1,4);

        button1.setStyle("-fx-background-color: skyblue; -fx-text-fill: white; -fx-font-size:13pt;");
        button2.setStyle("-fx-background-color: skyblue; -fx-text-fill: white; -fx-font-size:13pt;");
        
        text1.setStyle("-fx-font: normal bold 20px 'serif'");
        text2.setStyle("-fx-font: normal bold 20px 'serif'");
        text3.setStyle("-fx-font: normal bold 20px 'serif'");
        root.setStyle("-fx-background-color: WHITE");

        

        Scene scene=new Scene(root);
        stage.setTitle("Movie Library System");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
