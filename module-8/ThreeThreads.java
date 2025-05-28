// Samir Rodriguez
// Module 8 Assignment 8.2


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThreeThreads extends Application {

    private TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setEditable(false);  // Make the text area non-editable

        VBox layout = new VBox(textArea);
        Scene scene = new Scene(layout, 400, 400);

        primaryStage.setTitle("ThreeThreads");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the three threads
        startLetterThread();
        startNumberThread();
        startSpecialCharThread();
    }

    // Thread for random letters (a-z)
    private void startLetterThread() {
        Thread letterThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char randomLetter = (char) ('a' + (int) (Math.random() * 26));
                appendToTextArea(String.valueOf(randomLetter));
                try {
                    Thread.sleep(10);  // Slow down the output for better readability
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        letterThread.start();
    }

    // Thread for random numbers (0-9)
    private void startNumberThread() {
        Thread numberThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                int randomNumber = (int) (Math.random() * 10);
                appendToTextArea(String.valueOf(randomNumber));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        numberThread.start();
    }

    // Thread for random special characters
    private void startSpecialCharThread() {
        Thread specialCharThread = new Thread(() -> {
            String specialChars = "!@#$%&*";
            for (int i = 0; i < 10000; i++) {
                char randomSpecialChar = specialChars.charAt((int) (Math.random() * specialChars.length()));
                appendToTextArea(String.valueOf(randomSpecialChar));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        specialCharThread.start();
    }

    // Append text to the text area on the JavaFX Application Thread
    private synchronized void appendToTextArea(String text) {
        javafx.application.Platform.runLater(() -> textArea.appendText(text));
    }
}