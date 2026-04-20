import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Rentals extends Application {
    private ObservableList<String> customers = FXCollections.observableArrayList("John", "Jane", "Alice");
    private ObservableList<String> genres = FXCollections.observableArrayList("Action", "Comedy", "Drama", "Horro");

    private ObservableList<String> actionMovies = FXCollections.observableArrayList("Beekeeper", "Agent 47", "John Wick");
    private ObservableList<String> comedyMovies = FXCollections.observableArrayList("Mr.Bean", "SuperBad", "Bridesmaids");
    private ObservableList<String> dramaMovies = FXCollections.observableArrayList("The Godfather", "Euphoria", "Forrest Gump");
    private ObservableList<String> horrorMovies = FXCollections.observableArrayList("The Nun", "Walking Dead", "The Conjuring");

    private ObservableList<String> borrowedMovies = FXCollections.observableArrayList();
    private ObservableList<String> returnedMovies = FXCollections.observableArrayList();

    private ComboBox<String> customerCombo = new ComboBox<>();
    private ComboBox<String> genreCombo = new ComboBox<>();
    private ComboBox<String> moviesCombo = new ComboBox<>();
    private ListView<String> borrowedList = new ListView<>();
    private ListView<String> returnedList = new ListView<>();

    @Override
public void start(Stage stage){

        Text customerLable = new Text("Customer:");
        Text genreLable = new Text("Genre:");
        Text moviesLable = new Text("Movies:");
        Text borrowedLable = new Text("Borrowed:");
        Text returnedLable = new Text("Returned:");

        customerCombo.setItems(customers);
        genreCombo.setItems(genres);
        moviesCombo.setDisable(true);

        Button button1 = new Button("Save");
        Button button2 = new Button("Return");

        genreCombo.setOnAction(e -> updateMoviesByGenre());
        button1.setOnAction(e -> saveRental());
        button2.setOnAction(e -> returnMovie());

        GridPane root = new GridPane();
        root.setMinSize(600, 400);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);

        root.add(customerLable, 0, 0);
        root.add(customerCombo, 1, 0);

        root.add(genreLable, 0, 1);
        root.add(genreCombo, 1, 1);

        root.add(moviesLable, 0, 2);
        root.add(moviesCombo, 1, 2);

        root.add(button1, 1, 3);

        root.add(borrowedLable, 0, 4);
        root.add(borrowedList, 1, 4);

        root.add(returnedLable, 0, 5);
        root.add(returnedList, 1, 5);

        root.add(button2, 1, 6);

        String buttonstyle = "-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-font-size: 13pt;";
        button1.setStyle(buttonstyle);
        button2.setStyle(buttonstyle);

        String labelStyle = "-fx-font: normal bold 16px 'Serif';";
        customerLable.setStyle(labelStyle);
        genreLable.setStyle(labelStyle);
        moviesLable.setStyle(labelStyle);
        borrowedLable.setStyle(labelStyle);
        returnedLable.setStyle(labelStyle);

        root.setStyle("-fx-background-color: #f5f5dc;");

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Movie Library System -Rentals");
        stage.setScene(scene);
        stage.show();
    }

    private void updateMoviesByGenre(){
        String selectedGenre = genreCombo.getValue();
        if (selectedGenre == null){
            moviesCombo.setDisable(true);
            return;
        }

        moviesCombo.setDisable(false);
        switch (selectedGenre){
            case "Action":
                moviesCombo.setItems(actionMovies);
                break;
            case "Comedy":
                moviesCombo.setItems(comedyMovies);
                break;
            case "Drama":
                moviesCombo.setItems(dramaMovies);
                break;
            case "Horror":
                moviesCombo.setItems(horrorMovies);
                break;
            default:
                moviesCombo.setItems(FXCollections.observableArrayList());
        }
    }

    private void saveRental(){
        String customer = customerCombo.getValue();
        String  movie = moviesCombo.getValue();

        if (customer == null || movie == null){
            showAlert("Selection Error", "Please select a customer and a movie.");
            return;
        }
        if (borrowedMovies.contains(movie)){
            showAlert("Rental Error", "This movie is already borrowed and not yet returned");
            return;
        }
        borrowedMovies.add(movie);
        borrowedList.setItems(borrowedMovies);
        showAlert("Success", "Movie \"" + movie + "\" rented to " + customer + ".");
;    }

    private void returnMovie(){
        String selectedMovie = borrowedList.getSelectionModel().getSelectedItem();
        if (selectedMovie == null){
            showAlert("Selection Error", "Please select a movie from Borrowed List to return.");
            return;
        }
        borrowedMovies.remove(selectedMovie);
        returnedMovies.add(selectedMovie);

        borrowedList.setItems(borrowedMovies);
        returnedList.setItems(returnedMovies);
        showAlert("Return Success", "Movie \"" + selectedMovie + "\" has been returned.");
    }
    private void showAlert(String title, String message){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle(title);
       alert.setHeaderText(null);
       alert.setContentText(message);
       alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
