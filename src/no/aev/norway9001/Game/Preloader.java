package no.aev.norway9001.Game;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Preloader extends javafx.application.Preloader
{

    private static final double WIDTH = 400;
    private static final double HEIGHT = 150;

    private Stage preloaderStage;
    private Scene scene;
    private Label progressLabel;

    public Preloader()
    {

    }

    @Override
    public void init() throws Exception
    {
        Platform.runLater(() -> {
            Label title = new Label("Norway 9001 is loading, please wait...");
            title.setTextAlignment(TextAlignment.CENTER);
            title.setFont(new Font(20));

            progressLabel = new Label();
            progressLabel.setFont(new Font(20));

            VBox root = new VBox(title, progressLabel);
            root.setAlignment(Pos.CENTER);

            scene = new Scene(root, WIDTH, HEIGHT);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.preloaderStage = primaryStage;

        // Set preloader scene and show stage
        preloaderStage.setTitle("Norway 9001");
        preloaderStage.setResizable(false);
        preloaderStage.setScene(scene);
        preloaderStage.show();
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        // Handle application notification in this point (see Main#init)
        if (info instanceof ProgressNotification) {
            progressLabel.setText(((ProgressNotification) info).getProgress() + "%");
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        // Handle state change notifications
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            case BEFORE_LOAD:
                // Called after Preloader#start is called
                progressLabel.setText("Loading...");
                System.out.println("Loading...");
                break;
            case BEFORE_INIT:
                // Called before MyApplication#init is called.
                progressLabel.setText("Initializing...");
                System.out.println("Initializing...");
                break;
            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                progressLabel.setText("Starting...");
                System.out.println("Starting...");

                preloaderStage.hide();
                break;
        }
    }
}
