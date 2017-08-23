package no.aev.norway9001.Game;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Mikael
 * @author Asgeir Vinkenes
 */
public class Main extends Application
{

    private Stage stage = new Stage();
    private FontsProvider fonts;
    private LevelTracker levelTracker;
    private Scene mainMenu;
    private SpaceButton continueButton;
    private Label loadingLabel;

    private LevelsProvider levels;

    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_WIDTH_HOVER = 350;
    private static final String VERSION_MSG = "Norway 9001 Alpha";
    private static final String COPYRIGHT_MSG = "©AEVcorp 2017";

    public Main()
    {
        ProgressTracker progress = new ProgressTracker();
        levelTracker = progress.getProgress();
    }

    public static void main(String[] args)
    {
        LauncherImpl.launchApplication(Main.class, Preloader.class, args);
    }

    @Override
    public void init() throws Exception
    {
        String arguments;
        if (getParameters().getRaw().size() != 0)
        {
            arguments = getParameters().getRaw().get(0);
            try
            {
                if (!arguments.equals(""))
                {
                    levelTracker.setCurrentLevel(Integer.parseInt(arguments));
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("\nPlease enter a number for the first argument.\n");
                e.printStackTrace();
                Platform.exit();
            }
        }

        fonts = new FontsProvider();

        stage.setTitle("Norway 9001 Alpha");
        levels = new LevelsProvider();
        setupMainMenu(stage);

        stage.sceneProperty().addListener((obs, oldScene, newScene) ->
        {
            if (newScene == mainMenu)
            {
                updateMainMenu(stage);
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage.setScene(mainMenu);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    /**
     * Show the main menu.
     *
     * @param stage The stage in which to put the main menu.
     */
    private void setupMainMenu(Stage stage)
    {
        StackPane mainMenuPane = new StackPane();
        VBox mainMenuBox = new VBox();

        ImageView bgImg = new ImageView("menu/menubg.png");
        bgImg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        bgImg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight() + 50);
        mainMenuPane.getChildren().add(bgImg);
        mainMenuPane.setCursor(Cursor.DEFAULT);
        mainMenuBox.setAlignment(Pos.CENTER);
        mainMenuBox.setSpacing(5);

        ImageView logo = new ImageView("menu/logo.png");

        continueButton = new SpaceButton("Continue Game");
        continueButton.setPrefWidth(BUTTON_WIDTH);
        if (levelTracker.getCurrentLevel() == 1)
            continueButton.setDisable(true);
        continueButton.setOnAction(event -> continueGame(stage));

        SpaceButton newGameButton = new SpaceButton("New Game");
        newGameButton.setPrefWidth(BUTTON_WIDTH);
        newGameButton.setOnAction(event -> startNewGame(stage));

        SpaceButton exitButton = new SpaceButton("Exit");
        exitButton.setPrefWidth(BUTTON_WIDTH);
        exitButton.setCancelButton(true);
        exitButton.setOnAction(event -> Platform.exit());

        loadingLabel = new Label("Loading...");
        loadingLabel.setVisible(false);
        loadingLabel.setFont(fonts.getSpaceFontLarge());
        loadingLabel.setTextFill(Color.WHITE);
        loadingLabel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Label versionLabel = new Label(VERSION_MSG);
        versionLabel.setFont(new Font(12));
        versionLabel.setPadding(new Insets(10));
        versionLabel.setTextFill(Color.WHITE);

        Label copyrightLabel = new Label(COPYRIGHT_MSG);
        copyrightLabel.setFont(new Font(12));
        copyrightLabel.setPadding(new Insets(10));
        copyrightLabel.setTextFill(Color.WHITE);

        mainMenuBox.getChildren().addAll(logo, continueButton, newGameButton, exitButton);
        mainMenuPane.getChildren().addAll(mainMenuBox, loadingLabel, versionLabel, copyrightLabel);
        mainMenuPane.setAlignment(versionLabel, Pos.BOTTOM_LEFT);
        mainMenuPane.setAlignment(copyrightLabel, Pos.BOTTOM_RIGHT);
        mainMenu = new Scene(mainMenuPane);
        mainMenu.setCursor(Cursor.CROSSHAIR);
    }

    private void updateMainMenu(Stage stage)
    {
        loadingLabel.setVisible(false);
        if (levelTracker.getCurrentLevel() > 1)
        {
            continueButton.setDisable(false);
            continueButton.requestFocus();
        }
    }

    private void startNewGame(Stage stage)
    {
        loadingLabel.setVisible(true);
        Game game = new Game(stage, mainMenu, levels.getLevel(1), levelTracker);
        showLevelDesc(stage, game);
    }

    private void continueGame(Stage stage)
    {
        loadingLabel.setVisible(true);
        Game game = new Game(stage, mainMenu, levels.getLevel(levelTracker.getCurrentLevel()), levelTracker);
        showLevelDesc(stage, game);
    }

    /**
     * Show a level description before a level.
     *
     * @param stage
     */
    private void showLevelDesc(Stage stage, Game game)
    {
        levels.createLevels();

        VBox levelDescBox = new VBox();
        levelDescBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        levelDescBox.setAlignment(Pos.CENTER);
        levelDescBox.setSpacing(20);

        Label header = new Label("Level " + levelTracker.getCurrentLevel());
        header.setFont(fonts.getSpaceFontLarge());
        header.setTextFill(Color.WHITE);

        Label desc = new Label(levels.getLevel(levelTracker.getCurrentLevel()).getDesc());
        desc.setFont(new Font(16));
        desc.setTextFill(Color.WHITE);

        Label info = new Label("Press Space to continue");
        info.setFont(fonts.getSpaceFontMedium());
        info.setTextFill(Color.WHITE);

        levelDescBox.getChildren().addAll(header, desc, info);

        Scene descScene = new Scene(levelDescBox);
        descScene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.SPACE)
                game.run();
        });
        stage.setScene(descScene);
        stage.setFullScreen(true);
    }
}
