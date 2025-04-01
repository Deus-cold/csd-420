// Samir Rodriguez
// Module 1.3 Assignment
// Samir Rodriguez
// Module 1.3 Assignment
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardDisplay extends Application {
    private static final String CARD_DIR = "cards/";
    private static final int CARD_COUNT = 52;
    private static final int DISPLAY_COUNT = 4;

    private HBox cardBox = new HBox(10);

    @Override
    public void start(Stage primaryStage) {
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> displayRandomCards());

        cardBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);
        displayRandomCards();

        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.setTitle("Random Card Display");
        primaryStage.show();
    }

    private void displayRandomCards() {
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= CARD_COUNT; i++) {
            cardNumbers.add(i);
        }
        Collections.shuffle(cardNumbers);

        cardBox.getChildren().clear();
        for (int i = 0; i < DISPLAY_COUNT; i++) {
            String imagePath = "/" + CARD_DIR + cardNumbers.get(i) + ".png";
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(150);
            cardBox.getChildren().add(imageView);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
